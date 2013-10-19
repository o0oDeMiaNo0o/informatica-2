package uy.edu.um.services.article.test;

import java.math.BigDecimal;
import java.util.ArrayList;

import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.article.interfaces.ArticleMgt;
import uy.edu.um.services.categories.interfaces.CategoryMgt;
import uy.edu.um.value_object.article.ArticleVO;
import uy.edu.um.value_object.categories.CategoryVO;

public class Test3 {
	public static void main(String[] args){
		ArrayList<CategoryVO> categories = new ArrayList<CategoryVO>(10);
		CategoryMgt cmgt = ServiceFacade.getInstance().getCategoryMgt();
		String nombre = "daniel"; BigDecimal precio = new BigDecimal(10);
		categories = cmgt.allCategories();
		CategoryVO c1 = categories.get(0);
		ArticleMgt amgt = ServiceFacade.getInstance().getArticleMgt();
		ArticleVO aVO = amgt.createArticleVO(nombre, precio, c1);
		amgt.sendArticle(aVO);
		int v = 45;
	}
}
