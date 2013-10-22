package uy.edu.um.services.order.interfaces;

import java.util.ArrayList;

import uy.edu.um.value_object.articleOrder.ArticleOrderVO;
import uy.edu.um.value_object.oreder.OrderVO;
import uy.edu.um.value_object.table.TableVO;
import uy.edu.um.value_object.user.UserVO;

public interface OrderMgt {

	public void addOrder(OrderVO o);

	public void removeOrder(OrderVO o);

	public OrderVO createOrderVO(ArrayList<ArticleOrderVO> ao, TableVO t, UserVO u, String spec);

	public ArrayList<OrderVO> allOrders();

}
