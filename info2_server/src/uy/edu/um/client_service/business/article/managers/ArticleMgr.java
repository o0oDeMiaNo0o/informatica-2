package uy.edu.um.client_service.business.article.managers;

import java.math.BigDecimal;
import java.util.ArrayList;

import uy.edu.um.client_service.business.BusinessFacade;
import uy.edu.um.client_service.business.article.entities.Article;
import uy.edu.um.client_service.business.article.interfaces.ArticleMgt;
import uy.edu.um.client_service.business.categories.entities.Category;
import uy.edu.um.client_service.business.categories.interfaces.CategoryMgt;
import uy.edu.um.client_service.persistance.DAO.articles.ArticlesDAO;
import uy.edu.um.exceptions.checks.NoDatabaseConnection;
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
	public void addArticle(Article a) throws NoDatabaseConnection {
		//obtener instancia del DAO con Singleton
		ArticlesDAO dao = ArticlesDAO.getInstance();
		dao.addArticle(a);
	}

	@Override
	public void editArticle(Article a) throws NoDatabaseConnection {
		ArticlesDAO dao = ArticlesDAO.getInstance();
		dao.editArticle(a);

	}

	@Override
	public void removeArticle(Article a) throws NoDatabaseConnection {
		ArticlesDAO dao = ArticlesDAO.getInstance();
		dao.deleteArticle(a);
	}

	//Metodos

	public Article getArticle(ArticleVO a){
		int id = a.getId();
		String nombre = a.getNombre();
		BigDecimal precio = a.getPrecio();
		CategoryMgt cMgt = BusinessFacade.getInstance().getCategoryMgt();
		Category cat = cMgt.createCategory(a.getCategory());
		Article aReturn = new Article(id, nombre, precio,cat);
		return aReturn;
	}

	@Override
	public void getArticles() throws NoDatabaseConnection {
		ArticlesDAO dao = ArticlesDAO.getInstance();
		dao.getArticles();
	}

	@Override
	public ArticleVO consultArticle(int numProducto) {
		ArticlesDAO dao = ArticlesDAO.getInstance();
		//return dao.searchArticle(numProducto);
		return null;
	}

	@Override
	public ArrayList<ArticleVO> allArticles() throws NoDatabaseConnection {
		ArticlesDAO dao = ArticlesDAO.getInstance();
		ArrayList<Article> articles =  dao.getArticles();
		ArrayList<ArticleVO> toReturn = new ArrayList<ArticleVO>();
		for(Article a : articles){
			if(a!=null){
				ArticleVO toAdd = this.getArticleVO(a);
				toReturn.add(toAdd);
			}
		}
		return toReturn;
	}

	@Override
	public ArticleVO getArticleVO(Article a) {
		CategoryMgt cMgt = BusinessFacade.getInstance().getCategoryMgt();
		int id = a.getId();
		String nombre = a.getNombre();
		Category c = a.getCategory();
		BigDecimal precio = a.getPrecio();
		CategoryVO catVO = cMgt.getCategoryVO(c);
		return new ArticleVO(id,nombre,precio,catVO);
	}

	@Override
	public void descontinuarArticle(Article a) {
		ArticlesDAO dao = ArticlesDAO.getInstance();
	}

	@Override
	public boolean existeArticle(String nombre) throws NoDatabaseConnection {
		ArticlesDAO dao = ArticlesDAO.getInstance();
		return dao.existeArticle(nombre);
	}


}
