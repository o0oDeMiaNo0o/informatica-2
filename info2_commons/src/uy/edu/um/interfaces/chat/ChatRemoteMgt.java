package uy.edu.um.interfaces.chat;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import uy.edu.um.value_object.chat.ChatVO;

public interface ChatRemoteMgt extends Remote{

	public void enviarMensaje(ChatVO c) throws RemoteException;

	public void eliminarMensaje(ChatVO c) throws RemoteException;

	public ArrayList<ChatVO> allChats() throws RemoteException;
}
