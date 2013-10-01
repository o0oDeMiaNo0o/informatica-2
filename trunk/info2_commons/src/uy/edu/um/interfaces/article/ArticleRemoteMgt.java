package uy.edu.um.interfaces.article;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import uy.edu.um.value_object.article.ArticleVO;

public interface ArticleRemoteMgt extends Remote{

	public void addArticle(ArticleVO a) throws RemoteException;

	public ArticleVO searchArticle(int numProducto) throws RemoteException;

	public void removeArticle(ArticleVO a) throws RemoteException;

	public ArrayList<ArticleVO> getArticlesVO() throws RemoteException;


}
