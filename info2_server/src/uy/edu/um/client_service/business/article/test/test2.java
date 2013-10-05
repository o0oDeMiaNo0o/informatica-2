package uy.edu.um.client_service.business.article.test;

import java.util.ArrayList;

import uy.edu.um.client_service.business.BusinessFacade;
import uy.edu.um.client_service.business.article.interfaces.ArticleMgt;
import uy.edu.um.value_object.article.ArticleVO;

public class test2 {

	public static void main(String[] args){
		ArrayList<ArticleVO> articles = new ArrayList<ArticleVO>(10);
		ArticleMgt aMgt = BusinessFacade.getInstance().getArticleMgt();
		articles = aMgt.allArticles();
		for(int i = 0; i < 5 ; i++){
			if(articles.get(i) != null){
				String nombre = articles.get(i).getNombre();
				System.out.println(nombre);
			}
		}
	}
}
