package uy.edu.um.client_service.business.chat.intefaces;

import java.util.ArrayList;

import uy.edu.um.client_service.business.chat.entities.Chat;
import uy.edu.um.value_object.chat.ChatVO;

public interface ChatMgt {

	public void enviarMensaje(Chat c);

	public void borrarMensaje(Chat c);

	public ArrayList<ChatVO> allChats();

	public Chat getChat(ChatVO c);

	public ChatVO getChatVO(Chat c);
}
