package uy.edu.um.client_service.business.order.interfaces;

import java.rmi.RemoteException;
import java.util.ArrayList;

import uy.edu.um.client_service.business.order.entities.Order;
import uy.edu.um.client_service.business.people.clients.entities.Client;
import uy.edu.um.client_service.business.table.entities.Table;
import uy.edu.um.exceptions.checks.NoDatabaseConnection;
import uy.edu.um.value_object.oreder.OrderVO;

public interface OrderMgt {

	public void addOrder(Order o) throws NoDatabaseConnection;

	public void getOrderClient(Client c);

	public Order getOrder(OrderVO o);

	public ArrayList<OrderVO> allOrders() throws NoDatabaseConnection;

	public ArrayList<OrderVO> allDeliveries() throws NoDatabaseConnection;

	public OrderVO getOrderVO(Order o);

	public ArrayList<OrderVO> getOrderTable(Table t) throws NoDatabaseConnection;

	public void entregado(Order o) throws NoDatabaseConnection;

	public void enPreparacion(Order o) throws NoDatabaseConnection;

	public void rechazado(Order o) throws NoDatabaseConnection;

	public void delivery(Order o) throws NoDatabaseConnection;

	public void terminada(Order o) throws NoDatabaseConnection;


}
