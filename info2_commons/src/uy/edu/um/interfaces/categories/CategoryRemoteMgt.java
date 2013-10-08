package uy.edu.um.interfaces.categories;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import uy.edu.um.value_object.categories.CategoryVO;

public interface CategoryRemoteMgt extends Remote{

	public void addCategory(CategoryVO c) throws RemoteException;

	public ArrayList<CategoryVO> allCategories() throws RemoteException;
}
