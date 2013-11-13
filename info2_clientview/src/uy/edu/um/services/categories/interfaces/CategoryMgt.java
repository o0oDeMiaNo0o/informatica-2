package uy.edu.um.services.categories.interfaces;

import java.util.ArrayList;

import uy.edu.um.exceptions.checks.ExisteCategoryException;
import uy.edu.um.exceptions.checks.HasBlanksException;
import uy.edu.um.exceptions.checks.NoDatabaseConnection;
import uy.edu.um.exceptions.checks.NoServerConnectionException;
import uy.edu.um.value_object.categories.CategoryVO;

public interface CategoryMgt {

	public CategoryVO createCategoryVO(String nombre)
				throws ExisteCategoryException, HasBlanksException, NoServerConnectionException, NoDatabaseConnection;

	public void sendCategoryVO(CategoryVO c)  throws NoServerConnectionException, NoDatabaseConnection;

	public ArrayList<CategoryVO> allCategories()  throws NoServerConnectionException, NoDatabaseConnection;

	public boolean existCategory(String nombre)  throws NoServerConnectionException, NoDatabaseConnection;
}


