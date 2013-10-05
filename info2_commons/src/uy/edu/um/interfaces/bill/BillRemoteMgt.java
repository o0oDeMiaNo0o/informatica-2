package uy.edu.um.interfaces.bill;

import java.rmi.Remote;
import java.rmi.RemoteException;

import uy.edu.um.value_object.bill.BillVO;

public interface BillRemoteMgt extends Remote{

	public void addBill(BillVO b) throws RemoteException;
}
