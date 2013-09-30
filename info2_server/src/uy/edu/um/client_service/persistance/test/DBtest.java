package uy.edu.um.client_service.persistance.test;

import uy.edu.um.client_service.business.article.entities.Article;
import uy.edu.um.client_service.persistance.DAO.articles.ArticlesDAO;


public class DBtest {

	static Article a1 = new Article(101,"pizza",120);
	static Article a2 = new Article(102,"muzza",200);
	static Article a3 = new Article(201,"hambuerguesa",180);
	static Article a4 = new Article(202,"chivito",280);


	public static void main(String[] args) {
		ArticlesDAO d1= ArticlesDAO.getInstance();
//		d1.getArticles();
//		d1.addArticle(a1);
//		d1.addArticle(a2);
//		d1.addArticle(a3);
//		d1.addArticle(a4);

		d1.getArticles();


	}

}
