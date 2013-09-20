package uy.edu.um.services.article;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import uy.edu.um.interfaces.article.ArticleRemoteMgt;

public class ArticleTest {
	public static void main(String[] args) {

		try {

			String sObjectService = "ArticleService";

			Registry oRegitry = LocateRegistry.getRegistry(1099);

			ArticleRemoteMgt oArticleRemoteMgt = (ArticleRemoteMgt) oRegitry.lookup(sObjectService);



		} catch (Exception e) {
			System.err.println("error:");
			e.printStackTrace();
	}

	}
}
