package uy.edu.um.client_service.service.derliveryRemote.test;

import java.util.ArrayList;

import uy.edu.um.client_service.business.BusinessFacade;
import uy.edu.um.client_service.business.delivery.interfaces.DeliveryMgt;
import uy.edu.um.client_service.persistance.DAO.delivery.DeliveryDAO;
import uy.edu.um.exceptions.checks.NoDatabaseConnection;
import uy.edu.um.value_object.delivery.DeliveryVO;

public class test2 {
	public static void main(String[] args) throws NoDatabaseConnection{
		DeliveryMgt dMgt = BusinessFacade.getInstance().getDeliveryMgt();
		ArrayList<DeliveryVO> deliv = new ArrayList<DeliveryVO>(2);
		deliv = dMgt.allDeliveries();
		int v = 345;
		System.out.println("");
	}
}
