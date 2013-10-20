package uy.edu.um.ui.usuarios;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

import net.miginfocom.swing.MigLayout;
import uy.edu.um.imagenes.DirLocal;
import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.table.interfaces.TableMgt;
import uy.edu.um.ui.clasesAuxiliares.BasicoUsuario;
import uy.edu.um.ui.clasesAuxiliares.ImagePanel;
import uy.edu.um.ui.clasesAuxiliares.TransparentButton;
import uy.edu.um.ui.clasesAuxiliares.TransparentPanel;
import uy.edu.um.value_object.table.TableVO;
import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import javax.swing.BoxLayout;

public class Mesas extends BasicoUsuario {

	public URL libre = DirLocal.class.getResource("Libre.jpg");
	public URL ocupado = DirLocal.class.getResource("Ocupado.jpg");
	public ArrayList<TableVO> mesas = new ArrayList<TableVO>();
	public TableVO mesaSeleccionada = null;

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
		cargoMesas();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout(0, 0));

		TransparentPanel transparentPanel = new TransparentPanel();
		getContentPane().add(transparentPanel);
		transparentPanel.setLayout(new MigLayout("", "[][][grow]", "[][][][][][][][grow]"));

		Component rigidArea = Box.createRigidArea(new Dimension(100, 100));
		transparentPanel.add(rigidArea, "cell 0 0");

		TransparentPanel transparentPanel_1 = new TransparentPanel();
		getContentPane().add(transparentPanel_1, BorderLayout.NORTH);

		JLabel lblMesas = new JLabel("MESAS");
		lblMesas.setForeground(Color.WHITE);
		lblMesas.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		transparentPanel_1.add(lblMesas);
		cargaBotones(transparentPanel);

		ImagePanel imagePanel = new ImagePanel(libre);
		transparentPanel
				.add(imagePanel, "cell 1 1,alignx center,aligny center");
		imagePanel.setLayout(new MigLayout("", "[150px]", "[100px]"));
		JLabel lblNewLabel = new JLabel("DELIVERY");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		imagePanel.add(lblNewLabel, "cell 0 0,alignx center,aligny center");
		;

	}

	// Metodos auxiliares
	private void cargaBotones(TransparentPanel panel) {
		if (mesas.isEmpty()) {
			JLabel lbltemp = new JLabel("NO HAY MESAS AGREGADAS");
			lbltemp.setForeground(Color.WHITE);
			panel.add(lbltemp, "cell 0 0");
		} else {
			int n = 0;
			int i = 3, j = 1;
			URL dir;
			while (n < mesas.size()) {
				if (mesas.get(n).isOcupado()) {
					dir = ocupado;
				} else {
					dir = libre;
				}
				ImagePanel imagePanel = new ImagePanel(dir);
				panel.add(imagePanel, "cell " + i + " " + j);
				imagePanel.setLayout(new MigLayout("", "[150px]", "[100px]"));
				final TableVO mesa = mesas.get(n);
				imagePanel.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						mesaSeleccionada = mesa;
					}
				});

				JLabel lblNewLabel = new JLabel(Integer.toString(mesas.get(n)
						.getNumero()));
				lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
				imagePanel.add(lblNewLabel,
						"cell 0 0,alignx center,aligny center");
				i = i + 2;
				if (i == 15) {
					i = 1;
					j = j + 2;
				}
				n++;

			}
		}
	}

	private void cargoMesas() {
		TableVO nuevo1 = new TableVO(1, true);
		TableVO nuevo2 = new TableVO(2, false);
		mesas.add(nuevo1);
		mesas.add(nuevo2);
		mesas.add(nuevo2);
		mesas.add(nuevo2);
		mesas.add(nuevo2);
		mesas.add(nuevo2);
		mesas.add(nuevo2);
		mesas.add(nuevo2);
		mesas.add(nuevo2);
		mesas.add(nuevo2);
		mesas.add(nuevo2);
		mesas.add(nuevo2);
		mesas.add(nuevo2);
		mesas.add(nuevo2);

		// TableMgt nueva = ServiceFacade.getInstance().getTableMgt();
		// nueva.
	}
}
