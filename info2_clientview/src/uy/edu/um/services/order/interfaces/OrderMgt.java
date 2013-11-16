package uy.edu.um.services.order.interfaces;

import java.util.ArrayList;

import uy.edu.um.exceptions.checks.NoDatabaseConnection;
import uy.edu.um.exceptions.checks.NoServerConnectionException;
import uy.edu.um.value_object.articleOrder.ArticleOrderVO;
import uy.edu.um.value_object.oreder.OrderVO;
import uy.edu.um.value_object.table.TableVO;
import uy.edu.um.value_object.user.UserVO;

public interface OrderMgt {

	public void addOrder(OrderVO o) throws NoServerConnectionException, NoDatabaseConnection;

	public OrderVO createOrderVO(ArrayList<ArticleOrderVO> ao, TableVO t, UserVO u, String spec,
			int estado);

	public ArrayList<OrderVO> allOrders() throws NoServerConnectionException, NoDatabaseConnection;

	public void entregado(OrderVO o) throws NoServerConnectionException, NoDatabaseConnection;

	public void rechazado(OrderVO o) throws NoServerConnectionException, NoDatabaseConnection;

	public void enPreparacion(OrderVO o) throws NoServerConnectionException, NoDatabaseConnection;

	public void terminada(OrderVO o) throws NoServerConnectionException, NoDatabaseConnection;

	public void addDelivery(OrderVO o) throws NoServerConnectionException, NoDatabaseConnection;

	public ArrayList<OrderVO> getOrderTable(TableVO t) throws NoServerConnectionException, NoDatabaseConnection;

	public ArrayList<OrderVO> allDeliveries() throws NoServerConnectionException, NoDatabaseConnection;

}
