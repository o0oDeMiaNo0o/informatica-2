package uy.edu.um.value_object.administraor;


public class AdministratorVO{

	String user, password;

	public AdministratorVO(String user, String password){
		this.user = user;
		this.password = password;
	}



	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}




}
