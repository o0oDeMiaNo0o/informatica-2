package uy.edu.um.client_service.service.userRemote.test;

import uy.edu.um.client_service.business.BusinessFacade;
import uy.edu.um.client_service.business.users.entities.User;
import uy.edu.um.client_service.business.users.interfaces.UserMgt;
import uy.edu.um.exceptions.checks.NoDatabaseConnection;
import uy.edu.um.value_object.user.UserVO;

public class UserRemoteTest {
	public static void main(String[] args) throws NoDatabaseConnection {
		UserMgt uMgt = BusinessFacade.getInstance().getUserMgt();
		String username = "bernardou";
		String psw = "omaaag";
//		UserVO u = new UserVO(username,psw,false);
//		User uNew = uMgt.getUser(u);
//		uMgt.addUser(uNew);
		boolean check = uMgt.checkLogin(username, psw);
		System.out.println(check);
	}
}
