package uy.edu.um.client_service.business.article.managers;

import uy.edu.um.client_service.business.article.entities.Article;
import uy.edu.um.client_service.business.article.interfaces.ArticleMgt;
import uy.edu.um.client_service.persistance.DAO.articles.ArticlesDAO;
import uy.edu.um.value_object.article.ArticleVO;

public class ArticleMgr implements ArticleMgt{

	private static ArticleMgr instance = new ArticleMgr();

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
		int id = 23;
		String nombre = a.getNombre();
		int precio = a.getPrecio();
		Article aReturn = new Article(id,nombre, precio);
		return aReturn;
	}


}
