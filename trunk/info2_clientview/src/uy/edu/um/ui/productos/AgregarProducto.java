package uy.edu.um.ui.productos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import uy.edu.um.ui.Confirmacion;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import uy.edu.um.ui.ClasesAuxiliares.TransparentPanel;

public class AgregarProducto extends JFrame implements ActionListener {

	private JPanel contentPane;
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
					AgregarProducto frame = new AgregarProducto();
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
	public AgregarProducto() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				AgregarProducto.class
						.getResource("/uy/edu/um/imagenes/Bernie's.png")));
		setForeground(Color.LIGHT_GRAY);
		setTitle("Ingreso Producto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);

		// Meti mano
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

		JMenuItem mntmPedidoLocal = new JMenuItem("Pedido Local");
		menuCaja.add(mntmPedidoLocal);

		JMenuItem mntmDelivery = new JMenuItem("Delivery");
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

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel ZonaWest = new JPanel();
		contentPane.add(ZonaWest, BorderLayout.WEST);
		ZonaWest.setLayout(new BorderLayout(0, 0));

		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(AgregarProducto.class
				.getResource("/uy/edu/um/imagenes/Logo.png")));
		ZonaWest.add(label, BorderLayout.CENTER);

		TransparentPanel transparentPanel = new TransparentPanel();
		contentPane.add(transparentPanel, BorderLayout.CENTER);

		JLabel label_1 = new JLabel("Nombre");
		label_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		contentPane.add(label_1, BorderLayout.NORTH);

		JLabel label_2 = new JLabel("Precio");
		label_2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		contentPane.add(label_2);

		textField_1 = new JTextField();
		textField_1.setToolTipText("Ingrese Valor Numerico\n");
		textField_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textField_1.setColumns(10);
		contentPane.add(textField_1);

		JLabel label_3 = new JLabel("Descripcion");
		label_3.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		contentPane.add(label_3);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textField_2.setColumns(10);
		contentPane.add(textField_2);

		textField = new JTextField();
		textField.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textField.setColumns(10);
		contentPane.add(textField, BorderLayout.EAST);
		setFocusTraversalPolicy(new FocusTraversalOnArray(
				new Component[] { contentPane }));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
