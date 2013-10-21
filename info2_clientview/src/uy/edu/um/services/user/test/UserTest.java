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
		String nombre = "pep";
		String pass = "jos";
		boolean admin = false;
		UserMgt uMgt = ServiceFacade.getInstance().getUserMgt();
		UserVO u = uMgt.createUserVO(nombre, pass, admin);
		uMgt.addUser(u);

	}

}
