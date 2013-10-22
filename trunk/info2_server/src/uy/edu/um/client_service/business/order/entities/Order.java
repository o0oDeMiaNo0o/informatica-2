package uy.edu.um.client_service.business.order.entities;

import java.util.ArrayList;

import uy.edu.um.client_service.business.articleOrder.entities.ArticleOrder;
import uy.edu.um.client_service.business.table.entities.Table;
import uy.edu.um.client_service.business.users.entities.User;

public class Order {
	//atributos
	private ArrayList<ArticleOrder> articles = new ArrayList<ArticleOrder>(10);
	private Table table=null;
	private User user=null;
	private String spec;
	private boolean done=false;
	private int id;

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	//constructor
	public Order(ArrayList<ArticleOrder> articles, Table table, User user, String spec){
		this.articles = articles;
		this.table = table;
		this.user = user;
		this.spec = spec;
	}
	
	public Order(ArrayList<ArticleOrder> articles, Table table, User user, String spec, boolean e){
		this.articles = articles;
		this.table = table;
		this.user = user;
		this.spec = spec;
		this.done=e;
	}
	
	public Order(ArrayList<ArticleOrder> articles, Table table, User user){
		this.articles = articles;
		this.table = table;
		this.user = user;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

}
