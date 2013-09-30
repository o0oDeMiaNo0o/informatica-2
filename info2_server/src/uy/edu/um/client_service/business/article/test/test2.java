package uy.edu.um.client_service.business.article.test;

import uy.edu.um.client_service.business.BusinessFacade;
import uy.edu.um.client_service.business.article.interfaces.ArticleMgt;
import uy.edu.um.value_object.article.ArticleVO;

public class test2 {

	public static void main(String[] args){
		int prod = 23;
		ArticleMgt aMgt = BusinessFacade.getInstance().getArticleMgt();
		ArticleVO ad = aMgt.consultArticle(prod);
		System.out.println(ad.getNombre());
	}
}
