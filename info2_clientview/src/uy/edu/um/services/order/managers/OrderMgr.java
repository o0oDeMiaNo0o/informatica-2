package uy.edu.um.services.order.managers;

import java.util.ArrayList;

import uy.edu.um.services.order.interfaces.OrderMgt;
import uy.edu.um.value_object.article.ArticleVO;
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
	public void setClient() {
		// TODO Auto-generated method stub

	}

}
