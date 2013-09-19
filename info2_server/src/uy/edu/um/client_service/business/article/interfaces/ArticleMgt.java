package uy.edu.um.client_service.business.article.interfaces;

import uy.edu.um.client_service.business.article.entities.Article;

public interface ArticleMgt {

	public void addArticle(Article a);

	public void editArticle(Article a);

	public void removeArticle(Article a);

}
