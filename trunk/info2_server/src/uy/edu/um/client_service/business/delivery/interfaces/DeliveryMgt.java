package uy.edu.um.client_service.business.delivery.interfaces;

import uy.edu.um.client_service.business.delivery.entities.Delivery;
import uy.edu.um.value_object.delivery.DeliveryVO;

public interface DeliveryMgt {

	public Delivery getDelivery(DeliveryVO d);

	public DeliveryVO getDeliveryVO(Delivery d);

	public void addDelivery(Delivery d);

	public void enPreparacion(Delivery d);

	public void enViaje(Delivery d);

	public void rechazado(Delivery d);

	public void facturado(Delivery d);

}
