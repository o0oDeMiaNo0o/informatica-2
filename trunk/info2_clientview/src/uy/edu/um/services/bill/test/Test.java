package uy.edu.um.services.bill.test;

import java.math.BigDecimal;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import uy.edu.um.interfaces.bill.BillRemoteMgt;
import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.bill.interfaces.BillMgt;
import uy.edu.um.services.order.interfaces.OrderMgt;
import uy.edu.um.value_object.article.ArticleVO;
import uy.edu.um.value_object.bill.BillVO;
import uy.edu.um.value_object.oreder.OrderVO;
import uy.edu.um.value_object.people.client.ClientVO;

public class Test {
	public static void main(String[] args){
		try{
			String sObjectService = "BillRemoteMgr";

			Registry oRegitry = LocateRegistry.getRegistry(1099);

			BillRemoteMgt oBillRemoteMgt = (BillRemoteMgt) oRegitry.lookup(sObjectService);


			BillMgt bMgt = ServiceFacade.getInstance().getBillMgt();

			OrderMgt oMgt = ServiceFacade.getInstance().getOrderMgt();

			BigDecimal p1 = new BigDecimal(120);
			BigDecimal p2 = new BigDecimal(200);
			BigDecimal p3 = new BigDecimal(180);
			BigDecimal p4 = new BigDecimal(280);

			ArticleVO a1 = new ArticleVO(101,"pizza",p1);
			ArticleVO a2 = new ArticleVO(102,"muzza",p2);
			ArticleVO a3 = new ArticleVO(201,"hambuerguesa",p3);
			ArticleVO a4 = new ArticleVO(202,"chivito",p4);
			String nombre = "asdf";
			String apellido = "asdf";
			String direccion = "asdf";
			String email = "asdf";
			int ci= 1234;
			int tel = 345;
			ClientVO c1 = new ClientVO(nombre,apellido,ci,tel,direccion,email);
			ArrayList<ArticleVO> ar1 = new ArrayList<ArticleVO>(4);
			ArrayList<ArticleVO> ar2 = new ArrayList<ArticleVO>(4);
			ar2.add(a4);
			ar2.add(a3);
			ar2.add(a1);
			ar1.add(a1);
			ar1.add(a4);
			ar1.add(a2);
			ar1.add(a3);
			OrderVO order1 = new OrderVO(ar1,c1,null);
			OrderVO order2 = new OrderVO(ar2,c1,null);
			ArrayList<OrderVO> orders = new ArrayList<OrderVO>(2);
			orders.add(order1); orders.add(order2);

			BillVO toAdd = bMgt.createBillVO(orders);

			oBillRemoteMgt.addBill(toAdd);

			System.out.println("no hubo quilombo");

		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
