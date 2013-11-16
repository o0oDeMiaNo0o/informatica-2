package uy.edu.um.ui;

import uy.edu.um.ui.cocina.ControlaDelivery;

public class Main {

	public static void main(String[] args) {
		Login nuevo = new Login();
		nuevo.setVisible(true);
		CurrentUser user = new CurrentUser(null);
		ControlaDelivery delivery = new ControlaDelivery();
	}
}
