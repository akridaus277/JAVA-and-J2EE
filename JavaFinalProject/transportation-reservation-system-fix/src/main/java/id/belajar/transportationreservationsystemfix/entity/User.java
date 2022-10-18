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
@Table(name = "user")
public class User implements Serializable{

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private int id;
	
	@Column(name="email")
	private String email;
	
	@JsonIgnore
	@Column(name="password")
	private String password;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="mobile_number")
	private String mobileNumber;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "role_id", nullable = false)
	private Role role;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	private Set<Agency> agencies;
	public void addAgency(Agency agency){
		agencies.add(agency);
        agency.setUser(this);
    }
    public void removeAgency(Agency agency){
    	agencies.remove(agency);
        agency.setUser(null);
    }
    

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	private Set<Ticket> tickets;
	public void addTicket(Ticket ticket){
		tickets.add(ticket);
        ticket.setUser(this);
    }
    public void removeTicket(Ticket ticket){
    	tickets.remove(ticket);
        ticket.setUser(null);
    }

	public User() {
		
	}

	public User(String email, String password, String firstName, String lastName, String mobileNumber, Role role) {
		super();
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.role = role;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Set<Agency> getAgencies() {
		return agencies;
	}
	public void setAgencies(Set<Agency> agencies) {
		this.agencies = agencies;
	}
	public Set<Ticket> getTickets() {
		return tickets;
	}
	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}
	
	

	

	
	
	
	
	
	
	
}
