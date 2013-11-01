package uy.edu.um.client_service.service.derliveryRemote.manager;

import java.rmi.RemoteException;

import uy.edu.um.interfaces.delivery.DeliveryRemoteMgt;
import uy.edu.um.value_object.oreder.OrderVO;

public class DeliveryRemoteMgr implements DeliveryRemoteMgt{

	private static DeliveryRemoteMgr instance = null;

	private DeliveryRemoteMgr(){}

	public static DeliveryRemoteMgr getInstance(){
		if(instance == null){
			instance = new DeliveryRemoteMgr();
		}
		return instance;
	}

	@Override
	public void addOrder(OrderVO o) throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public void facturado(OrderVO o) throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public void isDone(OrderVO o) throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public void isPreaparing(OrderVO o) throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public void rejected(OrderVO o) throws RemoteException {
		// TODO Auto-generated method stub

	}

}
