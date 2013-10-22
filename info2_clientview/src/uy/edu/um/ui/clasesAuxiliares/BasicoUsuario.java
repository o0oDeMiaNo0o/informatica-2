package uy.edu.um.ui.clasesAuxiliares;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.border.EmptyBorder;

import uy.edu.um.imagenes.DirLocal;
import uy.edu.um.ui.productos.NewCategory;
import uy.edu.um.ui.productos.NewProduct;
import uy.edu.um.ui.usuarios.CajaPrincipal;
import uy.edu.um.ui.usuarios.Mesas;
import uy.edu.um.ui.usuarios.NewCliente;
import uy.edu.um.ui.usuarios.Pedidos;

public class BasicoUsuario extends JFrame {

	public ImagePanel contentPane;
	public URL DirFondo = DirLocal.class.getResource("Fondo2.jpg");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BasicoUsuario frame = new BasicoUsuario();
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
	public BasicoUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setExtendedState(Frame.MAXIMIZED_BOTH);

		contentPane = new ImagePanel(DirFondo);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		// Menu Opciones
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.DARK_GRAY);
		setJMenuBar(menuBar);

		JMenu menuUsuario = new JMenu("Opciones Usuario");
		menuUsuario.setForeground(Color.BLACK);
		menuUsuario.setBackground(Color.DARK_GRAY);
		menuBar.add(menuUsuario);

		JMenuItem mntmAgregarNuevo = new JMenuItem("Agregar Nuevo");
		menuUsuario.add(mntmAgregarNuevo);

		JMenuItem mntmVerLista = new JMenuItem("Ver Lista");
		menuUsuario.add(mntmVerLista);

		JMenuItem mntmEliminar = new JMenuItem("Eliminar");
		menuUsuario.add(mntmEliminar);

		JMenuItem menuItem_7 = new JMenuItem("Salir");
		menuItem_7.setForeground(Color.BLACK);
		menuItem_7.setBackground(Color.RED);
		menuUsuario.add(menuItem_7);

		JMenu menuCaja = new JMenu("Caja");
		menuCaja.setBackground(Color.DARK_GRAY);
		menuCaja.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CajaPrincipal nuevo = new CajaPrincipal(null, null);
				nuevo.setVisible(true);
			}
		});
		menuBar.add(menuCaja);

		JMenuItem mntmVerMesas = new JMenuItem("Ver Mesas");
		mntmVerMesas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Mesas nuevo = new Mesas(null, null, null);
				nuevo.setVisible(true);
			}
		});
		menuCaja.add(mntmVerMesas);

		JMenuItem mntmPedidoLocal = new JMenuItem("Realizar Pedido");
		menuCaja.add(mntmPedidoLocal);

		JMenuItem mntmDelivery = new JMenuItem("Calcelar Pedido");
		menuCaja.add(mntmDelivery);

		JMenu menuMenus = new JMenu("Men\u00FAs");
		menuMenus.setBackground(Color.DARK_GRAY);
		menuBar.add(menuMenus);

		JMenuItem menuCategoria = new JMenuItem("Agregar Nueva Categoria");
		menuCategoria.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				NewCategory nuevo = new NewCategory();
				nuevo.setVisible(true);
			}
		});
		menuMenus.add(menuCategoria);

		JMenuItem menuItem = new JMenuItem("Agregar Nuevo Articulo");
		menuItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				NewProduct nuevo = new NewProduct();
				nuevo.setVisible(true);
			}
		});
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

		JMenuItem mntmVerCocina = new JMenuItem("Ver");
		mntmVerCocina.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Pedidos nuevo = new Pedidos(null);
				nuevo.setVisible(true);
			}
		});
		menuCocina.add(mntmVerCocina);

		JMenuItem mntmEnviarMensaje = new JMenuItem("Enviar Mensaje");
		menuCocina.add(mntmEnviarMensaje);

		JMenu mnClientes = new JMenu("Clientes");
		mnClientes.setBackground(Color.DARK_GRAY);
		menuBar.add(mnClientes);

		JMenuItem mntmAgregarCliente = new JMenuItem("Agregar Nuevo");
		mntmAgregarCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				NewCliente nuevo = new NewCliente();
				nuevo.setVisible(true);
			}
		});
		mnClientes.add(mntmAgregarCliente);

		JMenuItem mntmListadoClientes = new JMenuItem("Ver Lista");
		mnClientes.add(mntmListadoClientes);

		JMenuItem mntmEliminarCliente = new JMenuItem("Eliminar");
		mntmEliminarCliente.setBackground(Color.WHITE);
		mnClientes.add(mntmEliminarCliente);
	}

}
