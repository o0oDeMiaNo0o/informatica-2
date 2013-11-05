package uy.edu.um.services.article.managers;

import java.math.BigDecimal;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import uy.edu.um.exceptions.checks.ExisteArticleException;
import uy.edu.um.interfaces.article.ArticleRemoteMgt;
import uy.edu.um.services.article.interfaces.ArticleMgt;
import uy.edu.um.value_object.article.ArticleVO;
import uy.edu.um.value_object.categories.CategoryVO;

public class ArticleMgr implements ArticleMgt {
	// respeta patron singleton
	private static ArticleMgr instance = null;

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
	public ArticleVO createArticleVO(String nombre, BigDecimal precio, CategoryVO category)
				throws ExisteArticleException{
		if(existeArticle(nombre)){
			throw new ExisteArticleException("El articlo "+nombre+" ya existe");
		}
		ArticleVO aReturn = new ArticleVO(nombre, precio,category);
		return aReturn;
	}

	@Override
	public void sendArticle(ArticleVO a) {
		try {
			String sObjectService = "ArticleRemoteMgr";
			Registry oRegitry = LocateRegistry.getRegistry(1099);
			ArticleRemoteMgt oArticleRemoteMgt = (ArticleRemoteMgt) oRegitry
					.lookup(sObjectService);
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

	@Override
	public ArrayList<ArticleVO> allArticles() {
		ArrayList<ArticleVO> array = new ArrayList<ArticleVO>(10);
		try {
			String sObjectService = "ArticleRemoteMgr";
			Registry oRegitry = LocateRegistry.getRegistry(1099);
			ArticleRemoteMgt oArticleRemoteMgt = (ArticleRemoteMgt) oRegitry
			.lookup(sObjectService);
			array = oArticleRemoteMgt.getArticlesVO();
		}catch (Exception e) {
			System.err.println("error:");
			e.printStackTrace();
		}
		return array;
	}

	@Override
	public void editArticle(ArticleVO a) {
		try {
			String sObjectService = "ArticleRemoteMgr";
			Registry oRegitry = LocateRegistry.getRegistry(1099);
			ArticleRemoteMgt oArticleRemoteMgt = (ArticleRemoteMgt) oRegitry
					.lookup(sObjectService);
			 oArticleRemoteMgt.editArtile(a);
		}catch (Exception e) {
			System.err.println("error:");
			e.printStackTrace();
		}
	}

	@Override
	public void descontinuarArticulo(ArticleVO a) {
		try {
			String sObjectService = "ArticleRemoteMgr";
			Registry oRegitry = LocateRegistry.getRegistry(1099);
			ArticleRemoteMgt oArticleRemoteMgt = (ArticleRemoteMgt) oRegitry
					.lookup(sObjectService);
			oArticleRemoteMgt.editArtile(a);
		}catch (Exception e) {
			System.err.println("error:");
			e.printStackTrace();

		}

	}

	@Override
	public ArticleVO createArticleVOid(int id, String nombre,
			BigDecimal precio, CategoryVO category) throws ExisteArticleException {
		if(existeArticle(nombre)){
			throw new ExisteArticleException("El article "+nombre+" ya existe");
		}
		ArticleVO aReturn = new ArticleVO(nombre, precio,category);
		return aReturn;
	}

	@Override
	public void removeArticle(ArticleVO a) {
		try {
			String sObjectService = "ArticleRemoteMgr";
			Registry oRegitry = LocateRegistry.getRegistry(1099);
			ArticleRemoteMgt oArticleRemoteMgt = (ArticleRemoteMgt) oRegitry
			.lookup(sObjectService);
			 oArticleRemoteMgt.editArtile(a);
		}catch (Exception e) {
			System.err.println("error:");
			e.printStackTrace();
		}
	}

	//Metodos auxiliares

	@Override
	public boolean existeArticle(String nombre) {
		boolean check = false;
		try {
			String sObjectService = "ArticleRemoteMgr";
			Registry oRegitry = LocateRegistry.getRegistry(1099);
			ArticleRemoteMgt oArticleRemoteMgt = (ArticleRemoteMgt) oRegitry
			.lookup(sObjectService);
			check = oArticleRemoteMgt.existeArticle(nombre);
		}catch (Exception e) {
			System.err.println("error:");
			e.printStackTrace();
		}
		return check;
	}
}
