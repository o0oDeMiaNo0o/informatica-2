package uy.edu.um.services;

import uy.edu.um.interfaces.article.ArticleRemoteMgt;
import uy.edu.um.services.article.interfaces.ArticleMgt;
import uy.edu.um.services.article.managers.ArticleMgr;

public class ServiceFacade {
	//instancia para implementar la instancia de Singleton
	private static ServiceFacade instance = new ServiceFacade();
	//constructor privado para instanciarlo solo en la clase
	private ServiceFacade(){

	}

	public static ServiceFacade getInstance(){
		if(instance == null){
			instance = new ServiceFacade();
		}
		return instance;
	}

	public ArticleMgt getArticleMgt(){
		return ArticleMgr.getInstance();
	}

	public ArticleRemoteMgt getArticleRemoteMgt(){
		return null;

	}
}
