package uy.edu.um.ui.mensajes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.order.interfaces.OrderMgt;
import uy.edu.um.services.table.interfaces.TableMgt;
import uy.edu.um.ui.usuarios.CajaPrincipal;
import uy.edu.um.value_object.table.TableVO;
import uy.edu.um.value_object.user.UserVO;

public class ConfirmMesa extends JFrame {

	private JPanel contentPane;
	UserVO user;

	// Metodo cerrar Ventana
	public void cerrar() {
		this.dispose();
	}

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * 
	 * @param toSend
	 */
	public ConfirmMesa(final TableVO mesa, String text, final JFrame frame) {

		setTitle("Confirma");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(frame);
		setBounds(100, 100, 460, 254);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel ZonaPassword = new JPanel();
		contentPane.add(ZonaPassword, BorderLayout.CENTER);
		ZonaPassword.setLayout(new MigLayout("", "[428px]",
				"[grow][16px][grow]"));

		JLabel lblContrasea = new JLabel(text);
		lblContrasea.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblContrasea.setForeground(Color.BLACK);
		ZonaPassword.add(lblContrasea, "cell 0 1,alignx center,aligny top");

		JPanel ZonaBotones = new JPanel();
		contentPane.add(ZonaBotones, BorderLayout.SOUTH);
		ZonaBotones.setLayout(new MigLayout("", "[grow][][]", "[]"));

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (mesa.isOcupado()) {
					ConfirmFacturar nuevo = new ConfirmFacturar(mesa, null);
					nuevo.setVisible(true);
					cerrar();
				} else {
					/*
					if (toSend.getArticulos() != null) {
						OrderMgt nuevo = ServiceFacade.getInstance()
								.getOrderMgt();
						nuevo.addOrder(toSend);
						TableMgt nuevoMesas = ServiceFacade.getInstance()
								.getTableMgt();
						nuevoMesas.setOcupado(toSend.getTable());
						ConfirmFacturar nueva = new ConfirmFacturar(toSend,
								frame);
						nueva.setVisible(true);
						cerrar();
					} else {
						CajaPrincipal nuevo = new CajaPrincipal(null, toSend
								.getTable());
						TableMgt nuevoMesas = ServiceFacade.getInstance()
								.getTableMgt();
						nuevoMesas.setOcupado(toSend.getTable());
						nuevo.setVisible(true);
						frame.dispose();
						cerrar();
						*/
					}
				}
		});
		ZonaBotones.add(btnAceptar, "cell 1 0,alignx center,growy");

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cerrar();
			}
		});
		ZonaBotones.add(btnCancelar, "cell 2 0,growx,aligny center");
	}

}
