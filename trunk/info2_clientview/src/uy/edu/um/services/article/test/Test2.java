package uy.edu.um.services.article.test;

import java.math.BigDecimal;

import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.article.interfaces.ArticleMgt;
import uy.edu.um.value_object.article.ArticleVO;
import uy.edu.um.value_object.categories.CategoryVO;

public class Test2 {
	public static void main(String[] args) {
		String nombre = "jaja";
		int id = 34;
		CategoryVO category = new CategoryVO(34,"poronga");
		BigDecimal precio = new BigDecimal(45);
		ArticleMgt ar = ServiceFacade.getInstance().getArticleMgt();
		ArticleVO art = ar.createArticleVOid(id, nombre, precio, category);
	}
}

