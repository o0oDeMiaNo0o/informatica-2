package uy.edu.um.client_service.service.userRemote.test;

import java.util.ArrayList;

import uy.edu.um.client_service.business.BusinessFacade;
import uy.edu.um.client_service.business.users.interfaces.UserMgt;
import uy.edu.um.value_object.user.UserVO;

public class test2 {
	public static void main(String[] args){
		ArrayList<UserVO> allUsers = new ArrayList<UserVO>(10);
		UserMgt umgt = BusinessFacade.getInstance().getUserMgt();
		allUsers = umgt.allUsers();
	}
}
