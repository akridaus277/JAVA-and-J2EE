package id.belajar.transportationreservationsystemfix.controller;

import java.security.NoSuchAlgorithmException;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.belajar.transportationreservationsystemfix.config.JwtToken;
import id.belajar.transportationreservationsystemfix.entity.Agency;
import id.belajar.transportationreservationsystemfix.entity.Bus;
import id.belajar.transportationreservationsystemfix.entity.Role;
import id.belajar.transportationreservationsystemfix.entity.Ticket;
import id.belajar.transportationreservationsystemfix.entity.User;
import id.belajar.transportationreservationsystemfix.entity.Role.role_name;
import id.belajar.transportationreservationsystemfix.exception.ExceptionMessage;
import id.belajar.transportationreservationsystemfix.repository.AgencyRepository;
import id.belajar.transportationreservationsystemfix.repository.RoleRepository;
import id.belajar.transportationreservationsystemfix.repository.UserRepository;
import lombok.extern.java.Log;

@RestController
@RequestMapping("/api")
public class AgencyController {

	final private UserRepository userInfoRepository;
	
	final private RoleRepository roleRepository;
	final private AgencyRepository agencyRepository;
	private final JwtToken jwtTokenUntil;

	public AgencyController(UserRepository userInfoRepository,RoleRepository roleRepository,JwtToken jwtTokenUntil,AgencyRepository agencyRepository) {
		this.roleRepository = roleRepository;
		this.userInfoRepository = userInfoRepository;
		this.jwtTokenUntil = jwtTokenUntil;
		this.agencyRepository = agencyRepository;
	}
	
	@PostMapping("/v1/agency")
	public ResponseEntity<?> createAgency(@RequestBody Map<String, String> body,HttpServletRequest request)  {
		
		String requestTokenHeader = request.getHeader("Authorization");
		String jwtToken = null;
		jwtToken = requestTokenHeader.substring(7);
		String email = jwtTokenUntil.getUsernameFromToken(jwtToken);
		User user = userInfoRepository.findByEmail(email);
		
		if (user.getRole().getId()==2) {
			String code = body.get("code");
			String details = body.get("details");
			String name = body.get("name");
			Agency agency = new Agency(code,details,name,user);

			user.addAgency(agency);
			agencyRepository.save(agency);
			userInfoRepository.save(user);


			return new ResponseEntity<>(ExceptionMessage.format("Agency '%s' berhasil ditambahkan",code), HttpStatus.OK);
		}else {
			
			return new ResponseEntity<>(ExceptionMessage.format("Anda tidak memiliki akses ke API ini"), HttpStatus.FORBIDDEN);
		}
		
	}
	


	
	
	
}
