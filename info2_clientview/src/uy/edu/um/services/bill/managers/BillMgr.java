package uy.edu.um.services.bill.managers;

import java.math.BigDecimal;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import uy.edu.um.exceptions.checks.NoDatabaseConnection;
import uy.edu.um.exceptions.checks.NoServerConnectionException;
import uy.edu.um.interfaces.bill.BillRemoteMgt;
import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.bill.interfaces.BillMgt;
import uy.edu.um.value_object.bill.BillVO;
import uy.edu.um.value_object.oreder.OrderVO;
import uy.edu.um.value_object.people.client.ClientVO;
import uy.edu.um.value_object.table.TableVO;

public class BillMgr implements BillMgt{

	private static BillMgr instance = null;

	private BillMgr(){}

	public static BillMgt getInstance() {
		if(instance == null){
			instance = new BillMgr();
		}
		return instance;
	}

	@Override
	public void addBillVO(BillVO b) throws NoServerConnectionException, NoDatabaseConnection {
		try {
			String host = ServiceFacade.getInstance().getHost();
			String sObjectService = "BillRemoteMgr";
			Registry oRegitry = LocateRegistry.getRegistry(host, ServiceFacade.getInstance().getPort());
			BillRemoteMgt oBillRemoteMgt = (BillRemoteMgt) oRegitry.lookup(sObjectService);
			oBillRemoteMgt.addBill(b);
		} catch (RemoteException e) {
			throw new  NoServerConnectionException("No hay conexion con el servidor, Cerrar el programa" +
					" y abrirlo nuevamente");
		} catch (NotBoundException e) {
			throw new  NoServerConnectionException("No hay conexion con el servidor, Cerrar el programa" +
			" y abrirlo nuevamente");
		}

	}

	@Override
	public BillVO createBillVO(ArrayList<OrderVO> orders, ClientVO c, TableVO t, BigDecimal montoTotal) {
		BillVO toReturn = new BillVO(orders,c,t,montoTotal);
		return toReturn;
	}

}

