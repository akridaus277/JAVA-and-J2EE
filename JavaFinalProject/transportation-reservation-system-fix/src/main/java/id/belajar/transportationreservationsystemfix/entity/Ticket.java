package id.belajar.transportationreservationsystemfix.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ticket")
public class Ticket implements Serializable{

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ticket_id")
	private int id;
	
	@Column(name="cancellable")
	private boolean cancellable;
	
	@Column(name="journey_date")
	private String journeyDate;
	
	@Column(name="seat_number")
	private long seatNumber;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "trip_schedule_id", nullable = false)
	private TripSchedule tripSchedule;

	public Ticket() {
		
	}



	public Ticket(boolean cancellable, String journeyDate, long seatNumber, User user, TripSchedule tripSchedule) {
		super();
		this.cancellable = cancellable;
		this.journeyDate = journeyDate;
		this.seatNumber = seatNumber;
		this.user = user;
		this.tripSchedule = tripSchedule;
	}




	public boolean getCancellable() {
		return cancellable;
	}

	public void setCancellable(boolean cancellable) {
		this.cancellable = cancellable;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getJourneyDate() {
		return journeyDate;
	}



	public void setJourneyDate(String journeyDate) {
		this.journeyDate = journeyDate;
	}



	public long getSeatNumber() {
		return seatNumber;
	}



	public void setSeatNumber(long seatNumber) {
		this.seatNumber = seatNumber;
	}



	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public TripSchedule getTripSchedule() {
		return tripSchedule;
	}

	public void setTripSchedule(TripSchedule tripSchedule) {
		this.tripSchedule = tripSchedule;
	}
	


	

	
	
	
	
	
	
	
}
