package uy.edu.um.client_service.business.order.managers;

import java.util.ArrayList;

import uy.edu.um.client_service.business.BusinessFacade;
import uy.edu.um.client_service.business.article.entities.Article;
import uy.edu.um.client_service.business.article.interfaces.ArticleMgt;
import uy.edu.um.client_service.business.clients.entities.Client;
import uy.edu.um.client_service.business.clients.interfaces.ClientMgt;
import uy.edu.um.client_service.business.order.entities.Order;
import uy.edu.um.client_service.business.order.interfaces.OrderMgt;
import uy.edu.um.value_object.article.ArticleVO;
import uy.edu.um.value_object.oreder.OrderVO;

public class OrderMgr implements OrderMgt{

	private static OrderMgr instance = null;

	private OrderMgr(){

	}

	public static OrderMgr getInstance(){
		if(instance == null){
			instance = new OrderMgr();
		}
		return instance;
	}

	@Override
	public void addOrder(Order o) {


	}

	@Override
	public Order getOrder(OrderVO o) {
		ArticleMgt aMgt = BusinessFacade.getInstance().getArticleMgt();
		ClientMgt cMgt = BusinessFacade.getInstance().getClientMgt();
		ArrayList<Article> articleReturn = null;
		ArrayList<ArticleVO> articulos = o.getArticulos();
		for(ArticleVO current: articulos){
			if(current != null){
				Article a = aMgt.getArticle(current);
				articleReturn.add(a);
			}
		}
		Client clientReturn = cMgt.getClient(o.getC());
		Order toReturn = new Order(articleReturn, clientReturn);
		return toReturn;
	}

	@Override
	public void getOrderClient(Client c) {
		// TODO Auto-generated method stub

	}

}
