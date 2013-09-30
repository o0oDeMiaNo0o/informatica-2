package uy.edu.um.client_service.business;

import uy.edu.um.client_service.business.article.interfaces.ArticleMgt;
import uy.edu.um.client_service.business.article.managers.ArticleMgr;
import uy.edu.um.client_service.business.categories.interfaces.CategoryMgt;
import uy.edu.um.client_service.business.categories.managers.CategoryMgr;
import uy.edu.um.client_service.business.clients.interfaces.ClientMgt;
import uy.edu.um.client_service.business.clients.managers.ClientMgr;
import uy.edu.um.client_service.business.order.interfaces.OrderMgt;
import uy.edu.um.client_service.business.order.managers.OrderMgr;
import uy.edu.um.client_service.service.articleRemote.manager.ArticleRemoteMgr;
import uy.edu.um.client_service.service.categoriesRemote.manager.CategoryRemoteMgr;
import uy.edu.um.interfaces.article.ArticleRemoteMgt;
import uy.edu.um.interfaces.categories.CategoryRemoteMgt;
import uy.edu.um.interfaces.clients.ClientRemoteMgt;
import uy.edu.um.interfaces.oreder.OrderRemoteMgt;
import uy.edu.um.client_service.service.clientRemote.manager.*;
import uy.edu.um.client_service.service.orderRemote.OrderRemoteMgr;

/**
 *
 * @author Bernardo Forrisi
 *
 *	Esta clase reconoce todas las interfaces de la capa de negocio para instanciarlas y poder
 *	aislar la capa de servicio de la de negocio
 */



public class BusinessFacade {
	private static BusinessFacade instance = null;

	private BusinessFacade(){};

	public static BusinessFacade getInstance(){
		if (instance == null){
			instance = new BusinessFacade();
		}
		return instance;
	}

	public ArticleMgt getArticleMgt(){
		return ArticleMgr.getInstance();
	}

	public CategoryMgt getCategoryMgt(){
		return CategoryMgr.getInstance();
	}

	public ClientMgt getClientMgt(){
		return ClientMgr.getInstance();
	}

	public OrderMgt getOrderMgt(){
		return OrderMgr.getInstance();
	}

	public ClientRemoteMgt getClientRemote(){
		return ClientRemoteMgr.getInstance();
	}

	public ArticleRemoteMgt getArticleRemote(){
		return ArticleRemoteMgr.getInstance();
	}

	public CategoryRemoteMgt getCategoryRemote(){
		return CategoryRemoteMgr.getInstance();
	}

	public OrderRemoteMgt getOrderRemote(){
		return OrderRemoteMgr.getInstance();
	}
}
