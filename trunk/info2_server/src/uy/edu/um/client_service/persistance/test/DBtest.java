package uy.edu.um.client_service.persistance.test;

import java.math.BigDecimal;
import java.util.ArrayList;

import uy.edu.um.client_service.business.article.entities.Article;
import uy.edu.um.client_service.business.articleOrder.entities.ArticleOrder;
import uy.edu.um.client_service.business.categories.entities.Category;
import uy.edu.um.client_service.business.order.entities.Order;
import uy.edu.um.client_service.business.table.entities.Table;
import uy.edu.um.client_service.business.users.entities.User;
import uy.edu.um.client_service.persistance.DAO.articles.ArticlesDAO;
import uy.edu.um.client_service.persistance.DAO.order.OrderDAO;


public class DBtest {




	public static void main(String[] args) {
		BigDecimal p = new BigDecimal(80);
		Category c = new Category("Minutas",8);
		Article a1 = new Article("faina",p,c);
		Article a2 = new Article("faina con muzza",p,c);
		ArticleOrder Ao1 = new ArticleOrder(a1,2);
		Table t = new Table(2);
		User u = new User("Roberto","robykpo",false);
		ArticleOrder Ao2 = new ArticleOrder(a2,5);
		ArrayList<ArticleOrder> array = new ArrayList<ArticleOrder>();
		
		ArticlesDAO aDAO = ArticlesDAO.getInstance();
		//aDAO.addArticle(a1);
		//aDAO.addArticle(a2);
		array.add(Ao1);
		array.add(Ao2);
		
		Order o = new Order(array,t,u);
		OrderDAO oDAO = OrderDAO.getInstance();
		
		oDAO.addOrder(o);
		
		

		
		


	}

}
