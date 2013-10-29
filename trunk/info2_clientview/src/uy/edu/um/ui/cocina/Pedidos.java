package uy.edu.um.ui.cocina;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.MigLayout;
import uy.edu.um.imagenes.DirLocal;
import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.order.interfaces.OrderMgt;
import uy.edu.um.ui.clasesAuxiliares.ConfirmCerrarMesa;
import uy.edu.um.ui.clasesAuxiliares.ImagePanel;
import uy.edu.um.ui.clasesAuxiliares.TransparentPanel;
import uy.edu.um.value_object.articleOrder.ArticleOrderVO;
import uy.edu.um.value_object.oreder.OrderVO;

public class Pedidos extends JFrame {

	private JPanel contentPane;
	public URL DirFondo = DirLocal.class.getResource("Fondo2.jpg");
	private JTable table;
	private ArrayList<OrderVO> arrayOrdenes = cargaOrdenes();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pedidos frame = new Pedidos(null);
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
	public Pedidos(OrderVO pedido) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		ImagePanel imagePanel = new ImagePanel(DirFondo);
		contentPane.add(imagePanel, BorderLayout.CENTER);
		imagePanel.setLayout(new BorderLayout(0, 0));

		TransparentPanel transparentPanel = new TransparentPanel();
		imagePanel.add(transparentPanel, BorderLayout.CENTER);
		transparentPanel.setLayout(new MigLayout("", "[][309.00][][][grow]",
				"[][263.00][][][][][][grow]"));

		// Creo los elementos
		armarPedido(pedido, transparentPanel);

		TransparentPanel transparentPanel_1 = new TransparentPanel();
		imagePanel.add(transparentPanel_1, BorderLayout.NORTH);
		transparentPanel_1.setLayout(new MigLayout("", "[grow][][grow]", "[]"));

		JLabel lblCocina = new JLabel("COCINA");
		lblCocina.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblCocina.setForeground(Color.WHITE);
		transparentPanel_1.add(lblCocina, "cell 1 0");
	}

	private void armarPedido(final OrderVO orden, JPanel transparentPanel) {
		if (orden != null) {
			arrayOrdenes.add(orden);
			int i = 1, j = 1;
			for (int n = 0; n < arrayOrdenes.size(); n++) {

				JPanel panel = new JPanel();
				panel.setBackground(Color.LIGHT_GRAY);
				panel.setBorder(new LineBorder(Color.ORANGE, 3));
				transparentPanel.add(panel, "cell " + i + " " + j + ",grow");
				panel.setLayout(new BorderLayout(0, 0));
				panel.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						ConfirmCerrarMesa nueva = new ConfirmCerrarMesa(orden);
					}
				});

				// Constante
				TransparentPanel transparentPanel_2 = new TransparentPanel();
				panel.add(transparentPanel_2, BorderLayout.NORTH);
				transparentPanel_2.setLayout(new MigLayout("",
						"[grow][][][][][80.00][grow]", "[]"));

				JLabel lblPedido = new JLabel("Pedido :");
				transparentPanel_2.add(lblPedido,
						"cell 1 0,alignx center,aligny center");

				JLabel lblDynamic = new JLabel("Dynamic");
				transparentPanel_2.add(lblDynamic,
						"cell 2 0,alignx center,aligny center");

				Component horizontalStrut = Box.createHorizontalStrut(20);
				transparentPanel_2.add(horizontalStrut, "cell 3 0");

				JLabel lblTiempo = new JLabel("Tiempo:");
				transparentPanel_2.add(lblTiempo,
						"cell 4 0,alignx center,aligny center");

				JLabel lblDynamic_1 = new JLabel("Dynamic");
				transparentPanel_2.add(lblDynamic_1,
						"cell 5 0,alignx center,aligny center");

				TransparentPanel transparentPanel_3 = new TransparentPanel();
				panel.add(transparentPanel_3, BorderLayout.CENTER);
				transparentPanel_3.setLayout(new MigLayout("", "[1px][grow]",
						"[1px][grow][]"));

				// Termina parte constante

				table = new JTable();
				table.setBorder(new LineBorder(new Color(255, 200, 0)));
				table.setBackground(Color.LIGHT_GRAY);

				Object[][] aux = armarTabla(arrayOrdenes.get(n).getArticulos());
				table.setModel(new DefaultTableModel(aux, new String[] {
						"Articulo", "Cantidad" }));
				transparentPanel_3.add(table, "cell 1 1,grow");

				JTextArea textArea = new JTextArea();
				textArea.setEditable(false);
				textArea.setText(orden.getEspecificaciones());
				transparentPanel_3
						.add(textArea, "cell 1 2,growx,aligny center");

				j++;
				if (j > 5) {
					j = 1;
					i++;
				}

			}
		} else {

			JLabel lblPedido = new JLabel("No hay pedidos en cola");
			lblPedido.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
			lblPedido.setForeground(Color.RED);
			transparentPanel.add(lblPedido,
					"cell 1 0,alignx center,aligny center");
		}

	}

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

	//Carga Ordenes
	private ArrayList<OrderVO> cargaOrdenes() {
		OrderMgt nuevo = ServiceFacade.getInstance().getOrderMgt();
		return nuevo.allOrders();
	}
}
