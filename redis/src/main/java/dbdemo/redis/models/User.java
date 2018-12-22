package dbdemo.redis.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class User implements java.io.Serializable{
	private String userId;
	private String username;
	private String email;
	private Date registrationDate = new Date();
	private Set<String> roles = new HashSet<>();

	public User() { }

	public User(String userId, String username,
                Date registrationDate, Set<String> roles) {
		this.userId = userId;
		this.username = username;
		this.registrationDate = registrationDate;
		this.roles = roles;

	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}

}
