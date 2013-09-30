package uy.edu.um.ui.usuarios;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import uy.edu.um.ui.clasesAuxiliares.ImagePanel;
import uy.edu.um.ui.clasesAuxiliares.TransparentPanel;

public class CajaPrincipal extends JFrame {

	private ImagePanel contentPane;
	private String DirFondo = "/Users/facundoliston/Documents/FACULTAD/UM/Informatica2/info2_clientview/src/uy/edu/um/imagenes/Fondo2.jpg";
	private final Action action = new SwingAction();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_4;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CajaPrincipal frame = new CajaPrincipal();
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
	public CajaPrincipal() {
		setTitle("Pedido");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,JFrame.MAXIMIZED_HORIZ,JFrame.MAXIMIZED_VERT);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		
		//Menu Opciones
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.DARK_GRAY);
		setJMenuBar(menuBar);
		
		JMenu menuUsuario = new JMenu("Opciones Usuario");
		menuUsuario.setForeground(Color.BLACK);
		menuUsuario.setBackground(Color.DARK_GRAY);
		menuBar.add(menuUsuario);
		
		JMenuItem menuItem_4 = new JMenuItem("Agregar Usuarios");
		menuUsuario.add(menuItem_4);
		
		JMenuItem menuItem_5 = new JMenuItem("Ver Lista Usuarios");
		menuUsuario.add(menuItem_5);
		
		JMenuItem menuItem_6 = new JMenuItem("Eliminar Usuarios");
		menuUsuario.add(menuItem_6);
		
		JMenuItem menuItem_7 = new JMenuItem("Salir");
		menuItem_7.setForeground(Color.BLACK);
		menuItem_7.setBackground(Color.RED);
		menuUsuario.add(menuItem_7);
		
		JMenu menuCaja = new JMenu("Caja");
		menuCaja.setBackground(Color.DARK_GRAY);
		menuBar.add(menuCaja);
		
		JMenuItem mntmPedidoLocal = new JMenuItem("Realizar Pedido");
		menuCaja.add(mntmPedidoLocal);
		
		JMenuItem mntmDelivery = new JMenuItem("Calcelar Pedido");
		menuCaja.add(mntmDelivery);
		
		JMenu menuMenus = new JMenu("Men\u00FAs");
		menuMenus.setBackground(Color.DARK_GRAY);
		menuBar.add(menuMenus);
		
		JMenuItem menuItem = new JMenuItem("Agregar Nuevo");
		menuMenus.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("Editar");
		menuMenus.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("Listado");
		menuMenus.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("Eliminar");
		menuMenus.add(menuItem_3);
		
		JMenu menuCocina = new JMenu("Cocina");
		menuCocina.setBackground(Color.DARK_GRAY);
		menuBar.add(menuCocina);
		
		JMenuItem mntmVerCocina = new JMenuItem("Ver Cocina");
		menuCocina.add(mntmVerCocina);
		
		JMenuItem mntmEnviarMensaje = new JMenuItem("Enviar Mensaje");
		menuCocina.add(mntmEnviarMensaje);
		//Termina menus
		
		contentPane = new ImagePanel(DirFondo);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		TransparentPanel transparentPanelPedido = new TransparentPanel();
		contentPane.add(transparentPanelPedido, BorderLayout.CENTER);
		transparentPanelPedido.setLayout(new MigLayout("", "[][][][][grow][]", "[grow][][][][][][][][][][][][][grow]"));
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setForeground(Color.WHITE);
		transparentPanelPedido.add(lblCantidad, "cell 3 1,alignx center,aligny center");
		
		JLabel lblEspecificaciones = new JLabel("Especificaciones");
		lblEspecificaciones.setForeground(Color.WHITE);
		transparentPanelPedido.add(lblEspecificaciones, "cell 4 1,alignx center,aligny center");
		
		JLabel lblMens = new JLabel("Men\u00FAs");
		lblMens.setForeground(Color.WHITE);
		transparentPanelPedido.add(lblMens, "cell 1 2,alignx left");
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setToolTipText("Desplegar Lista");
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {" ---- Desplegar Lista Men\u00FAs ----", "", "Men\u00FA 1 - Descripcion", "Men\u00FA 2 - Descripcion", "Men\u00FA 3 - Descripcion", "Men\u00FA 4 - Descripcion", "Men\u00FA 5 - Descripcion", "Men\u00FA 6 - Descripcion", "Men\u00FA 7 - Descripcion"}));
		transparentPanelPedido.add(comboBox_1, "cell 2 2,grow");
		
		JSpinner spinner = new JSpinner();
		transparentPanelPedido.add(spinner, "cell 3 2,alignx center");
		
		textField = new JTextField();
		transparentPanelPedido.add(textField, "cell 4 2,growx");
		textField.setColumns(10);
		
		JLabel lblPizzas = new JLabel("Pizzas");
		lblPizzas.setForeground(Color.WHITE);
		transparentPanelPedido.add(lblPizzas, "cell 1 4,alignx left");
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {" ---- Desplegar Lista Pizzas ----", "", "Tipo Pizza 1 - Descripcion", "Tipo Pizza 2 - Descripcion", "Tipo Pizza 3 - Descripcion", "Tipo Pizza 4 - Descripcion", "Tipo Pizza 5 - Descripcion", "Tipo Pizza 6 - Descripcion"}));
		comboBox_2.setToolTipText("Desplegar Lista");
		transparentPanelPedido.add(comboBox_2, "cell 2 4,grow");
		
		JSpinner spinner_1 = new JSpinner();
		transparentPanelPedido.add(spinner_1, "cell 3 4,alignx center");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		transparentPanelPedido.add(textField_1, "cell 4 4,growx");
		
		JLabel lblBebidas = new JLabel("Bebidas");
		lblBebidas.setForeground(Color.WHITE);
		transparentPanelPedido.add(lblBebidas, "cell 1 6,alignx left");
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {" ---- Desplegar Lista Bebidas ----", "", "Bebida 1", "Bebida 2", "Bebida 3", "Bebida 4", ""}));
		transparentPanelPedido.add(comboBox_4, "cell 2 6,grow");
		
		JSpinner spinner_2 = new JSpinner();
		transparentPanelPedido.add(spinner_2, "cell 3 6,alignx center");
		
		JButton button_2 = new JButton("Agregar a Pedido");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JRadioButton rdbtnLight = new JRadioButton("Light");
		rdbtnLight.setHorizontalAlignment(SwingConstants.RIGHT);
		rdbtnLight.setForeground(Color.WHITE);
		transparentPanelPedido.add(rdbtnLight, "flowx,cell 4 6,alignx center,aligny center");
		transparentPanelPedido.add(button_2, "cell 5 6");
		
		JLabel lblHamburguesas = new JLabel("Hamburguesas");
		lblHamburguesas.setForeground(Color.WHITE);
		transparentPanelPedido.add(lblHamburguesas, "cell 1 8,alignx left");
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {" ---- Desplegar Lista Hamburguesas ----", "", "Hamburguesa 1 - Descripcion", "Hamburguesa 2 - Descripcion", "Hamburguesa 3 - Descripcion", "Hamburguesa 4 - Descripcion", "Hamburguesa 5 - Descripcion", "Hamburguesa 6 - Descripcion", "Hamburguesa 7 - Descripcion"}));
		transparentPanelPedido.add(comboBox_3, "cell 2 8,grow");
		
		JSpinner spinner_3 = new JSpinner();
		transparentPanelPedido.add(spinner_3, "cell 3 8,alignx center");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		transparentPanelPedido.add(textField_2, "cell 4 8,growx");
		
		JLabel lblEspeciales = new JLabel("Especiales");
		lblEspeciales.setForeground(Color.WHITE);
		transparentPanelPedido.add(lblEspeciales, "cell 1 10,alignx left");
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {" ---- Desplegar Lista Especiales ----", "", "Especial 1", "Especial 2", "Especial 3", "Especial 4", "Especial 5", ""}));
		transparentPanelPedido.add(comboBox_5, "flowx,cell 2 10,growx");
		
		JSpinner spinner_4 = new JSpinner();
		transparentPanelPedido.add(spinner_4, "cell 3 10,alignx center");
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		transparentPanelPedido.add(textField_4, "cell 4 10,growx");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {" ---- Tama\u00F1o ----", "", "Peque\u00F1o", "Mediano", "Grande"}));
		transparentPanelPedido.add(comboBox, "cell 4 6,alignx right,aligny center");
		
		TransparentPanel transparentPanelBotonera = new TransparentPanel();
		contentPane.add(transparentPanelBotonera, BorderLayout.SOUTH);
		transparentPanelBotonera.setLayout(new MigLayout("", "[grow][][][]", "[]"));
		
		JButton btnCancelar = new JButton("Cancelar");
		transparentPanelBotonera.add(btnCancelar, "cell 1 0");
		
		JButton btnVerPedido = new JButton("Ver Pedido");
		transparentPanelBotonera.add(btnVerPedido, "cell 2 0");
		
		JButton btnFacturar = new JButton("Facturar");
		transparentPanelBotonera.add(btnFacturar, "cell 3 0");
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
