package uy.edu.um.client_service.service.orderRemote.test;

import java.util.ArrayList;

import uy.edu.um.client_service.business.BusinessFacade;
import uy.edu.um.client_service.business.order.entities.Order;
import uy.edu.um.client_service.business.order.interfaces.OrderMgt;
import uy.edu.um.value_object.article.ArticleVO;
import uy.edu.um.value_object.oreder.OrderVO;
import uy.edu.um.value_object.people.client.ClientVO;

public class OrderRemoteTest {
	public static void main(String[] args){

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
		 OrderMgt oMgt = BusinessFacade.getInstance().getOrderMgt();
		 OrderVO to = oMgt.createOrderVO(a, c1);
		 Order toAdd = oMgt.getOrder(to);
		 oMgt.addOrder(toAdd);
		 System.out.println("nada colapso");
	}
}
