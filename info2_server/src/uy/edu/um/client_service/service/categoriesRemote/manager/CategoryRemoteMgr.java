package uy.edu.um.client_service.service.categoriesRemote.manager;

import java.rmi.RemoteException;

import uy.edu.um.client_service.business.BusinessFacade;
import uy.edu.um.client_service.business.categories.entities.Category;
import uy.edu.um.client_service.business.categories.interfaces.CategoryMgt;
import uy.edu.um.interfaces.categories.CategoryRemoteMgt;
import uy.edu.um.value_object.categories.CategoryVO;

public class CategoryRemoteMgr implements CategoryRemoteMgt{

	private static CategoryRemoteMgr instance = new CategoryRemoteMgr();

	private CategoryRemoteMgr(){};

	public static CategoryRemoteMgr getInstance(){
		if(instance == null){
			instance = new CategoryRemoteMgr();
		}
		return instance;
	}

	@Override
	public void addCategory(CategoryVO c) throws RemoteException {
		CategoryMgt cMgt = BusinessFacade.getInstance().getCategoryMgt();
		Category category = cMgt.createCategory(c);
		cMgt.addCategory(category);
	}

}
