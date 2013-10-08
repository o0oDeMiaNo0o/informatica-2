package uy.edu.um.services.categories.interfaces;

import java.util.ArrayList;

import uy.edu.um.value_object.categories.CategoryVO;

public interface CategoryMgt {

	public CategoryVO createArticleVO(String nombre, int precio);

	public void sendCategoryVO(CategoryVO c);

	public void setCliente(CategoryVO c);

	public ArrayList<CategoryVO> allCategories();

}


