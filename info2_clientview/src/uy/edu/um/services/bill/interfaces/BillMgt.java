package uy.edu.um.services.bill.interfaces;

import java.util.ArrayList;

import uy.edu.um.value_object.bill.BillVO;
import uy.edu.um.value_object.oreder.OrderVO;

public interface BillMgt {

	public BillVO createBillVO(ArrayList<OrderVO> orders);

	public void sendBillVO(BillVO b);

}
