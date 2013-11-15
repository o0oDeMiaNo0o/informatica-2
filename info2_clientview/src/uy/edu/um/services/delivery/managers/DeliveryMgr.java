package uy.edu.um.services.delivery.managers;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Date;

import uy.edu.um.exceptions.checks.NoDatabaseConnection;
import uy.edu.um.exceptions.checks.NoServerConnectionException;
import uy.edu.um.interfaces.delivery.DeliveryRemoteMgt;
import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.delivery.interfaces.DeliveryMgt;
import uy.edu.um.value_object.articleOrder.ArticleOrderVO;
import uy.edu.um.value_object.delivery.DeliveryVO;
import uy.edu.um.value_object.user.UserVO;

public class DeliveryMgr implements DeliveryMgt{

	private static DeliveryMgr instance = null;

	private DeliveryMgr(){}

	public static DeliveryMgr getInstance(){
		if(instance == null){
			instance = new DeliveryMgr();
		}
		return instance;
	}

	@Override
	public void addDelivery(DeliveryVO d) throws NoServerConnectionException, NoDatabaseConnection{
		try {
			String sObjectService = "DeliveryRemoteMgr";
			Registry oRegitry = LocateRegistry.getRegistry(ServiceFacade.getInstance().getHost(),ServiceFacade.getInstance().getPort());
			DeliveryRemoteMgt oDeliveryRemoteMgt = (DeliveryRemoteMgt) oRegitry
					.lookup(sObjectService);
			oDeliveryRemoteMgt.addDelivery(d);
		} catch (Exception e) {
			e.printStackTrace();
			throw new  NoServerConnectionException("No hay conexion con el servidor, Cerrar el programa" +
					"y abrirlo nuevamente");
		}
	}

	@Override
	public void enViaje(DeliveryVO d) throws NoServerConnectionException{
		try {
			String sObjectService = "DeliveryRemoteMgr";
			Registry oRegitry = LocateRegistry.getRegistry(ServiceFacade.getInstance().getHost(),ServiceFacade.getInstance().getPort());
			DeliveryRemoteMgt oDeliveryRemoteMgt = (DeliveryRemoteMgt) oRegitry
					.lookup(sObjectService);

			oDeliveryRemoteMgt.enViaje(d);
			//System.out.println("articulo agregado");
		} catch (Exception e) {
			throw new  NoServerConnectionException("No hay conexion con el servidor, Cerrar el programa" +
					"y abrirlo nuevamente");
		}
	}

	@Override
	public void facturado(DeliveryVO d) throws NoServerConnectionException{
		try {
			String sObjectService = "DeliveryRemoteMgr";
			Registry oRegitry = LocateRegistry.getRegistry(ServiceFacade.getInstance().getHost(),ServiceFacade.getInstance().getPort());
			DeliveryRemoteMgt oDeliveryRemoteMgt = (DeliveryRemoteMgt) oRegitry
					.lookup(sObjectService);
			oDeliveryRemoteMgt.facturado(d);
			//System.out.println("articulo agregado");
		} catch (Exception e) {
			throw new  NoServerConnectionException("No hay conexion con el servidor, Cerrar el programa" +
					"y abrirlo nuevamente");

		}
	}


	@Override
	public void isDone(DeliveryVO d) throws NoServerConnectionException{
		try {
			String sObjectService = "DeliveryRemoteMgr";
			Registry oRegitry = LocateRegistry.getRegistry(ServiceFacade.getInstance().getHost(),ServiceFacade.getInstance().getPort());
			DeliveryRemoteMgt oDeliveryRemoteMgt = (DeliveryRemoteMgt) oRegitry
					.lookup(sObjectService);
			oDeliveryRemoteMgt.listo(d);
		} catch (Exception e) {
			throw new  NoServerConnectionException("No hay conexion con el servidor, Cerrar el programa" +
					"y abrirlo nuevamente");

		}
	}

	@Override
	public void isPreparing(DeliveryVO d) throws NoServerConnectionException{
		try {
			String sObjectService = "DeliveryRemoteMgr";
			Registry oRegitry = LocateRegistry.getRegistry(ServiceFacade.getInstance().getHost(),ServiceFacade.getInstance().getPort());
			DeliveryRemoteMgt oDeliveryRemoteMgt = (DeliveryRemoteMgt) oRegitry
					.lookup(sObjectService);
			oDeliveryRemoteMgt.enPreparacion(d);
		} catch (Exception e) {
			throw new  NoServerConnectionException("No hay conexion con el servidor, Cerrar el programa" +
					"y abrirlo nuevamente");
		}

	}

	@Override
	public DeliveryVO createDeliveryVO(ArrayList<ArticleOrderVO> articles,
			Date time, UserVO user, String specs, int estado, boolean enCocina) {
		return new DeliveryVO(articles,time,user,specs,estado,enCocina);
	}

	@Override
	public ArrayList<DeliveryVO> allDeliveries()
			throws NoServerConnectionException, NoDatabaseConnection {
		ArrayList<DeliveryVO> allDeliveries = new ArrayList<DeliveryVO>(2);
		try {
			String sObjectService = "DeliveryRemoteMgr";
			Registry oRegitry = LocateRegistry.getRegistry(ServiceFacade.getInstance().getHost(),ServiceFacade.getInstance().getPort());
			DeliveryRemoteMgt oDeliveryRemoteMgt = (DeliveryRemoteMgt) oRegitry
					.lookup(sObjectService);
			allDeliveries = oDeliveryRemoteMgt.allDeliveries();
			//System.out.println("articulo agregado");
		} catch (Exception e) {
			throw new  NoServerConnectionException("No hay conexion con el servidor, Cerrar el programa" +
					"y abrirlo nuevamente");

		}
		return allDeliveries;
	}

}
