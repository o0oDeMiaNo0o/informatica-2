package uy.edu.um.client_service.service.chatRemote.managers;

import java.rmi.RemoteException;
import java.util.ArrayList;

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
	public ArrayList<ChatVO> allChats() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarMensaje(ChatVO c) throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public void enviarMensaje(ChatVO c) throws RemoteException {
		// TODO Auto-generated method stub

	}

}
