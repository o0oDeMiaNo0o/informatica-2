package uy.edu.um.interfaces.chat;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import uy.edu.um.exceptions.checks.NoDatabaseConnection;
import uy.edu.um.value_object.chat.ChatVO;

public interface ChatRemoteMgt extends Remote{

	public void enviarMensaje(ChatVO c) throws RemoteException, NoDatabaseConnection;

	public void eliminarMensaje(ChatVO c) throws RemoteException, NoDatabaseConnection;

	public ArrayList<ChatVO> allChats() throws RemoteException, NoDatabaseConnection;
}
