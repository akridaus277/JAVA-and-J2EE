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
import id.belajar.transportationreservationsystemfix.entity.Role;
import id.belajar.transportationreservationsystemfix.entity.TripSchedule;
import id.belajar.transportationreservationsystemfix.entity.User;
import id.belajar.transportationreservationsystemfix.entity.Role.role_name;
import id.belajar.transportationreservationsystemfix.repository.RoleRepository;
import id.belajar.transportationreservationsystemfix.repository.UserRepository;

import lombok.extern.java.Log;

import id.belajar.transportationreservationsystemfix.exception.ExceptionMessage;

@RestController
@RequestMapping("/api")
public class UserController {

	final private UserRepository userInfoRepository;
	
	final private RoleRepository roleRepository;
	final private JwtToken jwtTokenUntil;
	

	public UserController(UserRepository userInfoRepository,RoleRepository roleRepository,JwtToken jwtTokenUntil) {
		this.roleRepository = roleRepository;
		this.userInfoRepository = userInfoRepository;
		this.jwtTokenUntil = jwtTokenUntil;
	}
	
	
	@GetMapping("/v1/user")
	public ResponseEntity<?> getAllUser() {
		return new ResponseEntity<List<User>>(userInfoRepository.findAll(), HttpStatus.OK);
	}
	
	@PostMapping("/v1/user/signup")
	public ResponseEntity<?> createUser(@RequestBody Map<String, String> body,HttpServletRequest request)  throws ValidationException {
		String requestTokenHeader = request.getHeader("Authorization");
		String email = body.get("email");
		String password = body.get("password");
		String encodedPassword = new BCryptPasswordEncoder().encode(password);
		String firstName = body.get("firstName");
		String lastName = body.get("lastName");
		String mobileNumber = body.get("mobileNumber");
		Role role = null;
		User user = null; 
		if(userInfoRepository.existsByEmail(email)) {
			return new ResponseEntity<>(ExceptionMessage.format("email '%s' sudah terdaftar", body.get("email")), HttpStatus.NOT_FOUND);
		}
		if (requestTokenHeader==null) {
			role = roleRepository.findById((long) 2).get();
			user = new User(email,encodedPassword,firstName,lastName,mobileNumber,role);
			userInfoRepository.save(user);
			roleRepository.save(role);
			return new ResponseEntity<>(ExceptionMessage.format("email '%s' berhasil terdaftar", body.get("email")), HttpStatus.OK);
		}else {
			String jwtToken = requestTokenHeader.substring(7);
			String emailToken = jwtTokenUntil.getUsernameFromToken(jwtToken);
			user = userInfoRepository.findByEmail(emailToken);
			role = user.getRole();
			user = new User(emailToken,encodedPassword,firstName,lastName,mobileNumber,role);
			userInfoRepository.save(user);
			roleRepository.save(role);
			return new ResponseEntity<>(ExceptionMessage.format("email '%s' berhasil terdaftar", body.get("email")), HttpStatus.OK);
		}
		
	}
	
	@PutMapping("/v1/user/profile")
	public ResponseEntity<?> updateProfile(@RequestBody Map<String, String> body,HttpServletRequest request)  {
		String requestTokenHeader = request.getHeader("Authorization");
		String jwtToken = null;
		jwtToken = requestTokenHeader.substring(7);
		String email = jwtTokenUntil.getUsernameFromToken(jwtToken);
		User user = userInfoRepository.findByEmail(email);
		if (user.getRole().getId()==2) {
			String firstName = body.get("firstName");
			String lastName = body.get("lastName");
			String mobileNumber = body.get("mobileNumber");

			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setMobileNumber(mobileNumber);
			userInfoRepository.save(user);

			return new ResponseEntity<>(ExceptionMessage.format("Profilmu berhasil diupdate", body.get("email")), HttpStatus.OK);
		}else {
			
			return new ResponseEntity<>(ExceptionMessage.format("Anda tidak memiliki akses ke API ini"), HttpStatus.FORBIDDEN);
		}
		
		
		
	}

	
	
	
}
