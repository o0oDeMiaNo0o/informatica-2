package uy.edu.um.interfaces.articleOrder;

import java.rmi.Remote;
import java.rmi.RemoteException;

import uy.edu.um.value_object.articleOrder.ArticleOrderVO;

public interface ArticleOrderRemoteMgt extends Remote{

	public void addArticleOrder(ArticleOrderVO ao) throws RemoteException;

}
