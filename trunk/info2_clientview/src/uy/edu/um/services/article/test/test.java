package uy.edu.um.services.article.test;

import java.math.BigDecimal;
import java.util.ArrayList;

import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.article.interfaces.ArticleMgt;
import uy.edu.um.value_object.article.ArticleVO;

public class test {

	public static void main(String[] args){
		ArrayList<ArticleVO> array = null;

		ArticleMgt aMgt = ServiceFacade.getInstance().getArticleMgt();

		array = aMgt.allArticles();

		ArticleVO toEdit = array.get(18);

		BigDecimal newPrice = new BigDecimal(678);

		toEdit.setPrecio(newPrice);

		aMgt.editArticle(toEdit);

		int v = 45;
	}

}
