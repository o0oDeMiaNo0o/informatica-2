package uy.edu.um.services.article.managers;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import uy.edu.um.interfaces.article.ArticleRemoteMgt;
import uy.edu.um.services.article.interfaces.ArticleMgt;
import uy.edu.um.value_object.article.ArticleVO;
import uy.edu.um.services.*;

public class ArticleMgr implements ArticleMgt {
	// respeta patron singleton
	private static ArticleMgr instance = new ArticleMgr();

	// constructor privado para que lo inicialize esta clase
	private ArticleMgr() {

	}

	//
	public static ArticleMgr getInstance() {
		if (instance == null) {
			instance = new ArticleMgr();
		}
		return instance;
	}

	@Override
	public ArticleVO createArticleVO(int prodN, String nombre, int precio) {
		ArticleVO aReturn = new ArticleVO(prodN, nombre, precio);
		return aReturn;
	}

	@Override
	public void sendArticleVO(ArticleVO article) {
		ArticleRemoteMgt aMgr = ServiceFacade.getInstance()
				.getArticleRemoteMgt();
		try {
			aMgr.addArticle(article);
			System.out.println("articulo agregado correctamente");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void setCliente(ArticleVO a) {
		try {

			String sObjectService = "ArticleRemoteMgr";

			Registry oRegitry = LocateRegistry.getRegistry(1099);

			ArticleRemoteMgt oArticleRemoteMgt = (ArticleRemoteMgt) oRegitry
					.lookup(sObjectService);


			ArticleMgt aMgt = ServiceFacade.getInstance().getArticleMgt();


			oArticleRemoteMgt.addArticle(a);

			System.out.println("articulo agregado");

		} catch (Exception e) {
			System.err.println("error:");
			e.printStackTrace();

		}

	}

	@Override
	public ArticleVO searchArticle(int numProducto) {
		return null;
	}
}
