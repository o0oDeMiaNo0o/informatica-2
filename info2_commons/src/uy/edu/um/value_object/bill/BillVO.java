package uy.edu.um.value_object.bill;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import uy.edu.um.value_object.article.ArticleVO;
import uy.edu.um.value_object.articleOrder.ArticleOrderVO;
import uy.edu.um.value_object.oreder.OrderVO;
import uy.edu.um.value_object.people.client.ClientVO;
import uy.edu.um.value_object.table.TableVO;

public class BillVO implements Serializable{

	private ArrayList<OrderVO> orders = new ArrayList<OrderVO>(10);
	private ClientVO client;
	private TableVO table;
	private int id;
	private BigDecimal montoTotal;
	private Date date;

	public BillVO(ArrayList<OrderVO> orders, ClientVO client, TableVO t,BigDecimal montoTotal,Date date){
		this.orders = orders;
		this.client = client;
		this.montoTotal = montoTotal;
		this.date = date;
	}

	public BillVO(ArrayList<OrderVO> orders, ClientVO client, TableVO t,BigDecimal montoTotal){
		this.orders = orders;
		this.client = client;
		this.table = t;
		this.montoTotal = montoTotal;
	}

//	public BillVO(ArrayList<OrderVO> orders, ClientVO client, TableVO t,Date date){
//		this.orders = orders;
//		this.client = client;
//		this.montoTotal = this.getTotal();
//		this.date = date;
//	}
//
//	public BillVO(ArrayList<OrderVO> orders, ClientVO client, TableVO t){
//		this.orders = orders;
//		this.client = client;
//		this.table = t;
//		this.montoTotal = this.getTotal();
//	}
//
//	public BillVO(int id, ArrayList<OrderVO> orders, ClientVO client, TableVO t,Date date){
//		this.id = id;
//		this.orders = orders;
//		this.client = client;
//		this.montoTotal = this.getTotal();
//		this.date = date;
//	}
//
//	public BillVO(int id, ArrayList<OrderVO> orders, ClientVO client, TableVO t, BigDecimal montoTotal,Date date){
//		this.id = id;
//		this.orders = orders;
//		this.client = client;
//		this.montoTotal = montoTotal;
//		this.date = date;
//	}

	public ArrayList<OrderVO> getOrders() {
		return orders;
	}
	public void setOrders(ArrayList<OrderVO> orders) {
		this.orders = orders;
	}

	public ClientVO getClient() {
		return client;
	}

	public void setClient(ClientVO client) {
		this.client = client;
	}

//	public BigDecimal getTotal(){
//		BigDecimal total = new BigDecimal(0);
//		for(OrderVO current : orders){
//			ArrayList<ArticleOrderVO> articles = current.getArticulos();
//			for(ArticleOrderVO a : articles){
//				ArticleVO currentArticle = a.getArticle();
//				BigDecimal currentPrice = currentArticle.getPrecio();
//				BigDecimal cantidad = new BigDecimal(a.getCantidad());
//				BigDecimal aux = currentPrice.multiply(cantidad);
//				total = currentPrice.add(aux);
//			}
//		}
//		return total;
//	}

	public TableVO getTable() {
		return table;
	}

	public void setTable(TableVO table) {
		this.table = table;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(BigDecimal montoTotal) {
		this.montoTotal = montoTotal;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
