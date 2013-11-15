package uy.edu.um.client_service.business.bill.interfaces;

import uy.edu.um.client_service.business.bill.entities.Bill;
import uy.edu.um.exceptions.checks.NoDatabaseConnection;
import uy.edu.um.value_object.bill.BillVO;

public interface BillMgt {

	public Bill getBill(BillVO b);

	public void addBill(Bill b) throws NoDatabaseConnection;

	public BillVO getBillVO(Bill b);

}
