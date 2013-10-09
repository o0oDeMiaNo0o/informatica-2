package uy.edu.um.services.article.interfaces;

import java.math.BigDecimal;
import java.util.ArrayList;

import uy.edu.um.value_object.article.ArticleVO;

public interface ArticleMgt {

	public ArticleVO createArticleVO(int prodN, String nombre , BigDecimal precio);

	public void sendCliente(ArticleVO a);

	public ArticleVO searchArticle(int numProducto);

	public ArrayList<ArticleVO> allArticles();
}
