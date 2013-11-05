package uy.edu.um.interfaces.delivery;

import java.rmi.Remote;
import java.rmi.RemoteException;

import uy.edu.um.value_object.delivery.DeliveryVO;

public interface DeliveryRemoteMgt extends Remote{

	public void addDelivery(DeliveryVO o) throws RemoteException;

	public void enPreparacion(DeliveryVO o) throws RemoteException;

	public void listo(DeliveryVO o) throws RemoteException;

	public void facturado(DeliveryVO o) throws RemoteException;

	public void rejected(DeliveryVO o) throws RemoteException;

	public void enViaje(DeliveryVO o) throws RemoteException;
}
