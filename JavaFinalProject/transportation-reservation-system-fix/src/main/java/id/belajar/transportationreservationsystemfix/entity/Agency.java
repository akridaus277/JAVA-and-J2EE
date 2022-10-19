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
@Table(name = "agency")
public class Agency implements Serializable{

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="agency_id")
	private int id;
	
	@Column(name="code")
	private String code;
	
	@Column(name="details")
	private String details;
	
	@Column(name="name")
	private String name;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "owner_user_id", nullable = false)
	private User user;

	@JsonIgnore
	@OneToMany(mappedBy = "agency", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	private Set<Bus> buses;
	public void addBus(Bus bus){
		buses.add(bus);
        bus.setAgency(this);
    }
    public void removeBus(Bus bus){
    	buses.remove(bus);
        bus.setAgency(null);
    }

    @JsonIgnore
    @OneToMany(mappedBy = "agency", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	private Set<Trip> trips;
	public void addTrip(Trip trip){
		trips.add(trip);
        trip.setAgency(this);
    }
    public void removeTrip(Trip trip){
    	trips.remove(trip);
        trip.setAgency(null);
    }
	
	public Agency() {
		
	}
	public Agency(String code, String details, String name, User user) {
		super();
		this.code = code;
		this.details = details;
		this.name = name;
		this.user = user;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Set<Bus> getBuses() {
		return buses;
	}
	public void setBuses(Set<Bus> buses) {
		this.buses = buses;
	}
	public Set<Trip> getTrips() {
		return trips;
	}
	public void setTrips(Set<Trip> trips) {
		this.trips = trips;
	}
	
	
	

	
	

	
	
	
	
	
	
	
}

