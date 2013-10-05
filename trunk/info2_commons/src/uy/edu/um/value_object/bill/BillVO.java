package uy.edu.um.value_object.bill;

import java.io.Serializable;
import java.util.ArrayList;

import uy.edu.um.value_object.article.ArticleVO;
import uy.edu.um.value_object.oreder.OrderVO;

public class BillVO implements Serializable{

	private ArrayList<OrderVO> orders = new ArrayList<OrderVO>(10);
	private int costoTotal;

	public BillVO(ArrayList<OrderVO> orders){
		this.orders = orders;
		this.costoTotal = getTotal();
	}

	public ArrayList<OrderVO> getOrders() {
		return orders;
	}

	public int getCostoTotal() {
		return costoTotal;
	}



	public int getTotal(){
		int total = 0;
		for(OrderVO current : orders){
			ArrayList<ArticleVO> articles = current.getArticulos();
			for(ArticleVO a : articles){
				total = total + a.getPrecio();
			}
		}
		return total;
	}
}
