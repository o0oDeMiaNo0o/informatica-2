package uy.edu.um.value_object.oreder;

import java.io.Serializable;
import java.util.ArrayList;

import uy.edu.um.value_object.article.ArticleVO;
import uy.edu.um.value_object.client.ClientVO;

public class OrderVO implements Serializable{

	ArrayList<ArticleVO> articulos = new ArrayList<ArticleVO>(10);
	ClientVO c = null;

	public OrderVO(ArrayList<ArticleVO> articulos, ClientVO c){
		this.articulos = articulos;
		this.c = c;
	}

	public ArrayList<ArticleVO> getArticulos() {
		return articulos;
	}
	public void setArticulos(ArrayList<ArticleVO> articulos) {
		this.articulos = articulos;
	}
	public ClientVO getC() {
		return c;
	}
	public void setC(ClientVO c) {
		this.c = c;
	}


}
