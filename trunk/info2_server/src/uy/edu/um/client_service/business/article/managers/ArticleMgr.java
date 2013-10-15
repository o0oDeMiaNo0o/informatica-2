package uy.edu.um.client_service.business.article.managers;

import java.math.BigDecimal;
import java.util.ArrayList;

import uy.edu.um.client_service.business.BusinessFacade;
import uy.edu.um.client_service.business.article.entities.Article;
import uy.edu.um.client_service.business.article.interfaces.ArticleMgt;
import uy.edu.um.client_service.business.categories.entities.Category;
import uy.edu.um.client_service.business.categories.interfaces.CategoryMgt;
import uy.edu.um.client_service.persistance.DAO.articles.ArticlesDAO;
import uy.edu.um.value_object.article.ArticleVO;
import uy.edu.um.value_object.categories.CategoryVO;

public class ArticleMgr implements ArticleMgt{

	private static ArticleMgr instance = null;

	//constructor privado
	private ArticleMgr(){

	}

	public static ArticleMgr getInstance(){
		if (instance == null){
			instance = new ArticleMgr();
		}
		return instance;
	}


	@Override
	public void addArticle(Article a) {
		//obtener instancia del DAO con Singleton
		ArticlesDAO dao = ArticlesDAO.getInstance();
		dao.addArticle(a);
	}

	@Override
	public void editArticle(Article a) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeArticle(Article a) {
		// TODO Auto-generated method stub

	}

	//Metodos

	public Article getArticle(ArticleVO a){
		String nombre = a.getNombre();
		BigDecimal precio = a.getPrecio();
		CategoryMgt cMgt = BusinessFacade.getInstance().getCategoryMgt();
		Category cat = cMgt.createCategory(a.getCategory());
		Article aReturn = new Article(nombre, precio,cat);
		return aReturn;
	}

	@Override
	public void getArticles() {
		ArticlesDAO dao = ArticlesDAO.getInstance();
		dao.getArticles();
	}

	@Override
	public ArticleVO consultArticle(int numProducto) {
		ArticlesDAO dao = ArticlesDAO.getInstance();
		return dao.searchArticle(numProducto);
	}

	@Override
	public ArrayList<ArticleVO> allArticles() {
		ArticlesDAO dao = ArticlesDAO.getInstance();
		return dao.getArticlesVO();
	}


}
