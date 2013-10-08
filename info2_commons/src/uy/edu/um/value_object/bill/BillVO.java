package uy.edu.um.value_object.bill;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;

import uy.edu.um.value_object.article.ArticleVO;
import uy.edu.um.value_object.oreder.OrderVO;

public class BillVO implements Serializable{

	private ArrayList<OrderVO> orders = new ArrayList<OrderVO>(10);
	private BigDecimal costoTotal;

	public BillVO(ArrayList<OrderVO> orders){
		this.orders = orders;
		this.costoTotal = getTotal();
	}

	public ArrayList<OrderVO> getOrders() {
		return orders;
	}

	public BigDecimal getCostoTotal() {
		return costoTotal;
	}



	public BigDecimal getTotal(){
		BigDecimal total = new BigDecimal(0);
		for(OrderVO current : orders){
			ArrayList<ArticleVO> articles = current.getArticulos();
			for(ArticleVO a : articles){
				BigDecimal currentPrice = a.getPrecio();
				total = currentPrice.add(currentPrice);
			}
		}
		return total;
	}
}
