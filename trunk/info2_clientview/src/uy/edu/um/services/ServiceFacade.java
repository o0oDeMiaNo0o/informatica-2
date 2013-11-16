package uy.edu.um.services;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import uy.edu.um.services.article.interfaces.ArticleMgt;
import uy.edu.um.services.article.managers.ArticleMgr;
import uy.edu.um.services.articleOrder.interfaces.ArticleOrderMgt;
import uy.edu.um.services.articleOrder.managers.ArticleOrderMgr;
import uy.edu.um.services.bill.interfaces.BillMgt;
import uy.edu.um.services.bill.managers.BillMgr;
import uy.edu.um.services.categories.interfaces.CategoryMgt;
import uy.edu.um.services.categories.managers.CategoryMgr;
import uy.edu.um.services.order.interfaces.OrderMgt;
import uy.edu.um.services.order.managers.OrderMgr;
import uy.edu.um.services.people.clients.interfaces.ClientMgt;
import uy.edu.um.services.people.clients.managers.ClientMgr;
import uy.edu.um.services.table.interfaces.TableMgt;
import uy.edu.um.services.table.managers.TableMgr;
import uy.edu.um.services.user.interfaces.UserMgt;
import uy.edu.um.services.user.managers.UserMgr;

public class ServiceFacade {
	//instancia para implementar la instancia de Singleton
	private static ServiceFacade instance = null;
	//constructor privado para instanciarlo solo en la clase
	private ServiceFacade(){

	}

	public static ServiceFacade getInstance(){
		if(instance == null){
			instance = new ServiceFacade();
		}
		return instance;
	}

	public ArticleMgt getArticleMgt(){
		return ArticleMgr.getInstance();
	}

	public ClientMgt getClientMgt(){
		return ClientMgr.getInstance();
	}

	public UserMgt getUserMgt(){
		return UserMgr.getInstance();
	}

	public OrderMgt getOrderMgt(){
		return OrderMgr.getInstance();
	}

	public BillMgt getBillMgt() {
		return BillMgr.getInstance();
	}

	public CategoryMgt getCategoryMgt(){
		return CategoryMgr.getInstance();
	}

	public ArticleOrderMgt getArticleOrderMgt(){
		return ArticleOrderMgr.getInstance();
	}

	public TableMgt getTableMgt(){
		return TableMgr.getInstance();
	}

	public String getHost() {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("properties"));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return prop.getProperty("host");
	}

	public int getPort() {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("properties"));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return Integer.parseInt(prop.getProperty("port"));
	}
}
