package uy.edu.um.client_service.persistance.test;

import java.math.BigDecimal;

import uy.edu.um.client_service.business.article.entities.Article;
import uy.edu.um.client_service.business.categories.entities.Category;
import uy.edu.um.client_service.persistance.DAO.articles.ArticlesDAO;
import uy.edu.um.client_service.persistance.DAO.category.CategoryDAO;


public class DBtest {




	public static void main(String[] args) {
		
	//Category c = new Category("Hamburguesas");
	BigDecimal b = new BigDecimal(23);
	Article a = new Article(101,"OPAAA",b);
	ArticlesDAO aDAO = ArticlesDAO.getInstance();
	
	//CategoryDAO cDAO = CategoryDAO.getInstance();
	aDAO.addArticle(a);
	//cDAO.addCategory(c);





	}

}
