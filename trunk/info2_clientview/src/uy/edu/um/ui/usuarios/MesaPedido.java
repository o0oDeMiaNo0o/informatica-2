package uy.edu.um.ui.usuarios;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.MigLayout;
import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.order.interfaces.OrderMgt;
import uy.edu.um.ui.clasesAuxiliares.TransparentPanel;
import uy.edu.um.value_object.articleOrder.ArticleOrderVO;
import uy.edu.um.value_object.oreder.OrderVO;
import uy.edu.um.value_object.table.TableVO;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MesaPedido extends BasicoUsuario {
	private JTable tablePedidoMesa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MesaPedido frame = new MesaPedido(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MesaPedido(final TableVO mesa) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		TransparentPanel transparentPanel = new TransparentPanel();
		getContentPane().add(transparentPanel, BorderLayout.CENTER);
		transparentPanel.setLayout(new MigLayout("", "[grow][grow][grow]",
				"[grow][grow][grow]"));

		tablePedidoMesa = new JTable();
		tablePedidoMesa.setBorder(new LineBorder(Color.ORANGE, 2, true));
		tablePedidoMesa.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		tablePedidoMesa.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablePedidoMesa.setEnabled(false);
		tablePedidoMesa.setRowSelectionAllowed(false);

		Object[][] aux = armarTabla(cargaOrdenes(mesa));

		tablePedidoMesa.setModel(new DefaultTableModel(aux, new String[] {
				"Articulo", "Cantidad" }));

		transparentPanel.add(tablePedidoMesa, "cell 1 1,grow");

		TransparentPanel ZonaBotones = new TransparentPanel();
		getContentPane().add(ZonaBotones, BorderLayout.SOUTH);
		ZonaBotones.setLayout(new MigLayout("", "[grow][][][]", "[]"));

		JButton btnFacturar = new JButton("Facturar");
		btnFacturar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Facturacion nuevo = new Facturacion(null);
				nuevo.setVisible(true);
			}
		});
		ZonaBotones.add(btnFacturar, "cell 1 0");

		JButton btnCaja = new JButton("Agregar Articulos A Mesa");
		btnCaja.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				CajaPrincipal nuevo = new CajaPrincipal(null, mesa);
				nuevo.setVisible(true);
				cerrar();
			}
		});
		ZonaBotones.add(btnCaja, "cell 2 0");

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Mesas nuevo = new Mesas(null, null);
				nuevo.setVisible(true);
				cerrar();

			}
		});
		ZonaBotones.add(btnCancelar, "cell 3 0");

	}

	// Metodos Auxiliares

	public Object[][] armarTabla(ArrayList<ArticleOrderVO> pedidoArticle) {
		Object[][] aux = null;
		if ((pedidoArticle.size() != 0)) {
			aux = new Object[pedidoArticle.size() + 1][2];
			aux[0][0] = "Articulo";
			aux[0][1] = "Cantidad";
			for (int i = 0; i < pedidoArticle.size(); i++) {

				aux[i + 1][0] = pedidoArticle.get(i).getArticle().getNombre();
				aux[i + 1][1] = pedidoArticle.get(i).getCantidad();
			}

		} else {
			aux = new Object[1][2];
			aux[0][0] = "Articulo";
			aux[0][1] = "Cantidad";
		}
		return aux;

	}

	// Cargo los metodos
	private ArrayList<ArticleOrderVO> cargaOrdenes(TableVO mesa) {
		ArrayList<ArticleOrderVO> aux = new ArrayList<ArticleOrderVO>();
		OrderMgt nuevo = ServiceFacade.getInstance().getOrderMgt();
		ArrayList<OrderVO> ordenes = nuevo.allOrders();
		for (int i = 0; i < ordenes.size(); i++) {
			if ((ordenes.get(i).getTable() == mesa)
					&& (ordenes.get(i).getEstado() == 1)) {
				aux = ordenes.get(i).getArticulos();
			}
		}
		return aux;
	}

	public void cerrar() {
		this.dispose();
	}
}
