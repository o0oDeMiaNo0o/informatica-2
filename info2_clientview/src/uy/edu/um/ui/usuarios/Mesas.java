package uy.edu.um.ui.usuarios;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.net.URL;

import javax.swing.JFrame;

import net.miginfocom.swing.MigLayout;
import uy.edu.um.imagenes.DirLocal;
import uy.edu.um.ui.clasesAuxiliares.BasicoUsuario;
import uy.edu.um.ui.clasesAuxiliares.ImagePanel;
import uy.edu.um.ui.clasesAuxiliares.TransparentPanel;

public class Mesas extends BasicoUsuario {

	public URL libre = DirLocal.class.getResource("Fondo2.jpg");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mesas frame = new Mesas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Mesas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		TransparentPanel transparentPanel = new TransparentPanel();
		getContentPane().add(transparentPanel, BorderLayout.NORTH);
		transparentPanel.setLayout(new MigLayout("", "[grow]", "[grow]"));

		ImagePanel imagePanel = new ImagePanel(libre);
		transparentPanel.add(imagePanel, "cell 0 0,grow");
	}

}
