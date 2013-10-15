package uy.edu.um.client_service.service.categoriesRemote.test;

import java.util.ArrayList;

import uy.edu.um.client_service.business.BusinessFacade;
import uy.edu.um.client_service.business.categories.interfaces.CategoryMgt;
import uy.edu.um.value_object.categories.CategoryVO;

public class test2 {
	public static void main(String[] args){
		ArrayList<CategoryVO> array = new ArrayList<CategoryVO>(10);
		CategoryMgt cMgt = BusinessFacade.getInstance().getCategoryMgt();
		array = cMgt.allCategories();
	}
}
