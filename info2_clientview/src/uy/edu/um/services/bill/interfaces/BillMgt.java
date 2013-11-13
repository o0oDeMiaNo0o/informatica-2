package uy.edu.um.services.bill.interfaces;

import java.util.ArrayList;

import uy.edu.um.exceptions.checks.NoDatabaseConnection;
import uy.edu.um.exceptions.checks.NoServerConnectionException;
import uy.edu.um.value_object.bill.BillVO;
import uy.edu.um.value_object.oreder.OrderVO;
import uy.edu.um.value_object.people.client.ClientVO;
import uy.edu.um.value_object.table.TableVO;

public interface BillMgt {

	public BillVO createBillVO(ArrayList<OrderVO> orders, ClientVO c, TableVO t);

	public void addBillVO(BillVO b) throws NoServerConnectionException, NoDatabaseConnection;

}
