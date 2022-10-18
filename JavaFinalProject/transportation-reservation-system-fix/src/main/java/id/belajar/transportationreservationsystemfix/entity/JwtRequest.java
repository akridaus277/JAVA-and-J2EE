package id.belajar.transportationreservationsystemfix.entity;

import java.io.Serializable;

public class JwtRequest implements Serializable{

	private static final long serialVersionUID = 5926468583005150707L;

	private String email;
	private String password;
	
	public JwtRequest() {
		
	}

	
	
//	public JwtRequest(String username, String password) {
//		
//		this.setUsername(username);
//		this.setPassword(password);
//	}
	
	public JwtRequest(String email, String password) {
		super();
		this.email = email;
		this.password = password;
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


	
	
	
	

}