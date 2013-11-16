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
import uy.edu.um.exceptions.checks.NoDatabaseConnection;
import uy.edu.um.exceptions.checks.NoServerConnectionException;
import uy.edu.um.imagenes.DirLocal;
import uy.edu.um.ui.admin.creacion.NewCategory;
import uy.edu.um.ui.admin.creacion.NewClientA;
import uy.edu.um.ui.admin.creacion.NewProduct;
import uy.edu.um.ui.admin.creacion.NewTable;
import uy.edu.um.ui.admin.creacion.NewUser;
import uy.edu.um.ui.admin.listas.CategoryList;
import uy.edu.um.ui.admin.listas.ClientList;
import uy.edu.um.ui.admin.listas.ProductList;
import uy.edu.um.ui.admin.listas.TableList;
import uy.edu.um.ui.admin.listas.UserList;
import uy.edu.um.ui.clasesAuxiliares.ImagePanel;
import uy.edu.um.ui.clasesAuxiliares.TransparentPanel;
import uy.edu.um.ui.mensajes.ConfirmSesion;
import uy.edu.um.ui.mensajes.MensajeGenerico;
import uy.edu.um.value_object.user.UserVO;

public class BasicoAdmin extends JFrame {

	public JPanel contentPane;
	private URL dirLogo = DirLocal.class.getResource("Logo.png");

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
				NewProduct nuevo = null;
				try {
					nuevo = new NewProduct();
					nuevo.setVisible(true);
					cerrar();
				} catch (NoServerConnectionException e) {
					MensajeGenerico nuevo1 = new MensajeGenerico(
							e.getMessage(), BasicoAdmin.this);
					nuevo1.setVisible(true);
				} catch (NoDatabaseConnection e) {
					MensajeGenerico nuevo1 = new MensajeGenerico(
							e.getMessage(), BasicoAdmin.this);
					nuevo1.setVisible(true);
				}

			}
		});

		menuArticle.add(mntmNArticle);

		JMenuItem mntmEditarArticulo = new JMenuItem("Editar/Eliminar");
		mntmEditarArticulo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				ProductList nuevo = null;
				try {
					nuevo = new ProductList();
					nuevo.setVisible(true);
					cerrar();
				} catch (NoServerConnectionException e) {
					MensajeGenerico nuevo1 = new MensajeGenerico(
							e.getMessage(), BasicoAdmin.this);
					nuevo1.setVisible(true);
				} catch (NoDatabaseConnection e) {
					MensajeGenerico nuevo1 = new MensajeGenerico(
							e.getMessage(), BasicoAdmin.this);
					nuevo1.setVisible(true);
				}
			}
		});
		menuArticle.add(mntmEditarArticulo);

		JMenu mnCategorias = new JMenu("Categorias");
		mnCategorias.setBackground(Color.DARK_GRAY);
		menuBar.add(mnCategorias);

		JMenuItem menuItem_1 = new JMenuItem("Nueva Categor\u00EDa");
		menuItem_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				NewCategory nuevo = new NewCategory();
				nuevo.setVisible(true);
				cerrar();
			}
		});
		mnCategorias.add(menuItem_1);

		JMenuItem menuItem_3 = new JMenuItem("Eliminar Categor\u00EDa");
		menuItem_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				CategoryList nuevo = null;
				try {
					nuevo = new CategoryList();
				} catch (NoDatabaseConnection e) {
					MensajeGenerico msg = new MensajeGenerico(e.getMessage(),
							BasicoAdmin.this);
					msg.setVisible(true);
				} catch (NoServerConnectionException e) {
					MensajeGenerico msg = new MensajeGenerico(e.getMessage(),
							BasicoAdmin.this);
					msg.setVisible(true);
				}
				nuevo.setVisible(true);
				cerrar();
			}
		});
		mnCategorias.add(menuItem_3);

		JMenu menuMesas = new JMenu("Mesas");
		menuMesas.setBackground(Color.DARK_GRAY);
		menuBar.add(menuMesas);

		JMenuItem mntmNuevaMesa = new JMenuItem("Nueva Mesa");
		mntmNuevaMesa.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				NewTable nueva = null;
				try {
					nueva = new NewTable();
					nueva.setVisible(true);
					cerrar();
				} catch (NoServerConnectionException e1) {
					MensajeGenerico nuevo1 = new MensajeGenerico(e1
							.getMessage(), BasicoAdmin.this);
					nuevo1.setVisible(true);
				} catch (NoDatabaseConnection e1) {
					MensajeGenerico nuevo1 = new MensajeGenerico(e1
							.getMessage(), BasicoAdmin.this);
					nuevo1.setVisible(true);
				}
			}
		});
		menuMesas.add(mntmNuevaMesa);

		JMenuItem mntmEnviarMensaje = new JMenuItem("Eliminar Mesa");
		mntmEnviarMensaje.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				TableList nuevo = null;
				try {
					nuevo = new TableList();
				} catch (NoServerConnectionException e1) {
					// TODO Auto-generated catch block
					MensajeGenerico nuevo1 = new MensajeGenerico(e1
							.getMessage(), BasicoAdmin.this);
					nuevo1.setVisible(true);
				} catch (NoDatabaseConnection e1) {
					// TODO Auto-generated catch block
					MensajeGenerico nuevo1 = new MensajeGenerico(e1
							.getMessage(), BasicoAdmin.this);
					nuevo1.setVisible(true);
				}
				nuevo.setVisible(true);
				cerrar();
			}
		});
		menuMesas.add(mntmEnviarMensaje);

		JMenu Usuarios = new JMenu("Usuarios");
		Usuarios.setBackground(Color.DARK_GRAY);
		menuBar.add(Usuarios);

		JMenuItem mntmNuevoUsuario = new JMenuItem("Nuevo Usuario");
		mntmNuevoUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				NewUser nuevo = new NewUser();
				nuevo.setVisible(true);
				cerrar();
			}
		});
		Usuarios.add(mntmNuevoUsuario);

		JMenuItem mntmEditarUsuario = new JMenuItem("Editar/Eliminar");
		mntmEditarUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				UserList nuevo = new UserList();
				nuevo.setVisible(true);
				cerrar();

			}
		});
		Usuarios.add(mntmEditarUsuario);

		JMenu mnClientes = new JMenu("Clientes");
		mnClientes.setBackground(Color.DARK_GRAY);
		menuBar.add(mnClientes);

		JMenuItem mntmAgregarCliente = new JMenuItem("Agregar Nuevo Cliente");
		mntmAgregarCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				NewClientA nuevo = new NewClientA();
				nuevo.setVisible(true);
				cerrar();
			}
		});
		mnClientes.add(mntmAgregarCliente);

		JMenuItem mntmEditarCliente = new JMenuItem("Editar/Eliminar Cliente");
		mntmEditarCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				ClientList nuevo = null;
				try {
					nuevo = new ClientList();
					nuevo.setVisible(true);
				} catch (NoServerConnectionException e) {
					MensajeGenerico nuevo1 = new MensajeGenerico(
							e.getMessage(), BasicoAdmin.this);
					nuevo1.setVisible(true);
				} catch (NoDatabaseConnection e) {
					MensajeGenerico nuevo1 = new MensajeGenerico(
							e.getMessage(), BasicoAdmin.this);
					nuevo1.setVisible(true);
				}
				cerrar();

			}
		});
		mnClientes.add(mntmEditarCliente);

		JMenu menuUsuario = new JMenu("Sesi\u00F3n");
		menuUsuario.setForeground(Color.BLACK);
		menuUsuario.setBackground(Color.DARK_GRAY);
		menuBar.add(menuUsuario);

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

	public void cerrar() {
		this.dispose();
	}

}
