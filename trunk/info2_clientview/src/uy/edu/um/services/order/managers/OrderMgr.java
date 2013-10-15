package uy.edu.um.services.order.managers;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import uy.edu.um.interfaces.oreder.OrderRemoteMgt;
import uy.edu.um.services.order.interfaces.OrderMgt;
import uy.edu.um.value_object.article.ArticleVO;
import uy.edu.um.value_object.oreder.OrderVO;
import uy.edu.um.value_object.people.client.ClientVO;

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
	public void getOrdersClient(ClientVO c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setClient(ArrayList<ArticleVO> a , ClientVO c) {
		// TODO Auto-generated met
		try {

			String sObjectService = "OrderRemoteMgr";

			Registry oRegitry = LocateRegistry.getRegistry(1299);

			OrderRemoteMgt oArticleRemoteMgt = (OrderRemoteMgt) oRegitry.lookup(sObjectService);

			OrderVO order = new OrderVO (a,c,null);
			
			oArticleRemoteMgt.addOrder(order);

			System.out.println("articulo agregado");

		} catch (Exception e) {
			System.err.println("error:");
			e.printStackTrace();

		}
	}

}
