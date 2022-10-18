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
@Table(name = "bus")
public class Bus implements Serializable{

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="bus_id")
	private int id;
	
	@Column(name="capacity")
	private long capacity;
	
	@Column(name="code")
	private String code;
	
	@Column(name="make")
	private String make;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "agency_id", nullable = false)
	private Agency agency;
	
	@JsonIgnore
	@OneToMany(mappedBy = "bus", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	private Set<Trip> trips;
	public void addTrip(Trip trip){
		trips.add(trip);
        trip.setBus(this);
    }
    public void removeTrip(Trip trip){
    	trips.remove(trip);
        trip.setBus(null);
    }
	

	public Bus() {
		
	}
	public Bus(long capacity, String code, String make, Agency agency) {
		super();
		this.capacity = capacity;
		this.code = code;
		this.make = make;
		this.agency = agency;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getCapacity() {
		return capacity;
	}
	public void setCapacity(long capacity) {
		this.capacity = capacity;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public Agency getAgency() {
		return agency;
	}
	public void setAgency(Agency agency) {
		this.agency = agency;
	}
	public Set<Trip> getTrips() {
		return trips;
	}
	public void setTrips(Set<Trip> trips) {
		this.trips = trips;
	}
		
}
