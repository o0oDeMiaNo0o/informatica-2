package uy.edu.um.client_service.business.article.test;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import uy.edu.um.client_service.business.BusinessFacade;
import uy.edu.um.client_service.business.article.interfaces.ArticleMgt;
import uy.edu.um.client_service.business.article.managers.ArticleMgr;
import uy.edu.um.client_service.service.articleRemote.manager.ArticleRemoteMgr;
import uy.edu.um.interfaces.article.ArticleRemoteMgt;

public class MainArticleServer {
	public static void main(String[] args) {
		try {
			String name = "ArticleRemoteMgr";

			ArticleRemoteMgt oArticleRemoteMgr = BusinessFacade.getInstance().getArticleRemote();

			ArticleRemoteMgt oStub = (ArticleRemoteMgt) UnicastRemoteObject
					.exportObject((Remote) oArticleRemoteMgr, 0);

			Registry oRegistry = LocateRegistry.createRegistry(1099);

			oRegistry.rebind(name, oStub);

			System.out.println("Ready and waiting");
		} catch (Exception e) {
			System.err.println("error:");
			e.printStackTrace();
		}
	}
}
