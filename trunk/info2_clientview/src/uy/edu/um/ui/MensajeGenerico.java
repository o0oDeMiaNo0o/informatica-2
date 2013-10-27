package uy.edu.um.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

public class MensajeGenerico extends JDialog {

	private static String mensaje = "";
	private final JPanel contentPanel = new JPanel();
	private final JButton btnAceptar = new JButton("Aceptar");

	public void setError(String a) {
		this.mensaje = a;
	}

	public MensajeGenerico(String error, final JPanel contentPane) {
		setResizable(false);
		setBounds(100, 100, 326, 107);
		this.setLocationRelativeTo(contentPane);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 326, 82);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(new MigLayout("", "[271px]", "[19px][29px]"));
		{
			JLabel lblUsuarioYoContrasea = new JLabel(error);
			lblUsuarioYoContrasea.setBackground(new Color(248, 248, 255));
			lblUsuarioYoContrasea.setFont(new Font("Lucida Grande", Font.PLAIN,
					15));
			contentPanel.add(lblUsuarioYoContrasea,
					"cell 0 0,alignx center,aligny center");
		}
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				contentPane.setVisible(false);
				cerrar();
			}
		});
		contentPanel.add(btnAceptar, "cell 0 1,alignx center,aligny top");
	}

	private void cerrar() {
		this.setVisible(false);
	}
}
