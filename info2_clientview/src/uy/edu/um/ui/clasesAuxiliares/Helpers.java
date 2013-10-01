package uy.edu.um.ui.clasesAuxiliares;

import java.util.ArrayList;

import uy.edu.um.value_object.article.ArticleVO;

public class Helpers {

	public static boolean isNumeric(String cadena){
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	}
	
	public static int buscaArticulo (ArrayList<ArticleVO> a,String b){
		for(int i = 0;i<a.size()-1;i++){
			if(a.get(i).getNombre().equals(b)){
				return i;
			}
		}
		return 0;
	}
	
}
