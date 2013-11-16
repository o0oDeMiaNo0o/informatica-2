package uy.edu.um.client_service;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import uy.edu.um.client_service.business.BusinessFacade;
import uy.edu.um.interfaces.article.ArticleRemoteMgt;
import uy.edu.um.interfaces.articleOrder.ArticleOrderRemoteMgt;
import uy.edu.um.interfaces.bill.BillRemoteMgt;
import uy.edu.um.interfaces.categories.CategoryRemoteMgt;
import uy.edu.um.interfaces.chat.ChatRemoteMgt;
import uy.edu.um.interfaces.oreder.OrderRemoteMgt;
import uy.edu.um.interfaces.people.clients.ClientRemoteMgt;
import uy.edu.um.interfaces.table.TableRemoteMgt;
import uy.edu.um.interfaces.user.UserRemoteMgt;

public class MainServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Inicializar COnexion a base de datos

		// Inicializar RMI

		try {
			Registry oRegistry = LocateRegistry.createRegistry(BusinessFacade.getInstance().getPort());

			// Componente de ordenes

			String name = "OrderRemoteMgr";

			OrderRemoteMgt oOrderRemoteMgr = BusinessFacade.getInstance().getOrderRemote();

			OrderRemoteMgt oStub = (OrderRemoteMgt) UnicastRemoteObject
					.exportObject((Remote) oOrderRemoteMgr, 0);

			oRegistry.rebind(name, oStub);

			//componente de categorias

			name = "CategoryRemoteMgr";

			CategoryRemoteMgt oCategoryRemoteMgr = BusinessFacade.getInstance().getCategoryRemote();

			CategoryRemoteMgt oStubCategory = (CategoryRemoteMgt) UnicastRemoteObject
					.exportObject((Remote) oCategoryRemoteMgr, 0);

			oRegistry.rebind(name, oStubCategory);


			// componente de articulos

			name = "ArticleRemoteMgr";

			ArticleRemoteMgt oArticleRemoteMgr = BusinessFacade.getInstance().getArticleRemote();

			ArticleRemoteMgt oStubArticle = (ArticleRemoteMgt) UnicastRemoteObject
					.exportObject((Remote) oArticleRemoteMgr, 0);

			oRegistry.rebind(name, oStubArticle);

			//componente de clientes

			name = "ClientRemoteMgr";

			ClientRemoteMgt oClientRemoteMgr = BusinessFacade.getInstance().getClientRemote();

			ClientRemoteMgt oStubClient = (ClientRemoteMgt) UnicastRemoteObject
					.exportObject((Remote) oClientRemoteMgr, 0);

			oRegistry.rebind(name, oStubClient);

			//comoponente de usuarios

			name = "UserRemoteMgr";

			UserRemoteMgt oUserRemoteMgr = BusinessFacade.getInstance().getUserRemote();

			UserRemoteMgt oStubUser = (UserRemoteMgt) UnicastRemoteObject
					.exportObject((Remote) oUserRemoteMgr, 0);

			oRegistry.rebind(name, oStubUser);

			//componente de facturas

			name = "BillRemoteMgr";

			BillRemoteMgt oBillRemoteMgr = BusinessFacade.getInstance().getBillRemote();

			BillRemoteMgt oStubBill = (BillRemoteMgt) UnicastRemoteObject
					.exportObject((Remote) oBillRemoteMgr, 0);

			oRegistry.rebind(name, oStubBill);

			//componente de mesas

			name = "TableRemoteMgr";

			TableRemoteMgt oTableRemoteMgr = BusinessFacade.getInstance().getTableRemote();

			TableRemoteMgt oStubTable = (TableRemoteMgt) UnicastRemoteObject
					.exportObject((Remote) oTableRemoteMgr, 0);

			oRegistry.rebind(name, oStubTable);

			//componente de articleOrder

			name = "ArticleOrderRemoteMgr";

			ArticleOrderRemoteMgt oArticleOrderRemoteMgr = BusinessFacade.getInstance().getArticleOrderRemote();

			ArticleOrderRemoteMgt oStubArticleOrder = (ArticleOrderRemoteMgt) UnicastRemoteObject
					.exportObject((Remote) oArticleOrderRemoteMgr, 0);

			oRegistry.rebind(name, oStubArticleOrder);

			//componente de articleOrder

			name = "ChatRemoteMgr";

			ChatRemoteMgt oChatRemoteMgr = BusinessFacade.getInstance().getChatRemote();

			ChatRemoteMgt oStubChat = (ChatRemoteMgt) UnicastRemoteObject
					.exportObject((Remote) oChatRemoteMgr, 0);

			oRegistry.rebind(name, oStubChat);


			System.out.println("Ready and waiting");
		} catch (Exception e) {
			System.err.println("error:");
			e.printStackTrace();
		}
	}

}
