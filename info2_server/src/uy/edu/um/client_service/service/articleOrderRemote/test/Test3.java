package uy.edu.um.client_service.service.articleOrderRemote.test;

import java.math.BigDecimal;
import java.util.ArrayList;

import uy.edu.um.client_service.business.BusinessFacade;
import uy.edu.um.client_service.business.article.entities.Article;
import uy.edu.um.client_service.business.article.interfaces.ArticleMgt;
import uy.edu.um.client_service.business.categories.interfaces.CategoryMgt;
import uy.edu.um.exceptions.checks.NoDatabaseConnection;
import uy.edu.um.value_object.article.ArticleVO;
import uy.edu.um.value_object.categories.CategoryVO;

public class Test3 {
	public static void main(String[] args) throws NoDatabaseConnection{
		ArrayList<CategoryVO> categories = new ArrayList<CategoryVO>(10);
		CategoryMgt cmgt = BusinessFacade.getInstance().getCategoryMgt();
		categories = cmgt.allCategories();
		CategoryVO c1 = categories.get(0);
		String nombre = "precio"; BigDecimal precio = new BigDecimal(10);
		ArticleVO toAdd = new ArticleVO(nombre,precio,c1);
		ArticleMgt amgt = BusinessFacade.getInstance().getArticleMgt();
		Article a = amgt.getArticle(toAdd);
		amgt.addArticle(a);
		int v = 45;
	}
}
