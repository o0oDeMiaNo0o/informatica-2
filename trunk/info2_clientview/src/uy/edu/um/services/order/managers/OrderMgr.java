package uy.edu.um.services.order.managers;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import uy.edu.um.exceptions.checks.NoDatabaseConnection;
import uy.edu.um.exceptions.checks.NoServerConnectionException;
import uy.edu.um.interfaces.oreder.OrderRemoteMgt;
import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.order.interfaces.OrderMgt;
import uy.edu.um.value_object.articleOrder.ArticleOrderVO;
import uy.edu.um.value_object.oreder.OrderVO;
import uy.edu.um.value_object.table.TableVO;
import uy.edu.um.value_object.user.UserVO;

public class OrderMgr implements OrderMgt{

	private static OrderMgr instance = null;

	private OrderMgr(){}

	public static OrderMgr getInstance(){
		if(instance == null){
			instance = new OrderMgr();
		}
		return instance;
	}


	@Override
	public void addOrder(OrderVO o) throws NoServerConnectionException, NoDatabaseConnection {
		try {
			String sObjectService = "OrderRemoteMgr";
			Registry oRegitry = LocateRegistry.getRegistry(ServiceFacade.getInstance().getHost(),ServiceFacade.getInstance().getPort());
			OrderRemoteMgt oArticleRemoteMgt = (OrderRemoteMgt) oRegitry.lookup(sObjectService);
			oArticleRemoteMgt.addOrder(o);
		} catch (Exception e) {
			throw new  NoServerConnectionException("No hay conexion con el servidor, Cerrar el programa" +
					"y abrirlo nuevamente");
		}


	}


	@Override
	public OrderVO createOrderVO(ArrayList<ArticleOrderVO> ao, TableVO t,
			UserVO u, String spec,int estado) {
		OrderVO toReturn = new OrderVO(ao,t,u,spec,estado);
		return toReturn;

	}

	@Override
	public ArrayList<OrderVO> allOrders()  throws NoServerConnectionException, NoDatabaseConnection {
		ArrayList<OrderVO> array = new ArrayList<OrderVO>(10);
		try {
			String sObjectService = "OrderRemoteMgr";
			Registry oRegitry = LocateRegistry.getRegistry(ServiceFacade.getInstance().getHost(),ServiceFacade.getInstance().getPort());
			OrderRemoteMgt oOrderRemoteMgt = (OrderRemoteMgt) oRegitry.lookup(sObjectService);
			array = oOrderRemoteMgt.allOrders();
		} catch (Exception e) {
			throw new  NoServerConnectionException("No hay conexion con el servidor, Cerrar el programa" +
						"y abrirlo nuevamente");
		}
		return array;


	}

	@Override
	public ArrayList<OrderVO> getOrderTable(TableVO t)  throws NoServerConnectionException, NoDatabaseConnection {
		ArrayList<OrderVO> array = new ArrayList<OrderVO>(10);
		try {
			String sObjectService = "OrderRemoteMgr";
			Registry oRegitry = LocateRegistry.getRegistry(ServiceFacade.getInstance().getHost(),ServiceFacade.getInstance().getPort());
			OrderRemoteMgt oOrderRemoteMgt = (OrderRemoteMgt) oRegitry.lookup(sObjectService);
			array = oOrderRemoteMgt.allOrdersTable(t);
			System.out.println("ordenes recibidas correctamente");
		} catch (Exception e) {
			throw new  NoServerConnectionException("No hay conexion con el servidor, Cerrar el programa" +
			"y abrirlo nuevamente");
		}
		return array;
	}

	@Override
	public void enPreparacion(OrderVO o)
			throws NoServerConnectionException, NoDatabaseConnection {
		try {
			int id=0;
			o.setEstado(id);
			String sObjectService = "OrderRemoteMgr";
			Registry oRegitry = LocateRegistry.getRegistry(ServiceFacade.getInstance().getHost(),ServiceFacade.getInstance().getPort());
			OrderRemoteMgt oOrderRemoteMgt = (OrderRemoteMgt) oRegitry.lookup(sObjectService);
			oOrderRemoteMgt.enPreparacion(o);
		} catch (Exception e) {
			throw new  NoServerConnectionException("No hay conexion con el servidor, Cerrar el programa" +
			"y abrirlo nuevamente");
		}

	}

	@Override
	public void entregado(OrderVO o)
			throws NoServerConnectionException, NoDatabaseConnection {
		try {
			int id = 1;
			o.setEstado(id);
			String sObjectService = "OrderRemoteMgr";
			Registry oRegitry = LocateRegistry.getRegistry(ServiceFacade.getInstance().getHost(),ServiceFacade.getInstance().getPort());
			OrderRemoteMgt oOrderRemoteMgt = (OrderRemoteMgt) oRegitry.lookup(sObjectService);
			oOrderRemoteMgt.entregado(o);
		} catch (Exception e) {
			throw new  NoServerConnectionException("No hay conexion con el servidor, Cerrar el programa" +
			"y abrirlo nuevamente");
		}
	}

	@Override
	public void rechazado(OrderVO o)
			throws NoServerConnectionException, NoDatabaseConnection {
		try {
			int id = 2;
			o.setEstado(id);
			String sObjectService = "OrderRemoteMgr";
			Registry oRegitry = LocateRegistry.getRegistry(ServiceFacade.getInstance().getHost(),ServiceFacade.getInstance().getPort());
			OrderRemoteMgt oOrderRemoteMgt = (OrderRemoteMgt) oRegitry.lookup(sObjectService);
			oOrderRemoteMgt.rechazado(o);
		} catch (Exception e) {
			throw new  NoServerConnectionException("No hay conexion con el servidor, Cerrar el programa" +
			"y abrirlo nuevamente");
		}
	}

	@Override
	public void terminada(OrderVO o)
			throws NoServerConnectionException, NoDatabaseConnection {
		try {
			int id = 3;
			o.setEstado(id);
			String sObjectService = "OrderRemoteMgr";
			Registry oRegitry = LocateRegistry.getRegistry(ServiceFacade.getInstance().getHost(),ServiceFacade.getInstance().getPort());
			OrderRemoteMgt oOrderRemoteMgt = (OrderRemoteMgt) oRegitry.lookup(sObjectService);
			oOrderRemoteMgt.terminada(o);
		} catch (Exception e) {
			throw new  NoServerConnectionException("No hay conexion con el servidor, Cerrar el programa" +
			"y abrirlo nuevamente");
		}
	}

//	@Override
//	public void delivery(OrderVO o) throws NoServerConnectionException,
//			NoDatabaseConnection {
//		try {
//			int id = 4;
//			o.setEstado(id);
//			String sObjectService = "OrderRemoteMgr";
//			Registry oRegitry = LocateRegistry.getRegistry(ServiceFacade.getInstance().getHost(),ServiceFacade.getInstance().getPort());
//			OrderRemoteMgt oOrderRemoteMgt = (OrderRemoteMgt) oRegitry.lookup(sObjectService);
//			oOrderRemoteMgt.delivery(o);
//		} catch (Exception e) {
//			throw new  NoServerConnectionException("No hay conexion con el servidor, Cerrar el programa" +
//			"y abrirlo nuevamente");
//		}
//
//	}

	@Override
	public void addDelivery(OrderVO o) throws NoServerConnectionException,
			NoDatabaseConnection {
		try {
			String sObjectService = "OrderRemoteMgr";
			Registry oRegitry = LocateRegistry.getRegistry(ServiceFacade.getInstance().getHost(),ServiceFacade.getInstance().getPort());
			OrderRemoteMgt oOrderRemoteMgt = (OrderRemoteMgt) oRegitry.lookup(sObjectService);
			oOrderRemoteMgt.delivery(o);
		} catch (Exception e) {
			throw new  NoServerConnectionException("No hay conexion con el servidor, Cerrar el programa" +
			"y abrirlo nuevamente");
		}

	}

}
