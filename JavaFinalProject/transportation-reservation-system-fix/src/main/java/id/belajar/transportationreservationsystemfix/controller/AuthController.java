package id.belajar.transportationreservationsystemfix.controller;




import javax.naming.AuthenticationException;

import org.apache.catalina.authenticator.SpnegoAuthenticator.AuthenticateAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.belajar.transportationreservationsystemfix.config.JwtToken;
import id.belajar.transportationreservationsystemfix.entity.JwtRequest;
import id.belajar.transportationreservationsystemfix.entity.JwtResponse;
import id.belajar.transportationreservationsystemfix.service.JwtUserDetailsService;
import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/api")
public class AuthController {

	

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtToken jwtToken;
	
	@Autowired
	private JwtUserDetailsService jwtUserDetailsService;
	
	@PostMapping("/auth")
	public ResponseEntity<?> createAuthenticationToken(
			@RequestBody JwtRequest authenticationRequest)
	
		
		throws Exception{

			String email = authenticationRequest.getEmail();
			String password = authenticationRequest.getPassword();


			authenticate(email, password);
			
//			try {
//				 authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//			} catch (DisabledException e) {
//				// TODO: handle exception
//				throw new Exception("USER_DISABLED", e);
//			}catch(BadCredentialsException e){
//				 throw new Exception("INVALID_CREDENTIALS",e);
//				
//			}
			
			final UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(authenticationRequest.getEmail());
			final String tokenString= jwtToken.generateToken(userDetails);
			return ResponseEntity.ok(new JwtResponse(tokenString));
		}
	
	private void authenticate(String email, String password) throws Exception {
		
		 try {

	            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
	        } catch (DisabledException e) {
	            throw new Exception("USER_DISABLED", e);
	        } catch (BadCredentialsException e) {
	            throw new Exception("INVALID_CREDENTIALS", e);
	        }
	
	}
	
}
	

