package uy.edu.um.client_service.business.categories.managers;

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
		int id = 12;
		String nombre = c.getNombre();
		int precio = c.getPrecio();
		Category category = new Category(id,nombre,precio);
		return category;
	}
}
