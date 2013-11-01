package uy.edu.um.client_service.service.articleRemote.manager;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import uy.edu.um.client_service.business.BusinessFacade;
import uy.edu.um.client_service.business.article.entities.Article;
import uy.edu.um.client_service.business.article.interfaces.ArticleMgt;
import uy.edu.um.interfaces.article.ArticleRemoteMgt;
import uy.edu.um.value_object.article.ArticleVO;

public class ArticleRemoteMgr implements ArticleRemoteMgt{

	private static ArticleRemoteMgr instance = null;

	private ArticleRemoteMgr(){};

	public static ArticleRemoteMgr getInstance(){
		if(instance == null){
			instance = new ArticleRemoteMgr();
		}
		return instance;
	}

	@Override
	public void addArticle(ArticleVO a) throws RemoteException {
		//obtener instacia del manager con singleton
		ArticleMgt aMgr = BusinessFacade.getInstance().getArticleMgt();
		Article article = aMgr.getArticle(a);
		aMgr.addArticle(article);
	}

	@Override
	public ArticleVO searchArticle(int numProducto) throws RemoteException {
		ArticleMgt oMgt = BusinessFacade.getInstance().getArticleMgt();
		ArticleVO toReturn = oMgt.consultArticle(numProducto);
		return toReturn;
	}

	@Override
	public void removeArticle(ArticleVO a) throws RemoteException {
		ArticleMgt aMgt = BusinessFacade.getInstance().getArticleMgt();
		Article article = aMgt.getArticle(a);
		aMgt.removeArticle(article);

	}

	@Override
	public ArrayList<ArticleVO> getArticlesVO() throws RemoteException {
		ArticleMgt aMgt = BusinessFacade.getInstance().getArticleMgt();
		return aMgt.allArticles();
	}

	@Override
	public void editArtile(ArticleVO a) throws RemoteException {
		ArticleMgt aMgt = BusinessFacade.getInstance().getArticleMgt();
		Article article = aMgt.getArticle(a);
		aMgt.editArticle(article);
	}

	@Override
	public void descontinuarArticle(ArticleVO a) throws RemoteException {
		ArticleMgt aMgt = BusinessFacade.getInstance().getArticleMgt();
		Article article = aMgt.getArticle(a);
		aMgt.descontinuarArticle(article);

	}

}


