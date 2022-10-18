package id.belajar.transportationreservationsystemfix.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.belajar.transportationreservationsystemfix.entity.User;
import id.belajar.transportationreservationsystemfix.repository.UserRepository;



@Service
@Transactional
public class UserService {
	@Autowired
	private UserRepository userRepository;
	public List<User> listAllUser(){
		return userRepository.findAll();
	}
	public User saveUser(User user){
//		userRepository.save(user);
		return userRepository.save(user);
	}
	public User getUser(Integer id) {
		Optional<User> userOptional = userRepository.findById(id);
		if (userOptional.isPresent()) {
			return userOptional.get();
		}
		return null;
//		return produkRepository.findById(id).get();
	}
	public void deleteUser(Integer id) {
		Optional<User> userOptional = userRepository.findById(id);
		if (userOptional.isPresent()) {
			userRepository.deleteById(id);
		}
//		produkRepository.deleteById(id);
	}
}
