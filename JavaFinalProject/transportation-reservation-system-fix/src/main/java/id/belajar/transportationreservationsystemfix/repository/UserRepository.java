package id.belajar.transportationreservationsystemfix.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import id.belajar.transportationreservationsystemfix.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	Boolean existsByEmail(String email);
	User findByEmail(String email);

}
