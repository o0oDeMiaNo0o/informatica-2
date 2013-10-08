package uy.edu.um.client_service.business.bill.entities;

import java.math.BigDecimal;
import java.util.ArrayList;

import uy.edu.um.client_service.business.article.entities.Article;
import uy.edu.um.client_service.business.articleOrder.entities.ArticleOrder;
import uy.edu.um.client_service.business.order.entities.Order;

public class Bill {

	private ArrayList<Order> orders = new ArrayList<Order>(10);
	private BigDecimal costoTotal;

	public ArrayList<Order> getOrders() {
		return orders;
	}
	public BigDecimal getCostoTotal() {
		return costoTotal;
	}

	public Bill(ArrayList<Order> orders){
		this.orders = orders;
		this.costoTotal = costoTotal();
	}

	private BigDecimal costoTotal(){
		BigDecimal total = new BigDecimal(0);
		for(Order o: orders){
			if(o != null){
				ArrayList<ArticleOrder> articles = o.getArticles();
				for(ArticleOrder a : articles){
					if(a != null){
						Article currentArticle = a.getArticle();
						BigDecimal currentPrice = currentArticle.getPrecio();
						total = total.add(currentPrice);
					}
				}
			}
		}
		return total;
	}
}
