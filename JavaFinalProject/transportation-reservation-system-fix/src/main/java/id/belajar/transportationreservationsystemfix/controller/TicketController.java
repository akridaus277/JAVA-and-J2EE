package id.belajar.transportationreservationsystemfix.controller;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.ValidationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
import id.belajar.transportationreservationsystemfix.entity.Ticket;
import id.belajar.transportationreservationsystemfix.entity.Trip;
import id.belajar.transportationreservationsystemfix.entity.TripSchedule;
import id.belajar.transportationreservationsystemfix.repository.RoleRepository;
import id.belajar.transportationreservationsystemfix.repository.StopRepository;
import id.belajar.transportationreservationsystemfix.repository.TicketRepository;
import id.belajar.transportationreservationsystemfix.repository.TripRepository;
import id.belajar.transportationreservationsystemfix.repository.TripScheduleRepository;
import id.belajar.transportationreservationsystemfix.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class TicketController {

	final private UserRepository userInfoRepository;
	
	final private RoleRepository roleRepository;
	final private StopRepository stopRepository;
	final private TripRepository tripRepository;
	final private TripScheduleRepository tripScheduleRepository;
	final private TicketRepository ticketRepository;
	private final JwtToken jwtTokenUntil;

	public TicketController(JwtToken jwtTokenUntil,UserRepository userInfoRepository,RoleRepository roleRepository,StopRepository stopRepository,TripRepository tripRepository,TripScheduleRepository tripScheduleRepository,TicketRepository ticketRepository) {
		this.roleRepository = roleRepository;
		this.userInfoRepository = userInfoRepository;
		this.stopRepository = stopRepository;
		this.tripRepository = tripRepository;
		this.tripScheduleRepository = tripScheduleRepository;
		this.ticketRepository = ticketRepository;
		this.jwtTokenUntil = jwtTokenUntil;
	}

	
	@PostMapping("/v1/reservation/bookticket")
	public ResponseEntity<?> bookTicket(@RequestBody Map<String, String> body,HttpServletRequest request) {
		String requestTokenHeader = request.getHeader("Authorization");
		String jwtToken = null;
		jwtToken = requestTokenHeader.substring(7);
		String email = jwtTokenUntil.getUsernameFromToken(jwtToken);
		User user = userInfoRepository.findByEmail(email);

		if (user.getRole().getId()==1) {
			int tripScheduleId = Integer.parseInt(body.get("tripScheduleId")) ;
			TripSchedule tripSchedule = tripScheduleRepository.findById(tripScheduleId).get();
			String journeyDate = tripSchedule.getTripDate();
			long seatNumber = tripSchedule.getTrip().getBus().getCapacity() - tripSchedule.getAvailableSeats()+1;
			boolean cancellable = false;
			Ticket ticket = new Ticket(cancellable,journeyDate,seatNumber,user,tripSchedule);
			user.addTicket(ticket);
			tripSchedule.setAvailableSeats(tripSchedule.getAvailableSeats() - 1);
			ticketRepository.save(ticket);
			tripScheduleRepository.save(tripSchedule);
			userInfoRepository.save(user);
			return new ResponseEntity<>(ExceptionMessage.format("Booking ticket untuk TripSchedule '%s' berhasil",Integer.toString(tripSchedule.getId())), HttpStatus.OK);
		}else {
			
			return new ResponseEntity<>(ExceptionMessage.format("Anda tidak memiliki akses ke API ini"), HttpStatus.FORBIDDEN);
		}
		
	}

	

	
	
	
}