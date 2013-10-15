package uy.edu.um.services.categories.test;

import java.util.ArrayList;

import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.categories.interfaces.CategoryMgt;
import uy.edu.um.value_object.categories.CategoryVO;

public class test2 {

	public static void main(String[] args){
		ArrayList<CategoryVO> array = new ArrayList<CategoryVO>(10);
		CategoryMgt cMgt = ServiceFacade.getInstance().getCategoryMgt();
		array = cMgt.allCategories();
	}

}
