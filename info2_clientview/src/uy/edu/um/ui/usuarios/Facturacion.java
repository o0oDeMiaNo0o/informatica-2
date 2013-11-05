package uy.edu.um.ui.usuarios;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import uy.edu.um.imagenes.DirLocal;
import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.bill.interfaces.BillMgt;
import uy.edu.um.services.order.interfaces.OrderMgt;
import uy.edu.um.services.people.clients.interfaces.ClientMgt;
import uy.edu.um.ui.clasesAuxiliares.Helpers;
import uy.edu.um.ui.clasesAuxiliares.ImagePanel;
import uy.edu.um.ui.clasesAuxiliares.TransparentPanel;
import uy.edu.um.ui.mensajes.MensajeGenerico;
import uy.edu.um.value_object.article.ArticleVO;
import uy.edu.um.value_object.articleOrder.ArticleOrderVO;
import uy.edu.um.value_object.bill.BillVO;
import uy.edu.um.value_object.oreder.OrderVO;
import uy.edu.um.value_object.people.client.ClientVO;
import uy.edu.um.value_object.table.TableVO;

public class Facturacion extends BasicoUsuario {
	private JTextField textFieldCliente;
	private JTextField textFieldPagaCon;
	private JTextField textFieldVuelto;
	private URL logo = DirLocal.class.getResource("Bernie's.png");
	private ArrayList<ClientVO> clientes = cargaClientes();
	private boolean tieneDescuento = false;
	private BigDecimal descuento = new BigDecimal(0);
	private BigDecimal montoPagar;
	private ArrayList<OrderVO> ordenesMesa = new ArrayList<OrderVO>();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Facturacion frame = new Facturacion(null, null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Facturacion(final TableVO mesa, ClientVO cliente) {

		ordenesMesa = cargoOrdenesMesa(mesa);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout(0, 0));

		TransparentPanel transparentPanel = new TransparentPanel();
		getContentPane().add(transparentPanel, BorderLayout.CENTER);
		transparentPanel.setLayout(new MigLayout("", "[grow][][grow][grow]",
				"[grow][][][grow]"));

		ImagePanel imagePanel = new ImagePanel(logo);
		transparentPanel
				.add(imagePanel, "cell 2 0,alignx center,aligny center");

		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setForeground(Color.WHITE);
		transparentPanel.add(lblCliente, "cell 1 1,alignx left");

		textFieldCliente = new JTextField();
		textFieldCliente.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {

			}
		});
		transparentPanel.add(textFieldCliente, "flowx,cell 2 1,growx");
		textFieldCliente.setColumns(10);

		JButton btnVerLista = new JButton("Ver Lista");
		btnVerLista.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ClientListU nuevo = new ClientListU(mesa);
				nuevo.setVisible(true);
			}
		});
		transparentPanel
				.add(btnVerLista, "cell 2 1,alignx right,aligny center");

		JLabel lblPagaCon = new JLabel("Paga Con");
		lblPagaCon.setForeground(Color.WHITE);
		transparentPanel.add(lblPagaCon, "cell 1 2,alignx left");

		textFieldPagaCon = new JTextField();
		textFieldPagaCon.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (textFieldPagaCon.getText().isEmpty()) {

				} else if (Helpers.isNumeric(textFieldPagaCon.getText())) {
					textFieldVuelto.setText(calcularVuelto(
							textFieldPagaCon.getText(), montoPagar.toString()));
				} else {
					MensajeGenerico nuevo = new MensajeGenerico(
							textFieldPagaCon.getText() + " no es un numero",
							null);
					nuevo.setVisible(true);
					textFieldPagaCon.setText("");
				}

			}

		});
		transparentPanel.add(textFieldPagaCon, "flowx,cell 2 2,growx");
		textFieldPagaCon.setColumns(10);

		TransparentPanel transparentPanel_1 = new TransparentPanel();
		transparentPanel.add(transparentPanel_1, "cell 2 3,grow");
		transparentPanel_1.setLayout(new MigLayout("", "[grow][][grow]",
				"[grow][][][][grow][]"));

		JLabel lblSubtotal = new JLabel("Subtotal");
		lblSubtotal.setForeground(Color.WHITE);
		transparentPanel_1.add(lblSubtotal, "cell 1 1");

		JLabel labelSub = new JLabel(cuentaPrecio(ordenesMesa));
		labelSub.setForeground(Color.WHITE);
		transparentPanel_1.add(labelSub, "cell 2 1,alignx left,aligny center");

		JLabel lblDescuento = new JLabel("Descuento");
		lblDescuento.setForeground(Color.WHITE);
		transparentPanel_1.add(lblDescuento, "cell 1 2");

		JLabel labelDescuento = new JLabel(descuento.toString());
		labelDescuento.setForeground(Color.WHITE);
		transparentPanel_1.add(labelDescuento, "flowx,cell 2 2");

		JLabel lblTotal = new JLabel("TOTAL");
		lblTotal.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblTotal.setForeground(Color.WHITE);
		transparentPanel_1.add(lblTotal, "cell 1 3");

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ClientVO cliente = buscaCliente(Integer
						.parseInt(textFieldCliente.getText()));
				BillMgt nuevo = ServiceFacade.getInstance().getBillMgt();
				if (cliente != null) {
					BillVO factura = nuevo.createBillVO(ordenesMesa, cliente, mesa);
					nuevo.addBillVO(factura);
					MensajeGenerico msg = new MensajeGenerico(
							"Factura Correcta", devuelve());
					msg.setVisible(true);
				} else {
					BillVO factura = nuevo.createBillVO(ordenesMesa, cliente, mesa);
					nuevo.addBillVO(factura);
					MensajeGenerico msg = new MensajeGenerico(
							"Factura Correcta", devuelve());
				}

			}
		});
		transparentPanel_1.add(btnAceptar, "flowx,cell 2 5,alignx right");

		JButton btnCancelar = new JButton("Cancelar");
		transparentPanel_1.add(btnCancelar, "cell 2 5,alignx right");

		JLabel labelTotal = new JLabel(calculaTotal());
		labelTotal.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
		labelTotal.setForeground(Color.ORANGE);
		transparentPanel_1.add(labelTotal, "cell 2 3");

		JLabel lblVuelto = new JLabel("Vuelto");
		lblVuelto.setForeground(Color.WHITE);
		transparentPanel.add(lblVuelto, "cell 2 2,alignx left");

		textFieldVuelto = new JTextField();
		textFieldVuelto.setEditable(false);
		transparentPanel.add(textFieldVuelto, "cell 2 2,growx");
		textFieldVuelto.setColumns(10);
	}

	private ArrayList<OrderVO> cargoOrdenesMesa(TableVO mesa) {
		OrderMgt nuevo = ServiceFacade.getInstance().getOrderMgt();
		return nuevo.allOrders();
	}

	private String calculaTotal() {
		if (tieneDescuento == true) {

		} else {

		}
		return null;
	}

	private String cuentaPrecio(OrderVO toSend) {
		BigDecimal subTotal = new BigDecimal(0);
		ArrayList<ArticleOrderVO> ao = toSend.getArticulos();
		for (ArticleOrderVO a : ao) {
			if (a != null) {
				ArticleVO article = a.getArticle();
				BigDecimal price = article.getPrecio();
				int c = a.getCantidad();
				BigDecimal cantidad = new BigDecimal(c);
				BigDecimal temp = cantidad.multiply(price);
				subTotal = subTotal.add(temp);
			}
		}
		montoPagar = subTotal;
		String toReturn = subTotal.toString();

		return toReturn;
	}

	public String calcularVuelto(String pago, String monto) {
		int sPago = Integer.parseInt(pago);
		int sMonto = Integer.parseInt(monto);
		if (sPago < sMonto) {
			return "monto insuficiente";
		} else {
			BigDecimal dPago = new BigDecimal(sPago);
			BigDecimal dMonto = new BigDecimal(sMonto);
			BigDecimal vuelto = dPago.subtract(dMonto);
			return vuelto.toString();
		}

	}

	public String calcularDescuento(ClientVO c, String monto) {
		BigDecimal hun = new BigDecimal(100);
		BigDecimal dMonto = new BigDecimal(Integer.parseInt(monto));
		BigDecimal dDis = c.getDescuento();
		BigDecimal tDis = hun.subtract(dDis);
		BigDecimal trueDist = tDis.divide(hun);
		BigDecimal total = dMonto.multiply(trueDist);
		descuento = total;
		return total.toString();
	}

	public ArrayList<ClientVO> cargaClientes() {
		ClientMgt nuevo = ServiceFacade.getInstance().getClientMgt();
		return nuevo.allClients();

	}

	public ClientVO buscaCliente(int ci) {
		ClientVO cliente = null;
		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i).getCi() == ci) {
				cliente = clientes.get(i);
				if (clientes.get(i).getDescuento().equals(0)) {
					tieneDescuento = true;
					descuento = clientes.get(i).getDescuento();
				}
			}
		}
		return cliente;
	}

	// Cargo ordenes de esa mesa

	public JFrame devuelve() {
		return this;
	}

}
