package id.belajar.transportationreservationsystemfix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import id.belajar.transportationreservationsystemfix.entity.Agency;

@Repository
public interface AgencyRepository extends JpaRepository<Agency, Integer> {

}
