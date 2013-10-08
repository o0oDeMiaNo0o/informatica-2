package uy.edu.um.client_service.business.order.managers;

import java.util.ArrayList;

import uy.edu.um.client_service.business.BusinessFacade;
import uy.edu.um.client_service.business.article.entities.Article;
import uy.edu.um.client_service.business.article.interfaces.ArticleMgt;
import uy.edu.um.client_service.business.articleOrder.entities.ArticleOrder;
import uy.edu.um.client_service.business.order.entities.Order;
import uy.edu.um.client_service.business.order.interfaces.OrderMgt;
import uy.edu.um.client_service.business.people.clients.entities.Client;
import uy.edu.um.client_service.business.people.clients.interfaces.ClientMgt;
import uy.edu.um.client_service.persistance.DAO.order.OrderDAO;
import uy.edu.um.value_object.article.ArticleVO;
import uy.edu.um.value_object.articleOrder.ArticleOrderVO;
import uy.edu.um.value_object.oreder.OrderVO;
import uy.edu.um.value_object.people.client.ClientVO;

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
		OrderDAO dao = OrderDAO.getInstance();
		dao.addOrder(o);
	}

	@Override
	public Order getOrder(OrderVO o) {
		ArticleMgt aMgt = BusinessFacade.getInstance().getArticleMgt();
		ClientMgt cMgt = BusinessFacade.getInstance().getClientMgt();
		ArrayList<ArticleOrder> articleReturn = new ArrayList<ArticleOrder>(10);
		ArrayList<ArticleOrderVO> articulos = o.getArticulos();
		for(ArticleOrderVO current: articulos){
			if(current != null){
				ArticleVO aVO = current.getArticle();
				int currentCantidad = current.getCantidad();
				Article a = aMgt.getArticle(aVO);
				ArticleOrder toAdd = new ArticleOrder(a,currentCantidad);
				articleReturn.add(toAdd);
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

	@Override
	public OrderVO createOrderVO(ArrayList<ArticleOrderVO> a, ClientVO c,String descripcion) {
		OrderVO toReturn = new OrderVO(a,c,descripcion);
		return toReturn;
	}




}
