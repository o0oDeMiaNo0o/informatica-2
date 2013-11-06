package uy.edu.um.services.order.interfaces;

import java.util.ArrayList;

import uy.edu.um.exceptions.checks.NoServerConnectionException;
import uy.edu.um.value_object.articleOrder.ArticleOrderVO;
import uy.edu.um.value_object.oreder.OrderVO;
import uy.edu.um.value_object.table.TableVO;
import uy.edu.um.value_object.user.UserVO;

public interface OrderMgt {

	public void addOrder(OrderVO o) throws NoServerConnectionException;

	public void removeOrder(OrderVO o) throws NoServerConnectionException;

	public OrderVO createOrderVO(ArrayList<ArticleOrderVO> ao, TableVO t, UserVO u, String spec,
			int estado);

	public ArrayList<OrderVO> allOrders() throws NoServerConnectionException;

	public void setDone(OrderVO o) throws NoServerConnectionException;

	public void rejected(OrderVO o) throws NoServerConnectionException;

	public void isWaiting(OrderVO o) throws NoServerConnectionException;

	public void isDone(OrderVO o) throws NoServerConnectionException;

	public ArrayList<OrderVO> getOrderTable(TableVO t) throws NoServerConnectionException;

}
