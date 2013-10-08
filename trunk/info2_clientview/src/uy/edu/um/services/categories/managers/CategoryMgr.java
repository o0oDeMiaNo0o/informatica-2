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

	public CategoryVO createArticleVO(String nombre, int precio) {
		CategoryVO toReturn = new CategoryVO(nombre,precio);
		return toReturn;
	}

	@Override
	public void sendCategoryVO(CategoryVO c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setCliente(CategoryVO c) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<CategoryVO> allCategories() {

		ArrayList<CategoryVO> array = new ArrayList<CategoryVO>(10);

		try {

			String sObjectService = "CategoryRemoteMgr";

			Registry oRegitry = LocateRegistry.getRegistry(1099);

			CategoryRemoteMgt oCategoryRemoteMgt = (CategoryRemoteMgt) oRegitry
					.lookup(sObjectService);


			CategoryMgt cMgt = ServiceFacade.getInstance().getCategoryMgt();

			array = oCategoryRemoteMgt.allCategories();

			System.out.println("nada colapso");

		} catch (Exception e) {
			System.err.println("error:");
			e.printStackTrace();

		}
		return array;

	}

}
