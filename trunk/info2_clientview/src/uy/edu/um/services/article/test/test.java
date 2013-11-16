package uy.edu.um.services.article.test;

import java.util.ArrayList;

import uy.edu.um.exceptions.checks.NoDatabaseConnection;
import uy.edu.um.exceptions.checks.NoServerConnectionException;
import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.article.interfaces.ArticleMgt;
import uy.edu.um.value_object.article.ArticleVO;

public class test {
	public static void main(String[] args) throws NoServerConnectionException, NoDatabaseConnection{
		ArticleMgt aMgt = ServiceFacade.getInstance().getArticleMgt();
		ArrayList<ArticleVO> articles = new ArrayList<ArticleVO>(2);
		articles = aMgt.allArticles();
		ArticleVO a1 = articles.get(4);
		a1.setNombre("jajajaja");
		aMgt.editArticle(a1);
		int v = 34;
	}
}
