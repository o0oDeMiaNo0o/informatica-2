package uy.edu.um.client_service.persistance.test;

import uy.edu.um.client_service.business.categories.entities.Category;
import uy.edu.um.client_service.business.table.entities.Table;
import uy.edu.um.client_service.persistance.DAO.articles.ArticlesDAO;
import uy.edu.um.client_service.persistance.DAO.category.CategoryDAO;
import uy.edu.um.exceptions.checks.NoDatabaseConnection;



public class DBtest {




	public static void main(String[] args) throws NoDatabaseConnection {
		CategoryDAO cd = CategoryDAO.getInstance();
		ArticlesDAO ad = ArticlesDAO.getInstance();
		Category c = ad.getCategory(5);
		cd.deleteCategory(c);


	}

}
