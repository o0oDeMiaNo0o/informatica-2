package uy.edu.um.services.categories.managers;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import uy.edu.um.interfaces.categories.CategoryRemoteMgt;
import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.categories.interfaces.CategoryMgt;
import uy.edu.um.value_object.categories.CategoryVO;

public class CategoryMgr implements CategoryMgt{

	private static CategoryMgr instance = null;

	private CategoryMgr(){}

	public static CategoryMgr getInstance(){
		if(instance == null){
			instance = new CategoryMgr();
		}
		return instance;
	}

	public CategoryVO createCategoryVO(String nombre, int id) {
		CategoryVO toReturn = new CategoryVO(nombre,id);
		return toReturn;
	}

	@Override
	public void sendCategoryVO(CategoryVO c) {
		try {

			String sObjectService = "CategoryRemoteMgr";

			Registry oRegitry = LocateRegistry.getRegistry(1099);

			CategoryRemoteMgt oCategoryRemoteMgt = (CategoryRemoteMgt) oRegitry
					.lookup(sObjectService);

			oCategoryRemoteMgt.addCategory(c);

			System.out.println("Categoria agregada correctamente");
		}catch(Exception e){
			e.printStackTrace();
		}

	}

	@Override
	public ArrayList<CategoryVO> allCategories() {

		ArrayList<CategoryVO> array = new ArrayList<CategoryVO>(10);

		try {

			String sObjectService = "CategoryRemoteMgr";

			Registry oRegitry = LocateRegistry.getRegistry(1099);

			CategoryRemoteMgt oCategoryRemoteMgt = (CategoryRemoteMgt) oRegitry
					.lookup(sObjectService);

			array = oCategoryRemoteMgt.allCategories();

			System.out.println("nada colapso");

		} catch (Exception e) {
			System.err.println("error:");
			e.printStackTrace();

		}
		return array;

	}

}
