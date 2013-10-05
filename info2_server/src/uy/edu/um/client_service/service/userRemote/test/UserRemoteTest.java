package uy.edu.um.client_service.service.userRemote.test;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import uy.edu.um.client_service.business.BusinessFacade;
import uy.edu.um.interfaces.article.ArticleRemoteMgt;
import uy.edu.um.interfaces.user.UserRemoteMgt;

public class UserRemoteTest {
	public static void main(String[] args) {
		try {
			String name = "UserRemoteMgr";

			UserRemoteMgt oArticleRemoteMgr = BusinessFacade.getInstance().getUserRemote();

			UserRemoteMgt oStub = (UserRemoteMgt) UnicastRemoteObject
					.exportObject((Remote) oArticleRemoteMgr, 0);

			Registry oRegistry = LocateRegistry.createRegistry(1099);

			oRegistry.rebind(name, oStub);

			System.out.println("Ready and waiting");
		} catch (Exception e) {
			System.err.println("error:");
			e.printStackTrace();
		}
	}
}
