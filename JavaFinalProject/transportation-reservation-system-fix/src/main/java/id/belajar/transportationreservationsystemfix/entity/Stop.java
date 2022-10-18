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
@Table(name = "stop")
public class Stop implements Serializable{

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="stop_id")
	private int id;
	
	@Column(name="code")
	private String code;
	
	@Column(name="detail")
	private String detail;
	
	@Column(name="name")
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy = "destStop", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	private Set<Trip> destStopTrips;
	public void addDestStopTrip(Trip trip){
		destStopTrips.add(trip);
        trip.setDestStop(this);
    }
    public void removeDestStopTrip(Trip trip){
    	destStopTrips.remove(trip);
        trip.setDestStop(null);
    }
    
    @JsonIgnore
    @OneToMany(mappedBy = "sourceStop", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	private Set<Trip> sourceStopTrips;
	public void addSourceStopTrip(Trip trip){
		sourceStopTrips.add(trip);
        trip.setSourceStop(this);
    }
    public void removeSourceStopTrip(Trip trip){
    	sourceStopTrips.remove(trip);
        trip.setSourceStop(null);
    }


	public Stop() {
		
	}
	public Stop(String code, String detail, String name) {
		super();
		this.code = code;
		this.detail = detail;
		this.name = name;
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
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Trip> getDestStopTrips() {
		return destStopTrips;
	}
	public void setDestStopTrips(Set<Trip> destStopTrips) {
		this.destStopTrips = destStopTrips;
	}
	public Set<Trip> getSourceStopTrips() {
		return sourceStopTrips;
	}
	public void setSourceStopTrips(Set<Trip> sourceStopTrips) {
		this.sourceStopTrips = sourceStopTrips;
	}
	
	


	

	
	
	
	
	
	
	
}
