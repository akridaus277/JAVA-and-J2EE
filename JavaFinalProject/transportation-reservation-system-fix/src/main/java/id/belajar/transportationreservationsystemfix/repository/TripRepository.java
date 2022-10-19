package id.belajar.transportationreservationsystemfix.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import id.belajar.transportationreservationsystemfix.entity.Bus;
import id.belajar.transportationreservationsystemfix.entity.Stop;
import id.belajar.transportationreservationsystemfix.entity.Trip;



@Repository
public interface TripRepository extends JpaRepository<Trip, Long>{
	List<Trip> findAllBySourceStopAndDestStop(Stop sourceStop,Stop destStop);
	Trip findBySourceStopAndDestStopAndBus(Stop sourceStop,Stop destStop,Bus bus);
}
