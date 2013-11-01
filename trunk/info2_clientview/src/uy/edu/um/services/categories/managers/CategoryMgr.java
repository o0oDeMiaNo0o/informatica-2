package uy.edu.um.services.categories.managers;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import uy.edu.um.exceptions.Verificacion;
import uy.edu.um.interfaces.categories.CategoryRemoteMgt;
import uy.edu.um.services.article.exceptions.HasNumberException;
import uy.edu.um.services.article.exceptions.NotNumberException;
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

	public CategoryVO createCategoryVO(String nombre) {
		try {
			hasNumbers(nombre);
		} catch (HasNumberException e) {
			e.printStackTrace();
		}
		CategoryVO toReturn = new CategoryVO(nombre);
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

	//metodos auxiliares

	private static void isNumeric(String id) throws NotNumberException{
		if(Verificacion.isNumeric(id)){
			throw new NotNumberException("el campo ingresado no es numerico");
		}
	}

	private static void hasNumbers(String s) throws HasNumberException{
		if(Verificacion.hasNumbers(s)){
			throw new HasNumberException("un campo ingresado tiene numeros que no deberia");
		}
	}


}
