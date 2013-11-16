package uy.edu.um.services.chat.interfaces;

import java.util.ArrayList;

import uy.edu.um.exceptions.checks.NoServerConnectionException;
import uy.edu.um.value_object.chat.ChatVO;

public interface ChatMgt {

	public void addChat(ChatVO c) throws NoServerConnectionException;
	public void removeChat(ChatVO c) throws NoServerConnectionException;
	public ArrayList<ChatVO> allChats()throws NoServerConnectionException;
}
