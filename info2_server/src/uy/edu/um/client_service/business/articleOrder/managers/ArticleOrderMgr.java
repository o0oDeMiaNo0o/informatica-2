package uy.edu.um.client_service.business.articleOrder.managers;

import uy.edu.um.client_service.business.BusinessFacade;
import uy.edu.um.client_service.business.article.entities.Article;
import uy.edu.um.client_service.business.article.interfaces.ArticleMgt;
import uy.edu.um.client_service.business.articleOrder.entities.ArticleOrder;
import uy.edu.um.client_service.business.articleOrder.interfaces.ArticleOrderMgt;
import uy.edu.um.value_object.article.ArticleVO;
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
		ArticleMgt aMgt = BusinessFacade.getInstance().getArticleMgt();
		Article a = aMgt.getArticle(ao.getArticle());
		ArticleOrder toReturn = new ArticleOrder(a,ao.getCantidad());
		return toReturn;
	}

	public ArticleOrderVO transition(ArticleVO a, int cantidad){
		ArticleOrderVO toReturn = new ArticleOrderVO(a,cantidad);
		return toReturn;
	}

}
