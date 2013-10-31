package uy.edu.um.services.order.tests;

import java.util.ArrayList;

import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.article.interfaces.ArticleMgt;
import uy.edu.um.services.articleOrder.interfaces.ArticleOrderMgt;
import uy.edu.um.services.order.interfaces.OrderMgt;
import uy.edu.um.services.table.interfaces.TableMgt;
import uy.edu.um.value_object.article.ArticleVO;
import uy.edu.um.value_object.articleOrder.ArticleOrderVO;
import uy.edu.um.value_object.oreder.OrderVO;
import uy.edu.um.value_object.table.TableVO;
import uy.edu.um.value_object.user.UserVO;

public class Test1 {
	public static void main(String[] args){
		//managers
		ArticleMgt aMgt = ServiceFacade.getInstance().getArticleMgt();
		ArticleOrderMgt oMgt = ServiceFacade.getInstance().getArticleOrderMgt();
		TableMgt tMgt = ServiceFacade.getInstance().getTableMgt();
		OrderMgt orderMgt = ServiceFacade.getInstance().getOrderMgt();

		UserVO user = new UserVO("pepe","pepe",true);
		ArrayList<TableVO> allTables = new ArrayList<TableVO>(10);
		ArrayList<ArticleVO> allArticles = new ArrayList<ArticleVO>(10);
		allArticles = aMgt.allArticles();
		allTables = tMgt.allTables();
		ArticleVO a1 = allArticles.get(0);
		ArticleVO a2 = allArticles.get(1);
		ArticleOrderVO ao1 = oMgt.createArticleOrderVO(a1, 3);
		ArticleOrderVO ao2 = oMgt.createArticleOrderVO(a2, 4);
		ArrayList<ArticleOrderVO> toAdd = new ArrayList<ArticleOrderVO>(2);
		toAdd.add(ao1); toAdd.add(ao2);
		TableVO t1 = allTables.get(0);
		String specs = "jajajajajjaa";
		OrderVO toSend = orderMgt.createOrderVO(toAdd, t1, user, specs,1);
		orderMgt.addOrder(toSend);


	}
}
