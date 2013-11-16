package uy.edu.um.ui.usuarios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

import uy.edu.um.exceptions.checks.NoServerConnectionException;
import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.chat.interfaces.ChatMgt;
import uy.edu.um.ui.mensajes.MensajeChat;
import uy.edu.um.ui.mensajes.MensajeGenerico;
import uy.edu.um.value_object.chat.ChatVO;

public class ChatUsuarios {

	private Timer timer = null;

	private ChatUsuarios() {

		this.timer = new Timer(15000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChatMgt chat = ServiceFacade.getInstance().getChatMgt();
				ArrayList<ChatVO> aux = null;
				try {
					aux = chat.allChats();
				} catch (NoServerConnectionException e1) {
					MensajeGenerico msg = new MensajeGenerico(e1.getMessage(),
							null);
					msg.setVisible(true);
				}
				if (aux.size() != 0) {
					for (int i = 0; i < aux.size(); i++) {
						if (!aux.get(i).isCocina()) {
							MensajeChat msg = new MensajeChat(aux.get(i));
							msg.setVisible(true);
						}
					}
				}
			}

		});
	}
}
