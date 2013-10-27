package uy.edu.um.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import uy.edu.um.ui.usuarios.BasicoUsuario;

import java.awt.BorderLayout;

import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LogIn extends JFrame {
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn frame = new LogIn();
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
	public LogIn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(
				new MigLayout("", "[grow][][][grow]", "[grow][][][grow]"));

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setForeground(Color.WHITE);
		getContentPane().add(lblUsuario, "cell 1 1,alignx left");

		textField = new JTextField();
		getContentPane().add(textField, "cell 2 1,growx");
		textField.setColumns(10);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setForeground(Color.WHITE);
		getContentPane().add(lblContrasea, "cell 1 2,alignx trailing");

		passwordField = new JPasswordField();
		getContentPane().add(passwordField, "cell 2 2,growx");

		JButton btnNewButton = new JButton("Ingresar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

			}
		});
		getContentPane().add(btnNewButton, "cell 3 3,aligny top");
	}

}
