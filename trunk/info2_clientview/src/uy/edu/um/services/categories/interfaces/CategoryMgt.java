package uy.edu.um.services.categories.interfaces;

import java.util.ArrayList;

import uy.edu.um.exceptions.checks.ExisteCategoryException;
import uy.edu.um.exceptions.checks.HasBlanksException;
import uy.edu.um.value_object.categories.CategoryVO;

public interface CategoryMgt {

	public CategoryVO createCategoryVO(String nombre)
				throws ExisteCategoryException, HasBlanksException;

	public void sendCategoryVO(CategoryVO c);

	public ArrayList<CategoryVO> allCategories();

	public boolean existCategory(String nombre);
}


