package uy.edu.um.services.categories.interfaces;

import java.util.ArrayList;

import uy.edu.um.exceptions.checks.ExisteCategoryException;
import uy.edu.um.exceptions.checks.HasBlanksException;
import uy.edu.um.exceptions.checks.NoServerConnectionException;
import uy.edu.um.value_object.categories.CategoryVO;

public interface CategoryMgt {

	public CategoryVO createCategoryVO(String nombre)
				throws ExisteCategoryException, HasBlanksException, NoServerConnectionException;

	public void sendCategoryVO(CategoryVO c)  throws NoServerConnectionException;

	public ArrayList<CategoryVO> allCategories()  throws NoServerConnectionException;

	public boolean existCategory(String nombre)  throws NoServerConnectionException;
}


