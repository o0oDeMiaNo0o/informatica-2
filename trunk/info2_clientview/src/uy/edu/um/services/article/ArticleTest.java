package uy.edu.um.services.article;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import uy.edu.um.business.interfaces.ArticleRemoteMgt;


public class ArticleTest {
	public static void main(String[] args) {

		try {

			String sObjectService = "ArticleService";

			Registry oRegitry = LocateRegistry.getRegistry(1099);

			ArticleRemoteMgt oArticleRemoteMgt = (ArticleRemoteMgt) oRegitry.lookup(sObjectService);

			int id = 4; int precio = 10;
			String nombre = "pizza";

			oArticleRemoteMgt.showArticle(id, nombre, precio);

		} catch (Exception e) {
			System.err.println("error:");
			e.printStackTrace();
	}

	}
}
