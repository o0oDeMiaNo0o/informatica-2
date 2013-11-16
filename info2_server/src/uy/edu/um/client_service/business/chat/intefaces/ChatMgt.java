package uy.edu.um.client_service.business.chat.intefaces;

import java.util.ArrayList;

import uy.edu.um.client_service.business.chat.entities.Chat;
import uy.edu.um.exceptions.checks.NoDatabaseConnection;
import uy.edu.um.value_object.chat.ChatVO;

public interface ChatMgt {

	public void enviarMensaje(Chat c) throws NoDatabaseConnection;

	public void borrarMensaje(Chat c) throws NoDatabaseConnection;

	public ArrayList<ChatVO> allChats() throws NoDatabaseConnection;

	public Chat getChat(ChatVO c);

	public ChatVO getChatVO(Chat c);
}
