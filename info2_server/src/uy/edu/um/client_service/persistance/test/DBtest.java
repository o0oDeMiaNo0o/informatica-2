package uy.edu.um.client_service.persistance.test;

import java.math.BigDecimal;

import uy.edu.um.client_service.business.article.entities.Article;
import uy.edu.um.client_service.business.categories.entities.Category;
import uy.edu.um.client_service.persistance.DAO.articles.ArticlesDAO;
import uy.edu.um.client_service.persistance.DAO.category.CategoryDAO;
import uy.edu.um.exceptions.checks.NoDatabaseConnection;



public class DBtest {




	public static void main(String[] args) throws NoDatabaseConnection {
		
		Category c = new Category("frula");
		CategoryDAO cd = CategoryDAO.getInstance();
		cd.addCategory(c);



	}

}
