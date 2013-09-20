package uy.edu.um.services.article.managers;

import java.rmi.RemoteException;

import uy.edu.um.interfaces.article.ArticleRemoteMgt;
import uy.edu.um.services.article.interfaces.ArticleMgt;
import uy.edu.um.value_object.article.ArticleVO;
import uy.edu.um.services.*;

public class ArticleMgr implements ArticleMgt{
	//respeta patron singleton
	private static ArticleMgr instance = new ArticleMgr();
	//constructor privado para que lo inicialize esta clase
	private ArticleMgr(){

	}
	//
	public static ArticleMgr getInstance(){
		if (instance == null){
			instance = new ArticleMgr();
		}
		return instance;
	}

	@Override
	public ArticleVO createArticleVO(String nombre, int precio) {
		ArticleVO aReturn = new ArticleVO(nombre,precio);
		return aReturn;
	}
	@Override

	public void sendArticleVO(ArticleVO article) {
		ArticleRemoteMgt aMgr = ServiceFacade.getInstance().getArticleRemoteMgt();
		try {
			aMgr.addArticle(article);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
