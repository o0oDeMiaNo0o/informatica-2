package uy.edu.um.services.user.test;

import java.util.ArrayList;

import uy.edu.um.exceptions.checks.HasBlanksException;
import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.user.interfaces.UserMgt;
import uy.edu.um.value_object.user.UserVO;

public class UserTest {
	public static void main(String[] args) {
		UserMgt uMgt = ServiceFacade.getInstance().getUserMgt();
		String nombre = "ber";
		String pass = "pass";
		UserVO u = null;
		try {
			u = uMgt.createUserVO(nombre, pass, false);
		} catch (HasBlanksException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		uMgt.addUser(u);
		int v = 34;
	}

}
