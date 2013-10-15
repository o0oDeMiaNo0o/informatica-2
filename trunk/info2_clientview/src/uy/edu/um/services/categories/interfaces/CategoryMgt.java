package uy.edu.um.services.categories.interfaces;

import java.util.ArrayList;

import uy.edu.um.value_object.categories.CategoryVO;

public interface CategoryMgt {

	public CategoryVO createCategoryVO(String nombre);

	public void sendCategoryVO(CategoryVO c);

	public ArrayList<CategoryVO> allCategories();

}


