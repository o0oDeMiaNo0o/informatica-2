package uy.edu.um.client_service.business.articleOrder.managers;

import uy.edu.um.client_service.business.articleOrder.entities.ArticleOrder;
import uy.edu.um.client_service.business.articleOrder.interfaces.ArticleOrderMgt;
import uy.edu.um.value_object.articleOrder.ArticleOrderVO;

public class ArticleOrderMgr implements ArticleOrderMgt{

	private static ArticleOrderMgr instance = null;

	private ArticleOrderMgr(){}

	public static ArticleOrderMgr getInstance(){
		if(instance == null){
			instance = new ArticleOrderMgr();
		}
		return instance;
	}

	@Override
	public ArticleOrder getArticleOrder(ArticleOrderVO ao) {
		// TODO Auto-generated method stub
		return null;
	}

}
