package uy.edu.um.services.articleOrder.managers;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import uy.edu.um.interfaces.article.ArticleRemoteMgt;
import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.article.interfaces.ArticleMgt;
import uy.edu.um.services.articleOrder.interfaces.ArticleOrderMgt;
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
	public ArticleOrderVO createArticleOrderVO(ArticleVO a, int cantidad) {
		return new ArticleOrderVO(a,cantidad);
	}

	@Override
	public void sendArticleOrder(ArticleOrderVO ao) {
		try {

			String sObjectService = "ArticleOrderRemoteMgr";

			Registry oRegitry = LocateRegistry.getRegistry(1099);

			ArticleRemoteMgt oArticleRemoteMgt = (ArticleRemoteMgt) oRegitry
					.lookup(sObjectService);


			ArticleMgt aMgt = ServiceFacade.getInstance().getArticleMgt();

			System.out.println("articulo agregado");

		} catch (Exception e) {
			System.err.println("error:");
			e.printStackTrace();

		}


	}

}
