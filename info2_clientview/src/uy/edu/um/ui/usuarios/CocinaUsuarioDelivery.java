package uy.edu.um.ui.usuarios;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.MigLayout;
import uy.edu.um.exceptions.checks.NoDatabaseConnection;
import uy.edu.um.exceptions.checks.NoServerConnectionException;
import uy.edu.um.imagenes.DirLocal;
import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.order.interfaces.OrderMgt;
import uy.edu.um.ui.clasesAuxiliares.ImagePanel;
import uy.edu.um.ui.clasesAuxiliares.TransparentPanel;
import uy.edu.um.ui.mensajes.RechazoCocinaU;
import uy.edu.um.value_object.articleOrder.ArticleOrderVO;
import uy.edu.um.value_object.oreder.OrderVO;

public class CocinaUsuarioDelivery extends BasicoUsuario {

	private JPanel contentPane;
	public URL DirFondo = DirLocal.class.getResource("Fondo.png");
	private JTable table;
	private ArrayList<OrderVO> arrayDeliveries;
	Timer timer = null;

	public CocinaUsuarioDelivery() throws NoDatabaseConnection,
			NoServerConnectionException {
		arrayDeliveries = cargaOrdenes();
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

		final TransparentPanel transparentPanel = new TransparentPanel();
		imagePanel.add(transparentPanel, BorderLayout.CENTER);
		transparentPanel.setLayout(new MigLayout("", "[][309.00][][][grow]",
				"[][263.00][][][][][][grow]"));

		// Creo los elementos
		armarPedido(transparentPanel);

		TransparentPanel transparentPanel_1 = new TransparentPanel();
		imagePanel.add(transparentPanel_1, BorderLayout.NORTH);
		transparentPanel_1.setLayout(new MigLayout("", "[grow][][grow]", "[]"));

		JLabel lblCocina = new JLabel("COLA DE ESPERA DELIVERY");
		lblCocina.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblCocina.setForeground(Color.WHITE);
		transparentPanel_1.add(lblCocina, "cell 1 0");

		// Refresh
		this.timer = new Timer(5000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<OrderVO> arrayOrdenesAux = null;
				try {
					// Cargo ordenes
					arrayOrdenesAux = cargaOrdenes();
				} catch (NoServerConnectionException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NoDatabaseConnection e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// armo los pedidos
				if (comparaOrdenes(arrayOrdenesAux)) {
					arrayDeliveries = arrayOrdenesAux;
					transparentPanel.removeAll();
					armarPedido(transparentPanel);
					transparentPanel.invalidate();
					transparentPanel.validate();
					transparentPanel.repaint();
				}

			}

		});

		timer.start();

		// catch(NoServerConnectionException e ){
		// MensajeGenerico nuevo = new
		// MensajeGenerico(e.getMessage(),CocinaUsuarios.this);
		// nuevo.setVisible(true);
		// }catch(NoDatabaseConnection e){
		// MensajeGenerico nuevoFrame = new
		// MensajeGenerico(e.getMessage(),CocinaUsuarios.this);
		// nuevoFrame.setVisible(true);
		// }
	}

	// Cuento tiempo que lleva el pedido

	private String tiempoEspera(Date date) {
		Calendar cal = new GregorianCalendar();
		int horaA = cal.get(cal.HOUR_OF_DAY);
		int minA = cal.get(cal.MINUTE);
		int horas = date.getHours();
		int min = date.getMinutes();
		int HORA = horaA - horas;
		int MIN = minA - min;
		return HORA + ":" + MIN;
	}

	// compara si hay que refrescar pantalla
	private boolean comparaOrdenes(ArrayList<OrderVO> arrayOrdenesAux) {
		if (arrayOrdenesAux.size() != arrayDeliveries.size()) {
			return true;
		} else {
			for (int i = 0; i < arrayDeliveries.size(); i++) {
				if (arrayDeliveries.get(i) != arrayOrdenesAux.get(i)) {
					return true;
				}
			}
		}
		return false;
	}

	private void armarPedido(JPanel transparentPanel) {
		if (arrayDeliveries.size() != 0) {
			int i = 1, j = 1;
			for (int n = 0; n < arrayDeliveries.size(); n++) {

				final OrderVO orden = arrayDeliveries.get(n);
				JPanel panel = new JPanel();
				panel.setBackground(Color.LIGHT_GRAY);
				panel.setBorder(new LineBorder(new Color(111, 102, 238), 3));
				transparentPanel.add(panel, "cell " + i + " " + j + ",grow");
				panel.setLayout(new BorderLayout(0, 0));
				panel.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						RechazoCocinaU nueva = new RechazoCocinaU(orden,
								devuelve());
						nueva.setVisible(true);
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

				JLabel lblTiempo = new JLabel("Tiempo (HH:MM) :");
				transparentPanel_2.add(lblTiempo,
						"cell 4 0,alignx center,aligny center");

				JLabel lblDynamic_1 = new JLabel(tiempoEspera(orden.getTime()));
				transparentPanel_2.add(lblDynamic_1,
						"cell 5 0,alignx center,aligny center");

				TransparentPanel transparentPanel_3 = new TransparentPanel();
				panel.add(transparentPanel_3, BorderLayout.CENTER);
				transparentPanel_3.setLayout(new MigLayout("", "[1px][grow]",
						"[1px][grow][]"));

				// Termina parte constante

				table = new JTable();
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						RechazoCocinaU nueva = new RechazoCocinaU(orden,
								devuelve());
						nueva.setVisible(true);
					}
				});
				table.setBorder(new LineBorder(new Color(111, 102, 238)));
				table.setBackground(Color.WHITE);

				Object[][] aux = armarTabla(arrayDeliveries.get(n)
						.getArticulos());
				table.setModel(new DefaultTableModel(aux, new String[] {
						"Articulo", "Cantidad" }));
				transparentPanel_3.add(table, "cell 1 1,grow");

				JTextArea textArea = new JTextArea();
				textArea.setEditable(false);
				textArea.setText(orden.getEspecificaciones());
				transparentPanel_3
						.add(textArea, "cell 1 2,growx,aligny center");

				j++;
				if (j > 3) {
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

	// Carga Ordenes
	private ArrayList<OrderVO> cargaOrdenes()
			throws NoServerConnectionException, NoDatabaseConnection {
		OrderMgt nuevo = ServiceFacade.getInstance().getOrderMgt();
		return nuevo.allDeliveries();
	}

	public JFrame devuelve() {
		return this;
	}
}
