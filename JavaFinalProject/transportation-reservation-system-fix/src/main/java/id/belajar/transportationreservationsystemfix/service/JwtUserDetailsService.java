package id.belajar.transportationreservationsystemfix.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import id.belajar.transportationreservationsystemfix.entity.User;
import id.belajar.transportationreservationsystemfix.repository.UserRepository;



@Component
public class JwtUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userInfoRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		User user = userInfoRepository.findByEmail(email);
		
		if(user == null) {
			throw new UsernameNotFoundException("User not found with username: " +email);
		}
		
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>());
		
	}
	
}
