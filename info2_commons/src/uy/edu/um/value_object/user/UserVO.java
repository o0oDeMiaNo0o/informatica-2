package uy.edu.um.value_object.user;


public class UserVO{

	String user, password;
	boolean isAdmin;

	public UserVO(String user, String password,boolean isAdmin){
		this.user = user;
		this.password = password;
		this.isAdmin = isAdmin;
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



	public boolean isAdmin() {
		return isAdmin;
	}



	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}




}
