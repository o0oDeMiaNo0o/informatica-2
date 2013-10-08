package uy.edu.um.client_service.service.articleRemote.test;

import java.math.BigDecimal;
import java.rmi.RemoteException;

import uy.edu.um.client_service.business.BusinessFacade;
import uy.edu.um.interfaces.article.ArticleRemoteMgt;
import uy.edu.um.value_object.article.ArticleVO;

public class ArticleRemoteMgrTest {
	public static void main(String[] args) throws RemoteException{
//		JDBC db = new JDBC();
//		db.createDatabase();
		String nombre = "pizza";
		BigDecimal precio = new BigDecimal(34);
		ArticleVO toAdd = new ArticleVO(12,nombre,precio);
		ArticleRemoteMgt aMgr = BusinessFacade.getInstance().getArticleRemote();

	}
}
