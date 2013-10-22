package uy.edu.um.services.bill.interfaces;

import java.util.ArrayList;

import uy.edu.um.value_object.bill.BillVO;
import uy.edu.um.value_object.oreder.OrderVO;
import uy.edu.um.value_object.people.client.ClientVO;
import uy.edu.um.value_object.people.waiters.WaiterVO;

public interface BillMgt {

	public BillVO createBillVO(ArrayList<OrderVO> orders, ClientVO c, WaiterVO w);

	public void addBillVO(BillVO b);

}
