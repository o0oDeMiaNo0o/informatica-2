package uy.edu.um.client_service.communications.clients.managers.articles;

import java.rmi.RemoteException;

import uy.edu.um.business.interfaces.articles.ArticleRemoteMgt;
import uy.edu.um.client_service.persistance.articles.ArticleDAO;

public class ArticleRemoteService implements ArticleRemoteMgt{

	public void showArticle(int id, String nombre, int precio){
		System.out.println(id+" "+nombre+" "+precio);
	}

	@Override
	public void addArticle(int id, String nombre, int precio) throws RemoteException {

	}

	@Override
	public void editArticle(int id, String nombre, int precio)
			throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeArticle(int id, String nombre, int precio) throws RemoteException {
		// TODO Auto-generated method stub

	}

}
