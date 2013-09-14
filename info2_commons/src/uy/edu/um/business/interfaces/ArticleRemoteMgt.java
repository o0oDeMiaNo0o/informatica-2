package uy.edu.um.business.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ArticleRemoteMgt extends Remote{

	public void addArticle(int id, String nombre, int precio) throws RemoteException;

	public void removeArticle(int id,String nombre, int precio) throws RemoteException;

	public void editArticle(int id,String nombre, int precio) throws RemoteException;

	public void showArticle(int id, String nombre, int precio) throws RemoteException;
}
