package uy.edu.um.client_service.business.delivery.entities;

import java.util.ArrayList;
import java.util.Date;

import uy.edu.um.client_service.business.articleOrder.entities.ArticleOrder;
import uy.edu.um.client_service.business.users.entities.User;

public class Delivery {

	private ArrayList<ArticleOrder> articulos = new ArrayList<ArticleOrder>(10);
	private String specs;
	private int estado;
	private Date time;
	private User user;
	private boolean enCocina;

	public Delivery (ArrayList<ArticleOrder> articulos, User user, Date time, String specs, int estado, boolean enCocina){
		this.articulos = articulos;
		this.user = user;
		this.time = time;
		this.specs = specs;
		this.estado = estado;
		this.enCocina = enCocina;
	}
}

