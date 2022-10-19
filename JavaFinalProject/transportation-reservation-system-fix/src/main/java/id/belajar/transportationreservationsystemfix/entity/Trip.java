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
@Table(name = "trip")
public class Trip implements Serializable{

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="trip_id")
	private int id;
	
	@Column(name="fare")
	private long fare;
	
	@Column(name="journey_time")
	private long journeyTime;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "agency_id", nullable = false)
	private Agency agency;
	

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "bus_id", nullable = false)
	private Bus bus;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "dest_stop_id", nullable = false)
	private Stop destStop;
	

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "source_stop_id", nullable = false)
	private Stop sourceStop;
	
	@JsonIgnore
	@OneToMany(mappedBy = "trip", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	private Set<TripSchedule> tripSchedules;
	public void addTripSchedule(TripSchedule tripSchedule){
		tripSchedules.add(tripSchedule);
        tripSchedule.setTrip(this);
    }
    public void removeTripSchedule(TripSchedule tripSchedule){
    	tripSchedules.remove(tripSchedule);
        tripSchedule.setTrip(null);
    }

	public Trip() {
		
	}
	

	public Trip(long fare, long journeyTime, Agency agency, Bus bus, Stop destStop, Stop sourceStop) {
		super();
		this.fare = fare;
		this.journeyTime = journeyTime;
		this.agency = agency;
		this.bus = bus;
		this.destStop = destStop;
		this.sourceStop = sourceStop;
	}
	public long getFare() {
		return fare;
	}
	public void setFare(long fare) {
		this.fare = fare;
	}

	public Agency getAgency() {
		return agency;
	}
	public void setAgency(Agency agency) {
		this.agency = agency;
	}
	public Bus getBus() {
		return bus;
	}
	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public Set<TripSchedule> getTripSchedules() {
		return tripSchedules;
	}
	public void setTripSchedules(Set<TripSchedule> tripSchedules) {
		this.tripSchedules = tripSchedules;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getJourneyTime() {
		return journeyTime;
	}
	public void setJourneyTime(long journeyTime) {
		this.journeyTime = journeyTime;
	}
	public Stop getDestStop() {
		return destStop;
	}
	public void setDestStop(Stop destStop) {
		this.destStop = destStop;
	}
	public Stop getSourceStop() {
		return sourceStop;
	}
	public void setSourceStop(Stop sourceStop) {
		this.sourceStop = sourceStop;
	}

	
	
	
	
	
}

