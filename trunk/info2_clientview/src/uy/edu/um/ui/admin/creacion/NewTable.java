package uy.edu.um.ui.admin.creacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import net.miginfocom.swing.MigLayout;
import uy.edu.um.exceptions.checks.NoDatabaseConnection;
import uy.edu.um.exceptions.checks.NoServerConnectionException;
import uy.edu.um.imagenes.DirLocal;
import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.table.interfaces.TableMgt;
import uy.edu.um.ui.admin.BasicoAdmin;
import uy.edu.um.ui.admin.creacion.NewTable;
import uy.edu.um.ui.clasesAuxiliares.ImagePanel;
import uy.edu.um.ui.clasesAuxiliares.TransparentPanel;
import uy.edu.um.ui.mensajes.MensajeGenerico;
import uy.edu.um.value_object.table.TableVO;

public class NewTable extends BasicoAdmin {

	public URL libre = DirLocal.class.getResource("Libre.jpg");
	public URL ocupado = DirLocal.class.getResource("Ocupado.jpg");
	public URL dirNew = DirLocal.class.getResource("Nuevo.png");
	public ArrayList<TableVO> mesas;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewTable frame = new NewTable();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public NewTable() throws NoServerConnectionException, NoDatabaseConnection {
		//try{
			mesas = cargoMesas();
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 300);
			getContentPane().setLayout(new BorderLayout(0, 0));

			TransparentPanel transparentPanel = new TransparentPanel();
			getContentPane().add(transparentPanel);
			transparentPanel.setLayout(new MigLayout("", "[grow][][grow][][grow]", "[][][][][][][][grow]"));

			TransparentPanel transparentPanel_1 = new TransparentPanel();
			getContentPane().add(transparentPanel_1, BorderLayout.NORTH);

			JLabel lblMesas = new JLabel("MESAS");
			lblMesas.setForeground(Color.WHITE);
			lblMesas.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			transparentPanel_1.add(lblMesas);
			cargaBotones(transparentPanel);

			TransparentPanel transparentPanel_2 = new TransparentPanel();
			getContentPane().add(transparentPanel_2, BorderLayout.SOUTH);
			transparentPanel_2
			.setLayout(new MigLayout("", "[98px,grow]", "[29px]"));

			JButton btnNewButton = new JButton("Cancelar");
			transparentPanel_2.add(btnNewButton,
			"cell 0 0,alignx right,aligny center");
			;

		//}catch(NoServerConnectionException e){
		//	MensajeGenerico nuevo = new MensajeGenerico(e.getMessage(),devuelve());
		//	nuevo.setVisible(true);
		//}
	}

	// Metodos auxiliares
	private void cargaBotones(final TransparentPanel panel) {
		if (mesas.isEmpty()) {
			JLabel lbltemp = new JLabel("NO HAY MESAS AGREGADAS");
			lbltemp.setForeground(Color.WHITE);
			panel.add(lbltemp, "cell 0 0");
		} else {
			int n = 1;
			int i = 1, j = 1;
			URL dir;
			while (n < mesas.size()) {
				String nombre = String.valueOf(mesas.get(n).getNumero());

				if (mesas.get(n).isOcupado()) {
					dir = ocupado;
				} else {
					dir = libre;
				}

				final String nom2 = nombre;
				ImagePanel imagePanel = new ImagePanel(dir);
				panel.add(imagePanel, "cell " + i + " " + j);
				imagePanel.setLayout(new MigLayout("", "[150px]", "[100px]"));

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

			// Nueva Mesa
			ImagePanel imagePanel = new ImagePanel(dirNew);
			panel.add(imagePanel, "cell " + i + " " + j);
			imagePanel.setLayout(new MigLayout("", "[150px]", "[100px]"));
			imagePanel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try{
					TableMgt nuevo = ServiceFacade.getInstance().getTableMgt();
					nuevo.addTable();
					NewTable newT = new NewTable();
					newT.setVisible(true);
					devuelve().dispose();
					}catch(NoServerConnectionException e1){
						MensajeGenerico nFrame = new MensajeGenerico(e1.getMessage(),devuelve());
						nFrame.setVisible(true);
					}catch(NoDatabaseConnection e1){
						MensajeGenerico test = new MensajeGenerico(e1.getMessage(),
								NewTable.this);
						test.setVisible(true);
					}
				}

			});
		}
	}

	private JFrame devuelve() {
		return this;
	}

	private ArrayList<TableVO> cargoMesas() throws NoServerConnectionException, NoDatabaseConnection {
		TableMgt nueva = ServiceFacade.getInstance().getTableMgt();
		return nueva.allTables();

	}
}
