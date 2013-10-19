package uy.edu.um.client_service.business.order.managers;

import java.util.ArrayList;

import uy.edu.um.client_service.business.BusinessFacade;
import uy.edu.um.client_service.business.article.interfaces.ArticleMgt;
import uy.edu.um.client_service.business.articleOrder.entities.ArticleOrder;
import uy.edu.um.client_service.business.articleOrder.interfaces.ArticleOrderMgt;
import uy.edu.um.client_service.business.order.entities.Order;
import uy.edu.um.client_service.business.order.interfaces.OrderMgt;
import uy.edu.um.client_service.business.people.clients.entities.Client;
import uy.edu.um.client_service.business.table.entities.Table;
import uy.edu.um.client_service.business.table.interfaces.TableMgt;
import uy.edu.um.client_service.persistance.DAO.order.OrderDAO;
import uy.edu.um.value_object.article.ArticleVO;
import uy.edu.um.value_object.articleOrder.ArticleOrderVO;
import uy.edu.um.value_object.oreder.OrderVO;
import uy.edu.um.value_object.people.client.ClientVO;
import uy.edu.um.value_object.table.TableVO;

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
		ArticleOrderMgt aoMgt = BusinessFacade.getInstance().getArticleOrder();
		TableMgt tMgt = BusinessFacade.getInstance().getTableMgt();
		ArrayList<ArticleOrder> articleReturn = new ArrayList<ArticleOrder>(10);
		ArrayList<ArticleOrderVO> articulos = o.getArticulos();
		for(ArticleOrderVO current: articulos){
			if(current != null){
				ArticleVO aVO = current.getArticle();
				String especificaciones = current.getEspecificaciones();
				int currentCantidad = current.getCantidad();
				ArticleOrderVO temp = aoMgt.transition(aVO, currentCantidad, especificaciones);
				ArticleOrder toAdd = aoMgt.getArticleOrder(temp);
				articleReturn.add(toAdd);
			}
		}
		TableVO t = o.getTable();
		Table tAdd = tMgt.getTable(t);
		Order toReturn = new Order(articleReturn,tAdd);
		return toReturn;
	}

	@Override
	public void getOrderClient(Client c) {
		// TODO Auto-generated method stub

	}

	@Override
	public OrderVO createOrderVO(ArrayList<ArticleOrderVO> a, TableVO t) {
		OrderVO toReturn = new OrderVO(a,t);
		return toReturn;
	}




}
