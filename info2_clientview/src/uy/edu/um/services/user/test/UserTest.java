package uy.edu.um.services.user.test;

import java.util.ArrayList;

import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.user.interfaces.UserMgt;
import uy.edu.um.value_object.user.UserVO;

public class UserTest {
	public static void main(String[] args) {
		UserMgt uMgt = ServiceFacade.getInstance().getUserMgt();
		ArrayList<UserVO> allUsers = new ArrayList<UserVO>(10);
		allUsers = uMgt.allUsers();
		int v = 34;
	}

}
