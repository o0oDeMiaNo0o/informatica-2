package uy.edu.um.value_object.bill;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;

import uy.edu.um.value_object.article.ArticleVO;
import uy.edu.um.value_object.articleOrder.ArticleOrderVO;
import uy.edu.um.value_object.oreder.OrderVO;
import uy.edu.um.value_object.table.TableVO;

public class BillVO implements Serializable{

	private ArrayList<OrderVO> orders = new ArrayList<OrderVO>(10);
	private BigDecimal costoTotal;
	private TableVO t;

	public BillVO(ArrayList<OrderVO> orders, TableVO t){
		this.orders = orders;
		this.costoTotal = getTotal();
		this.t = t;
	}

	public ArrayList<OrderVO> getOrders() {
		return orders;
	}

	public BigDecimal getCostoTotal() {
		return costoTotal;
	}



	public BigDecimal getTotal(){
		BigDecimal total = new BigDecimal(0);
		for(OrderVO current : orders){
			ArrayList<ArticleOrderVO> articles = current.getArticulos();
			for(ArticleOrderVO a : articles){
				ArticleVO currentArticle = a.getArticle();
				BigDecimal currentPrice = currentArticle.getPrecio();
				total = currentPrice.add(currentPrice);
			}
		}
		return total;
	}

	public TableVO getT() {
		return t;
	}

	public void setT(TableVO t) {
		this.t = t;
	}

	public void setOrders(ArrayList<OrderVO> orders) {
		this.orders = orders;
	}

	public void setCostoTotal(BigDecimal costoTotal) {
		this.costoTotal = costoTotal;
	}
}
