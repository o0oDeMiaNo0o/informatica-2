package uy.edu.um.client_service.business.bill.entities;

import java.math.BigDecimal;
import java.util.ArrayList;

import uy.edu.um.client_service.business.article.entities.Article;
import uy.edu.um.client_service.business.articleOrder.entities.ArticleOrder;
import uy.edu.um.client_service.business.order.entities.Order;
import uy.edu.um.client_service.business.people.clients.entities.Client;
import uy.edu.um.client_service.business.people.waiters.entities.Waiter;
import uy.edu.um.client_service.business.table.entities.Table;

public class Bill {

	private ArrayList<Order> orders = new ArrayList<Order>(10);
	private Waiter waiter;
	private Client client;
	private Table table;
	private int id;

	public ArrayList<Order> getOrders() {
		return orders;
	}

	public Bill(int id, ArrayList<Order> orders,Client client, Table table, Waiter waiter){
		this.id = id;
		this.orders = orders;
		this.client = client;
		this.waiter = waiter;
		this.table = table;
	}

	public Bill(ArrayList<Order> orders,Client client, Table table, Waiter waiter){
		this.orders = orders;
		this.client = client;
		this.table = table;
		this.waiter = waiter;
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

	public Waiter getWaiter() {
		return waiter;
	}

	public void setWaiter(Waiter waiter) {
		this.waiter = waiter;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}
}
