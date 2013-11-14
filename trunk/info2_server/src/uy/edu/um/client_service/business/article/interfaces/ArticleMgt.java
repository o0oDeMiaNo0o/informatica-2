package uy.edu.um.client_service.business.article.interfaces;

import java.util.ArrayList;

import uy.edu.um.client_service.business.article.entities.Article;
import uy.edu.um.exceptions.checks.NoDatabaseConnection;
import uy.edu.um.value_object.article.ArticleVO;

public interface ArticleMgt {

	public void addArticle(Article a) throws NoDatabaseConnection;

	public void editArticle(Article a) throws NoDatabaseConnection;

	public void removeArticle(Article a) throws NoDatabaseConnection;

	public Article getArticle(ArticleVO a);

	public void getArticles() throws NoDatabaseConnection;

	public ArticleVO consultArticle(int numProducto);

	public ArrayList<ArticleVO> allArticles() throws NoDatabaseConnection;

	public ArticleVO getArticleVO(Article a);

	public void descontinuarArticle(Article a);

	public boolean existeArticle(String nombre) throws NoDatabaseConnection;
}
