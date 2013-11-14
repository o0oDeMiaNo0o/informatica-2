package uy.edu.um.client_service.business.order.managers;

import java.rmi.RemoteException;
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
import uy.edu.um.exceptions.checks.NoDatabaseConnection;
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
	public void addOrder(Order o) throws NoDatabaseConnection {
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
		int estado = o.getEstado();
		int id = o.getId();
		//public Order(int id,ArrayList<ArticleOrder> articles, Table table, User user, int e, String specs){
		Order toReturn = new Order(id,articleReturn,tAdd,uAdd,spec,estado);
		return toReturn;
	}

	@Override
	public void getOrderClient(Client c) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<OrderVO> allOrders() throws NoDatabaseConnection {
		OrderDAO dao = OrderDAO.getInstance();
		ArrayList<Order> orders = dao.getOrders();
		ArrayList<OrderVO> toReturn = new ArrayList<OrderVO>(10);
		for(Order o : orders){
			if(o!=null){
				OrderVO toAdd = this.getOrderVO(o);
				toReturn.add(toAdd);
			}
		}
		return toReturn;
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
		UserVO uAdd = null;
		if(o.getUser()!=null){
			uAdd = uMgt.getUserVO(o.getUser());
		}

		int estado = o.getEstado();
		int id = o.getId();
		OrderVO toReturn = new OrderVO(id,aoVO,tAdd,uAdd,o.getSpec(),estado);

		return toReturn;

	}


	@Override
	public ArrayList<OrderVO> getOrderTable(Table t) throws NoDatabaseConnection {
		OrderMgt oMgt = BusinessFacade.getInstance().getOrderMgt();
		OrderDAO dao = OrderDAO.getInstance();
		ArrayList<Order> orders = dao.getTableOrders(t);
		ArrayList<OrderVO> toReturn = new ArrayList<OrderVO>(2);
		for(Order o : orders){
			if(o!=null){
				OrderVO oAdd = oMgt.getOrderVO(o);
				toReturn.add(oAdd);
			}
		}
		return toReturn;
	}


	@Override
	public void enPreparacion(Order o) throws NoDatabaseConnection {
		OrderDAO dao = OrderDAO.getInstance();
		dao.cambioEstadoOrder(o);

	}

	@Override
	public void entregado(Order o) throws NoDatabaseConnection {
		OrderDAO dao = OrderDAO.getInstance();
		dao.cambioEstadoOrder(o);

	}

	@Override
	public void rechazado(Order o) throws NoDatabaseConnection {
		OrderDAO dao = OrderDAO.getInstance();
		dao.cambioEstadoOrder(o);
	}

	@Override
	public void terminada(Order o) throws NoDatabaseConnection {
		OrderDAO dao = OrderDAO.getInstance();
		dao.cambioEstadoOrder(o);

	}

	@Override
	public void delivery(Order o) throws NoDatabaseConnection {
		// TODO Auto-generated method stub

	}


}
