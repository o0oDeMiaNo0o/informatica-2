package uy.edu.um.client_service.service.articleRemote.manager;

import java.rmi.RemoteException;

import uy.edu.um.business.articles.interfaces.article.ArticleRemoteMgt;
import uy.edu.um.business.value_object.article.ArticleVO;
import uy.edu.um.client_service.business.article.entities.Article;


public class ArticleRemoteMgr implements ArticleRemoteMgt{

	@Override
	public void addArticle(ArticleVO a) throws RemoteException {
		Article art = this.getArticle(a);
	}

	@Override
	public void editArticle(ArticleVO a) throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeArticle(ArticleVO a) throws RemoteException {
		// TODO Auto-generated method stub

	}

	public Article getArticle(ArticleVO a){
		String nombre = a.getNombre();
		int precio = a.getPrecio();
		Article aReturn = new Article(nombre, precio);
		return aReturn;
	}


}
