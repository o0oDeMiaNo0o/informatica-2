package uy.edu.um.services.chat.managers;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import uy.edu.um.exceptions.checks.NoServerConnectionException;
import uy.edu.um.interfaces.chat.ChatRemoteMgt;
import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.chat.interfaces.ChatMgt;
import uy.edu.um.value_object.chat.ChatVO;

public class ChatMgr implements ChatMgt{

	private static ChatMgr instance = null;

	private ChatMgr(){}

	public static ChatMgt getInstance() {
		if(instance == null){
			instance = new ChatMgr();
		}
		return instance;
	}
	@Override
	public void addChat(ChatVO c) throws NoServerConnectionException {
		try {
			String sObjectService = "ChatRemoteMgr";
			Registry oRegitry = LocateRegistry.getRegistry(ServiceFacade.getInstance().getHost(),ServiceFacade.getInstance().getPort());
			ChatRemoteMgt oChatRemoteMgt = (ChatRemoteMgt) oRegitry.lookup(sObjectService);
			oChatRemoteMgt.enviarMensaje(c);
		}catch (Exception e) {
			throw new  NoServerConnectionException("No hay conexion con el servidor, Cerrar el programa " +
					"y abrirlo nuevamente");
		}


	}

	@Override
	public void removeChat(ChatVO c) throws NoServerConnectionException {
		try {
			String sObjectService = "ChatRemoteMgr";
			Registry oRegitry = LocateRegistry.getRegistry(ServiceFacade.getInstance().getHost(),ServiceFacade.getInstance().getPort());
			ChatRemoteMgt oChatRemoteMgt = (ChatRemoteMgt) oRegitry.lookup(sObjectService);
			oChatRemoteMgt.eliminarMensaje(c);
		}catch (Exception e) {
			throw new  NoServerConnectionException("No hay conexion con el servidor, Cerrar el programa" +
					"y abrirlo nuevamente");
		}
	}

	@Override
	public ArrayList<ChatVO> allChats() {
		// TODO Auto-generated method stub
		return null;
	}


}
