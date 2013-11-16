package uy.edu.um.services.categories.test;

import java.util.ArrayList;

import uy.edu.um.exceptions.checks.NoDatabaseConnection;
import uy.edu.um.exceptions.checks.NoServerConnectionException;
import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.categories.interfaces.CategoryMgt;
import uy.edu.um.value_object.categories.CategoryVO;

public class test {
	public static void main(String[] args) throws NoServerConnectionException, NoDatabaseConnection{
		CategoryMgt cmgt = ServiceFacade.getInstance().getCategoryMgt();
		ArrayList<CategoryVO> allcat = new ArrayList<CategoryVO>(2);
		allcat = cmgt.allCategories();
		CategoryVO c1 = allcat.get(1);
		cmgt.borrarCateogry(c1);




		int v = 345;

	}
}
