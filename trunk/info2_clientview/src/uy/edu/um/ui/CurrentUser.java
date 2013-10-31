package uy.edu.um.ui;

import uy.edu.um.value_object.user.UserVO;

public class CurrentUser {
	private static UserVO user;

	public CurrentUser(UserVO user){
		this.user = user;
	}

	public static UserVO getUser() {
		return user;
	}

	public void setUser(UserVO user) {
		this.user = user;
	}


}
