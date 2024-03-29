package uy.edu.um.ui.admin.listas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

import net.miginfocom.swing.MigLayout;
import uy.edu.um.exceptions.checks.NoDatabaseConnection;
import uy.edu.um.exceptions.checks.NoServerConnectionException;
import uy.edu.um.imagenes.DirLocal;
import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.table.interfaces.TableMgt;
import uy.edu.um.ui.admin.BasicoAdmin;
import uy.edu.um.ui.clasesAuxiliares.ImagePanel;
import uy.edu.um.ui.clasesAuxiliares.TransparentPanel;
import uy.edu.um.ui.mensajes.ConfirmRemoveTable;
import uy.edu.um.ui.mensajes.MensajeGenerico;
import uy.edu.um.value_object.table.TableVO;

public class TableList extends BasicoAdmin {

	public URL libre = DirLocal.class.getResource("Libre.jpg");
	public URL ocupado = DirLocal.class.getResource("Ocupado.jpg");
	public URL delivery = DirLocal.class.getResource("Delivery.jpg");
	public URL mostrador = DirLocal.class.getResource("Mostrador.jpg");
	public ArrayList<TableVO> mesas;
	public Timer timer = null;

	public TableList() throws NoServerConnectionException, NoDatabaseConnection {
		mesas = cargoMesas();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout(0, 0));

		final TransparentPanel transparentPanel = new TransparentPanel();
		getContentPane().add(transparentPanel);
		transparentPanel.setLayout(new MigLayout("", "[grow][][grow][][grow]",
				"[][][][][][][][grow]"));

		TransparentPanel transparentPanel_1 = new TransparentPanel();
		getContentPane().add(transparentPanel_1, BorderLayout.NORTH);

		JLabel lblMesas = new JLabel("MESAS");
		lblMesas.setForeground(Color.WHITE);
		lblMesas.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		transparentPanel_1.add(lblMesas);

		//
		cargaBotones(transparentPanel);

		TransparentPanel transparentPanel_2 = new TransparentPanel();
		getContentPane().add(transparentPanel_2, BorderLayout.SOUTH);
		transparentPanel_2
				.setLayout(new MigLayout("", "[98px,grow]", "[29px]"));

		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				BasicoAdmin nuevo = new BasicoAdmin();
				nuevo.setVisible(true);
				TableList.this.dispose();
			}
		});
		transparentPanel_2.add(btnNewButton,
				"cell 0 0,alignx right,aligny center");

		this.timer = new Timer(5000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					mesas = cargoMesas();
				} catch (NoServerConnectionException e1) {
					// TODO Auto-generated catch block
					MensajeGenerico msg = new MensajeGenerico(e1.getMessage(),
							TableList.this);
					msg.setVisible(true);
				} catch (NoDatabaseConnection e1) {
					// TODO Auto-generated catch block
					MensajeGenerico msg = new MensajeGenerico(e1.getMessage(),
							TableList.this);
					msg.setVisible(true);
				}
				transparentPanel.removeAll();
				cargaBotones(transparentPanel);
				transparentPanel.invalidate();
				transparentPanel.validate();
				transparentPanel.repaint();
			}

		});
		timer.start();
	}

	// Metodos auxiliares
	private void cargaBotones(TransparentPanel panel) {

		if (mesas.isEmpty()) {
			JLabel lbltemp = new JLabel("NO HAY MESAS AGREGADAS");
			lbltemp.setForeground(Color.WHITE);
			panel.add(lbltemp, "cell 0 0");
		} else {
			int n = 2;
			int i = 1, j = 1;
			URL dir;
			while (n < mesas.size()) {
				String nombre = String.valueOf(mesas.get(n).getNumero());

				if (mesas.get(n).isOcupado()) {
					dir = ocupado;
				} else {
					dir = libre;
				}
				if (mesas.get(n).getNumero() == 0) {
					dir = mostrador;
					nombre = "MOSTRADOR";
				}
				final String nom2 = nombre;
				ImagePanel imagePanel = new ImagePanel(dir);
				panel.add(imagePanel, "cell " + i + " " + j);
				imagePanel.setLayout(new MigLayout("", "[150px]", "[100px]"));
				final TableVO mesa = mesas.get(n);
				imagePanel.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if (mesa.isOcupado()) {
							MensajeGenerico nuevo = new MensajeGenerico(
									"No Es Posible Eliminar Una Mesa Ocupada",
									devuelve());
							nuevo.setVisible(true);
						} else {
							ConfirmRemoveTable nuevo = new ConfirmRemoveTable(
									mesa, devuelve());
							nuevo.setVisible(true);

						}

					}

				});

				JLabel lblNewLabel = new JLabel(nombre);
				lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
				imagePanel.add(lblNewLabel,
						"cell 0 0,alignx center,aligny center");
				i = i + 2;
				if (i == 17) {
					i = 1;
					j = j + 2;
				}
				n++;

			}
		}

	}

	private JFrame devuelve() {
		return this;
	}

	private ArrayList<TableVO> cargoMesas() throws NoServerConnectionException,
			NoDatabaseConnection {
		TableMgt nueva = ServiceFacade.getInstance().getTableMgt();
		return nueva.allTables();

	}
}
