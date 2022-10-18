package id.belajar.transportationreservationsystemfix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import antlr.collections.List;
import id.belajar.transportationreservationsystemfix.entity.Stop;

@Repository
public interface StopRepository extends JpaRepository<Stop, Integer> {
	Stop findByCode(String code);
}
