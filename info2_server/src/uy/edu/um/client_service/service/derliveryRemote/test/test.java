package uy.edu.um.client_service.service.derliveryRemote.test;

import java.util.ArrayList;

import uy.edu.um.client_service.business.BusinessFacade;
import uy.edu.um.client_service.business.article.interfaces.ArticleMgt;
import uy.edu.um.client_service.business.bill.interfaces.BillMgt;
import uy.edu.um.client_service.business.delivery.entities.Delivery;
import uy.edu.um.client_service.business.delivery.interfaces.DeliveryMgt;
import uy.edu.um.client_service.business.people.clients.interfaces.ClientMgt;
import uy.edu.um.client_service.business.table.interfaces.TableMgt;
import uy.edu.um.client_service.business.users.interfaces.UserMgt;
import uy.edu.um.exceptions.checks.NoDatabaseConnection;
import uy.edu.um.value_object.article.ArticleVO;
import uy.edu.um.value_object.articleOrder.ArticleOrderVO;
import uy.edu.um.value_object.delivery.DeliveryVO;
import uy.edu.um.value_object.people.client.ClientVO;
import uy.edu.um.value_object.table.TableVO;
import uy.edu.um.value_object.user.UserVO;

public class test {
	public static void main(String[] args) throws NoDatabaseConnection{
		ArticleMgt amgt = BusinessFacade.getInstance().getArticleMgt();
		TableMgt tmgt = BusinessFacade.getInstance().getTableMgt();
		ClientMgt cmgt = BusinessFacade.getInstance().getClientMgt();
		UserMgt umgt = BusinessFacade.getInstance().getUserMgt();
		BillMgt bmgt = BusinessFacade.getInstance().getBillMgt();

		ArrayList<ClientVO> clients = new ArrayList<ClientVO>(2);
		ArrayList<TableVO> tables = new ArrayList<TableVO>(2);
		ArrayList<UserVO> users = new ArrayList<UserVO>(2);
		ArrayList<ArticleVO> articles = new ArrayList<ArticleVO>(2);
		ArrayList<ArticleOrderVO> articlesOrder = new ArrayList<ArticleOrderVO>(2);

		tables = tmgt.allTables();
		users = umgt.allUsers();
		articles=amgt.allArticles();
		clients = cmgt.allClients();
		ArticleVO ej = articles.get(1);
		ArticleOrderVO ao = new ArticleOrderVO(ej,1);
		articlesOrder.add(ao);

		DeliveryVO toAdd = new DeliveryVO(articlesOrder,null,users.get(0),"",0,false);
		DeliveryMgt dMgt = BusinessFacade.getInstance().getDeliveryMgt();
		Delivery temp = dMgt.getDelivery(toAdd);
		dMgt.addDelivery(temp);
	}
}
