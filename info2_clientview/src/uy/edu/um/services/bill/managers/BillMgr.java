package uy.edu.um.services.bill.managers;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import uy.edu.um.interfaces.article.ArticleRemoteMgt;
import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.article.interfaces.ArticleMgt;
import uy.edu.um.services.bill.interfaces.BillMgt;
import uy.edu.um.value_object.article.ArticleVO;
import uy.edu.um.value_object.bill.BillVO;
import uy.edu.um.value_object.oreder.OrderVO;

public class BillMgr implements BillMgt{

	private static BillMgr instance = null;

	private BillMgr(){}

	public static BillMgt getInstance() {
		if(instance == null){
			instance = new BillMgr();
		}
		return instance;
	}
	@Override
	public BillVO createBillVO(ArrayList<OrderVO> orders) {
		return new BillVO(orders);
	}

	@Override
	public void sendBillVO(BillVO b) {

	}
}

