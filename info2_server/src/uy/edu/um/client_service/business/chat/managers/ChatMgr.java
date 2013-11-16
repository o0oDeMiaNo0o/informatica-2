package uy.edu.um.client_service.business.chat.managers;

import uy.edu.um.client_service.business.chat.intefaces.ChatMgt;

public class ChatMgr implements ChatMgt{

	private static ChatMgt instance = null;

	private ChatMgr(){}

	public static ChatMgt getInstance(){
		if(instance == null){
			instance = new ChatMgr();
		}
		return instance;
	}

}
