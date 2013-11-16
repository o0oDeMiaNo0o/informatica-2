package uy.edu.um.client_service.business.article.test;

import java.util.ArrayList;

import uy.edu.um.client_service.business.BusinessFacade;
import uy.edu.um.client_service.business.article.entities.Article;
import uy.edu.um.client_service.business.article.interfaces.ArticleMgt;
import uy.edu.um.exceptions.checks.NoDatabaseConnection;
import uy.edu.um.value_object.article.ArticleVO;

public class MainArticleServer {
	public static void main(String[] args) throws NoDatabaseConnection {
		ArticleMgt aMgt = BusinessFacade.getInstance().getArticleMgt();
		ArrayList<ArticleVO> a = new ArrayList<ArticleVO>(10);
		a = aMgt.allArticles();
		ArticleVO a1 = a.get(1);
		Article a2 = aMgt.getArticle(a1);

		int v = 34;
	}
}
