package uy.edu.um.interfaces.delivery;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import uy.edu.um.exceptions.checks.NoDatabaseConnection;
import uy.edu.um.value_object.delivery.DeliveryVO;

public interface DeliveryRemoteMgt extends Remote{

	public void addDelivery(DeliveryVO o) throws RemoteException, NoDatabaseConnection;

	public void enPreparacion(DeliveryVO o) throws RemoteException, NoDatabaseConnection;

	public void listo(DeliveryVO o) throws RemoteException, NoDatabaseConnection;

	public void facturado(DeliveryVO o) throws RemoteException, NoDatabaseConnection;

	public void rejected(DeliveryVO o) throws RemoteException, NoDatabaseConnection;

	public void enViaje(DeliveryVO o) throws RemoteException, NoDatabaseConnection;

	public ArrayList<DeliveryVO> allDeliveries() throws RemoteException, NoDatabaseConnection;
}
