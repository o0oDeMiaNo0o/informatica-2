package uy.edu.um.ui.usuarios;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import net.miginfocom.swing.MigLayout;
import uy.edu.um.exceptions.checks.NoDatabaseConnection;
import uy.edu.um.exceptions.checks.NoServerConnectionException;
import uy.edu.um.imagenes.DirLocal;
import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.delivery.interfaces.DeliveryMgt;
import uy.edu.um.services.order.interfaces.OrderMgt;
import uy.edu.um.services.table.interfaces.TableMgt;
import uy.edu.um.ui.CurrentUser;
import uy.edu.um.ui.clasesAuxiliares.ImagePanel;
import uy.edu.um.ui.clasesAuxiliares.TransparentPanel;
import uy.edu.um.ui.mensajes.ConfirmMesa;
import uy.edu.um.ui.mensajes.MensajeGenerico;
import uy.edu.um.value_object.articleOrder.ArticleOrderVO;
import uy.edu.um.value_object.delivery.DeliveryVO;
import uy.edu.um.value_object.oreder.OrderVO;
import uy.edu.um.value_object.table.TableVO;
import uy.edu.um.value_object.user.UserVO;

public class Mesas extends BasicoUsuario {

	public URL libre = DirLocal.class.getResource("Libre.jpg");
	public URL ocupado = DirLocal.class.getResource("Ocupado.jpg");
	public URL delivery = DirLocal.class.getResource("Delivery.jpg");
	public URL mostrador = DirLocal.class.getResource("Mostrador.jpg");
	public ArrayList<TableVO> mesas;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mesas frame = new Mesas(null, null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Mesas(final ArrayList<ArticleOrderVO> pedidoAux, final String esp) throws NoDatabaseConnection, NoServerConnectionException {
//		try {
			mesas = cargoMesas();

			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 300);
			getContentPane().setLayout(new BorderLayout(0, 0));

			TransparentPanel transparentPanel = new TransparentPanel();
			getContentPane().add(transparentPanel);
			transparentPanel.setLayout(new MigLayout("", "[][][grow][][grow]",
			"[][][][][][][][grow]"));

			Component rigidArea = Box.createRigidArea(new Dimension(100, 100));
			transparentPanel.add(rigidArea, "cell 0 0");

			TransparentPanel transparentPanel_1 = new TransparentPanel();
			getContentPane().add(transparentPanel_1, BorderLayout.NORTH);

			JLabel lblMesas = new JLabel("MESAS");
			lblMesas.setForeground(Color.WHITE);
			lblMesas.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			transparentPanel_1.add(lblMesas);
			cargaBotones(transparentPanel, pedidoAux, esp);

			ImagePanel imagePanelDelivery = new ImagePanel(delivery);
			imagePanelDelivery.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (pedidoAux != null) {
						DeliveryVO delivery = new DeliveryVO(pedidoAux, null,
								CurrentUser.getUser(), esp, 0, false);
						DeliveryMgt nuevo = ServiceFacade.getInstance()
						.getDeliveryMgt();
						// nuevo.addOrder(delivery);
						MensajeGenerico msg = new MensajeGenerico(
								"Agregado A Delivery Correctamente",Mesas.this);
						msg.setVisible(true);
					} else {
						TableVO tableDelivery = new TableVO();
						tableDelivery.setNumero(999);
						ConfirmMesa nuevo = new ConfirmMesa(tableDelivery, null,
								esp, Mesas.this);
						nuevo.setVisible(true);
					}
				}
			});
			transparentPanel.add(imagePanelDelivery,
			"cell 1 1,alignx center,aligny center");
			imagePanelDelivery.setLayout(new MigLayout("", "[150px]", "[100px]"));
			JLabel lblNewLabel = new JLabel("DELIVERY");
			lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			imagePanelDelivery.add(lblNewLabel,
			"cell 0 0,alignx center,aligny center");

			TransparentPanel transparentPanel_2 = new TransparentPanel();
			getContentPane().add(transparentPanel_2, BorderLayout.SOUTH);
			transparentPanel_2
			.setLayout(new MigLayout("", "[98px,grow]", "[29px]"));

			JButton btnNewButton = new JButton("Cancelar");
			transparentPanel_2.add(btnNewButton,
			"cell 0 0,alignx right,aligny center");
			;
//		} catch (NoServerConnectionException e1) {
//			MensajeGenerico newFrame = new MensajeGenerico(e1.getMessage(),devuelve());
//			newFrame.setVisible(true);
//		}
	}

	// Metodos auxiliares
	private void cargaBotones(TransparentPanel panel,
			final ArrayList<ArticleOrderVO> pedidoAux, final String esp) {

		if (mesas.isEmpty()) {
			JLabel lbltemp = new JLabel("NO HAY MESAS AGREGADAS");
			lbltemp.setForeground(Color.WHITE);
			panel.add(lbltemp, "cell 0 0");
		} else {
			int n = 0;
			int i = 3, j = 1;
			URL dir;
			while (n < mesas.size()) {
				String nombre = String.valueOf(mesas.get(n).getNumero());
				if (mesas.get(n).getNumero() != 999) {
					if (mesas.get(n).isOcupado()) {
						dir = ocupado;
					} else {
						dir = libre;
					}
					if (mesas.get(n).getNumero() == 0) {
						dir = mostrador;
						nombre = "MOSTRADOR";
					}
					final String nom2 = nombre;
					ImagePanel imagePanel = new ImagePanel(dir);
					panel.add(imagePanel, "cell " + i + " " + j);
					imagePanel
							.setLayout(new MigLayout("", "[150px]", "[100px]"));
					final TableVO mesa = mesas.get(n);
					imagePanel.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							try{
							if (mesa.isOcupado()) {
								MesaPedido nuevo = new MesaPedido(mesa);
								nuevo.setVisible(true);
							} else {
								OrderVO toSend = enviarPedido(pedidoAux, mesa,
										esp, CurrentUser.getUser());
								ConfirmMesa conf = new ConfirmMesa(mesa,
										toSend, "Confirma Seleccion De : Mesa "
												+ nom2 + " ?", devuelve());
								conf.setVisible(true);
							}
							}catch(NoDatabaseConnection e1){
								MensajeGenerico nuevo = new MensajeGenerico(e1.getMessage(),Mesas.this);
								nuevo.setVisible(true);
							}
						}

					});
					JLabel lblNewLabel = new JLabel(nombre);
					lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN,
							16));
					imagePanel.add(lblNewLabel,
							"cell 0 0,alignx center,aligny center");
					i = i + 2;
					if (i == 13) {
						i = 1;
						j = j + 2;
					}
					n++;

				}else{
					n++;
				}

			}
		}
	}

	// Creo y envio OrderVO
	private OrderVO enviarPedido(ArrayList<ArticleOrderVO> pedidoAux,
			TableVO mesa, String esp, UserVO user) {
		OrderMgt nueva = ServiceFacade.getInstance().getOrderMgt();
		// compilo tiene valor por defecto 0 q es en preparacion
		OrderVO toSend = nueva.createOrderVO(pedidoAux, mesa,
				CurrentUser.getUser(), esp, 0);
		return toSend;

	}

	private JFrame devuelve() {
		return this;
	}

	private ArrayList<TableVO> cargoMesas() throws NoServerConnectionException, NoDatabaseConnection{
		TableMgt nueva = ServiceFacade.getInstance().getTableMgt();
		return nueva.allTables();

	}
}
