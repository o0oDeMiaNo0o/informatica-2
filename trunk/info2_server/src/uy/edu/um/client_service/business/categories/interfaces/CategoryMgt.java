package uy.edu.um.client_service.business.categories.interfaces;

import uy.edu.um.client_service.business.categories.entities.Category;
import uy.edu.um.value_object.categories.CategoryVO;

public interface CategoryMgt {

	public void addCategory(CategoryVO c);

	public Category createCategory(CategoryVO c);

}
