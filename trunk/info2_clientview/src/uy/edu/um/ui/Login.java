package uy.edu.um.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import uy.edu.um.exceptions.checks.NoDatabaseConnection;
import uy.edu.um.exceptions.checks.NoServerConnectionException;
import uy.edu.um.imagenes.DirLocal;
import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.user.interfaces.UserMgt;
import uy.edu.um.ui.admin.MainAdmin;
import uy.edu.um.ui.clasesAuxiliares.ImagePanel;
import uy.edu.um.ui.clasesAuxiliares.TransparentPanel;
import uy.edu.um.ui.cocina.Cocina;
import uy.edu.um.ui.mensajes.MensajeGenerico;
import uy.edu.um.ui.usuarios.MainUsuario;
import uy.edu.um.value_object.user.UserVO;

public class Login extends JFrame {

	private ImagePanel contentPane;
	private URL dirFondo = DirLocal.class.getResource("Fondo.png");
	private JTextField textField;
	private JPasswordField passwordField;
	private TransparentPanel transparentPanel_1;
	private JButton btnNewButton;

	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new ImagePanel(dirFondo);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		TransparentPanel transparentPanel = new TransparentPanel();
		contentPane.add(transparentPanel, BorderLayout.CENTER);
		transparentPanel.setLayout(new MigLayout("", "[grow][][][grow]",
				"[grow][][][grow]"));

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setForeground(Color.WHITE);
		transparentPanel.add(lblUsuario, "cell 1 1,alignx trailing");

		textField = new JTextField();
		transparentPanel.add(textField, "cell 2 1,alignx center");
		textField.setColumns(10);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setForeground(Color.WHITE);
		transparentPanel.add(lblContrasea, "cell 1 2,alignx trailing");

		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(final KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					UserMgt nuevo = ServiceFacade.getInstance().getUserMgt();
					String pass = conviertePass(passwordField.getPassword());
					String nombre = textField.getText();
					try {
						if (nuevo.checkLogin(nombre, pass)) {
							UserVO user = nuevo.isUser(nombre);
							if (user.isAdmin()) {
								CurrentUser.setUser(user);
								MainAdmin nuevoVentana = new MainAdmin();
								nuevoVentana.setVisible(true);
								cerrar();
							} else {
								CurrentUser.setUser(user);
								MainUsuario nuevoVentana = new MainUsuario();
								nuevoVentana.setVisible(true);
								cerrar();
							}
						} else {
							MensajeGenerico msg = new MensajeGenerico(
									"Usuario y/o Contrase–a Incorrecto/s",
									Login.this);
							msg.setVisible(true);
						}
					} catch (NoServerConnectionException e) {
						MensajeGenerico nuevoFrame = new MensajeGenerico(e
								.getMessage(), devuelve());
						nuevoFrame.setVisible(true);
					}
				}
			}
		});
		transparentPanel.add(passwordField, "cell 2 2,growx");

		transparentPanel_1 = new TransparentPanel();
		contentPane.add(transparentPanel_1, BorderLayout.SOUTH);
		transparentPanel_1
				.setLayout(new MigLayout("", "[117px,grow]", "[29px]"));

		btnNewButton = new JButton("Ingresar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UserMgt nuevo = ServiceFacade.getInstance().getUserMgt();
				String pass = conviertePass(passwordField.getPassword());
				String nombre = textField.getText();
				if (nombre.equals("") && pass.equals("")) {
					Cocina cocina = null;
					try {
						cocina = new Cocina();
					} catch (NoDatabaseConnection e1) {
						// TODO Auto-generated catch block
						MensajeGenerico nuevo1 = new MensajeGenerico(e1
								.getMessage(), Login.this);
						nuevo1.setVisible(true);
					} catch (NoServerConnectionException e1) {
						// TODO Auto-generated catch block
						MensajeGenerico nuevo1 = new MensajeGenerico(e1
								.getMessage(), Login.this);
						nuevo1.setVisible(true);
					}
					cocina.setVisible(true);
					cerrar();
				} else {

					try {

						if (nuevo.checkLogin(nombre, pass)) {
							UserVO user = nuevo.isUser(nombre);
							if (user.isAdmin()) {
								CurrentUser.setUser(user);
								MainAdmin nuevoVentana = new MainAdmin();
								nuevoVentana.setVisible(true);
								cerrar();
							} else {
								CurrentUser.setUser(user);
								MainUsuario nuevoVentana = new MainUsuario();
								nuevoVentana.setVisible(true);
								cerrar();
							}
						} else {
							MensajeGenerico msg = new MensajeGenerico(
									"Usuario y/o Contrase–a Incorrectos",
									devuelve());
							msg.setVisible(true);
							passwordField.setText("");
							textField.setText("");
						}
					} catch (NoServerConnectionException e1) {
						MensajeGenerico msg = new MensajeGenerico(e1
								.getMessage(), devuelve());
						msg.setVisible(true);
					}
				}
			}
		});
		transparentPanel_1
				.add(btnNewButton, "cell 0 0,alignx right,aligny top");
	}

	// Metodos Auxiliares

	// Convierte password a String
	private String conviertePass(char[] password) {
		String psw = "";
		for (int i = 0; i < password.length; i++) {
			psw = psw + Character.toString(password[i]);
		}
		return psw;
	}

	private void cerrar() {
		this.dispose();
	}

	public JFrame devuelve() {
		return this;
	}
}
