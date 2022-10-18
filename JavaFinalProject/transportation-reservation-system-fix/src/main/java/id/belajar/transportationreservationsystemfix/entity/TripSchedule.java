package id.belajar.transportationreservationsystemfix.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "trip_schedule")
public class TripSchedule implements Serializable{

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="trip_schedule_id")
	private int id;
	
	@Column(name="available_seats")
	private long availableSeats;
	
	@Column(name="trip_date")
	private String tripDate;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "trip_id", nullable = false)
	private Trip trip;
	
	@JsonIgnore
	@OneToMany(mappedBy = "tripSchedule", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	private Set<Ticket> tickets;
	public void addTicket(Ticket ticket){
		tickets.add(ticket);
        ticket.setTripSchedule(this);
    }
    public void removeTicket(Ticket ticket){
    	tickets.remove(ticket);
        ticket.setTripSchedule(null);
    }

	public TripSchedule() {
		
	}


	public TripSchedule(long availableSeats, String tripDate, Trip trip) {
		super();
		this.availableSeats = availableSeats;
		this.tripDate = tripDate;
		this.trip = trip;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(long availableSeats) {
		this.availableSeats = availableSeats;
	}
	public String getTripDate() {
		return tripDate;
	}
	public void setTripDate(String tripDate) {
		this.tripDate = tripDate;
	}
	public Trip getTrip() {
		return trip;
	}
	public void setTrip(Trip trip) {
		this.trip = trip;
	}
	public Set<Ticket> getTickets() {
		return tickets;
	}
	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}

	
	


	

	
	
	
	
	
	
	
}