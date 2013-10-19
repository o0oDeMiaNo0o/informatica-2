package uy.edu.um.client_service.persistance.test;

import java.util.ArrayList;

import uy.edu.um.client_service.business.table.entities.Table;
import uy.edu.um.client_service.persistance.DAO.mesas.TableDAO;
import uy.edu.um.value_object.table.TableVO;


public class DBtest {




	public static void main(String[] args) {
		TableDAO t = TableDAO.getInstance();
		Table t1 = new Table(2);
		ArrayList<TableVO> array = new ArrayList<TableVO>();
		array=t.EstadosMesas();
		String a;
		
		for(int i=0;i<array.size();i++){
			if(array.get(i).isOcupado()){
				a = "Ocupado";
			}
			else{
				a = "Libre";
			}
			System.out.println("Mesa: "+array.get(i).getNumero()+" esta "+a+"");
		}
		
		


	}

}
