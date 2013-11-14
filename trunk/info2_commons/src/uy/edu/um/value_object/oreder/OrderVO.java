package uy.edu.um.value_object.oreder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import uy.edu.um.value_object.articleOrder.ArticleOrderVO;
import uy.edu.um.value_object.table.TableVO;
import uy.edu.um.value_object.user.UserVO;

public class OrderVO implements Serializable{

	private int id;
	private ArrayList<ArticleOrderVO> articulos = new ArrayList<ArticleOrderVO>(10);
	private TableVO table;
	private UserVO user;
	private String especificaciones;
	private int estado;
	private Date time;

	public OrderVO(ArrayList<ArticleOrderVO> articulos, TableVO table, UserVO u, String spec,int estado){
		this.articulos = articulos;
		this.table = table;
		this.user = u;
		this.especificaciones = spec;
		this.estado = estado;
	}

	public OrderVO(int id,ArrayList<ArticleOrderVO> articulos, TableVO table, UserVO u, String spec,int estado){
		this.articulos = articulos;
		this.table = table;
		this.user = u;
		this.especificaciones = spec;
		this.estado = estado;
		this.id = id;
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

	public UserVO getUser() {
		return user;
	}

	public void setUser(UserVO user) {
		this.user = user;
	}

	public String getEspecificaciones() {
		return especificaciones;
	}

	public void setEspecificaciones(String especificaciones) {
		this.especificaciones = especificaciones;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



}
