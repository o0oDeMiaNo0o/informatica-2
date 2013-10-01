package uy.edu.um.services.article.test;

import java.util.ArrayList;

import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.article.interfaces.ArticleMgt;
import uy.edu.um.value_object.article.ArticleVO;

public class test {

	public static void main(String[] args){
		ArrayList<ArticleVO> array = null;

		ArticleMgt aMgt = ServiceFacade.getInstance().getArticleMgt();

		array = aMgt.allArticles();

		int i = 0;

		for(ArticleVO a : array){
			String nombre = a.getNombre();
			System.out.println(nombre);
			i++;

		}
	}

}
