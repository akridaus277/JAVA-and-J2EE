package id.belajar.transportationreservationsystemfix.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import id.belajar.transportationreservationsystemfix.entity.Stop;
import id.belajar.transportationreservationsystemfix.entity.Trip;
import id.belajar.transportationreservationsystemfix.entity.TripSchedule;


@Repository
public interface TripScheduleRepository extends JpaRepository<TripSchedule, Integer> {
	List<TripSchedule> findAllByTripDate(String tripDate);
	TripSchedule findByTripAndTripDate(Trip trip, String tripDate);
}

