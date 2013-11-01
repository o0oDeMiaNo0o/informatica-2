package uy.edu.um.client_service.business.delivery.interfaces;

import uy.edu.um.client_service.business.delivery.entities.Delivery;
import uy.edu.um.value_object.delivery.DeliveryVO;

public interface DeliveryMgt {

	public Delivery getDelivery(DeliveryVO d);

	public DeliveryVO getDeliveryVO(Delivery d);

	public void addDelivery(DeliveryVO d);

	public void enPreparacion(DeliveryVO d);

	public void enViaje(DeliveryVO d);

	public void rechazado(DeliveryVO d);

	public void facturado(DeliveryVO d);

}
