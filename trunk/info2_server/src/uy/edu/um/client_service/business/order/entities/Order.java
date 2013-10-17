package uy.edu.um.client_service.business.order.entities;

import java.util.ArrayList;

import uy.edu.um.client_service.business.people.clients.entities.Client;
import uy.edu.um.client_service.business.articleOrder.entities.ArticleOrder;

public class Order {
	//atributos
	ArrayList<ArticleOrder> articles = new ArrayList<ArticleOrder>(10);
	Client c = null;


	//constructor
	public Order(ArrayList<ArticleOrder> articles, Client c){
		this.articles = articles;
		this.c = c;
	}

	public ArrayList<ArticleOrder> getArticles() {
		return articles;
	}

	public void setArticles(ArrayList<ArticleOrder> articles) {
		this.articles = articles;
	}

	public Client getC() {
		return c;
	}

	public void setC(Client c) {
		this.c = c;
	}


}
