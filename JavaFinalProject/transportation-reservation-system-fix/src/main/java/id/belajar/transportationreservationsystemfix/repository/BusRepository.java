package id.belajar.transportationreservationsystemfix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import id.belajar.transportationreservationsystemfix.entity.Bus;


@Repository
public interface BusRepository extends JpaRepository<Bus, Integer> {

}

