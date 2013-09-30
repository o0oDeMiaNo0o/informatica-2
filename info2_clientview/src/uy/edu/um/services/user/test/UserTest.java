package uy.edu.um.services.user.test;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import uy.edu.um.interfaces.article.ArticleRemoteMgt;
import uy.edu.um.interfaces.user.UserRemoteMgt;
import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.user.interfaces.UserMgt;
import uy.edu.um.value_object.user.UserVO;

public class UserTest {
	public static void main(String[] args) {

		try {

			String sObjectService = "UserRemoteMgr";

			Registry oRegitry = LocateRegistry.getRegistry(1099);

			UserRemoteMgt oUserRemoteMgt = (UserRemoteMgt) oRegitry.lookup(sObjectService);

			String name = "bforrisi";
			String password = "asd";
			boolean isAdmin = false;

			UserMgt uMgt = ServiceFacade.getInstance().getUserMgt();

			UserVO toSend = uMgt.createUserVO(name, password, isAdmin);

			oUserRemoteMgt.addUser(toSend);

			System.out.println("usuario agregado");

		} catch (Exception e) {
			System.err.println("error:");
			e.printStackTrace();
		}
	}
}
