package id.belajar.transportationreservationsystemfix.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "role")
public class Role implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="role_id")
	private long id;
	
	public enum role_name {
	    ADMIN,PASSENGER;
	}
	
	@Column(name = "role")
	private String role;
	
	@JsonIgnore
	@OneToMany(mappedBy = "role", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	private Set<User> users;
	public void addUser(User user){
        users.add(user);
        user.setRole(this);
    }
    public void removeUser(User user){
        users.remove(user);
        user.setRole(null);
    }
	
	public Role() {
	}

	public Role(long id, String role) {
		super();
		this.id = id;
		this.role = role;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	

	

	
}
