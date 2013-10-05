package uy.edu.um.client_service.service.userRemote.test;

import uy.edu.um.client_service.business.BusinessFacade;
import uy.edu.um.client_service.business.users.entities.User;
import uy.edu.um.client_service.business.users.interfaces.UserMgt;
import uy.edu.um.value_object.user.UserVO;

public class test2 {
	public static void main(String[] args){
		String name = "bforrisi";
		String password = "asd";
		boolean isAdmin = false;
		UserVO u = new UserVO(name,password,isAdmin);
		UserMgt uMgt = BusinessFacade.getInstance().getUserMgt();
		User toAdd = uMgt.getUser(u);
		uMgt.addUser(toAdd);
	}
}
