package uy.edu.um.exceptions;

public class Verificacion {

	/**
	 * Metodo que sirve para verificar si un string contiene "impurezas"
	 * @param s
	 * @return true-> is esta limpio, false-> en caso contrario
	 */
	public static boolean isNumeric(String s){
		boolean status = true;
		for(int i=0 ; i<s.length() ; i++){
			char current = s.charAt(i);
			boolean check = true;
			if(Character.isDigit(current)){
				check = true;
			}else{
				check = false;
			}
			status = status && check;
			if(status==false){
				break;
			}
		}
		return status;
	}

	/**
	 * Metodo que puede servir para chequear si un nombre o apellido tiene numeros
	 * @param s
	 * @return true-> en caso que un string tenga numeros, false-> caso contrario
	 */
	public static boolean hasNumbers(String s){
		boolean status = false;
		for(int i=0; i<s.length(); i++){
			char current = s.charAt(i);
			boolean check = false;
			if(Character.isDigit(current)){
				check = true;
			}
			status = status || check;
			if(status == true) {
				break;
			}
		}
		return status;
	}

	/**
	 * Metodo que busca si un string tiene espacios, puede servir para rechazar
	 * contraseñas con espacios
	 * @param s
	 * @return
	 */

	public static boolean hasSpaces(String s){
		boolean status = false;
		for(int i=0; i<s.length(); i++){
			char current = s.charAt(i);
			boolean check = false;
			if(Character.isWhitespace(current)){
				check = true;
			}
			status = status || check;
			if(status == true) {
				break;
			}
		}
		return status;

	}

}
