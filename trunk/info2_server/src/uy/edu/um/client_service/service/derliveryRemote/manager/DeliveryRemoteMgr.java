package uy.edu.um.client_service.service.derliveryRemote.manager;

import java.rmi.RemoteException;
import java.util.ArrayList;

import uy.edu.um.client_service.business.BusinessFacade;
import uy.edu.um.client_service.business.delivery.entities.Delivery;
import uy.edu.um.client_service.business.delivery.interfaces.DeliveryMgt;
import uy.edu.um.exceptions.checks.NoDatabaseConnection;
import uy.edu.um.interfaces.delivery.DeliveryRemoteMgt;
import uy.edu.um.value_object.delivery.DeliveryVO;

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
	public void addDelivery(DeliveryVO o) throws RemoteException, NoDatabaseConnection {
		DeliveryMgt dMgt = BusinessFacade.getInstance().getDeliveryMgt();
		Delivery toAdd = dMgt.getDelivery(o);
		dMgt.addDelivery(toAdd);
	}

	@Override
	public void enViaje(DeliveryVO o) throws RemoteException {
		DeliveryMgt dMgt = BusinessFacade.getInstance().getDeliveryMgt();
		Delivery enViaje = dMgt.getDelivery(o);
	}

	@Override
	public void facturado(DeliveryVO o) throws RemoteException {
		// TODO Auto-generated method stub

	}


	@Override
	public void rejected(DeliveryVO o) throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public void enPreparacion(DeliveryVO o) throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public void listo(DeliveryVO o) throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<DeliveryVO> allDeliveries() throws RemoteException,
			NoDatabaseConnection {
		DeliveryMgt dMgt = BusinessFacade.getInstance().getDeliveryMgt();
		return dMgt.allDeliveries();
	}



}
