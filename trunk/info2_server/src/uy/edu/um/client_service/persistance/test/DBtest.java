package uy.edu.um.client_service.persistance.test;

import java.util.ArrayList;

import uy.edu.um.client_service.business.article.entities.Article;
import uy.edu.um.client_service.business.clients.entities.Client;
import uy.edu.um.client_service.business.order.entities.Order;
import uy.edu.um.client_service.persistance.DAO.articles.ArticlesDAO;
import uy.edu.um.client_service.persistance.DAO.order.OrderDAO;
import uy.edu.um.value_object.article.ArticleVO;


public class DBtest {

	static Article a1 = new Article(101,"pizza",120);
	static Article a2 = new Article(102,"muzza",200);
	static Article a3 = new Article(201,"hambuerguesa",180);
	static Article a4 = new Article(202,"chivito",280);
	ArrayList<Article> aa = new ArrayList<Article>();
	static Client c = new Client("rodrigo", "aa", 4010, 4010, "aaaa", "aaaa");

	public static void main(String[] args) {
		
		ArrayList<Article> aa = new ArrayList<Article>();
		aa.add(a1);
		aa.add(a2);
		aa.add(a3);
		aa.add(a4);
		Order o = new Order(aa,c);

		OrderDAO o1 = OrderDAO.getInstance();
		
		o1.addOrder(o);
		//ArticleVO vo = d1.searchArticle(304);
		//System.out.println(vo.getNombre());


	}

}
