package uy.edu.um.client_service.service.articleOrderRemote.managers;

import java.rmi.RemoteException;

import uy.edu.um.interfaces.articleOrder.ArticleOrderRemoteMgt;
import uy.edu.um.value_object.articleOrder.ArticleOrderVO;

public class ArticleOrderRemoteMgr implements ArticleOrderRemoteMgt{

	private static ArticleOrderRemoteMgr instance = null;

	private ArticleOrderRemoteMgr(){}

	public static ArticleOrderRemoteMgr getInstance(){
		if(instance == null){
			instance = new ArticleOrderRemoteMgr();
		}
		return instance;
	}

	@Override
	public void addArticleOrder(ArticleOrderVO ao) throws RemoteException {
		// TODO Auto-generated method stub

	}

}
