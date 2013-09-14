package uy.edu.um.client_service.communications.clients.managers;

import java.rmi.RemoteException;

import uy.edu.um.business.interfaces.ArticleRemoteMgt;

public class ArticleRemoteService implements ArticleRemoteMgt{

	public void showArticle(int id, String nombre, int precio){
		System.out.println("id : "+id+", nombre : "+nombre+", precio : "+precio);
	}

	@Override
	public void addArticle(int id, String nombre, int precio) throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public void editArticle(int id, String nombre, int precio)
			throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeArticle(int id, String nombre, int precio)
			throws RemoteException {
		// TODO Auto-generated method stub

	}

}
