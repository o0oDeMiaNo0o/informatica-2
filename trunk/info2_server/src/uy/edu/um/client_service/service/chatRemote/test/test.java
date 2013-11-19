package uy.edu.um.client_service.service.chatRemote.test;

import uy.edu.um.client_service.business.BusinessFacade;
import uy.edu.um.client_service.business.chat.entities.Chat;
import uy.edu.um.client_service.business.chat.intefaces.ChatMgt;
import uy.edu.um.exceptions.checks.NoDatabaseConnection;

public class test {
	public static void main(String[] args) throws NoDatabaseConnection{
		ChatMgt cmgt = BusinessFacade.getInstance().getChatMgt();
		String msj = "hola";
		boolean check = false;
		Chat chat = new Chat(msj,check);
		cmgt.enviarMensaje(chat);
	}
}
