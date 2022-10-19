package id.belajar.transportationreservationsystemfix;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import id.belajar.transportationreservationsystemfix.entity.Agency;
import id.belajar.transportationreservationsystemfix.entity.Bus;
import id.belajar.transportationreservationsystemfix.entity.Role;
import id.belajar.transportationreservationsystemfix.entity.Stop;
import id.belajar.transportationreservationsystemfix.entity.Trip;
import id.belajar.transportationreservationsystemfix.entity.TripSchedule;
import id.belajar.transportationreservationsystemfix.entity.User;
import id.belajar.transportationreservationsystemfix.repository.AgencyRepository;
import id.belajar.transportationreservationsystemfix.repository.BusRepository;
import id.belajar.transportationreservationsystemfix.repository.RoleRepository;
import id.belajar.transportationreservationsystemfix.repository.StopRepository;
import id.belajar.transportationreservationsystemfix.repository.TripRepository;
import id.belajar.transportationreservationsystemfix.repository.TripScheduleRepository;
import id.belajar.transportationreservationsystemfix.repository.UserRepository;

@SpringBootApplication
public class TransportationReservationSystemFixApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransportationReservationSystemFixApplication.class, args);
	}
	@Bean
    CommandLineRunner init(RoleRepository roleRepository, UserRepository userRepository,
                           StopRepository stopRepository, AgencyRepository agencyRepository,
                           BusRepository busRepository, TripRepository tripRepository,
                           TripScheduleRepository tripScheduleRepository) {
        return args -> {
            //Create Admin and Passenger Roles
        	Role adminRole = roleRepository.findByRole("ADMIN");
        	if (adminRole == null) {
        		adminRole = new Role();
                adminRole.setRole("ADMIN");
                roleRepository.save(adminRole);
                Role userRole = new Role();
                userRole.setRole("PASSENGER");
                roleRepository.save(userRole);
        	}
        	Role passengerRole = roleRepository.findByRole("PASSENGER");
        	if (passengerRole == null) {
        		passengerRole = new Role();
        		passengerRole.setRole("PASSENGER");
                roleRepository.save(passengerRole);
                Role userRole = new Role();
                userRole.setRole("PASSENGER");
                roleRepository.save(userRole);
        	}
        	
          //Create Admin and Passenger
        	User admin = userRepository.findByEmail("admin@gmail.com");
        	if (admin == null) {
        		admin = new User();
                admin.setEmail("admin@gmail.com");
                admin.setPassword("$2a$10$7PtcjEnWb/ZkgyXyxY1/Iei2dGgGQUbqIIll/dt.qJ8l8nQBWMbYO");// "123456"
                admin.setFirstName("John");
                admin.setLastName("Doe");
                admin.setMobileNumber("9425094250");
                admin.setRole(adminRole);
                userRepository.save(admin);
            }
            
        	User passenger = userRepository.findByEmail("passenger@gmail.com");
        	if (passenger == null) {
        		passenger = new User();
                passenger.setEmail("passenger@gmail.com");
                passenger.setPassword("$2a$10$7PtcjEnWb/ZkgyXyxY1/Iei2dGgGQUbqIIll/dt.qJ8l8nQBWMbYO");// "123456"
                passenger.setFirstName("Mira");
                passenger.setLastName("Jane");
                passenger.setMobileNumber("8000110008");
                passenger.setRole(passengerRole);
                userRepository.save(passenger);
            }

          //Create four stops
        	Stop stopA = stopRepository.findByCode("STPA");
            if (stopA == null) {
            	stopA = new Stop();
                stopA.setName("Stop A");
                stopA.setDetail("Near hills");
                stopA.setCode("STPA");
                stopRepository.save(stopA);
            }
            Stop stopB = stopRepository.findByCode("STPB");
            if (stopB == null) {
            	stopB = new Stop();
                stopB.setName("Stop B");
                stopB.setDetail("Near river");
                stopB.setCode("STPB");
                stopRepository.save(stopB);
            }
            Stop stopC = stopRepository.findByCode("STPC");
            if (stopC == null) {
            	stopC = new Stop();
                stopC.setName("Stop C");
                stopC.setDetail("Near desert");
                stopC.setCode("STPC");
                stopRepository.save(stopC);
            }
            Stop stopD = stopRepository.findByCode("STPD");
            if (stopD == null) {
                stopD = new Stop();
                stopD.setName("Stop D");
                stopD.setDetail("Near lake");
                stopD.setCode("STPD");
                stopRepository.save(stopD);
            }
          //Create an Agency
            Agency agencyA = agencyRepository.findByCode("AGENCY-A");
            if (agencyA == null) {
                agencyA = new Agency();
                agencyA.setName("Green Mile Agency");
                agencyA.setCode("AGENCY-A");
                agencyA.setDetails("Reaching desitnations with ease");
                agencyA.setUser(admin);
                agencyRepository.save(agencyA);
            }
          //Create a bus
            Bus busA = busRepository.findByCode("AGENCY-A-1");
            if (busA == null) {
                busA = new Bus();
                busA.setCode("AGENCY-A-1");
                busA.setAgency(agencyA);
                busA.setCapacity(60);
                busRepository.save(busA);
            }
          //Add busA to set of buses owned by Agency 'AGENCYA'
            if (agencyA.getBuses() == null) {
                Set<Bus> buses = new HashSet<>();
                agencyA.setBuses(buses);
                agencyA.getBuses().add(busA);
                agencyRepository.save(agencyA);
            }
          //Create a Trip
            Trip trip = tripRepository.findBySourceStopAndDestStopAndBus(stopA, stopB, busA);
            if (trip == null) {
                trip = new Trip();
                trip.setSourceStop(stopA);
                trip.setDestStop(stopB);
                trip.setBus(busA);
                trip.setAgency(agencyA);
                trip.setFare(100);
                trip.setJourneyTime(60);
                tripRepository.save(trip);
            }
          //Create a trip schedule
            TripSchedule tripSchedule = tripScheduleRepository.findByTripAndTripDate(trip, new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()));
            if (tripSchedule == null) {
                tripSchedule = new TripSchedule();
                tripSchedule.setTrip(trip);
                tripSchedule.setTripDate("2022-10-16");
                tripSchedule.setAvailableSeats(busA.getCapacity());
                tripScheduleRepository.save(tripSchedule);
            }
            


        };
    }

}
