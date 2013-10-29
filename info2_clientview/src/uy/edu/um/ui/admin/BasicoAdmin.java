package uy.edu.um.ui.admin;

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
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import net.miginfocom.swing.MigLayout;
import uy.edu.um.imagenes.DirLocal;
import uy.edu.um.ui.ConfirmSesion;
import uy.edu.um.ui.MensajeGenerico;
import uy.edu.um.ui.admin.edicion.NewProduct;
import uy.edu.um.ui.clasesAuxiliares.ImagePanel;
import uy.edu.um.ui.clasesAuxiliares.TransparentPanel;
import uy.edu.um.ui.cocina.Pedidos;
import uy.edu.um.ui.usuarios.NewCliente;

public class BasicoAdmin extends JFrame {

	public JPanel contentPane;
	private URL dirLogo = DirLocal.class.getResource("Logo.png");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BasicoAdmin frame = new BasicoAdmin();
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
	public BasicoAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setExtendedState(Frame.MAXIMIZED_BOTH);

		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		TransparentPanel transparentPanel = new TransparentPanel();
		contentPane.add(transparentPanel, BorderLayout.NORTH);
		transparentPanel.setLayout(new MigLayout("", "[100px,grow]", "[96px]"));

		ImagePanel imagePanel = new ImagePanel(dirLogo);
		transparentPanel
				.add(imagePanel, "cell 0 0,alignx center,aligny center");

		// Menu Opciones
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.DARK_GRAY);
		setJMenuBar(menuBar);

		JMenu menuArticle = new JMenu("Articulos");
		menuArticle.setBackground(Color.DARK_GRAY);
		menuBar.add(menuArticle);

		JMenuItem mntmNArticle = new JMenuItem("Nuevo Articulo");
		mntmNArticle.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				NewProduct nuevo = new NewProduct();
				nuevo.setVisible(true);
			}
		});

		menuArticle.add(mntmNArticle);

		JMenuItem mntmEditarArticulo = new JMenuItem("Editar Articulo");
		menuArticle.add(mntmEditarArticulo);

		JMenuItem mntmVer = new JMenuItem("Ver Articulos");
		menuArticle.add(mntmVer);

		JMenuItem mntmEArticle = new JMenuItem("Eliminar Articulo");
		menuArticle.add(mntmEArticle);

		JMenu mnCategorias = new JMenu("Categorias");
		mnCategorias.setBackground(Color.DARK_GRAY);
		menuBar.add(mnCategorias);

		JMenuItem menuItem_1 = new JMenuItem("Nueva Categor\u00EDa");
		mnCategorias.add(menuItem_1);

		JMenuItem mntmEditarCategora = new JMenuItem("Editar Categor\u00EDa");
		mnCategorias.add(mntmEditarCategora);

		JMenuItem mntmVerCategorias = new JMenuItem("Ver Categor\u00EDas");
		mnCategorias.add(mntmVerCategorias);

		JMenuItem menuItem_3 = new JMenuItem("Eliminar Categor\u00EDa");
		mnCategorias.add(menuItem_3);

		JMenu menuMesas = new JMenu("Mesas");
		menuMesas.setBackground(Color.DARK_GRAY);
		menuBar.add(menuMesas);

		JMenuItem mntmVerCocina = new JMenuItem("Ver Mesas");
		mntmVerCocina.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				Pedidos nuevo = new Pedidos(null);
				nuevo.setVisible(true);
			}
		});

		JMenuItem mntmNuevaMesa = new JMenuItem("Nueva Mesa");
		menuMesas.add(mntmNuevaMesa);
		menuMesas.add(mntmVerCocina);

		JMenuItem mntmEnviarMensaje = new JMenuItem("Eliminar Mesa");
		menuMesas.add(mntmEnviarMensaje);

		JMenu Usuarios = new JMenu("Usuarios");
		Usuarios.setBackground(Color.DARK_GRAY);
		menuBar.add(Usuarios);

		JMenuItem mntmNuevoUsuario = new JMenuItem("Nuevo Usuario");
		Usuarios.add(mntmNuevoUsuario);

		JMenuItem mntmEditarUsuario = new JMenuItem("Editar Usuario");
		Usuarios.add(mntmEditarUsuario);

		JMenuItem mntmVerUsuarios = new JMenuItem("Ver Usuarios");
		Usuarios.add(mntmVerUsuarios);

		JMenuItem mntmEliminarUsuarios = new JMenuItem("Eliminar Usuarios");
		Usuarios.add(mntmEliminarUsuarios);

		JMenu mnClientes = new JMenu("Clientes");
		mnClientes.setBackground(Color.DARK_GRAY);
		menuBar.add(mnClientes);

		JMenuItem mntmAgregarCliente = new JMenuItem("Agregar Nuevo Cliente");
		mntmAgregarCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				NewCliente nuevo = new NewCliente();
				nuevo.setVisible(true);
				cerrar();
			}
		});
		mnClientes.add(mntmAgregarCliente);

		JMenuItem mntmEditarCliente = new JMenuItem("Editar Cliente");
		mnClientes.add(mntmEditarCliente);

		JMenuItem mntmListadoClientes = new JMenuItem("Ver Clientes");
		mnClientes.add(mntmListadoClientes);

		JMenuItem mntmEliminarCliente = new JMenuItem("Eliminar Cliente");
		mntmEliminarCliente.setBackground(Color.WHITE);
		mnClientes.add(mntmEliminarCliente);

		JMenu menuUsuario = new JMenu("Sesi\u00F3n");
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

	private JFrame ventana() {
		return this;
	}

	private void cerrar() {
		this.dispose();
	}

}
