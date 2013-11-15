package uy.edu.um.services.delivery.test;

import java.util.ArrayList;

import uy.edu.um.exceptions.checks.NoDatabaseConnection;
import uy.edu.um.exceptions.checks.NoServerConnectionException;
import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.article.interfaces.ArticleMgt;
import uy.edu.um.services.delivery.interfaces.DeliveryMgt;
import uy.edu.um.services.people.clients.interfaces.ClientMgt;
import uy.edu.um.services.table.interfaces.TableMgt;
import uy.edu.um.services.user.interfaces.UserMgt;
import uy.edu.um.value_object.article.ArticleVO;
import uy.edu.um.value_object.articleOrder.ArticleOrderVO;
import uy.edu.um.value_object.delivery.DeliveryVO;
import uy.edu.um.value_object.people.client.ClientVO;
import uy.edu.um.value_object.table.TableVO;
import uy.edu.um.value_object.user.UserVO;

public class test {
	public static void main(String[] args) throws NoDatabaseConnection, NoServerConnectionException{
		ArticleMgt amgt = ServiceFacade.getInstance().getArticleMgt();
		TableMgt tmgt = ServiceFacade.getInstance().getTableMgt();
		ClientMgt cmgt = ServiceFacade.getInstance().getClientMgt();
		UserMgt umgt = ServiceFacade.getInstance().getUserMgt();
		DeliveryMgt dmgt = ServiceFacade.getInstance().getDeliveryMgt();

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
		dmgt.addDelivery(toAdd);
	}
}
