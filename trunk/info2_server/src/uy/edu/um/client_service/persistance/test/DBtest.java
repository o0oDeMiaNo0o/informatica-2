package uy.edu.um.client_service.persistance.test;

import uy.edu.um.client_service.persistance.DAO.articles.ArticlesDAO;



public class DBtest {




	public static void main(String[] args) {
	
		ArticlesDAO a = ArticlesDAO.getInstance();
		boolean e = a.existeArticle("MILANESA CON PROVOLONEwww");
		if(e){
			System.out.println("esta");
		}
		else{
			System.out.println("no esta");

		}
	
	
	
	}

}
