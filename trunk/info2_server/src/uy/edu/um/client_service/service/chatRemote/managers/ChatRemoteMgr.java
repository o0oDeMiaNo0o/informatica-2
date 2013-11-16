package uy.edu.um.client_service.service.chatRemote.managers;

import java.rmi.RemoteException;
import java.util.ArrayList;

import uy.edu.um.client_service.business.BusinessFacade;
import uy.edu.um.client_service.business.chat.entities.Chat;
import uy.edu.um.client_service.business.chat.intefaces.ChatMgt;
import uy.edu.um.exceptions.checks.NoDatabaseConnection;
import uy.edu.um.interfaces.chat.ChatRemoteMgt;
import uy.edu.um.value_object.chat.ChatVO;

public class ChatRemoteMgr implements ChatRemoteMgt{

	private static ChatRemoteMgr instance = null;

	private ChatRemoteMgr(){};

	public static ChatRemoteMgt getInstance(){
		if(instance == null){
			instance = new ChatRemoteMgr();
		}
		return instance;
	}

	@Override
	public ArrayList<ChatVO> allChats() throws RemoteException, NoDatabaseConnection {
		ChatMgt cMgt = BusinessFacade.getInstance().getChatMgt();
		return cMgt.allChats();
	}

	@Override
	public void eliminarMensaje(ChatVO c) throws RemoteException, NoDatabaseConnection {
		ChatMgt cMgt = BusinessFacade.getInstance().getChatMgt();
		Chat toDelete = cMgt.getChat(c);
		cMgt.borrarMensaje(toDelete);

	}

	@Override
	public void enviarMensaje(ChatVO c) throws RemoteException, NoDatabaseConnection {
		ChatMgt cMgt = BusinessFacade.getInstance().getChatMgt();
		Chat toAdd = cMgt.getChat(c);
		cMgt.enviarMensaje(toAdd);
	}

}
