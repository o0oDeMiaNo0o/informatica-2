package uy.edu.um.client_service.business.chat.managers;

import java.util.ArrayList;

import uy.edu.um.client_service.business.chat.entities.Chat;
import uy.edu.um.client_service.business.chat.intefaces.ChatMgt;
import uy.edu.um.client_service.persistance.DAO.chatDAO.ChatDAO;
import uy.edu.um.exceptions.checks.NoDatabaseConnection;
import uy.edu.um.value_object.chat.ChatVO;

public class ChatMgr implements ChatMgt{

	private static ChatMgt instance = null;

	private ChatMgr(){}

	public static ChatMgt getInstance(){
		if(instance == null){
			instance = new ChatMgr();
		}
		return instance;
	}

	@Override
	public void borrarMensaje(Chat c) throws NoDatabaseConnection {
		ChatDAO dao = ChatDAO.getInstance();
		dao.setEntregado(c);
	}

	@Override
	public void enviarMensaje(Chat c) throws NoDatabaseConnection {
		ChatDAO dao = ChatDAO.getInstance();
		dao.addMsj(c);

	}

	@Override
	public Chat getChat(ChatVO c) {
		String msj = c.getMensaje();
		boolean cocina = c.isCocina();
		return new Chat(msj,cocina);
	}

	@Override
	public ChatVO getChatVO(Chat c) {
		String msg = c.getMsj();
		boolean cocina = c.isCocina();
		return new ChatVO(msg,cocina);
	}

	@Override
	public ArrayList<ChatVO> allChats() throws NoDatabaseConnection {
		ChatDAO dao = ChatDAO.getInstance();
		ArrayList<Chat> allChats = dao.getChat();
		ArrayList<ChatVO> toReturn = new ArrayList<ChatVO>(1);
		for(Chat c: allChats){
			if(c!=null){
				ChatVO toAdd = getChatVO(c);
				toReturn.add(toAdd);
			}
		}
		return toReturn;
	}



}
