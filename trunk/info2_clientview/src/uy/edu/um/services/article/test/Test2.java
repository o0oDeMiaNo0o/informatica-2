package uy.edu.um.services.article.test;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import uy.edu.um.interfaces.article.ArticleRemoteMgt;
import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.article.interfaces.ArticleMgt;
import uy.edu.um.value_object.article.ArticleVO;

public class Test2 {
	public static void main(String[] args) {

		try {

			String sObjectService = "ArticleRemoteMgr";

			Registry oRegitry = LocateRegistry.getRegistry(1099);

			ArticleRemoteMgt oArticleRemoteMgt = (ArticleRemoteMgt) oRegitry.lookup(sObjectService);

			ArticleMgt aMgt = ServiceFacade.getInstance().getArticleMgt();

			ArrayList<ArticleVO> a = oArticleRemoteMgt.getArticlesVO();

			System.out.println(a.get(0));

		} catch (Exception e) {
			System.err.println("error:");
			e.printStackTrace();
		}
	}
}

