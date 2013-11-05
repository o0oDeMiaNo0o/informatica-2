package uy.edu.um.services.order.managers;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import uy.edu.um.interfaces.oreder.OrderRemoteMgt;
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
	public void addOrder(OrderVO o) {
		try {

			String sObjectService = "OrderRemoteMgr";

			Registry oRegitry = LocateRegistry.getRegistry(1099);

			OrderRemoteMgt oArticleRemoteMgt = (OrderRemoteMgt) oRegitry.lookup(sObjectService);

			oArticleRemoteMgt.addOrder(o);

			System.out.println("orden agregada");
		} catch (Exception e) {
			System.err.println("error:");
			e.printStackTrace();

		}


	}


	@Override
	public OrderVO createOrderVO(ArrayList<ArticleOrderVO> ao, TableVO t,
			UserVO u, String spec,int estado) {
		OrderVO toReturn = new OrderVO(ao,t,u,spec,estado);
		return toReturn;

	}

	@Override
	public void removeOrder(OrderVO o) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<OrderVO> allOrders() {

		ArrayList<OrderVO> array = new ArrayList<OrderVO>(10);

		try {

			String sObjectService = "OrderRemoteMgr";

			Registry oRegitry = LocateRegistry.getRegistry(1099);

			OrderRemoteMgt oOrderRemoteMgt = (OrderRemoteMgt) oRegitry.lookup(sObjectService);

			array = oOrderRemoteMgt.allOrders();

			System.out.println("ordenes recibidas correctamente");
		} catch (Exception e) {
			System.err.println("error:");
			e.printStackTrace();

		}

		return array;


	}

	@Override
	public void setDone(OrderVO o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delivery(OrderVO o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void isDone(OrderVO o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void isWaiting(OrderVO o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void rejected(OrderVO o) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<OrderVO> getOrderTable(TableVO t) {
		ArrayList<OrderVO> array = new ArrayList<OrderVO>(10);
		try {
			String sObjectService = "OrderRemoteMgr";
			Registry oRegitry = LocateRegistry.getRegistry(1099);
			OrderRemoteMgt oOrderRemoteMgt = (OrderRemoteMgt) oRegitry.lookup(sObjectService);
			array = oOrderRemoteMgt.allOrdersTable(t);
			System.out.println("ordenes recibidas correctamente");
		} catch (Exception e) {
			System.err.println("error:");
			e.printStackTrace();
		}
		return array;
	}

}
