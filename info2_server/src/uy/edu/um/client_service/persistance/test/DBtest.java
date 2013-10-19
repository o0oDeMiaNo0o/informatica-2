package uy.edu.um.client_service.persistance.test;

import uy.edu.um.client_service.business.table.entities.Table;
import uy.edu.um.client_service.persistance.DAO.mesas.TableDAO;
import uy.edu.um.value_object.article.ArticleVO;


public class DBtest {




	public static void main(String[] args) {
		TableDAO t = TableDAO.getInstance();
		Table t1 = new Table(1);
		
		//t.addTable(t1);
		t.setLibre(t1);
		


	}

}
