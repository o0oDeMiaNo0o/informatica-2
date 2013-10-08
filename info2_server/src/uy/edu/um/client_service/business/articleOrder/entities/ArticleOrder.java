package uy.edu.um.client_service.business.articleOrder.entities;

import uy.edu.um.client_service.business.article.entities.Article;

public class ArticleOrder {

	private Article article;
	private int cantidad;

	public ArticleOrder(Article article, int cantidad){
		this.article = article;
		this.cantidad = cantidad;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}



}
