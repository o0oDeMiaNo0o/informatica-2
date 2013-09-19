package uy.edu.um.client_service.service.articleRemote.manager;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import uy.edu.um.client_service.business.BusinessFacade;
import uy.edu.um.client_service.business.article.entities.Article;
import uy.edu.um.client_service.business.article.interfaces.ArticleMgt;
import uy.edu.um.interfaces.article.ArticleRemoteMgt;
import uy.edu.um.value_object.article.ArticleVO;

public class ArticleRemoteMgr implements ArticleRemoteMgt{

	@Override
	public void addArticle(ArticleVO a) throws RemoteException {
		//obtener instacia del manager con singleton
		ArticleMgt aMgr = BusinessFacade.getInstance().getArticleMgt();
		Article article = aMgr.getArticle(a);
		aMgr.addArticle(article);
	}

	public static void setServerConnection(){
		try {
			String name = "ArticleRemoteMgr";

			ArticleRemoteMgr oArticleRemoteMgr = new ArticleRemoteMgr();

			ArticleRemoteMgt oStub = (ArticleRemoteMgt) UnicastRemoteObject
					.exportObject(oArticleRemoteMgr, 0);

			Registry oRegistry = LocateRegistry.createRegistry(1099);

			oRegistry.rebind(name, oStub);

			System.out.println("Ready and waiting");
		} catch (Exception e) {
			System.err.println("error:");
			e.printStackTrace();
		}
	}
}


