package uy.edu.um.client_service.business.order.interfaces;

import java.util.ArrayList;

import uy.edu.um.client_service.business.order.entities.Order;
import uy.edu.um.client_service.business.people.clients.entities.Client;
import uy.edu.um.value_object.articleOrder.ArticleOrderVO;
import uy.edu.um.value_object.oreder.OrderVO;
import uy.edu.um.value_object.table.TableVO;

public interface OrderMgt {

	public OrderVO createOrderVO(ArrayList<ArticleOrderVO> a , TableVO t);

	public void addOrder(Order o);

	public void getOrderClient(Client c);

	public Order getOrder(OrderVO o);

}
