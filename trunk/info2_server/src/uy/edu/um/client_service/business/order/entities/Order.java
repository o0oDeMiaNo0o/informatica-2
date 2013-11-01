package uy.edu.um.client_service.business.order.entities;

import java.util.ArrayList;
import java.util.Date;

import uy.edu.um.client_service.business.articleOrder.entities.ArticleOrder;
import uy.edu.um.client_service.business.table.entities.Table;
import uy.edu.um.client_service.business.users.entities.User;

public class Order {
	//atributos
	private ArrayList<ArticleOrder> articles = new ArrayList<ArticleOrder>(10);
	private Table table=null;
	private User user=null;
	private String spec;
	private int id,estado;
	private Date time;


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
	
	public Order(ArrayList<ArticleOrder> articles, Table table, User user, String spec, int estado, Date d){
		this.articles = articles;
		this.table = table;
		this.user = user;
		this.spec = spec;
		this.estado=estado;
		this.time=d;
	}
	
	public Order(int id,ArrayList<ArticleOrder> articles, Table table, User user, int e, Date d){
		this.id=id;
		this.articles = articles;
		this.table = table;
		this.user = user;
		this.estado=e;
		this.time=d;
	}
	
	
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Order(ArrayList<ArticleOrder> articles, Table table, User user, String spec, int e){
		this.articles = articles;
		this.table = table;
		this.user = user;
		this.spec = spec;
		this.estado=e;
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
	

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

}
