package id.belajar.transportationreservationsystemfix.controller;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.ValidationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.belajar.transportationreservationsystemfix.config.JwtToken;
import id.belajar.transportationreservationsystemfix.entity.Role;
import id.belajar.transportationreservationsystemfix.entity.User;
import id.belajar.transportationreservationsystemfix.entity.Role.role_name;
import id.belajar.transportationreservationsystemfix.exception.ExceptionMessage;
import id.belajar.transportationreservationsystemfix.entity.Stop;
import id.belajar.transportationreservationsystemfix.entity.Trip;
import id.belajar.transportationreservationsystemfix.entity.TripSchedule;
import id.belajar.transportationreservationsystemfix.repository.RoleRepository;
import id.belajar.transportationreservationsystemfix.repository.StopRepository;
import id.belajar.transportationreservationsystemfix.repository.TripRepository;
import id.belajar.transportationreservationsystemfix.repository.TripScheduleRepository;
import id.belajar.transportationreservationsystemfix.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class TripScheduleController {

	final private UserRepository userInfoRepository;
	
	final private RoleRepository roleRepository;
	final private StopRepository stopRepository;
	final private TripRepository tripRepository;
	final private TripScheduleRepository tripScheduleRepository;
	final private JwtToken jwtTokenUntil;

	public TripScheduleController(JwtToken jwtTokenUntil,UserRepository userInfoRepository,RoleRepository roleRepository,StopRepository stopRepository,TripRepository tripRepository,TripScheduleRepository tripScheduleRepository) {
		this.roleRepository = roleRepository;
		this.userInfoRepository = userInfoRepository;
		this.stopRepository = stopRepository;
		this.tripRepository = tripRepository;
		this.tripScheduleRepository = tripScheduleRepository;
		this.jwtTokenUntil = jwtTokenUntil;
	}

	
	@GetMapping("/v1/reservation/tripschedules")
	public ResponseEntity<?> getTripsSechedulesByTripDate(@RequestBody Map<String, String> body,HttpServletRequest request) {
		String requestTokenHeader = request.getHeader("Authorization");
		String jwtToken = null;
		jwtToken = requestTokenHeader.substring(7);
		String email = jwtTokenUntil.getUsernameFromToken(jwtToken);
		User user = userInfoRepository.findByEmail(email);
		
		
		if (user.getRole().getId()==1) {
			String trip_date = body.get("tripDate");
			return new ResponseEntity<List<TripSchedule>>(tripScheduleRepository.findAllByTripDate(trip_date), HttpStatus.OK);
		}else {
			
			return new ResponseEntity<>(ExceptionMessage.format("Anda tidak memiliki akses ke API ini"), HttpStatus.FORBIDDEN);
		}

	

	}

	

	
	
	
}