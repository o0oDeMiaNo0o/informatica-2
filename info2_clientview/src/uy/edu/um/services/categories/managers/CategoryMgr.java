package uy.edu.um.services.categories.managers;

import uy.edu.um.services.categories.interfaces.CategoryMgt;
import uy.edu.um.value_object.categories.CategoryVO;

public class CategoryMgr implements CategoryMgt{

	private static CategoryMgr instance = null;

	private CategoryMgr(){}

	public static CategoryMgr getInstance(){
		if(instance == null){
			instance = new CategoryMgr();
		}
		return instance;
	}

	@Override
	public CategoryVO createArticleVO(String nombre, int precio) {
		CategoryVO toReturn = new CategoryVO(nombre,precio);
		return toReturn;
	}

	@Override
	public void sendCategoryVO(CategoryVO c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setCliente(CategoryVO c) {
		// TODO Auto-generated method stub

	}

}
