package id.belajar.transportationreservationsystemfix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import id.belajar.transportationreservationsystemfix.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
