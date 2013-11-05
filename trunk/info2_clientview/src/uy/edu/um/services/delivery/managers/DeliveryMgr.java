package uy.edu.um.services.delivery.managers;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import uy.edu.um.interfaces.delivery.DeliveryRemoteMgt;
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
	public void addDelivery(DeliveryVO d) {
		try {

			String sObjectService = "DeliveryRemoteMgr";

			Registry oRegitry = LocateRegistry.getRegistry(1099);

			DeliveryRemoteMgt oDeliveryRemoteMgt = (DeliveryRemoteMgt) oRegitry
					.lookup(sObjectService);

			oDeliveryRemoteMgt.addDelivery(d);

			//System.out.println("articulo agregado");

		} catch (Exception e) {
			System.err.println("error:");
			e.printStackTrace();

		}

	}

	@Override
	public void enViaje(DeliveryVO d) {
		try {

			String sObjectService = "DeliveryRemoteMgr";

			Registry oRegitry = LocateRegistry.getRegistry(1099);

			DeliveryRemoteMgt oDeliveryRemoteMgt = (DeliveryRemoteMgt) oRegitry
					.lookup(sObjectService);

			oDeliveryRemoteMgt.enViaje(d);

			//System.out.println("articulo agregado");

		} catch (Exception e) {
			System.err.println("error:");
			e.printStackTrace();

		}
	}

	@Override
	public void facturado(DeliveryVO d) {
		try {

			String sObjectService = "DeliveryRemoteMgr";

			Registry oRegitry = LocateRegistry.getRegistry(1099);

			DeliveryRemoteMgt oDeliveryRemoteMgt = (DeliveryRemoteMgt) oRegitry
					.lookup(sObjectService);

			oDeliveryRemoteMgt.facturado(d);

			//System.out.println("articulo agregado");

		} catch (Exception e) {
			System.err.println("error:");
			e.printStackTrace();

		}
	}


	@Override
	public void isDone(DeliveryVO d) {
		try {

			String sObjectService = "DeliveryRemoteMgr";

			Registry oRegitry = LocateRegistry.getRegistry(1099);

			DeliveryRemoteMgt oDeliveryRemoteMgt = (DeliveryRemoteMgt) oRegitry
					.lookup(sObjectService);

			oDeliveryRemoteMgt.listo(d);

			//System.out.println("articulo agregado");

		} catch (Exception e) {
			System.err.println("error:");
			e.printStackTrace();

		}
	}

	@Override
	public void isPreparing(DeliveryVO d) {
		try {

			String sObjectService = "DeliveryRemoteMgr";

			Registry oRegitry = LocateRegistry.getRegistry(1099);

			DeliveryRemoteMgt oDeliveryRemoteMgt = (DeliveryRemoteMgt) oRegitry
					.lookup(sObjectService);

			oDeliveryRemoteMgt.enPreparacion(d);

			//System.out.println("articulo agregado");

		} catch (Exception e) {
			System.err.println("error:");
			e.printStackTrace();

		}

	}

}
