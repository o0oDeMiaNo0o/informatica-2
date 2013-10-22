package uy.edu.um.client_service.business.article.interfaces;

import java.util.ArrayList;

import uy.edu.um.client_service.business.article.entities.Article;
import uy.edu.um.value_object.article.ArticleVO;

public interface ArticleMgt {

	public void addArticle(Article a);

	public void editArticle(Article a);

	public void removeArticle(Article a);

	public Article getArticle(ArticleVO a);

	public void getArticles();

	public ArticleVO consultArticle(int numProducto);

	public ArrayList<ArticleVO> allArticles();

	public ArticleVO getArticleVO(Article a);
}
