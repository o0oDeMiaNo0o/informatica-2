package uy.edu.um.services.categories.interfaces;

import uy.edu.um.value_object.categories.CategoryVO;

public interface CategoryMgt {

	public CategoryVO createArticleVO(int numProducto, String nombre, int precio);

	public void sendCategoryVO(CategoryVO c);

	public void setCliente(CategoryVO c);

}


