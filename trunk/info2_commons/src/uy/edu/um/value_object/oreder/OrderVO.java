package uy.edu.um.value_object.oreder;

import java.io.Serializable;
import java.util.ArrayList;

import uy.edu.um.value_object.articleOrder.ArticleOrderVO;
import uy.edu.um.value_object.table.TableVO;

public class OrderVO implements Serializable{

	private ArrayList<ArticleOrderVO> articulos = new ArrayList<ArticleOrderVO>(10);
	private TableVO table;

	public OrderVO(ArrayList<ArticleOrderVO> articulos, TableVO table){
		this.articulos = articulos;
		this.table = table;
	}

	public ArrayList<ArticleOrderVO> getArticulos() {
		return articulos;
	}
	public void setArticulos(ArrayList<ArticleOrderVO> articulos) {
		this.articulos = articulos;
	}

	public TableVO getTable() {
		return table;
	}

	public void setTable(TableVO table) {
		this.table = table;
	}

}
