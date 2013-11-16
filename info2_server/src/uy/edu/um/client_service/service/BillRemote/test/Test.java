package uy.edu.um.client_service.service.BillRemote.test;

import java.util.ArrayList;

import uy.edu.um.client_service.business.BusinessFacade;
import uy.edu.um.client_service.business.article.interfaces.ArticleMgt;
import uy.edu.um.client_service.business.bill.entities.Bill;
import uy.edu.um.client_service.business.bill.interfaces.BillMgt;
import uy.edu.um.client_service.business.people.clients.interfaces.ClientMgt;
import uy.edu.um.client_service.business.table.interfaces.TableMgt;
import uy.edu.um.client_service.business.users.interfaces.UserMgt;
import uy.edu.um.exceptions.checks.NoDatabaseConnection;
import uy.edu.um.value_object.article.ArticleVO;
import uy.edu.um.value_object.articleOrder.ArticleOrderVO;
import uy.edu.um.value_object.bill.BillVO;
import uy.edu.um.value_object.oreder.OrderVO;
import uy.edu.um.value_object.people.client.ClientVO;
import uy.edu.um.value_object.table.TableVO;
import uy.edu.um.value_object.user.UserVO;

public class Test {
	public static void main(String[] args) throws NoDatabaseConnection{
/*		ArticleMgt amgt = BusinessFacade.getInstance().getArticleMgt();
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
		OrderVO alksdj = new OrderVO(articlesOrder,tables.get(0), users.get(0), "", 0);
		ArrayList<OrderVO> toAdd = new ArrayList<OrderVO>(1);
		toAdd.add(alksdj);

		BillVO tBill = new BillVO(toAdd,clients.get(0),tables.get(0));
		Bill addBIll = bmgt.getBill(tBill);
		bmgt.addBill(addBIll);*/
	}
}
