package uy.edu.um.interfaces.oreder;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import uy.edu.um.exceptions.checks.NoDatabaseConnection;
import uy.edu.um.value_object.oreder.OrderVO;
import uy.edu.um.value_object.people.client.ClientVO;
import uy.edu.um.value_object.table.TableVO;

public interface OrderRemoteMgt extends Remote{

	public void addOrder(OrderVO order) throws RemoteException, NoDatabaseConnection;

	public void getOrdersClient(ClientVO c) throws RemoteException;

	public ArrayList<OrderVO> allOrders() throws RemoteException, NoDatabaseConnection;

	public void entregado(OrderVO o) throws RemoteException, NoDatabaseConnection;

	public void enPreparacion(OrderVO o) throws RemoteException, NoDatabaseConnection;

	public void rechazado(OrderVO o) throws RemoteException, NoDatabaseConnection;

	public void delivery(OrderVO o) throws RemoteException, NoDatabaseConnection;

	public void terminada(OrderVO o) throws RemoteException, NoDatabaseConnection;

	public ArrayList<OrderVO> allOrdersTable(TableVO t) throws RemoteException, NoDatabaseConnection;

	public ArrayList<OrderVO> allDeliveries() throws RemoteException, NoDatabaseConnection;

}

