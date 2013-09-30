package uy.edu.um.client_service.persistance.DAO.category;

import uy.edu.um.client_service.business.categories.entities.Category;

public class CategoryDAO {

	private static CategoryDAO instance = null;

	private CategoryDAO(){};

	public static CategoryDAO getInstance(){
		if(instance == null){
			instance = new CategoryDAO();
		}
		return instance;
	}

	public void addCategory(Category c){

	}

}


