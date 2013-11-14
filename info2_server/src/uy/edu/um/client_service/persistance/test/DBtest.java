package uy.edu.um.client_service.persistance.test;

import java.util.ArrayList;

import uy.edu.um.client_service.business.articleOrder.entities.ArticleOrder;
import uy.edu.um.client_service.persistance.DAO.articleOrderDAO.ArticleOrderDAO;
import uy.edu.um.exceptions.checks.NoDatabaseConnection;



public class DBtest {




	public static void main(String[] args) throws NoDatabaseConnection {

		ArticleOrderDAO a = ArticleOrderDAO.getInstance();
		ArrayList<ArticleOrder> array=a.getArticleOrder(10, null);

		for(int i = 0; i<array.size();i++){
			System.out.println("Articulo: "+array.get(i).getArticle().getNombre()+".");
		}



	}

}
