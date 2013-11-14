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
import uy.edu.um.exceptions.checks.NoDatabaseConnection;
import uy.edu.um.exceptions.checks.NoServerConnectionException;
import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.table.interfaces.TableMgt;
import uy.edu.um.ui.usuarios.ClientListU;
import uy.edu.um.ui.usuarios.Facturacion;
import uy.edu.um.value_object.table.TableVO;

public class ConfirmFacturar extends JFrame {
	private JPanel contentPane;

	// Metodo cerrar Ventana
	public void cerrar() {
		this.dispose();
	}

	/**
	 * Create the frame.
	 *
	 * @param toSend
	 */
	public ConfirmFacturar(final TableVO mesa, final JFrame frame) {
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

		JLabel lblContrasea = new JLabel("\u00BFDesea Cerrar Mesa y Facturar?");
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
				Facturacion factura = null;
				try{
					factura = new Facturacion(mesa, null);
					factura.setVisible(true);
					frame.dispose();
					cerrar();
				}catch(NoServerConnectionException ex){
					MensajeGenerico newFrame = new MensajeGenerico(ex.getMessage(),ConfirmFacturar.this);
					newFrame.setVisible(true);
				}catch(NoDatabaseConnection ex){
					MensajeGenerico newFrame = new MensajeGenerico(ex.getMessage(),ConfirmFacturar.this);
					newFrame.setVisible(true);
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
