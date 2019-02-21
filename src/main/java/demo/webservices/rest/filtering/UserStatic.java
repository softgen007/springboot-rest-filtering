package demo.webservices.rest.filtering;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserStatic {
	
	private Integer id;
	
	private String userName;
	
	@JsonIgnore
	private String password;
	
	private String firstName;
	
	private String lastName;
	

	public UserStatic(Integer id, String userName, String password, String firstName, String lastName) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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


	@Override
	public String toString() {
		return String.format("User [id=%s, userName=%s, password=%s, firstName=%s, lastName=%s]", id, userName, password, firstName, lastName);
	}
}
