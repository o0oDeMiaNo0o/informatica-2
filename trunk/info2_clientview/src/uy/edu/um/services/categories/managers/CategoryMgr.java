package uy.edu.um.services.categories.managers;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import uy.edu.um.exceptions.checks.ExisteCategoryException;
import uy.edu.um.exceptions.checks.HasBlanksException;
import uy.edu.um.exceptions.checks.NoDatabaseConnection;
import uy.edu.um.exceptions.checks.NoServerConnectionException;
import uy.edu.um.exceptions.checks.Verificacion;
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

	public CategoryVO createCategoryVO(String nombre) throws ExisteCategoryException, HasBlanksException, NoServerConnectionException, NoDatabaseConnection{
		CategoryVO toReturn = null;
		if(existCategory(nombre)){
			throw new ExisteCategoryException("La categoria "+nombre+" ya existe");
		}
		if(Verificacion.hasSpaces(nombre)){
			throw new HasBlanksException("El nombre de la categoria contiene espacios");
		}
		toReturn = new CategoryVO(nombre);
		return toReturn;
	}

	@Override
	public void sendCategoryVO(CategoryVO c) throws NoServerConnectionException, NoDatabaseConnection{
		try {

			String sObjectService = "CategoryRemoteMgr";

			Registry oRegitry = LocateRegistry.getRegistry(ServiceFacade.getInstance().getHost(),ServiceFacade.getInstance().getPort());

			CategoryRemoteMgt oCategoryRemoteMgt = (CategoryRemoteMgt) oRegitry
					.lookup(sObjectService);

			oCategoryRemoteMgt.addCategory(c);
		}catch(Exception e){
			throw new  NoServerConnectionException("No hay conexion con el servidor, Cerrar el programa" +
					"y abrirlo nuevamente");
		}

	}

	@Override
	public ArrayList<CategoryVO> allCategories() throws NoServerConnectionException, NoDatabaseConnection{

		ArrayList<CategoryVO> array = new ArrayList<CategoryVO>(10);

		try {

			String sObjectService = "CategoryRemoteMgr";

			Registry oRegitry = LocateRegistry.getRegistry(ServiceFacade.getInstance().getHost(),ServiceFacade.getInstance().getPort());

			CategoryRemoteMgt oCategoryRemoteMgt = (CategoryRemoteMgt) oRegitry
					.lookup(sObjectService);

			array = oCategoryRemoteMgt.allCategories();

		} catch (Exception e) {
			throw new  NoServerConnectionException("No hay conexion con el servidor, Cerrar el programa" +
					"y abrirlo nuevamente");

		}
		return array;

	}

	@Override
	public boolean existCategory(String nombre) throws NoServerConnectionException, NoDatabaseConnection{
		boolean checker = false;
		try {

			String sObjectService = "CategoryRemoteMgr";

			Registry oRegitry = LocateRegistry.getRegistry(ServiceFacade.getInstance().getHost(),ServiceFacade.getInstance().getPort());

			CategoryRemoteMgt oCategoryRemoteMgt = (CategoryRemoteMgt) oRegitry
					.lookup(sObjectService);
			checker = oCategoryRemoteMgt.existsCategory(nombre);

		} catch (Exception e) {
			throw new  NoServerConnectionException("No hay conexion con el servidor, Cerrar el programa" +
					"y abrirlo nuevamente");
		}
		return  checker;
	}

}



