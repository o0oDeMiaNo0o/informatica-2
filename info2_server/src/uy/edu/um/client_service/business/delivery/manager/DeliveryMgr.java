package uy.edu.um.client_service.business.delivery.manager;

import java.util.ArrayList;

import uy.edu.um.client_service.business.BusinessFacade;
import uy.edu.um.client_service.business.articleOrder.entities.ArticleOrder;
import uy.edu.um.client_service.business.articleOrder.interfaces.ArticleOrderMgt;
import uy.edu.um.client_service.business.delivery.entities.Delivery;
import uy.edu.um.client_service.business.delivery.interfaces.DeliveryMgt;
import uy.edu.um.client_service.business.users.entities.User;
import uy.edu.um.client_service.business.users.interfaces.UserMgt;
import uy.edu.um.client_service.persistance.DAO.delivery.DeliveryDAO;
import uy.edu.um.exceptions.checks.NoDatabaseConnection;
import uy.edu.um.value_object.articleOrder.ArticleOrderVO;
import uy.edu.um.value_object.delivery.DeliveryVO;
import uy.edu.um.value_object.user.UserVO;

public class DeliveryMgr implements DeliveryMgt{

	private static DeliveryMgr instance = null;

	private DeliveryMgr(){}

	public static DeliveryMgr getInstance(){
		if(instance == null){
			instance = new DeliveryMgr();
		}
		return instance;
	}

	@Override
	public void addDelivery(Delivery d) throws NoDatabaseConnection {
		DeliveryDAO dao = DeliveryDAO.getInstance();
		dao.addDelivery(d);
	}

	@Override
	public void enPreparacion(Delivery d) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enViaje(Delivery d) {
		// TODO Auto-generated method stub

	}

	@Override
	public void facturado(Delivery d) {
		// TODO Auto-generated method stub

	}

	@Override
	public void rechazado(Delivery d) {
		// TODO Auto-generated method stub

	}

	@Override
	public Delivery getDelivery(DeliveryVO d) {
		//managers
		ArticleOrderMgt oMgt = BusinessFacade.getInstance().getArticleOrder();
		UserMgt uMgt = BusinessFacade.getInstance().getUserMgt();

		ArrayList<ArticleOrderVO> articlesVO = d.getArticulos();
		ArrayList<ArticleOrder> articles = new ArrayList<ArticleOrder>(10);
		for(ArticleOrderVO a : articlesVO){
			if(a!=null){
				ArticleOrder oAdd = oMgt.getArticleOrder(a);
				articles.add(oAdd);
			}
		}
		User uAdd = uMgt.getUser(d.getUser());
		String specs = d.getSpecs();
		int estado = d.getEstado();
		boolean enCocina = d.isEnCocina();
		Delivery toReturn = new Delivery(articles,uAdd,d.getTime(),specs,estado,enCocina);
		return toReturn;
	}

	@Override
	public DeliveryVO getDeliveryVO(Delivery d) {
		//managers
		ArticleOrderMgt oMgt = BusinessFacade.getInstance().getArticleOrder();
		UserMgt uMgt = BusinessFacade.getInstance().getUserMgt();
		ArrayList<ArticleOrder> articles = d.getArticles();
		ArrayList<ArticleOrderVO> articlesAdd = new ArrayList<ArticleOrderVO>(10);
		for(ArticleOrder a : articles){
			if(a!=null){
				ArticleOrderVO aAdd = oMgt.getArticleOrderVO(a);
				articlesAdd.add(aAdd);
			}
		}
		UserVO uAdd = uMgt.getUserVO(d.getUser());
		return new DeliveryVO(articlesAdd,d.getTime(),uAdd,d.getSpecs(),d.getEstado(),d.isEnCocina());
	}

	@Override
	public ArrayList<DeliveryVO> allDeliveries() throws NoDatabaseConnection {
		DeliveryMgt dMgt = BusinessFacade.getInstance().getDeliveryMgt();
		DeliveryDAO dao = DeliveryDAO.getInstance();
		ArrayList<Delivery> allDeliveries = new ArrayList<Delivery>(2);
		ArrayList<DeliveryVO> toReturn = new ArrayList<DeliveryVO>(1);
		allDeliveries = dao.getDeliverys();
		for(Delivery d : allDeliveries){
			if(d!=null){
				DeliveryVO toAdd = dMgt.getDeliveryVO(d);
				toReturn.add(toAdd);
			}
		}
		return toReturn;
	}



}
