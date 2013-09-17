package uy.edu.um.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fondo extends JFrame {

	/**
	 * Create the panel.
	 */
	
	public static void main(String[] args){
		Fondo f = new Fondo();
		f.setSize(400, 400);
		f.setVisible(true);
		PanelFondo p = new PanelFondo("/uy/edu/um/imagenes/Bernie's.png");
		f.add(p);
	}

}
