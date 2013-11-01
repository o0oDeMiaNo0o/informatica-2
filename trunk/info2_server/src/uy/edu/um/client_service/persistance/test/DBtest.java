package uy.edu.um.client_service.persistance.test;

import java.util.ArrayList;

import uy.edu.um.client_service.business.article.entities.Article;
import uy.edu.um.client_service.persistance.DAO.articles.ArticlesDAO;


public class DBtest {




	public static void main(String[] args) {
	
	ArticlesDAO a = ArticlesDAO.getInstance();
	ArrayList<Article> array = a.getArticles();
	
	for(int i=0;i<array.size();i++){
		System.out.println("Nombre de articulo: "+array.get(i).getNombre()+"");
	}
	
	
	
	}

}
