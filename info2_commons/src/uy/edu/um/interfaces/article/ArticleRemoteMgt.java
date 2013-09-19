package uy.edu.um.interfaces.article;

import java.rmi.Remote;
import java.rmi.RemoteException;

import uy.edu.um.value_object.article.ArticleVO;

public interface ArticleRemoteMgt extends Remote{

	public void addArticle(ArticleVO a) throws RemoteException;

}
