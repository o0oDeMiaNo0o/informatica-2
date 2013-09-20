package uy.edu.um.client_service.business;

import uy.edu.um.client_service.service.articleRemote.manager.*;
import uy.edu.um.client_service.business.article.interfaces.ArticleMgt;
import uy.edu.um.client_service.business.article.managers.ArticleMgr;
import uy.edu.um.client_service.business.categories.interfaces.CategoryMgt;
import uy.edu.um.client_service.business.categories.managers.CategoryMgr;
import uy.edu.um.interfaces.article.ArticleRemoteMgt;


/**
 *
 * @author Bernardo Forrisi
 *
 *	Esta clase reconoce todas las interfaces de la capa de negocio para instanciarlas y poder
 *	aislar la capa de servicio de la de negocio
 */



public class BusinessFacade {
	private static BusinessFacade instance = new BusinessFacade();

	private BusinessFacade(){};

	public static BusinessFacade getInstance(){
		if (instance == null){
			instance = new BusinessFacade();
		}
		return instance;
	}

//	public ArticleMgt getArticleMgt2(){
//		return ArticleMgr.getInstance();
//	}

	public ArticleMgt getArticleMgt(){
		return ArticleMgr.getInstance();
	}

	public CategoryMgt getCategoryMgt(){
		return CategoryMgr.getInstance();
	}

	public ArticleRemoteMgt getArticleRemote(){
		return ArticleRemoteMgr.getInstance();
	}
}
