package uy.edu.um.services.article.test;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.article.interfaces.ArticleMgt;
import uy.edu.um.value_object.article.ArticleVO;
import uy.edu.um.interfaces.article.ArticleRemoteMgt;

public class ArticleTest {
	public static void main(String[] args) {

		try {

			String sObjectService = "ArticleRemoteMgr";

			Registry oRegitry = LocateRegistry.getRegistry(1099);

			ArticleRemoteMgt oArticleRemoteMgt = (ArticleRemoteMgt) oRegitry.lookup(sObjectService);


			int prodN = 105;
			String nombre = " daniel";
			int precio = 45;

			ArticleMgt aMgt = ServiceFacade.getInstance().getArticleMgt();

			ArticleVO toSend = aMgt.createArticleVO(prodN, nombre, precio);

			oArticleRemoteMgt.addArticle(toSend);

			System.out.println("articulo agregado");

		} catch (Exception e) {
			System.err.println("error:");
			e.printStackTrace();
		}
	}
}
