package uy.edu.um.services.categories.test;

import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.categories.interfaces.CategoryMgt;
import uy.edu.um.value_object.categories.CategoryVO;

public class test2 {

	public static void main(String[] args){
		String cat = "pizzas"; int id = 45;
		CategoryMgt cMgt = ServiceFacade.getInstance().getCategoryMgt();
		CategoryVO toSend = cMgt.createCategoryVO(id,cat);
		cMgt.sendCategoryVO(toSend);
	}

}
