package uy.edu.um.client_service.service.userRemote.test;

import java.util.ArrayList;

import uy.edu.um.client_service.business.BusinessFacade;
import uy.edu.um.client_service.business.users.interfaces.UserMgt;
import uy.edu.um.value_object.user.UserVO;

public class test2 {
	public static void main(String[] args){
		UserMgt umgt = BusinessFacade.getInstance().getUserMgt();
		String nombre = "Bernardo";
		String pass = "uss";
		String crypted = umgt.hashPassword(pass);
		System.out.println(crypted);
	}
}
