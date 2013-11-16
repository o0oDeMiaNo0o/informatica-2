package uy.edu.um.client_service.service.categoriesRemote.test;

import java.rmi.RemoteException;
import java.util.ArrayList;

import uy.edu.um.client_service.business.BusinessFacade;
import uy.edu.um.client_service.business.categories.entities.Category;
import uy.edu.um.client_service.business.categories.interfaces.CategoryMgt;
import uy.edu.um.exceptions.checks.NoDatabaseConnection;
import uy.edu.um.interfaces.categories.CategoryRemoteMgt;
import uy.edu.um.value_object.categories.CategoryVO;

public class test2 {
	public static void main(String[] args) throws NoDatabaseConnection, RemoteException{
		ArrayList<CategoryVO> allCat = new ArrayList<CategoryVO>(2);
		CategoryMgt cMgt = BusinessFacade.getInstance().getCategoryMgt();
		CategoryRemoteMgt cmgt= BusinessFacade.getInstance().getCategoryRemote();
		allCat = cMgt.allCategories();
		CategoryVO get = allCat.get(2);
		cmgt.eliminarCategory(get);
		int v = 34;
	}
}
