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
		int id = c.getId();
		return new Category(nombre,id);

	}

	@Override
	public ArrayList<CategoryVO> allCategories() {
		CategoryDAO dao = CategoryDAO.getInstance();
		ArrayList<Category> categories =  dao.getCategory();
		ArrayList<CategoryVO> toReturn = new ArrayList<CategoryVO>(10);
		for(Category c : categories){
			if(c!=null){
				CategoryVO toAdd = this.getCategoryVO(c);
				toReturn.add(toAdd);
			}
		}
		return toReturn;
	}

	@Override
	public CategoryVO getCategoryVO(Category c) {
		int id = c.getId();
		String nombre = c.getNombre();
		return new CategoryVO(id,nombre);
	}

	private String encryptPass(String pass){
		return null;
	}
}
