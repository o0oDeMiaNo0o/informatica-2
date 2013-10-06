package uy.edu.um.client_service.service.orderRemote.test;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import uy.edu.um.client_service.business.BusinessFacade;
import uy.edu.um.interfaces.oreder.OrderRemoteMgt;

public class test2 {
	public static void main(String[] args){
		try {
			String name = "ArticleRemoteMgr";

			OrderRemoteMgt oOrderRemoteMgr = BusinessFacade.getInstance().getOrderRemote();

			OrderRemoteMgt oStub = (OrderRemoteMgt) UnicastRemoteObject
					.exportObject((Remote) oOrderRemoteMgr, 0);

			Registry oRegistry = LocateRegistry.createRegistry(1299);

			oRegistry.rebind(name, oStub);

			System.out.println("Ready and waiting");
		} catch (Exception e) {
			System.err.println("error:");
			e.printStackTrace();
		}
	}
}

