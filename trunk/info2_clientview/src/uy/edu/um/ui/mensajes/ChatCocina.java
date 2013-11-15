package uy.edu.um.ui.mensajes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import uy.edu.um.value_object.user.UserVO;

public class ChatCocina {

	private Timer timer = null;

	private ChatCocina(UserVO user) {

		this.timer = new Timer(5000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (true) {
					MensajeGenerico msg = new MensajeGenerico(null, null);
					msg.setVisible(true);
				}
			}

		});
	}

}
