package uy.edu.um.client_service.service.articleRemote.test;

import java.math.BigDecimal;

import uy.edu.um.client_service.business.BusinessFacade;
import uy.edu.um.client_service.business.article.entities.Article;
import uy.edu.um.client_service.business.article.interfaces.ArticleMgt;
import uy.edu.um.value_object.article.ArticleVO;
import uy.edu.um.value_object.categories.CategoryVO;


public class test4 {

	public static void main(String[] args){
		String nombre = "muzza";
		BigDecimal precio = new BigDecimal(34);
		CategoryVO category = new CategoryVO("pizzas");
		ArticleMgt aMgt = BusinessFacade.getInstance().getArticleMgt();
		ArticleVO a = new ArticleVO(nombre,precio,category);
		Article article = aMgt.getArticle(a);
		aMgt.addArticle(article);
	}


}
