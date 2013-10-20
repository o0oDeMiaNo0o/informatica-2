package uy.edu.um.client_service.business.articleOrder.interfaces;

import uy.edu.um.client_service.business.articleOrder.entities.ArticleOrder;
import uy.edu.um.value_object.article.ArticleVO;
import uy.edu.um.value_object.articleOrder.ArticleOrderVO;

public interface ArticleOrderMgt {

	public ArticleOrder getArticleOrder(ArticleOrderVO ao);

	public ArticleOrderVO transition(ArticleVO a, int cantidad);
}
