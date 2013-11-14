package uy.edu.um.client_service.business.bill.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import uy.edu.um.client_service.business.article.entities.Article;
import uy.edu.um.client_service.business.articleOrder.entities.ArticleOrder;
import uy.edu.um.client_service.business.order.entities.Order;
import uy.edu.um.client_service.business.people.clients.entities.Client;
import uy.edu.um.client_service.business.table.entities.Table;

public class Bill {

	private ArrayList<Order> orders = new ArrayList<Order>(10);
	private Client client;
	private Table table;
	private int id;
	private BigDecimal montoTotal;
	private Date date;

	public ArrayList<Order> getOrders() {
		return orders;
	}

	public Bill(int id, ArrayList<Order> orders,Client client, Table table, Date date){
		this.id = id;
		this.orders = orders;
		this.client = client;
		this.table = table;
		this.date = date;
	}

	public Bill(ArrayList<Order> orders,Client client, Table table, Date date){
		this.orders = orders;
		this.client = client;
		this.table = table;
		this.date = date;
	}

	public Bill(ArrayList<Order> orders,Client client, Table table, BigDecimal montoTotal, Date date){
		this.orders = orders;
		this.client = client;
		this.table = table;
		this.montoTotal = montoTotal;
		this.date = date;
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

	public BigDecimal getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(BigDecimal montoTotal) {
		this.montoTotal = montoTotal;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
