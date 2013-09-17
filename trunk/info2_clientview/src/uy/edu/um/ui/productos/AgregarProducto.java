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

public class AgregarProducto extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtIngreseValorNumerico;

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

		//Meti mano
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.DARK_GRAY);
		setJMenuBar(menuBar);
		
		JMenu mnProductos = new JMenu("Productos");
		mnProductos.setBackground(Color.DARK_GRAY);
		menuBar.add(mnProductos);
		
		JMenuItem mntmAgregarNuevo = new JMenuItem("Agregar Nuevo");
		mnProductos.add(mntmAgregarNuevo);
		
		JMenuItem mntmEditar = new JMenuItem("Editar");
		mnProductos.add(mntmEditar);
		
		JMenuItem mntmListado = new JMenuItem("Listado");
		mnProductos.add(mntmListado);
		
		JMenuItem mntmEliminar = new JMenuItem("Eliminar");
		mnProductos.add(mntmEliminar);
		JMenu menuOpciones = new JMenu("Opciones Usuario");
		menuOpciones.setForeground(Color.BLACK);
		menuOpciones.setBackground(Color.DARK_GRAY);
		menuBar.add(menuOpciones);
		JMenuItem menuSalir = new JMenuItem("Salir");
		menuSalir.setForeground(Color.BLACK);
		menuSalir.setBackground(Color.RED);
		menuSalir.addActionListener(this);
		
		JMenuItem mntmAgregarUsuarios = new JMenuItem("Agregar Usuarios");
		menuOpciones.add(mntmAgregarUsuarios);
		
		JMenuItem mntmVerListaUsuarios = new JMenuItem("Ver Lista Usuarios");
		menuOpciones.add(mntmVerListaUsuarios);
		
		JMenuItem mntmEliminarUsuarios = new JMenuItem("Eliminar Usuarios");
		menuOpciones.add(mntmEliminarUsuarios);
		menuOpciones.add(menuSalir);
		

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new MigLayout("", "[][grow]", "[grow][][][][grow]"));

		JLabel lblDescripcion = new JLabel("Nombre");
		lblDescripcion.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		panel_1.add(lblDescripcion, "cell 0 1,alignx left,aligny center");

		textField = new JTextField();
		textField.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		panel_1.add(textField, "cell 1 1,growx");
		textField.setColumns(10);

		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		panel_1.add(lblPrecio, "cell 0 2,alignx left,aligny center");

		txtIngreseValorNumerico = new JTextField();
		txtIngreseValorNumerico.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtIngreseValorNumerico.setToolTipText("Ingrese Valor Numerico\n");
		panel_1.add(txtIngreseValorNumerico, "cell 1 2,growx");
		txtIngreseValorNumerico.setColumns(10);

		JLabel lblDescripcion_1 = new JLabel("Descripcion");
		lblDescripcion_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		panel_1.add(lblDescripcion_1, "cell 0 3,alignx trailing,aligny center");

		JTextField textField_1 = new JTextField();
		textField_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		panel_1.add(textField_1, "cell 1 3,growx");
		textField_1.setColumns(10);

		JPanel ZonaBotones = new JPanel();
		contentPane.add(ZonaBotones, BorderLayout.SOUTH);
		ZonaBotones.setLayout(new MigLayout("", "[grow][117px][117px]",
				"[29px]"));

		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		ZonaBotones.add(btnNewButton, "cell 1 0,growx,aligny center");

		JButton btnNewButton_1 = new JButton("Cancelar");
		ZonaBotones.add(btnNewButton_1, "cell 2 0,grow");

		JPanel ZonaWest = new JPanel();
		contentPane.add(ZonaWest, BorderLayout.WEST);
		ZonaWest.setLayout(new BorderLayout(0, 0));

		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(AgregarProducto.class
				.getResource("/uy/edu/um/imagenes/Logo.png")));
		ZonaWest.add(label, BorderLayout.CENTER);
		setFocusTraversalPolicy(new FocusTraversalOnArray(
				new Component[] { contentPane }));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
