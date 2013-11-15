package uy.edu.um.services.delivery.interfaces;

import java.util.ArrayList;
import java.util.Date;

import uy.edu.um.exceptions.checks.NoDatabaseConnection;
import uy.edu.um.exceptions.checks.NoServerConnectionException;
import uy.edu.um.value_object.articleOrder.ArticleOrderVO;
import uy.edu.um.value_object.delivery.DeliveryVO;
import uy.edu.um.value_object.user.UserVO;

public interface DeliveryMgt {

	public DeliveryVO createDeliveryVO(ArrayList<ArticleOrderVO> articles, Date time, UserVO user, String specs,
			int estado, boolean enCocina);

	public void addDelivery(DeliveryVO d)  throws NoServerConnectionException, NoDatabaseConnection;

	public void isPreparing(DeliveryVO d)  throws NoServerConnectionException, NoDatabaseConnection;

	public void isDone(DeliveryVO d) throws NoServerConnectionException, NoDatabaseConnection;

	public void enViaje(DeliveryVO d) throws NoServerConnectionException, NoDatabaseConnection;

	public void facturado(DeliveryVO d) throws NoServerConnectionException, NoDatabaseConnection;

	public ArrayList<DeliveryVO> allDeliveries() throws NoServerConnectionException, NoDatabaseConnection;
}
