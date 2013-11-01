package uy.edu.um.interfaces.oreder;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import uy.edu.um.value_object.oreder.OrderVO;
import uy.edu.um.value_object.people.client.ClientVO;

public interface OrderRemoteMgt extends Remote{

	public void addOrder(OrderVO order) throws RemoteException;

	public void getOrdersClient(ClientVO c) throws RemoteException;

	public ArrayList<OrderVO> allOrders() throws RemoteException;

	public void isReady(OrderVO o) throws RemoteException;

	public void isPreparing(OrderVO o) throws RemoteException;

	public void rejected(OrderVO o) throws RemoteException;

	public void delivery(OrderVO o) throws RemoteException;

}

