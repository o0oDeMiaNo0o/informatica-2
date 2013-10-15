package uy.edu.um.services.article.interfaces;

import java.math.BigDecimal;
import java.util.ArrayList;

import uy.edu.um.value_object.article.ArticleVO;
import uy.edu.um.value_object.categories.CategoryVO;

public interface ArticleMgt {

	public ArticleVO createArticleVO(String nombre , BigDecimal precio, CategoryVO category);

	public void sendCliente(ArticleVO a);

	public ArticleVO searchArticle(int numProducto);




	public ArrayList<ArticleVO> allArticles();
}
