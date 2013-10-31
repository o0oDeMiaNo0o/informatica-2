package uy.edu.um.client_service.service.orderRemote.test;

import java.util.ArrayList;

import uy.edu.um.client_service.business.BusinessFacade;
import uy.edu.um.client_service.business.article.interfaces.ArticleMgt;
import uy.edu.um.client_service.business.articleOrder.interfaces.ArticleOrderMgt;
import uy.edu.um.client_service.business.order.entities.Order;
import uy.edu.um.client_service.business.order.interfaces.OrderMgt;
import uy.edu.um.client_service.business.table.interfaces.TableMgt;
import uy.edu.um.value_object.article.ArticleVO;
import uy.edu.um.value_object.articleOrder.ArticleOrderVO;
import uy.edu.um.value_object.oreder.OrderVO;
import uy.edu.um.value_object.table.TableVO;
import uy.edu.um.value_object.user.UserVO;

public class test2 {
	public static void main(String[] args){
		//managers
		ArticleMgt aMgt = BusinessFacade.getInstance().getArticleMgt();
		TableMgt tMgt = BusinessFacade.getInstance().getTableMgt();
		OrderMgt orderMgt = BusinessFacade.getInstance().getOrderMgt();

		UserVO user = new UserVO("pepe","pepe",true);
		ArrayList<TableVO> allTables = new ArrayList<TableVO>(10);
		ArrayList<ArticleVO> allArticles = new ArrayList<ArticleVO>(10);
		allArticles = aMgt.allArticles();
		allTables = tMgt.allTables();
		ArticleVO a1 = allArticles.get(0);
		ArticleVO a2 = allArticles.get(1);
		ArticleOrderVO ao1 = new ArticleOrderVO(a1, 3);
		ArticleOrderVO ao2 = new ArticleOrderVO(a2, 4);
		ArrayList<ArticleOrderVO> toAdd = new ArrayList<ArticleOrderVO>(2);
		toAdd.add(ao1); toAdd.add(ao2);
		TableVO t1 = allTables.get(0);
		OrderVO toSend = new OrderVO(toAdd, t1, user, null,9);
		Order finale = orderMgt.getOrder(toSend);
		orderMgt.addOrder(finale);
	}
}

