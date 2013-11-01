package uy.edu.um.client_service.service.articleRemote.test;

import java.math.BigDecimal;
import java.util.ArrayList;

import uy.edu.um.client_service.business.BusinessFacade;
import uy.edu.um.client_service.business.article.entities.Article;
import uy.edu.um.client_service.business.article.interfaces.ArticleMgt;
import uy.edu.um.value_object.article.ArticleVO;

public class test {
	public static void main(String[] args){
		ArrayList<ArticleVO> array = null;

		ArticleMgt aMgt = BusinessFacade.getInstance().getArticleMgt();

		array = aMgt.allArticles();

		ArticleVO toDelete = array.get(15);

		Article to = aMgt.getArticle(toDelete);

		aMgt.removeArticle(to);

		int v = 45;
	}
}
