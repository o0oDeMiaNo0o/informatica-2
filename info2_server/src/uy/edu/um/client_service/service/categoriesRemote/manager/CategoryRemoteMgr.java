package uy.edu.um.client_service.service.categoriesRemote.manager;

import java.rmi.RemoteException;

import uy.edu.um.interfaces.categories.CategoryRemoteMgt;
import uy.edu.um.value_object.categories.CategoryVO;

public class CategoryRemoteMgr implements CategoryRemoteMgt{

	private static CategoryRemoteMgr instance = new CategoryRemoteMgr();

	private CategoryRemoteMgr(){};

	public CategoryRemoteMgr getInstance(){
		if(instance == null){
			instance = new CategoryRemoteMgr();
		}
		return instance;
	}

	@Override
	public void addCategory(CategoryVO c) throws RemoteException {
		// TODO Auto-generated method stub

	}

}
