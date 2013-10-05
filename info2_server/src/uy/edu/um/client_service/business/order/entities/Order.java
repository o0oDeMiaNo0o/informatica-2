package uy.edu.um.client_service.business.order.entities;

import java.util.ArrayList;

import uy.edu.um.client_service.business.article.entities.Article;
import uy.edu.um.client_service.business.people.clients.entities.Client;

public class Order {
	//atributos
	ArrayList<Article> articles = new ArrayList<Article>(10);
	Client c = null;
	

	//constructor
	public Order(ArrayList<Article> articles, Client c){
		this.articles = articles;
		this.c = c;
	}

	public ArrayList<Article> getArticles() {
		return articles;
	}

	public void setArticles(ArrayList<Article> articles) {
		this.articles = articles;
	}

	public Client getC() {
		return c;
	}

	public void setC(Client c) {
		this.c = c;
	}


}
