package uy.edu.um.client_service.persistance.DAO.bill;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import uy.edu.um.client_service.business.articleOrder.entities.ArticleOrder;
import uy.edu.um.client_service.business.bill.entities.Bill;
import uy.edu.um.client_service.business.order.entities.Order;
import uy.edu.um.client_service.persistance.DatabaseConnectionMgr;
import uy.edu.um.exceptions.checks.NoDatabaseConnection;

public class BillDAO {

	private static BillDAO instance = null;
	private final static Logger log = Logger.getLogger(BillDAO.class);
	
	public static BillDAO getInstance(){
		if (instance==null){
			instance = new BillDAO();
		}
		return instance;
	}
	
	@SuppressWarnings("null")
	public void addBill(Bill b) throws NoDatabaseConnection{
		Connection con = null;
		log.info("Intento de agregar una factura");
		
		try{
			con = DatabaseConnectionMgr.getInstance().getConnection();
			ArrayList <Order> ordenes = b.getOrders();
			ArrayList <ArticleOrder> articles = new ArrayList<ArticleOrder>();
			Statement oStatement = con.createStatement();
			oStatement.execute("INSERT INTO facturas (`Importe Total`,`Mesa_idMesa`,`Clientes_id`,`Clientes_Ci`) VALUES ("+b.getMontoTotal()+","+b.getTable().getNumero()+","+b.getClient().getId()+","+b.getClient().getCi()+");");
			
			
			for(Order o : ordenes){
				ArrayList<ArticleOrder> art = o.getArticles();
				for(ArticleOrder ao : art){
					articles.add(ao);
				}
			}
			
			for(int i =0;i<articles.size();i++){
				ResultSet oResultSet1 = oStatement.executeQuery("SELECT ID FROM ARTICLES WHERE (ARTICLES.NAME='"+articles.get(i).getArticle().getNombre()+"') AND (ARTICLES.Estado='Activo');");
				int nId= 0;
				while(oResultSet1.next()){
					nId = oResultSet1.getInt(1);
				}
				BigDecimal precio=(articles.get(i).getArticle().getPrecio());
				BigDecimal cant= new BigDecimal(articles.get(i).getCantidad());
				BigDecimal precioTotal = precio.multiply(cant);
				oStatement.execute("INSERT INTO `Linea de Factura` (Facturas_idFacturas, Articles_ID,Cantidad,`Precio Unitario`,`Precio Total`) VALUES (LAST_INSERT_ID(),"+nId+","+articles.get(i).getCantidad()+","+precio+","+precioTotal+");");
			}
			
			oStatement.close();
			log.info("Factura agregada");
		}
		catch(SQLException e){
			log.error("Error al agregar la factura");
			throw new NoDatabaseConnection("No hay conexion con la base de datos");	
		}
		finally{
			if (con != null) {

				try {

					con.close();

				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
		}
		}
		}
	
	
	
	
	}
	
	
	
	

