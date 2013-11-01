package uy.edu.um.value_object.delivery;

import java.util.ArrayList;
import java.util.Date;

import uy.edu.um.value_object.articleOrder.ArticleOrderVO;
import uy.edu.um.value_object.user.UserVO;


public class DeliveryVO {

	private ArrayList<ArticleOrderVO> articulos = new ArrayList<ArticleOrderVO>(10);
	private String specs;
	private int estado;
	private Date time;
	private UserVO user;
	private boolean enCocina;

	public DeliveryVO(ArrayList<ArticleOrderVO> articulos, Date time, UserVO user, String specs, int estado,
			boolean enCocina){
		this.articulos = articulos;
		this.time = time;
		this.user = user;
		this.specs = specs;
		this.estado = estado;
		this.enCocina = enCocina;
	}


	public ArrayList<ArticleOrderVO> getArticulos() {
		return articulos;
	}
	public void setArticulos(ArrayList<ArticleOrderVO> articulos) {
		this.articulos = articulos;
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
	public UserVO getUser() {
		return user;
	}
	public void setUser(UserVO user) {
		this.user = user;
	}

	public boolean isEnCocina() {
		return enCocina;
	}

	public void setEnCocina(boolean enCocina) {
		this.enCocina = enCocina;
	}



}
