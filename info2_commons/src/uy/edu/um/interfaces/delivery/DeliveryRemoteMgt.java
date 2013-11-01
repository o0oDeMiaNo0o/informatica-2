package uy.edu.um.interfaces.delivery;

import java.rmi.Remote;
import java.rmi.RemoteException;

import uy.edu.um.value_object.oreder.OrderVO;

public interface DeliveryRemoteMgt extends Remote{

	public void addOrder(OrderVO o) throws RemoteException;

	public void isPreaparing(OrderVO o) throws RemoteException;

	public void isDone(OrderVO o) throws RemoteException;

	public void facturado(OrderVO o) throws RemoteException;

	public void rejected(OrderVO o) throws RemoteException;
}
