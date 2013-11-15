package uy.edu.um.client_service.business.delivery.interfaces;

import java.util.ArrayList;

import uy.edu.um.client_service.business.delivery.entities.Delivery;
import uy.edu.um.exceptions.checks.NoDatabaseConnection;
import uy.edu.um.value_object.delivery.DeliveryVO;

public interface DeliveryMgt {

	public Delivery getDelivery(DeliveryVO d) ;

	public DeliveryVO getDeliveryVO(Delivery d) ;

	public void addDelivery(Delivery d)throws NoDatabaseConnection;

	public void enPreparacion(Delivery d)throws NoDatabaseConnection;

	public void enViaje(Delivery d)throws NoDatabaseConnection;

	public void rechazado(Delivery d)throws NoDatabaseConnection;

	public void facturado(Delivery d) throws NoDatabaseConnection;

	public ArrayList<DeliveryVO> allDeliveries() throws NoDatabaseConnection;

}
