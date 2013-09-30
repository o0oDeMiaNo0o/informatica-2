package uy.edu.um.client_service.business.users.entities;

public class User {


	private String Username;
	private String Password;
	boolean admin = false;

	public User(String Username, String password, boolean admin){
		this.Username = Username;
		this.Password = password;
		this.admin = admin;
	}

	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}



}
