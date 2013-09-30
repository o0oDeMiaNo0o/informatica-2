package uy.edu.um.client_service.business.order.interfaces;

import uy.edu.um.client_service.business.clients.entities.Client;
import uy.edu.um.client_service.business.order.entities.Order;
import uy.edu.um.value_object.oreder.OrderVO;

public interface OrderMgt {

	public void addOrder(Order o);

	public void getOrderClient(Client c);

	public Order getOrder(OrderVO o);
}
