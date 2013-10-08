package uy.edu.um.services.order.test;

import java.math.BigDecimal;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import uy.edu.um.interfaces.oreder.OrderRemoteMgt;
import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.order.interfaces.OrderMgt;
import uy.edu.um.value_object.article.ArticleVO;
import uy.edu.um.value_object.oreder.OrderVO;
import uy.edu.um.value_object.people.client.ClientVO;

public class OrderClientTest {
	public static void main(String[] args){
		try {

			String sObjectService = "OrderRemoteMgr";

			Registry oRegitry = LocateRegistry.getRegistry(1099);

			OrderRemoteMgt oOrderRemoteMgt = (OrderRemoteMgt) oRegitry.lookup(sObjectService);

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
			ArrayList<ArticleVO> a = new ArrayList<ArticleVO>(4);
			a.add(a1);
			a.add(a4);
			a.add(a2);
			a.add(a3);

			OrderVO order = new OrderVO(a,c1,null);

			oOrderRemoteMgt.addOrder(order);

			System.out.println("orden agregada");

		} catch (Exception e) {
			System.err.println("error:");
			e.printStackTrace();
		}

	}
}
