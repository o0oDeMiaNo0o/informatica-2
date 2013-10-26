package uy.edu.um.client_service.business.order.test;

import java.util.ArrayList;

import uy.edu.um.client_service.business.BusinessFacade;
import uy.edu.um.client_service.business.order.interfaces.OrderMgt;
import uy.edu.um.value_object.articleOrder.ArticleOrderVO;
import uy.edu.um.value_object.oreder.OrderVO;

public class Test {
	public static void main(String[] args){
		OrderMgt oMgt = BusinessFacade.getInstance().getOrderMgt();

		ArrayList<OrderVO> toReturn = new ArrayList<OrderVO>(10);

		toReturn = oMgt.allOrders();

		for (OrderVO o : toReturn){
			if(o!=null){
				ArrayList<ArticleOrderVO> articles = o.getArticulos();
				for(ArticleOrderVO a : articles){
					System.out.println("Articulo : "+a.getArticle().getNombre()+", cantidad : "+
							a.getCantidad());
				}
				System.out.println("||||||||||||||||||||||||||||||||");
			}
		}
	}
}
