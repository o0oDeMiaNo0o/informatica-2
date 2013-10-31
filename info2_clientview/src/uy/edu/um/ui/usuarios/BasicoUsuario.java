package uy.edu.um.ui.usuarios;

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
import uy.edu.um.ui.ConfirmSesion;
import uy.edu.um.ui.clasesAuxiliares.ImagePanel;
import uy.edu.um.ui.cocina.Pedidos;
import uy.edu.um.value_object.user.UserVO;

public class BasicoUsuario extends JFrame {

	public ImagePanel contentPane;
	public URL DirFondo = DirLocal.class.getResource("Fondo.png");

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

		JMenu menuCaja = new JMenu("Caja");
		menuCaja.setBackground(Color.DARK_GRAY);
		menuBar.add(menuCaja);

		JMenuItem mntmVerMesas = new JMenuItem("Ver Mesas");
		mntmVerMesas.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				Mesas nuevo = new Mesas(null, null);
				nuevo.setVisible(true);
				cerrar();
			}
		});
		menuCaja.add(mntmVerMesas);

		JMenuItem mntmPedidoLocal = new JMenuItem("Caja Principal");
		mntmPedidoLocal.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				CajaPrincipal nuevo = new CajaPrincipal(null, null);
				nuevo.setVisible(true);
				cerrar();
			}
		});

		menuCaja.add(mntmPedidoLocal);

		JMenuItem mntmDelivery = new JMenuItem("Calcelar Pedido");
		menuCaja.add(mntmDelivery);

		JMenu menuCocina = new JMenu("Cocina");
		menuCocina.setBackground(Color.DARK_GRAY);
		menuBar.add(menuCocina);

		JMenuItem mntmVerCocina = new JMenuItem("Ver");
		mntmVerCocina.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				Pedidos nuevo = new Pedidos(null);
				nuevo.setVisible(true);
				cerrar();
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
			public void mousePressed(MouseEvent arg0) {
				NewClienteU nuevo = new NewClienteU();
				nuevo.setVisible(true);
				cerrar();
			}
		});
		mnClientes.add(mntmAgregarCliente);

		JMenuItem mntmListadoClientes = new JMenuItem("Ver Lista");
		mnClientes.add(mntmListadoClientes);

		JMenuItem mntmEliminarCliente = new JMenuItem("Eliminar");
		mntmEliminarCliente.setBackground(Color.WHITE);
		mnClientes.add(mntmEliminarCliente);

		JMenu menuUsuario = new JMenu("Sesi\u00F3n Usuario");
		menuUsuario.setForeground(Color.BLACK);
		menuUsuario.setBackground(Color.DARK_GRAY);
		menuBar.add(menuUsuario);

		JMenuItem mntmVerLista = new JMenuItem("Ver Info");
		menuUsuario.add(mntmVerLista);

		JMenuItem menuItem_7 = new JMenuItem("Salir");
		menuItem_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				ConfirmSesion nuevo = new ConfirmSesion("Desea Cerrar Sesion?",
						ventana());
				nuevo.setVisible(true);
			}
		});
		menuItem_7.setForeground(Color.BLACK);
		menuItem_7.setBackground(Color.RED);
		menuUsuario.add(menuItem_7);
	}

	// Metodos Auxiliares
	private JFrame ventana() {
		return this;
	}

	private void cerrar() {
		this.dispose();
	}

}
