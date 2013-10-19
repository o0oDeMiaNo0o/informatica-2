package uy.edu.um.client_service.business.order.entities;

import java.util.ArrayList;

import uy.edu.um.client_service.business.articleOrder.entities.ArticleOrder;
import uy.edu.um.client_service.business.people.clients.entities.Client;
import uy.edu.um.client_service.business.table.entities.Table;

public class Order {
	//atributos
	private ArrayList<ArticleOrder> articles = new ArrayList<ArticleOrder>(10);
	private Table table;

	//constructor
	public Order(ArrayList<ArticleOrder> articles, Table table){
		this.articles = articles;
		this.table = table;
	}

	public ArrayList<ArticleOrder> getArticles() {
		return articles;
	}

	public void setArticles(ArrayList<ArticleOrder> articles) {
		this.articles = articles;
	}

	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}

}
