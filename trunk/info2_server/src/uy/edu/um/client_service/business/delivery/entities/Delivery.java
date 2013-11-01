package uy.edu.um.client_service.business.delivery.entities;

import java.util.ArrayList;
import java.util.Date;

import uy.edu.um.client_service.business.articleOrder.entities.ArticleOrder;
import uy.edu.um.client_service.business.users.entities.User;

public class Delivery {

	private ArrayList<ArticleOrder> articles = new ArrayList<ArticleOrder>(10);
	private String specs;
	private int estado,id;
	private Date time;
	private User user;
	private boolean enCocina;
	


	public Delivery (ArrayList<ArticleOrder> articulos, User user, Date time, String specs, int estado, boolean enCocina){
		this.articles = articulos;
		this.user = user;
		this.time = time;
		this.specs = specs;
		this.estado = estado;
		this.enCocina = enCocina;
	}
	
	public Delivery (int id,ArrayList<ArticleOrder> articulos, User user, Date time, String specs, int estado, boolean enCocina){
		this.id=id;
		this.articles = articulos;
		this.user = user;
		this.time = time;
		this.specs = specs;
		this.estado = estado;
		this.enCocina = enCocina;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<ArticleOrder> getArticles() {
		return articles;
	}

	public void setArticles(ArrayList<ArticleOrder> articulos) {
		this.articles = articulos;
	}

	public String getSpecs() {
		return specs;
	}

	public void setSpecs(String specs) {
		this.specs = specs;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isEnCocina() {
		return enCocina;
	}

	public void setEnCocina(boolean enCocina) {
		this.enCocina = enCocina;
	}
}

