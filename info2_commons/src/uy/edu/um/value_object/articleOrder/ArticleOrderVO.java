package uy.edu.um.value_object.articleOrder;

import java.io.Serializable;

import uy.edu.um.value_object.article.ArticleVO;

public class ArticleOrderVO implements Serializable {

	private ArticleVO article;
	private String especificaciones;
	private int cantidad;

	public ArticleOrderVO(ArticleVO article, int cantidad,
			String especificaciones) {
		this.article = article;
		this.cantidad = cantidad;
		this.especificaciones = especificaciones;
	}

	public ArticleVO getArticle() {
		return article;
	}

	public void setArticle(ArticleVO article) {
		this.article = article;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getEspecificaciones() {
		return especificaciones;
	}

	public void setEspecificaciones(String especificaciones) {
		this.especificaciones = especificaciones;
	}

}
