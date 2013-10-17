package uy.edu.um.services.categories.test;

import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.categories.interfaces.CategoryMgt;
import uy.edu.um.value_object.categories.CategoryVO;

public class addCatTest {

	public static void main(String[] args){
		CategoryMgt c = ServiceFacade.getInstance().getCategoryMgt();
		String p = "pizza";
		CategoryVO toAdd = c.createCategoryVO(p);
		c.sendCategoryVO(toAdd);
		int v = 34;
	}

}
