package uy.edu.um.ui.usuarios;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

import net.miginfocom.swing.MigLayout;
import uy.edu.um.imagenes.DirLocal;
import uy.edu.um.services.ServiceFacade;
import uy.edu.um.ui.clasesAuxiliares.BasicoUsuario;
import uy.edu.um.ui.clasesAuxiliares.TransparentButton;
import uy.edu.um.ui.clasesAuxiliares.TransparentPanel;
import uy.edu.um.value_object.table.TableVO;

public class Mesas extends BasicoUsuario {

	public URL libre = DirLocal.class.getResource("Libre.jpg");
	public URL ocupado = DirLocal.class.getResource("Ocupado.jpg");
	public ArrayList<TableVO> mesas = cargoMesas();
	private ArrayList<TableVO> aux;

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
		getContentPane().setLayout(new BorderLayout(0, 0));

		TransparentPanel transparentPanel = new TransparentPanel();
		getContentPane().add(transparentPanel);
		transparentPanel.setLayout(new MigLayout("", "[grow][][grow]", "[grow][][grow]"));

		cargaBotones(transparentPanel);
	}

	// Metodos auxiliares
	private void cargaBotones(TransparentPanel panel) {
		if (mesas.isEmpty()) {
			JLabel lbltemp = new JLabel("NO HAY MESAS AGREGADAS");
			lbltemp.setForeground(Color.WHITE);
			panel.add(lbltemp, "cell 0 0");
		} else {
			int n = 0, i = 1, j = 1;
			URL dir;
			while (n < mesas.size()) {
				if (mesas.get(n).isOcupado()) {
					dir = ocupado;
				} else {
					dir = libre;
				}
				TransparentButton transparentButton = new TransparentButton(dir);
				transparentButton.setText("Mesa " + mesas.get(n).getNumero());
				panel.add(transparentButton, "cell " + i + " " + j);
				i++;
				if (i == 10) {
					i = 1;
					j++;
				}
				n++;

			}
		}
	}

	private ArrayList<TableVO> cargoMesas() {
		aux = null;
		
		return aux;
	}
}
