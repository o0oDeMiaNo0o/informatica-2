package uy.edu.um.client_service.business.order.managers;

import java.util.ArrayList;

import uy.edu.um.client_service.business.BusinessFacade;
import uy.edu.um.client_service.business.articleOrder.entities.ArticleOrder;
import uy.edu.um.client_service.business.articleOrder.interfaces.ArticleOrderMgt;
import uy.edu.um.client_service.business.order.entities.Order;
import uy.edu.um.client_service.business.order.interfaces.OrderMgt;
import uy.edu.um.client_service.business.people.clients.entities.Client;
import uy.edu.um.client_service.business.table.entities.Table;
import uy.edu.um.client_service.business.table.interfaces.TableMgt;
import uy.edu.um.client_service.business.users.entities.User;
import uy.edu.um.client_service.business.users.interfaces.UserMgt;
import uy.edu.um.client_service.persistance.DAO.order.OrderDAO;
import uy.edu.um.value_object.article.ArticleVO;
import uy.edu.um.value_object.articleOrder.ArticleOrderVO;
import uy.edu.um.value_object.oreder.OrderVO;
import uy.edu.um.value_object.table.TableVO;
import uy.edu.um.value_object.user.UserVO;

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
		UserMgt uMgt = BusinessFacade.getInstance().getUserMgt();
		TableMgt tMgt = BusinessFacade.getInstance().getTableMgt();
		ArrayList<ArticleOrder> articleReturn = new ArrayList<ArticleOrder>(10);
		ArrayList<ArticleOrderVO> articulos = o.getArticulos();
		for(ArticleOrderVO current: articulos){
			if(current != null){
				ArticleVO aVO = current.getArticle();
				int currentCantidad = current.getCantidad();
				ArticleOrderVO temp = aoMgt.transition(aVO, currentCantidad);
				ArticleOrder toAdd = aoMgt.getArticleOrder(temp);
				articleReturn.add(toAdd);
			}
		}
		Table tAdd = tMgt.getTable(o.getTable());
		User uAdd = uMgt.getUser(o.getUser());
		String spec = o.getEspecificaciones();
		Order toReturn = new Order(articleReturn,tAdd,uAdd,spec);
		return toReturn;
	}

	@Override
	public void getOrderClient(Client c) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<OrderVO> allOrders() {
		OrderDAO dao = OrderDAO.getInstance();
		return null;
	}

	@Override
	public OrderVO getOrderVO(Order o) {
		//managers
		ArticleOrderMgt aMgt = BusinessFacade.getInstance().getArticleOrder();
		TableMgt tMgt = BusinessFacade.getInstance().getTableMgt();
		UserMgt uMgt = BusinessFacade.getInstance().getUserMgt();

		ArrayList<ArticleOrder> articleOrders = o.getArticles();
		ArrayList<ArticleOrderVO> aoVO = new ArrayList<ArticleOrderVO>(10);
		for(ArticleOrder ao : articleOrders){
			if(ao!=null){
				ArticleOrderVO toAdd = aMgt.getArticleOrderVO(ao);
				aoVO.add(toAdd);
			}
		}
		TableVO tAdd = tMgt.getTableVO(o.getTable());
		UserVO uAdd = uMgt.getUserVO(o.getUser());

		OrderVO toReturn = new OrderVO(aoVO,tAdd,uAdd,o.getSpec());

		return toReturn;

	}





}
