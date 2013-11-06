package uy.edu.um.services.user.test;

import uy.edu.um.exceptions.checks.NoServerConnectionException;
import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.user.interfaces.UserMgt;

public class UserTest {
	public static void main(String[] args) throws NoServerConnectionException {
		UserMgt uMgt = ServiceFacade.getInstance().getUserMgt();
		String nombre = "Daniel";
		String pass = "jaja";
		System.out.println(uMgt.checkLogin(nombre, pass));
	}

}
