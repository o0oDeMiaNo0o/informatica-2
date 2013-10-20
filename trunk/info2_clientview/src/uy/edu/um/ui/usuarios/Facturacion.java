package uy.edu.um.ui.usuarios;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import uy.edu.um.imagenes.DirLocal;
import uy.edu.um.ui.clasesAuxiliares.BasicoUsuario;
import uy.edu.um.ui.clasesAuxiliares.ImagePanel;
import uy.edu.um.ui.clasesAuxiliares.TransparentPanel;
import uy.edu.um.value_object.article.ArticleVO;
import uy.edu.um.value_object.articleOrder.ArticleOrderVO;
import uy.edu.um.value_object.oreder.OrderVO;
import uy.edu.um.value_object.people.client.ClientVO;

public class Facturacion extends BasicoUsuario {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private URL logo = DirLocal.class.getResource("Logo.png");
	private String montoPagar, pagaCon, vuelto;

	/**
	 * Create the frame.
	 *
	 * @param toSend
	 */
	public Facturacion(OrderVO toSend) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout(0, 0));

		TransparentPanel transparentPanel = new TransparentPanel();
		getContentPane().add(transparentPanel, BorderLayout.CENTER);
		transparentPanel.setLayout(new MigLayout("", "[grow][][grow][grow]", "[grow][][][][grow]"));

		ImagePanel imagePanel = new ImagePanel(logo);
		transparentPanel
				.add(imagePanel, "cell 2 0,alignx center,aligny center");

		JLabel lblMozo = new JLabel("Mozo");
		lblMozo.setForeground(Color.WHITE);
		transparentPanel.add(lblMozo, "cell 1 1,alignx left");

		JComboBox comboBox = new JComboBox();
		transparentPanel.add(comboBox, "flowx,cell 2 1,growx,aligny center");

		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setForeground(Color.WHITE);
		transparentPanel.add(lblCliente, "cell 1 2,alignx left");

		textField = new JTextField();
		transparentPanel.add(textField, "flowx,cell 2 2,growx");
		textField.setColumns(10);

		JButton btnVerLista = new JButton("Ver Lista");
		transparentPanel
				.add(btnVerLista, "cell 2 2,alignx right,aligny center");

		JLabel lblPagaCon = new JLabel("Paga Con");
		lblPagaCon.setForeground(Color.WHITE);
		transparentPanel.add(lblPagaCon, "cell 1 3,alignx left");

		textField_1 = new JTextField();
		transparentPanel.add(textField_1, "flowx,cell 2 3,growx");
		textField_1.setColumns(10);

		TransparentPanel transparentPanel_1 = new TransparentPanel();
		transparentPanel.add(transparentPanel_1, "cell 2 4,grow");
		transparentPanel_1.setLayout(new MigLayout("", "[grow][][grow]",
				"[grow][][][][grow][]"));

		JLabel lblSubtotal = new JLabel("Subtotal");
		lblSubtotal.setForeground(Color.WHITE);
		transparentPanel_1.add(lblSubtotal, "cell 1 1");

		JLabel labelSub = new JLabel(cuentaPrecio(toSend));
		labelSub.setForeground(Color.WHITE);
		transparentPanel_1.add(labelSub, "cell 2 1,alignx left,aligny center");

		JLabel lblDescuento = new JLabel("Descuento");
		lblDescuento.setForeground(Color.WHITE);
		transparentPanel_1.add(lblDescuento, "cell 1 2");

		JLabel lblTotal = new JLabel("TOTAL");
		lblTotal.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblTotal.setForeground(Color.WHITE);
		transparentPanel_1.add(lblTotal, "cell 1 3");

		JButton btnAceptar = new JButton("Aceptar");
		transparentPanel_1.add(btnAceptar, "flowx,cell 2 5,alignx right");

		JButton btnCancelar = new JButton("Cancelar");
		transparentPanel_1.add(btnCancelar, "cell 2 5,alignx right");

		JLabel lblVuelto = new JLabel("Vuelto");
		lblVuelto.setForeground(Color.WHITE);
		transparentPanel.add(lblVuelto, "cell 2 3,alignx left");

		textField_2 = new JTextField();
		transparentPanel.add(textField_2, "cell 2 3,growx");
		textField_2.setColumns(10);
	}

	private String cuentaPrecio(OrderVO toSend) {
		BigDecimal subTotal = new BigDecimal(0);
		ArrayList<ArticleOrderVO> ao = toSend.getArticulos();
		for(ArticleOrderVO a : ao){
			if(a!= null){
				ArticleVO article = a.getArticle();
				BigDecimal price = article.getPrecio();
				int c = a.getCantidad();
				BigDecimal cantidad = new BigDecimal(c);
				BigDecimal temp = cantidad.multiply(price);
				subTotal = subTotal.add(temp);
			}
		}
		String toReturn = subTotal.toString();
		return toReturn;
	}

	public String calcularVuelto(String pago, String monto){
		int sPago = Integer.parseInt(pago);
		int sMonto = Integer.parseInt(monto);
		if(sPago < sMonto){
			return "monto insuficiente";
		}else{
			BigDecimal dPago = new BigDecimal(sPago);
			BigDecimal dMonto = new BigDecimal(sMonto);
			BigDecimal vuelto = dPago.subtract(dMonto);
			return vuelto.toString();
		}

	}

	public String calcularDescuento(ClientVO c, String monto){
		int discount = c.getDescuento();
		BigDecimal hun = new BigDecimal(100);
		BigDecimal dMonto = new BigDecimal(Integer.parseInt(monto));
		BigDecimal dDis = new BigDecimal(discount);
		BigDecimal tDis = hun.subtract(dDis);
		BigDecimal trueDist = tDis.divide(hun);
		BigDecimal total = dMonto.multiply(trueDist);
		return total.toString();
	}

}
