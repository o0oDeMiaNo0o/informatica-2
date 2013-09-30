package uy.edu.um.interfaces.oreder;

import java.rmi.Remote;
import java.rmi.RemoteException;

import uy.edu.um.value_object.client.ClientVO;
import uy.edu.um.value_object.oreder.OrderVO;

public interface OrderRemoteMgt extends Remote{

	public void addOrder(OrderVO order) throws RemoteException;

	public void getOrdersClient(ClientVO c) throws RemoteException;

}

