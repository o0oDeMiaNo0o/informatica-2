package uy.edu.um.client_service.service.articleRemote.test;

import uy.edu.um.client_service.business.BusinessFacade;
import uy.edu.um.client_service.business.article.interfaces.ArticleMgt;


public class test4 {

	public static void main(String[] args){
		String nombre = "chisbuger";
		ArticleMgt aMgt = BusinessFacade.getInstance().getArticleMgt();
		System.out.println(aMgt.existeArticle(nombre));
	}


}
