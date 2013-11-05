package uy.edu.um.value_object.bill;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;

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


	public BillVO(ArrayList<OrderVO> orders, ClientVO client, TableVO t){
		this.orders = orders;
		this.client = client;
		this.montoTotal = this.getTotal();
	}

	public BillVO(int id, ArrayList<OrderVO> orders, ClientVO client, TableVO t){
		this.id = id;
		this.orders = orders;
		this.client = client;
		this.montoTotal = this.getTotal();
	}

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



}
