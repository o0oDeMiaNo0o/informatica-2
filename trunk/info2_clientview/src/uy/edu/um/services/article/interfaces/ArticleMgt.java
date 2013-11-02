package uy.edu.um.services.article.interfaces;

import java.math.BigDecimal;
import java.util.ArrayList;

import uy.edu.um.services.exceptions.HasNumberException;
import uy.edu.um.services.exceptions.NotNumberException;
import uy.edu.um.value_object.article.ArticleVO;
import uy.edu.um.value_object.categories.CategoryVO;

public interface ArticleMgt {

	public ArticleVO createArticleVO(String nombre , BigDecimal precio, CategoryVO category);

	public ArticleVO createArticleVOid(int id,String nombre , BigDecimal precio, CategoryVO category);

	public void sendArticle(ArticleVO a);

	public ArticleVO searchArticle(int numProducto);

	public ArrayList<ArticleVO> allArticles();

	public void editArticle(ArticleVO a);

	public void descontinuarArticulo(ArticleVO a);

	public void removeArticle(ArticleVO a);

	public boolean existeArticle(String nombre);

}
