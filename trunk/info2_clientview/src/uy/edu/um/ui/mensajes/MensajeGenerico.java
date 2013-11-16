package uy.edu.um.ui.mensajes;

import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.BoxLayout;

public class MensajeGenerico extends JDialog {

	private static String mensaje = "";
	private final JPanel contentPanel = new JPanel();
	private final JButton btnAceptar = new JButton("Aceptar");

	public void setError(String a) {
		this.mensaje = a;
	}

	public MensajeGenerico(String error, final JFrame jFrame) {
		setResizable(false);
		setBounds(100, 100, 400, 107);
		setMinimumSize(new Dimension(600, 150));
		if (jFrame != null) {
			this.setLocationRelativeTo(jFrame);
		}
		getContentPane().setLayout(
				new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(new MigLayout("", "[271px,grow]",
				"[grow][19px][29px,grow]"));
		{
			JLabel lblUsuarioYoContrasea = new JLabel(error);
			lblUsuarioYoContrasea.setBackground(new Color(248, 248, 255));
			lblUsuarioYoContrasea.setFont(new Font("Lucida Grande", Font.PLAIN,
					15));
			contentPanel.add(lblUsuarioYoContrasea,
					"cell 0 1,alignx center,aligny center");
		}
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cerrar();
			}
		});
		contentPanel.add(btnAceptar, "cell 0 2,alignx center,aligny bottom");
	}

	private void cerrar() {
		this.dispose();
	}
}
