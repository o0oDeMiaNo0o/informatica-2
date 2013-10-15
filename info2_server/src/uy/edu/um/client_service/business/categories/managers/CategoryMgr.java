package uy.edu.um.client_service.business.categories.managers;

import java.util.ArrayList;

import uy.edu.um.client_service.business.categories.entities.Category;
import uy.edu.um.client_service.business.categories.interfaces.CategoryMgt;
import uy.edu.um.client_service.persistance.DAO.category.CategoryDAO;
import uy.edu.um.value_object.categories.CategoryVO;

public class CategoryMgr implements CategoryMgt{

	private static CategoryMgr instance = new CategoryMgr();

	private CategoryMgr(){

	}

	public static CategoryMgr getInstance(){
		if(instance == null){
			instance = new CategoryMgr();
		}
		return instance;
	}

	@Override
	public void addCategory(Category c) {
		CategoryDAO dao = CategoryDAO.getInstance();
		dao.addCategory(c);
	}

	@Override
	public Category createCategory(CategoryVO c) {
		String nombre = c.getNombre();
		return new Category(nombre);

	}

	@Override
	public ArrayList<CategoryVO> allCategories() {
		CategoryDAO dao = CategoryDAO.getInstance();
		return dao.getCategoryVO();
	}
}
