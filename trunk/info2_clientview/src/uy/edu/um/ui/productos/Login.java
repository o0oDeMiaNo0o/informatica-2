package uy.edu.um.ui.productos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import uy.edu.um.ui.ClasesAuxiliares.ImagePanel;
import net.miginfocom.swing.MigLayout;
import uy.edu.um.ui.ClasesAuxiliares.TransparentPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private ImagePanel contentPane;
	private String DirFondo = "/Users/facundoliston/Documents/FACULTAD/UM/Informatica2/info2_clientview/src/uy/edu/um/imagenes/Fondo2.jpg";
	private JTextField Usuario;
	private JLabel lblContrasea;
	private JPasswordField passwordField;

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
		setBackground(new Color(0, 0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new ImagePanel(DirFondo);
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		TransparentPanel transparentPanel = new TransparentPanel();
		contentPane.add(transparentPanel, BorderLayout.CENTER);
		transparentPanel.setLayout(new MigLayout("", "[grow][][189.00][grow]", "[grow][][][grow]"));
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setForeground(new Color(255, 255, 255));
		transparentPanel.add(lblUsuario, "cell 1 1,alignx left");
		
		Usuario = new JTextField();
		transparentPanel.add(Usuario, "cell 2 1,grow");
		Usuario.setColumns(10);
		
		lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setForeground(new Color(255, 255, 255));
		transparentPanel.add(lblContrasea, "cell 1 2,alignx trailing");
		
		passwordField = new JPasswordField();
		transparentPanel.add(passwordField, "cell 2 2,grow");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

}
