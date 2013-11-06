package uy.edu.um.services.article.interfaces;

import java.math.BigDecimal;
import java.util.ArrayList;

import uy.edu.um.exceptions.checks.ExisteArticleException;
import uy.edu.um.exceptions.checks.NoServerConnectionException;
import uy.edu.um.value_object.article.ArticleVO;
import uy.edu.um.value_object.categories.CategoryVO;

public interface ArticleMgt {

	public ArticleVO createArticleVO(String nombre , BigDecimal precio, CategoryVO category) throws ExisteArticleException, NoServerConnectionException;

	public ArticleVO createArticleVOid(int id,String nombre , BigDecimal precio, CategoryVO category)
						throws ExisteArticleException, NoServerConnectionException;

	public void sendArticle(ArticleVO a) throws NoServerConnectionException;

	public ArticleVO searchArticle(int numProducto) throws NoServerConnectionException;

	public ArrayList<ArticleVO> allArticles() throws NoServerConnectionException;

	public void editArticle(ArticleVO a) throws NoServerConnectionException;

	public void descontinuarArticulo(ArticleVO a) throws NoServerConnectionException;

	public void removeArticle(ArticleVO a) throws NoServerConnectionException;

	public boolean existeArticle(String nombre) throws NoServerConnectionException;



}
