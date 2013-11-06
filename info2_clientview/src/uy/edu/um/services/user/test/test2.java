package uy.edu.um.services.user.test;

import uy.edu.um.exceptions.checks.NoServerConnectionException;
import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.user.interfaces.UserMgt;
import uy.edu.um.value_object.user.UserVO;

public class test2 {
	public static void main(String[] args) throws NoServerConnectionException{
		String nombre = "vamolospibe";
		String pass = "om12";
		UserMgt uMgt = ServiceFacade.getInstance().getUserMgt();
		//UserVO added = uMgt.createUserVO(nombre, pass, false);
		//uMgt.addUser(added);
		boolean check = uMgt.checkLogin(nombre, pass);
		System.out.println(check);
	}
}
