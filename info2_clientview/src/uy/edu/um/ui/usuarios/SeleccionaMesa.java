package uy.edu.um.ui.usuarios;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import uy.edu.um.ui.clasesAuxiliares.BasicoUsuario;
import uy.edu.um.value_object.article.ArticleVO;
import uy.edu.um.value_object.articleOrder.ArticleOrderVO;
import uy.edu.um.ui.clasesAuxiliares.TransparentPanel;

import java.awt.Color;

import javax.swing.JTable;
import javax.swing.border.BevelBorder;

public class SeleccionaMesa extends BasicoUsuario {
	ArrayList<ArticleOrderVO> pedido;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeleccionaMesa frame = new SeleccionaMesa(null);
					frame.setLocationRelativeTo(null);
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
	public SeleccionaMesa(ArrayList<ArticleOrderVO> pedidoAux) {

		this.pedido = pedidoAux;

		setTitle("Seleccionar Mesa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		TransparentPanel transparentPanelMesa = new TransparentPanel();
		getContentPane().add(transparentPanelMesa, BorderLayout.CENTER);
		transparentPanelMesa.setLayout(new MigLayout("", "[grow][][grow][grow]", "[fill][][][grow][grow]"));
		
		JLabel lblMesa = new JLabel("Mesa");
		lblMesa.setForeground(Color.WHITE);
		transparentPanelMesa.add(lblMesa, "cell 1 1,alignx left,aligny center");
		
		JComboBox comboBox = new JComboBox();
		transparentPanelMesa.add(comboBox, "flowx,cell 2 1,growx,aligny center");
		
		JButton btnVerMapa = new JButton("Ver Mapa");
		transparentPanelMesa.add(btnVerMapa, "cell 3 1,alignx left,aligny center");
		
		table = new JTable();
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		transparentPanelMesa.add(table, "cell 2 3,grow");
		
		TransparentPanel transparentPanelBotones = new TransparentPanel();
		getContentPane().add(transparentPanelBotones, BorderLayout.SOUTH);
		transparentPanelBotones.setLayout(new MigLayout("", "[grow][][]", "[]"));
		
		JButton btnFacturar = new JButton("Facturar");
		transparentPanelBotones.add(btnFacturar, "cell 1 0");
		
		JButton btnVaciarMesa = new JButton("Vaciar Mesa");
		transparentPanelBotones.add(btnVaciarMesa, "cell 2 0");
	}

}
