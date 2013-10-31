package uy.edu.um.services.delivery.interfaces;

import uy.edu.um.value_object.delivery.DeliveryVO;

public interface DeliveryMgt {

	public void addOrder(DeliveryVO d);

	public void isPreparing(DeliveryVO d);

	public void isDone(DeliveryVO d);

	public void enViaje(DeliveryVO d);

	public void facturado(DeliveryVO d);
}
