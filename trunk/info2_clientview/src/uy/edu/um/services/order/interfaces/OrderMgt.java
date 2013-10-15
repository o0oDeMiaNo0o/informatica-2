package uy.edu.um.services.order.interfaces;

import java.util.ArrayList;

import uy.edu.um.value_object.article.ArticleVO;
import uy.edu.um.value_object.people.client.ClientVO;

public interface OrderMgt {

	public void getOrdersClient(ClientVO c);

	public void setClient(ArrayList<ArticleVO> a, ClientVO c);



}
