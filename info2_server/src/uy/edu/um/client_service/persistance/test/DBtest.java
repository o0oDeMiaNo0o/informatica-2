package uy.edu.um.client_service.persistance.test;

import java.util.ArrayList;

import uy.edu.um.client_service.persistance.DAO.articles.ArticlesDAO;
import uy.edu.um.value_object.article.ArticleVO;


public class DBtest {




	public static void main(String[] args) {
		ArticlesDAO a = new ArticlesDAO();
		ArrayList array = new ArrayList();
		array=a.getArticlesVO();
		
		for(int i=0;i<array.size();i++){
			ArticleVO current = (ArticleVO) array.get(i);
			System.out.println("Nombre: "+current.getNombre()+". Precio: "+current.getPrecio()+". Categoria: "+current.getCategory().getNombre()+".");
			
		}
		


	}

}
