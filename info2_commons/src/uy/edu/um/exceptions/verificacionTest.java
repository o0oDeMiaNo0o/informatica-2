package uy.edu.um.exceptions;

public class verificacionTest {
	public static void main(String[] args){
		String s = "lkjasd  ";
		boolean check = Verificacion.hasNumbers(s);
		System.out.println(check);
	}
}
