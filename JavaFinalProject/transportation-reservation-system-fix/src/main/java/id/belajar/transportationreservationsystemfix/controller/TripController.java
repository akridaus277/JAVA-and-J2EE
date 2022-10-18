package id.belajar.transportationreservationsystemfix.controller;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.ValidationException;

import org.aspectj.apache.bcel.classfile.NestHost;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.belajar.transportationreservationsystemfix.config.JwtToken;
import id.belajar.transportationreservationsystemfix.entity.Agency;
import id.belajar.transportationreservationsystemfix.entity.Bus;
import id.belajar.transportationreservationsystemfix.entity.Role;
import id.belajar.transportationreservationsystemfix.entity.User;
import id.belajar.transportationreservationsystemfix.entity.Role.role_name;
import id.belajar.transportationreservationsystemfix.exception.ExceptionMessage;
import id.belajar.transportationreservationsystemfix.entity.Stop;
import id.belajar.transportationreservationsystemfix.entity.Trip;
import id.belajar.transportationreservationsystemfix.entity.TripSchedule;
import id.belajar.transportationreservationsystemfix.repository.AgencyRepository;
import id.belajar.transportationreservationsystemfix.repository.BusRepository;
import id.belajar.transportationreservationsystemfix.repository.RoleRepository;
import id.belajar.transportationreservationsystemfix.repository.StopRepository;
import id.belajar.transportationreservationsystemfix.repository.TripRepository;
import id.belajar.transportationreservationsystemfix.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class TripController {

	final private UserRepository userInfoRepository;
	
	final private RoleRepository roleRepository;
	final private StopRepository stopRepository;
	final private TripRepository tripRepository;
	final private AgencyRepository agencyRepository;
	final private BusRepository busRepository;
	final private JwtToken jwtTokenUntil;

	public TripController(JwtToken jwtTokenUntil,BusRepository busRepository,AgencyRepository agencyRepository,UserRepository userInfoRepository,RoleRepository roleRepository,StopRepository stopRepository,TripRepository tripRepository) {
		this.roleRepository = roleRepository;
		this.userInfoRepository = userInfoRepository;
		this.stopRepository = stopRepository;
		this.tripRepository = tripRepository;
		this.busRepository = busRepository;
		this.agencyRepository = agencyRepository;
		this.jwtTokenUntil = jwtTokenUntil;
	}
	
	@GetMapping("/v1/reservation/tripsbystops")
	public ResponseEntity<?> getTripsByStops(@RequestBody Map<String, String> body,HttpServletRequest request){
		String requestTokenHeader = request.getHeader("Authorization");
		String jwtToken = null;
		jwtToken = requestTokenHeader.substring(7);
		String email = jwtTokenUntil.getUsernameFromToken(jwtToken);
		User user = userInfoRepository.findByEmail(email);
		String sourceStopCodeString = body.get("sourceStopCode");
		String destinationStopCodeString = body.get("destinationStopCode");
		Stop sourceStop = stopRepository.findByCode(sourceStopCodeString);
		Stop destinationStop = stopRepository.findByCode(destinationStopCodeString);
		
		if (user.getRole().getId()==1) {

			return new ResponseEntity<List<Trip>>(tripRepository.findAllBySourceStopAndDestStop(sourceStop,destinationStop), HttpStatus.OK);
		}else {
			
			return new ResponseEntity<>(ExceptionMessage.format("Anda tidak memiliki akses ke API ini"), HttpStatus.FORBIDDEN);
		}

	}
	
	@PostMapping("/v1/reservation/trip")
	public ResponseEntity<?> createTrip(@RequestBody Map<String, String> body,HttpServletRequest request) {
		String requestTokenHeader = request.getHeader("Authorization");
		String jwtToken = null;
		jwtToken = requestTokenHeader.substring(7);
		String email = jwtTokenUntil.getUsernameFromToken(jwtToken);
		User user = userInfoRepository.findByEmail(email);
		
		
		long fare = Long.parseLong(body.get("fare"));
		long journey_time = Long.parseLong(body.get("journey_time"));
		int bus_id = Integer.parseInt(body.get("bus_id"));
		int dest_stop_id = Integer.parseInt(body.get("dest_stop_id"));
		int source_stop_id = Integer.parseInt(body.get("source_stop_id"));
		if (user.getRole().getId()==2) {
			Bus bus = busRepository.findById(bus_id).get();
			Agency agency = bus.getAgency();
			Stop destStop = stopRepository.findById(dest_stop_id).get();
			Stop sourceStop = stopRepository.findById(source_stop_id).get();
			Trip trip = new Trip(fare,journey_time,agency,bus,destStop,sourceStop);
			agency.addTrip(trip);
			destStop.addDestStopTrip(trip);
			sourceStop.addSourceStopTrip(trip);
			tripRepository.save(trip);
			agencyRepository.save(agency);
			stopRepository.save(destStop);
			stopRepository.save(sourceStop);
			return new ResponseEntity<>(ExceptionMessage.format("Trip untuk Bus '%s' dari Stop '%s' ke Stop '%s' berhasil dibuat",bus.getCode(),sourceStop.getCode(),destStop.getCode()), HttpStatus.OK);
		}else {
			
			return new ResponseEntity<>(ExceptionMessage.format("Anda tidak memiliki akses ke API ini"), HttpStatus.FORBIDDEN);
		}
		

	}

	

	
	
	
}