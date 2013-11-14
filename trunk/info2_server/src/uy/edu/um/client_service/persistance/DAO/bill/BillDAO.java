package uy.edu.um.client_service.persistance.DAO.bill;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import uy.edu.um.client_service.business.articleOrder.entities.ArticleOrder;
import uy.edu.um.client_service.business.bill.entities.Bill;
import uy.edu.um.client_service.business.order.entities.Order;
import uy.edu.um.client_service.persistance.DatabaseConnectionMgr;
import uy.edu.um.exceptions.checks.NoDatabaseConnection;

public class BillDAO {

	private static BillDAO instance = null;
	
	public static BillDAO getInstance(){
		if (instance==null){
			instance = new BillDAO();
		}
		return instance;
	}
	
	@SuppressWarnings("null")
	public void addBill(Bill b) throws NoDatabaseConnection{
		Connection con = null;
		
		try{
			con = DatabaseConnectionMgr.getInstance().getConnection();
			ArrayList <Order> ordenes = b.getOrders();
			ArrayList <ArticleOrder> articles = null;
			Statement oStatement = con.createStatement();
			oStatement.execute("INSERT INTO facturas (`Importe Total`,`Mesa_idMesa`,`Clientes_id`,`Clientes_Ci`) VALUES ("+b.getMontoTotal()+","+b.getTable().getNumero()+","+b.getClient().getId()+","+b.getClient().getCi()+");");
			
			
			for(int j=0;j<ordenes.size();j++){
				Order o = ordenes.get(j);
				int m=0;
				while(o.getArticles().get(m)!=null){
					articles.add(o.getArticles().get(m));
					m=m+1;
				}
			}
			
			for(int i =0;i<articles.size();i++){
				ResultSet oResultSet1 = oStatement.executeQuery("SELECT ID FROM ARTICLES WHERE (ARTICLES.NAME='"+articles.get(i).getArticle().getNombre()+"') AND (ARTICLES.Estado='Activo';");
				int nId= 0;
				while(oResultSet1.next()){
					nId = oResultSet1.getInt(1);
				}
				BigDecimal precio=(articles.get(i).getArticle().getPrecio());
				BigDecimal cant= new BigDecimal(articles.get(i).getCantidad());
				BigDecimal precioTotal = precio.multiply(cant);
				oStatement.execute("INSERT INTO `Linea de Factura` (Facturas_idFacturas, Articles_ID,Cantidad,Precio Unitario,Precio Total) VALUES (LAST_INSERT_ID(),"+nId+","+articles.get(i).getCantidad()+","+precio+","+precioTotal+");");
			}
			
			oStatement.close();
			//Verificacion por consola
			System.out.println("Factura agregada correctamente");
		}
		catch(SQLException e){
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
	
	
	
	

