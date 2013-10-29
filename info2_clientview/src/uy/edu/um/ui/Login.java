package uy.edu.um.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import uy.edu.um.imagenes.DirLocal;
import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.user.interfaces.UserMgt;
import uy.edu.um.ui.admin.MainAdmin;
import uy.edu.um.ui.clasesAuxiliares.ImagePanel;
import uy.edu.um.ui.clasesAuxiliares.TransparentPanel;
import uy.edu.um.ui.usuarios.MainUsuario;
import uy.edu.um.value_object.user.UserVO;

public class Login extends JFrame {

	private ImagePanel contentPane;
	private URL dirFondo = DirLocal.class.getResource("Fondo.png");
	private JTextField textField;
	private JPasswordField passwordField;
	private TransparentPanel transparentPanel_1;
	private JButton btnNewButton;
	private ArrayList<UserVO> listaUsers = cargaUsers();
	private UserVO user = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
		transparentPanel.add(passwordField, "cell 2 2,growx");

		transparentPanel_1 = new TransparentPanel();
		contentPane.add(transparentPanel_1, BorderLayout.SOUTH);
		transparentPanel_1
				.setLayout(new MigLayout("", "[117px,grow]", "[29px]"));

		btnNewButton = new JButton("Ingresar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String pass = conviertePass(passwordField.getPassword());
				System.out.println(pass);
				if (chequeaUser(textField.getText(), pass)) {
					if (user.isAdmin()) {
						MainAdmin nuevo = new MainAdmin(user);
						nuevo.setVisible(true);
						cerrar();
					} else {
						MainUsuario nuevo = new MainUsuario(user);
						nuevo.setVisible(true);
						cerrar();
					}
				}
			}

		});
		transparentPanel_1
				.add(btnNewButton, "cell 0 0,alignx right,aligny top");
	}

	// Metodos Auxiliares

	// Carga Users
	private ArrayList<UserVO> cargaUsers() {
		/*
		UserVO user = new UserVO("fmlg", "hola", false);
		ArrayList<UserVO> nuevo = new ArrayList<UserVO>();
		nuevo.add(user);
		return nuevo;
		 */
		
		UserMgt nuevo = ServiceFacade.getInstance().getUserMgt();
		return nuevo.allUsers();
	}

	// Chequea User
	private boolean chequeaUser(String usr, String psw) {
		for (int i = 0; i < listaUsers.size(); i++) {
			if ((listaUsers.get(i).getUser().equals(usr))
					&& (listaUsers.get(i).getPassword().equals(psw))) {
				user = listaUsers.get(i);
				return true;
			}
		}
		return false;
	}

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

}
