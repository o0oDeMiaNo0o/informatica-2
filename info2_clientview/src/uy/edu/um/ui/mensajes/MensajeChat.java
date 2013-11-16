package uy.edu.um.ui.mensajes;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import net.miginfocom.swing.MigLayout;
import uy.edu.um.exceptions.checks.NoServerConnectionException;
import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.chat.interfaces.ChatMgt;
import uy.edu.um.value_object.chat.ChatVO;

public class MensajeChat extends JFrame {

	private JPanel contentPane;

	public MensajeChat(final ChatVO mensaje) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][grow][]", "[][grow][]"));

		JTextPane textPane = new JTextPane();
		textPane.setText(mensaje.getMensaje());
		textPane.setBorder(new LineBorder(new Color(111, 102, 238), 2));
		contentPane.add(textPane, "cell 1 1,grow");

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ChatMgt chat = ServiceFacade.getInstance().getChatMgt();
				try {
					chat.removeChat(mensaje);
				} catch (NoServerConnectionException e1) {
					MensajeGenerico msg = new MensajeGenerico(e1.getMessage(),
							null);
					msg.setVisible(true);
				}
				MensajeChat.this.dispose();
			}
		});
		contentPane.add(btnAceptar, "cell 1 2,alignx center,aligny center");
	}

}
