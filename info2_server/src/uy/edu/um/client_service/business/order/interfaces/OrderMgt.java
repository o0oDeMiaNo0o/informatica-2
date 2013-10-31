package uy.edu.um.client_service.business.order.interfaces;

import java.rmi.RemoteException;
import java.util.ArrayList;

import uy.edu.um.client_service.business.order.entities.Order;
import uy.edu.um.client_service.business.people.clients.entities.Client;
import uy.edu.um.value_object.articleOrder.ArticleOrderVO;
import uy.edu.um.value_object.oreder.OrderVO;
import uy.edu.um.value_object.table.TableVO;

public interface OrderMgt {

	public void addOrder(Order o);

	public void getOrderClient(Client c);

	public Order getOrder(OrderVO o);

	public ArrayList<OrderVO> allOrders();

	public OrderVO getOrderVO(Order o);

	public void isReady(OrderVO o) throws RemoteException;

	public void isPreparing(OrderVO o) throws RemoteException;

	public void rejected(OrderVO o) throws RemoteException;

	public void delivery(OrderVO o) throws RemoteException;


}
