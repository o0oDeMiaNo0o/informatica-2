package uy.edu.um.client_service.business;

import uy.edu.um.client_service.business.article.interfaces.ArticleMgt;
import uy.edu.um.client_service.business.article.managers.ArticleMgr;

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



	public ArticleMgt getArticleMgt(){
		return ArticleMgr.getInstance();
	}
}
