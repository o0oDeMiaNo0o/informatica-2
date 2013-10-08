package uy.edu.um.services.articleOrder.managers;

public class ArticleOrderMgr {

	private static ArticleOrderMgr instance = null;

	private ArticleOrderMgr(){}

	public ArticleOrderMgr getInstance(){
		if(instance == null){
			instance = new ArticleOrderMgr();
		}
		return instance;
	}

}
