package uy.edu.um.services.article.test;

import java.math.BigDecimal;

import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.article.interfaces.ArticleMgt;
import uy.edu.um.value_object.article.ArticleVO;
import uy.edu.um.value_object.categories.CategoryVO;

public class Test3 {
	public static void main(String[] args){
		String nombre = "tomatoma";
		BigDecimal precio = new BigDecimal(34);
		CategoryVO category = new CategoryVO("pizzas");
		ArticleMgt aMgt = ServiceFacade.getInstance().getArticleMgt();
		ArticleVO toSend = aMgt.createArticleVO(nombre, precio, category);
		aMgt.sendArticle(toSend);
	}
}
