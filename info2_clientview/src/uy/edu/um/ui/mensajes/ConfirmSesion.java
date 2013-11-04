package uy.edu.um.ui.mensajes;

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

import uy.edu.um.ui.CurrentUser;
import uy.edu.um.ui.Login;
import net.miginfocom.swing.MigLayout;

public class ConfirmSesion extends JDialog {

	private static String mensaje = "";
	private final JPanel contentPanel = new JPanel();
	private final JButton btnAceptar = new JButton("Aceptar");
	private final JButton btnCancelar = new JButton("Cancelar");

	public void setError(String a) {
		this.mensaje = a;
	}

	public ConfirmSesion(String mensaje, final JFrame ventana) {
		setResizable(false);
		setBounds(100, 100, 326, 107);
		this.setLocationRelativeTo(ventana.getContentPane());
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 326, 82);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(new MigLayout("", "[271px]", "[19px][29px]"));
		{
			JLabel lblMensaje = new JLabel(mensaje);
			lblMensaje.setBackground(new Color(248, 248, 255));
			lblMensaje.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			contentPanel
					.add(lblMensaje, "cell 0 0,alignx center,aligny center");
		}
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CurrentUser.setUser(null);
				Login nuevo = new Login();
				nuevo.setVisible(true);
				ventana.dispose();
				cerrar();
			}
		});
		contentPanel.add(btnAceptar, "flowx,cell 0 1,alignx center,aligny top");

		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cerrar();
			}
		});

		contentPanel.add(btnCancelar, "cell 0 1");
	}

	private void cerrar() {
		this.dispose();
	}
}
