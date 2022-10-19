package id.belajar.transportationreservationsystemfix.controller;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.ValidationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder.BCryptVersion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.belajar.transportationreservationsystemfix.config.JwtToken;
import id.belajar.transportationreservationsystemfix.entity.Agency;
import id.belajar.transportationreservationsystemfix.entity.Bus;
import id.belajar.transportationreservationsystemfix.entity.Role;
import id.belajar.transportationreservationsystemfix.entity.Stop;
import id.belajar.transportationreservationsystemfix.entity.Ticket;
import id.belajar.transportationreservationsystemfix.entity.User;
import id.belajar.transportationreservationsystemfix.entity.Role.role_name;
import id.belajar.transportationreservationsystemfix.exception.ExceptionMessage;
import id.belajar.transportationreservationsystemfix.repository.AgencyRepository;
import id.belajar.transportationreservationsystemfix.repository.BusRepository;
import id.belajar.transportationreservationsystemfix.repository.RoleRepository;
import id.belajar.transportationreservationsystemfix.repository.UserRepository;
import lombok.extern.java.Log;

@RestController
@RequestMapping("/api")
public class BusController {

	final private UserRepository userInfoRepository;
	
	final private RoleRepository roleRepository;
	final private AgencyRepository agencyRepository;
	final private BusRepository busRepository;
	private final JwtToken jwtTokenUntil;

	public BusController(BusRepository busRepository,UserRepository userInfoRepository,RoleRepository roleRepository,JwtToken jwtTokenUntil,AgencyRepository agencyRepository) {
		this.roleRepository = roleRepository;
		this.userInfoRepository = userInfoRepository;
		this.jwtTokenUntil = jwtTokenUntil;
		this.agencyRepository = agencyRepository;
		this.busRepository = busRepository;
	}
	
	@PostMapping("/v1/bus")
	public ResponseEntity<?> createBus(@RequestBody Map<String, String> body,HttpServletRequest request)  {
		String requestTokenHeader = request.getHeader("Authorization");
		String jwtToken = null;
		jwtToken = requestTokenHeader.substring(7);
		String email = jwtTokenUntil.getUsernameFromToken(jwtToken);
		User user = userInfoRepository.findByEmail(email);

		if (user.getRole().getId()==2) {
			long capacity = Long.parseLong(body.get("capacity"));
			String code = body.get("code");
			String make = body.get("make");
			int agency_id = Integer.parseInt(body.get("agency_id"));
			
			Agency agency = agencyRepository.findById(agency_id).get();
			Bus bus = new Bus(capacity,code,make,agency);
			agency.addBus(bus);
			
			busRepository.save(bus);
			agencyRepository.save(agency);


			return new ResponseEntity<>(ExceptionMessage.format("Bus '%s' berhasil ditambahkan",code), HttpStatus.OK);
		}else {
			
			return new ResponseEntity<>(ExceptionMessage.format("Anda tidak memiliki akses ke API ini"), HttpStatus.FORBIDDEN);
		}
		
	}
	
	@GetMapping("/v1/bus")
	public ResponseEntity<?> getAgencybyBus(@RequestBody Map<String, String> body,HttpServletRequest request)  {
		
		int agency_id = Integer.parseInt(body.get("agency_id"));
		Agency agency = agencyRepository.findById(agency_id).get();
		return new ResponseEntity<>(agency.getBuses(), HttpStatus.OK);

		
	}
	


	
	
	
}
