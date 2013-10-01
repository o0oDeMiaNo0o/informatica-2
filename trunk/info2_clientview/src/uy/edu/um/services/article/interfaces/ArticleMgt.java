package uy.edu.um.services.article.interfaces;

import java.util.ArrayList;

import uy.edu.um.value_object.article.ArticleVO;

public interface ArticleMgt {

	public ArticleVO createArticleVO(int prodN, String nombre , int precio);

	public void sendArticleVO(ArticleVO article);
	
	public void setCliente(ArticleVO a);

	public void setCliente(ArticleVO a);

	public ArticleVO searchArticle(int numProducto);

	public ArrayList<ArticleVO> allArticles();
}
