package uy.edu.um.services.order.test;

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

			 ArticleVO a1 = new ArticleVO(101,"pizza",120);
			 ArticleVO a2 = new ArticleVO(102,"muzza",200);
			 ArticleVO a3 = new ArticleVO(201,"hambuerguesa",180);
			 ArticleVO a4 = new ArticleVO(202,"chivito",280);
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

			System.out.println("orden agregado");

		} catch (Exception e) {
			System.err.println("error:");
			e.printStackTrace();
		}

	}
}
