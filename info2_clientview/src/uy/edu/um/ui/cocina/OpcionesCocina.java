package uy.edu.um.ui.cocina;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import uy.edu.um.exceptions.checks.NoDatabaseConnection;
import uy.edu.um.exceptions.checks.NoServerConnectionException;
import uy.edu.um.imagenes.DirLocal;
import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.order.interfaces.OrderMgt;
import uy.edu.um.ui.clasesAuxiliares.ImagePanel;
import uy.edu.um.ui.clasesAuxiliares.TransparentPanel;
import uy.edu.um.ui.mensajes.MensajeGenerico;
import uy.edu.um.value_object.oreder.OrderVO;

public class OpcionesCocina extends JFrame {

	private JPanel contentPane;
	private URL green = DirLocal.class.getResource("Libre.jpg");
	private URL red = DirLocal.class.getResource("Ocupado.jpg");

	public OpcionesCocina(final OrderVO orden, final JFrame frame) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(frame);
		setBounds(100, 100, 500, 325);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		TransparentPanel transparentPanel = new TransparentPanel();
		contentPane.add(transparentPanel, BorderLayout.CENTER);
		transparentPanel.setLayout(new MigLayout("", "[grow][][grow][][grow]",
				"[grow][][grow]"));

		ImagePanel panelRealizado = new ImagePanel(green);
		transparentPanel.add(panelRealizado, "cell 1 1,grow");
		panelRealizado.setLayout(new BorderLayout(0, 0));

		JLabel lblPedidoRealizado = new JLabel("Realizado");
		lblPedidoRealizado.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				OrderMgt nueva = null;
				try {
					nueva = ServiceFacade.getInstance().getOrderMgt();
					nueva.entregado(orden);
				} catch (NoServerConnectionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoDatabaseConnection e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				MensajeGenerico nuevo = new MensajeGenerico(
						"Pedido Cerrado Con Exito", frame);
				nuevo.setVisible(true);
				cerrar();
			}
		});
		lblPedidoRealizado.setHorizontalAlignment(SwingConstants.CENTER);
		panelRealizado.add(lblPedidoRealizado, BorderLayout.CENTER);

		ImagePanel imagePanel = new ImagePanel(red);
		transparentPanel.add(imagePanel, "cell 3 1,grow");
		imagePanel.setLayout(new BorderLayout(0, 0));

		JLabel lblPedidoRechazado = new JLabel("Rechazado");
		lblPedidoRechazado.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				OrderMgt ordenAux = ServiceFacade.getInstance().getOrderMgt();
				try {
					ordenAux.rechazado(orden);
				} catch (NoServerConnectionException e1) {
					// TODO Auto-generated catch block
					MensajeGenerico msg = new MensajeGenerico(e1.getMessage(),
							null);
					msg.setVisible(true);
				} catch (NoDatabaseConnection e1) {
					// TODO Auto-generated catch block
					MensajeGenerico msg = new MensajeGenerico(e1.getMessage(),
							null);
					msg.setVisible(true);

				}
				OrdenRechazada nuevo = new OrdenRechazada(orden);
				nuevo.setVisible(true);
				cerrar();
			}
		});
		lblPedidoRechazado.setHorizontalAlignment(SwingConstants.CENTER);
		imagePanel.add(lblPedidoRechazado, BorderLayout.CENTER);

		TransparentPanel transparentPanel_1 = new TransparentPanel();
		contentPane.add(transparentPanel_1, BorderLayout.SOUTH);
		transparentPanel_1.setLayout(new MigLayout("", "[grow]", "[]"));

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				cerrar();
			}
		});
		transparentPanel_1.add(btnCancelar,
				"cell 0 0,alignx center,aligny center");
	}

	// Metodos Auxiliares

	public void cerrar() {
		this.dispose();
	}
}
