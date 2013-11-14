package uy.edu.um.interfaces.article;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import uy.edu.um.exceptions.checks.NoDatabaseConnection;
import uy.edu.um.value_object.article.ArticleVO;

public interface ArticleRemoteMgt extends Remote{

	public void addArticle(ArticleVO a) throws RemoteException, NoDatabaseConnection;

	public ArticleVO searchArticle(int numProducto) throws RemoteException;

	public void removeArticle(ArticleVO a) throws RemoteException, NoDatabaseConnection;

	public ArrayList<ArticleVO> getArticlesVO() throws RemoteException, NoDatabaseConnection;

	public void editArtile(ArticleVO a) throws RemoteException, NoDatabaseConnection;

	public void descontinuarArticle(ArticleVO a) throws RemoteException;

	public boolean existeArticle(String nombre) throws RemoteException, NoDatabaseConnection;

}
