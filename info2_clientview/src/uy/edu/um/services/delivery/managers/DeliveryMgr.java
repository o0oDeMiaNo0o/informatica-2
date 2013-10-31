package uy.edu.um.services.delivery.managers;

import uy.edu.um.services.delivery.interfaces.DeliveryMgt;
import uy.edu.um.value_object.delivery.DeliveryVO;

public class DeliveryMgr implements DeliveryMgt{

	private static DeliveryMgr instance = null;

	private DeliveryMgr(){}

	public static DeliveryMgr getInstance(){
		if(instance == null){
			instance = new DeliveryMgr();
		}
		return instance;
	}

	@Override
	public void addOrder(DeliveryVO d) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enViaje(DeliveryVO d) {
		// TODO Auto-generated method stub

	}

	@Override
	public void facturado(DeliveryVO d) {
		// TODO Auto-generated method stub

	}

	@Override
	public void isDone(DeliveryVO d) {
		// TODO Auto-generated method stub

	}

	@Override
	public void isPreparing(DeliveryVO d) {
		// TODO Auto-generated method stub

	}

}
