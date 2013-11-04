package uy.edu.um.services.categories.managers;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import uy.edu.um.exceptions.checks.HasBlanksException;
import uy.edu.um.exceptions.checks.HasNumberException;
import uy.edu.um.exceptions.checks.NotNumberException;
import uy.edu.um.exceptions.checks.Verificacion;
import uy.edu.um.interfaces.categories.CategoryRemoteMgt;
import uy.edu.um.services.categories.exceptions.ExisteCategoryException;
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
		CategoryVO toReturn = null;
		try {
			checkCatgory(nombre);
			toReturn = new CategoryVO(nombre);
		} catch (HasNumberException e) {
			e.printStackTrace();
		} catch (ExisteCategoryException e){
			e.printStackTrace();
		} catch (HasBlanksException e) {
			e.printStackTrace();
		}
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

	@Override
	public boolean existCategory(String nombre){
		boolean checker = false;
		try {

			String sObjectService = "CategoryRemoteMgr";

			Registry oRegitry = LocateRegistry.getRegistry(1099);

			CategoryRemoteMgt oCategoryRemoteMgt = (CategoryRemoteMgt) oRegitry
					.lookup(sObjectService);
			checker = oCategoryRemoteMgt.existsCategory(nombre);
			System.out.println("nada colapso");

		} catch (Exception e) {
			System.err.println("error:");
			e.printStackTrace();
		}
		return  checker;
	}

	//metodos auxiliares

	private void checkCatgory(String nombre) throws ExisteCategoryException, HasNumberException, HasBlanksException{
		if(existCategory(nombre) == true){
			throw new ExisteCategoryException("Ya existe la categoria "+nombre);
		}
		if(Verificacion.hasNumbers(nombre)){
			throw new HasNumberException("El campo nombre tiene numeros y no debe");
		}
		if(Verificacion.hasSpaces(nombre)){
			throw new HasBlanksException("El campo nombre tiene espacios y no de debe");
		}
	}


}
