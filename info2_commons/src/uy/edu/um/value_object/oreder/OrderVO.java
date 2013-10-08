package uy.edu.um.value_object.oreder;

import java.io.Serializable;
import java.util.ArrayList;

import uy.edu.um.value_object.article.ArticleVO;
import uy.edu.um.value_object.articleOrder.ArticleOrderVO;
import uy.edu.um.value_object.people.client.ClientVO;

public class OrderVO implements Serializable{

	ArrayList<ArticleOrderVO> articulos = new ArrayList<ArticleOrderVO>(10);
	ClientVO c = null;
	String descripcion;

	public OrderVO(ArrayList<ArticleOrderVO> articulos, ClientVO c, String descripcion){
		this.articulos = articulos;
		this.c = c;
		this.descripcion = descripcion;
	}

	public ArrayList<ArticleOrderVO> getArticulos() {
		return articulos;
	}
	public void setArticulos(ArrayList<ArticleOrderVO> articulos) {
		this.articulos = articulos;
	}
	public ClientVO getC() {
		return c;
	}
	public void setC(ClientVO c) {
		this.c = c;
	}


}
