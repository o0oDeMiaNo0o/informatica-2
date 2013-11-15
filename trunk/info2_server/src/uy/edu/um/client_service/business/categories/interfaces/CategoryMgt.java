package uy.edu.um.client_service.business.categories.interfaces;

import java.util.ArrayList;

import uy.edu.um.client_service.business.categories.entities.Category;
import uy.edu.um.exceptions.checks.NoDatabaseConnection;
import uy.edu.um.value_object.categories.CategoryVO;

public interface CategoryMgt {

	public Category createCategory(CategoryVO c);

	public void addCategory(Category c) throws NoDatabaseConnection;

	public ArrayList<CategoryVO> allCategories() throws NoDatabaseConnection;

	public CategoryVO getCategoryVO(Category c);

	public boolean existCategory(String nombre) throws NoDatabaseConnection;

	public void borrarCategory(Category c) throws NoDatabaseConnection;

}
