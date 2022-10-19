package id.belajar.transportationreservationsystemfix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import id.belajar.transportationreservationsystemfix.entity.Agency;
import id.belajar.transportationreservationsystemfix.entity.Role;

@Repository
public interface AgencyRepository extends JpaRepository<Agency, Integer> {
	Agency findByCode(String code);
}
