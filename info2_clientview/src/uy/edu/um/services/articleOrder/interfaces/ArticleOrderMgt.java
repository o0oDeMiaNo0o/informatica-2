package uy.edu.um.services.articleOrder.interfaces;

import uy.edu.um.value_object.article.ArticleVO;
import uy.edu.um.value_object.articleOrder.ArticleOrderVO;

public interface ArticleOrderMgt {

	public void sendArticleOrder(ArticleOrderVO ao);

	public ArticleOrderVO createArticleOrderVO(ArticleVO a, int cantidad, String especificaciones);

}
