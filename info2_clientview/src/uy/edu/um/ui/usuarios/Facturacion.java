package uy.edu.um.ui.usuarios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import uy.edu.um.ui.clasesAuxiliares.BasicoUsuario;
import uy.edu.um.ui.clasesAuxiliares.TransparentPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import uy.edu.um.ui.clasesAuxiliares.ImagePanel;

public class Facturacion extends BasicoUsuario {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Facturacion frame = new Facturacion();
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
	public Facturacion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		TransparentPanel transparentPanel = new TransparentPanel();
		getContentPane().add(transparentPanel, BorderLayout.CENTER);
		transparentPanel.setLayout(new MigLayout("", "[grow][][grow][grow]", "[grow][][][][][grow]"));
		
		ImagePanel imagePanel = new ImagePanel("/Users/facundoliston/Documents/FACULTAD/UM/Informatica2/info2_clientview/src/uy/edu/um/imagenes/Logo.png");
		transparentPanel.add(imagePanel, "cell 2 0,alignx center,aligny center");
		
		JLabel lblMozo = new JLabel("Mozo");
		lblMozo.setForeground(Color.WHITE);
		transparentPanel.add(lblMozo, "cell 1 1,alignx left");
		
		JComboBox comboBox = new JComboBox();
		transparentPanel.add(comboBox, "flowx,cell 2 1,growx,aligny center");
		
		JLabel lblMesa = new JLabel("Mesa");
		lblMesa.setForeground(Color.WHITE);
		transparentPanel.add(lblMesa, "cell 1 2,alignx left");
		
		JComboBox comboBox_1 = new JComboBox();
		transparentPanel.add(comboBox_1, "flowx,cell 2 2,growx");
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setForeground(Color.WHITE);
		transparentPanel.add(lblCliente, "cell 1 3,alignx left");
		
		textField = new JTextField();
		transparentPanel.add(textField, "flowx,cell 2 3,growx");
		textField.setColumns(10);
		
		JButton btnVerLista = new JButton("Ver Lista");
		transparentPanel.add(btnVerLista, "cell 2 3,alignx right,aligny center");
		
		JLabel lblPagaCon = new JLabel("Paga Con");
		lblPagaCon.setForeground(Color.WHITE);
		transparentPanel.add(lblPagaCon, "cell 1 4,alignx left");
		
		textField_1 = new JTextField();
		transparentPanel.add(textField_1, "flowx,cell 2 4,growx");
		textField_1.setColumns(10);
		
		TransparentPanel transparentPanel_1 = new TransparentPanel();
		transparentPanel.add(transparentPanel_1, "cell 2 5,grow");
		transparentPanel_1.setLayout(new MigLayout("", "[grow][][grow]", "[grow][][][][grow][]"));
		
		JLabel lblSubtotal = new JLabel("Subtotal");
		lblSubtotal.setForeground(Color.WHITE);
		transparentPanel_1.add(lblSubtotal, "cell 1 1");
		
		JLabel lblDescuento = new JLabel("Descuento");
		lblDescuento.setForeground(Color.WHITE);
		transparentPanel_1.add(lblDescuento, "cell 1 2");
		
		JLabel lblTotal = new JLabel("TOTAL");
		lblTotal.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblTotal.setForeground(Color.WHITE);
		transparentPanel_1.add(lblTotal, "cell 1 3");
		
		JButton btnAceptar = new JButton("Aceptar");
		transparentPanel_1.add(btnAceptar, "flowx,cell 2 5,alignx right");
		
		JButton btnCancelar = new JButton("Cancelar");
		transparentPanel_1.add(btnCancelar, "cell 2 5,alignx right");
		
		JLabel lblVuelto = new JLabel("Vuelto");
		lblVuelto.setForeground(Color.WHITE);
		transparentPanel.add(lblVuelto, "cell 2 4,alignx left");
		
		textField_2 = new JTextField();
		transparentPanel.add(textField_2, "cell 2 4,growx");
		textField_2.setColumns(10);
		
		JButton btnVerMapaMesas = new JButton("Ver Mapa Mesas");
		transparentPanel.add(btnVerMapaMesas, "cell 2 2,alignx right");
	}

}
