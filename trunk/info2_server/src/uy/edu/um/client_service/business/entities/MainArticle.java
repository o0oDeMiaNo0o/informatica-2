package uy.edu.um.client_service.business.entities;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import uy.edu.um.business.interfaces.articles.ArticleRemoteMgt;
import uy.edu.um.client_service.communications.clients.managers.articles.ArticleRemoteService;

public class MainArticle {
	public static void main(String[] args) {
		try {
			String name = "ArticleService";

			ArticleRemoteService oArticleService = new ArticleRemoteService();

			ArticleRemoteMgt oStub = (ArticleRemoteMgt) UnicastRemoteObject
					.exportObject(oArticleService, 0);

			Registry oRegistry = LocateRegistry.createRegistry(1099);

			oRegistry.rebind(name, oStub);

			System.out.println("Ready and waiting");
		} catch (Exception e) {
			System.err.println("error:");
			e.printStackTrace();
		}
	}
}
