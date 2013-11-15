package uy.edu.um.client_service.service.categoriesRemote.test;

import java.util.ArrayList;

import uy.edu.um.client_service.business.BusinessFacade;
import uy.edu.um.client_service.business.categories.interfaces.CategoryMgt;
import uy.edu.um.exceptions.checks.NoDatabaseConnection;
import uy.edu.um.value_object.categories.CategoryVO;

public class test2 {
	public static void main(String[] args) throws NoDatabaseConnection{
		ArrayList<CategoryVO> allCat = new ArrayList<CategoryVO>(2);
		CategoryMgt cMgt = BusinessFacade.getInstance().getCategoryMgt();
		allCat = cMgt.allCategories();
		int v = 34;
	}
}
