package uy.edu.um.ui.admin.edicion;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import uy.edu.um.exceptions.checks.NoDatabaseConnection;
import uy.edu.um.exceptions.checks.NoServerConnectionException;
import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.article.interfaces.ArticleMgt;
import uy.edu.um.services.people.clients.interfaces.ClientMgt;
import uy.edu.um.ui.clasesAuxiliares.Helpers;
import uy.edu.um.ui.mensajes.MensajeGenerico;
import uy.edu.um.value_object.article.ArticleVO;
import uy.edu.um.value_object.categories.CategoryVO;
import uy.edu.um.value_object.people.client.ClientVO;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class EditRemoveC extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldAp;
	private JTextField textFieldDir;
	private ArrayList<ClientVO> clientes;
	String[] textos;
	private JTextField textFieldCi;
	private JTextField textFieldNom;
	private JTextField textFieldMail;
	private JTextField textFieldTel;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 *
	 * @param toSend
	 */
	public EditRemoveC(ClientVO cliente, JPanel cPanel, final boolean editable,
			String mensaje) {
		try{
			clientes = cargoClientes();
			setTitle("Confirma");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 925, 315);
			this.setLocationRelativeTo(cPanel);
			contentPane = new JPanel();
			setContentPane(contentPane);
			contentPane.setLayout(new BorderLayout(0, 0));

			JPanel ZonaEdicion = new JPanel();
			contentPane.add(ZonaEdicion, BorderLayout.CENTER);
			ZonaEdicion.setLayout(new MigLayout("", "[][388.00px][][grow]",
			"[grow][][16px][][grow]"));
			if (!mensaje.equals("")) {
				JLabel lblNewLabelMensaje = new JLabel(mensaje);
				lblNewLabelMensaje
				.setFont(new Font("Lucida Grande", Font.PLAIN, 21));
				ZonaEdicion.add(lblNewLabelMensaje, "cell 2 0,alignx center");
			}

			JLabel lblCi = new JLabel("Ci");
			ZonaEdicion.add(lblCi, "cell 0 1,alignx left");

			textFieldCi = new JTextField();
			textFieldCi.setText(String.valueOf(cliente.getCi()));
			textFieldCi.setEditable(editable);
			textFieldCi.setColumns(10);
			ZonaEdicion.add(textFieldCi, "cell 1 1,growx");

			JLabel label = new JLabel("Nombre");
			ZonaEdicion.add(label, "cell 2 1");

			textFieldNom = new JTextField();
			textFieldNom.setText(cliente.getNombre());
			textFieldNom.setEditable(editable);
			textFieldNom.setColumns(10);
			ZonaEdicion.add(textFieldNom, "cell 3 1,growx");

			JLabel lblAp = new JLabel("Apellido");
			ZonaEdicion.add(lblAp, "cell 0 2,alignx left,aligny center");

			textFieldAp = new JTextField();
			textFieldAp.setText(cliente.getApellido());
			textFieldAp.setEditable(editable);
			ZonaEdicion.add(textFieldAp, "cell 1 2,growx");
			textFieldAp.setColumns(10);

			JLabel lblNewLabel_1 = new JLabel("Mail");
			ZonaEdicion.add(lblNewLabel_1, "cell 2 2");

			textFieldMail = new JTextField();
			textFieldMail.setText(cliente.getEmail());
			textFieldMail.setEditable(editable);
			textFieldMail.setColumns(10);
			ZonaEdicion.add(textFieldMail, "cell 3 2,growx");

			JLabel lblDir = new JLabel("Direcci\u00F3n");
			ZonaEdicion.add(lblDir, "cell 0 3,alignx left,aligny center");

			textFieldDir = new JTextField();
			textFieldDir.setText(cliente.getDireccion());
			textFieldDir.setEditable(editable);
			textFieldDir.setColumns(10);
			ZonaEdicion.add(textFieldDir, "cell 1 3,growx,aligny center");

			JLabel lblNewLabel = new JLabel("Telefono");
			ZonaEdicion.add(lblNewLabel, "cell 2 3");

			textFieldTel = new JTextField();
			textFieldTel.setText(String.valueOf(cliente.getTel()));
			textFieldTel.setEditable(editable);
			textFieldTel.setColumns(10);
			ZonaEdicion.add(textFieldTel, "cell 3 3,growx");

			JLabel lblDescuento = new JLabel("Descuento");
			ZonaEdicion.add(lblDescuento, "cell 0 4");

			JSpinner spinner = new JSpinner();
			spinner.setEnabled(editable);
			spinner.setModel(new SpinnerNumberModel(Integer.parseInt(cliente
					.getDescuento().toString()), new Integer(0), null, new Integer(
							1)));

			ZonaEdicion.add(spinner, "cell 1 4,alignx left,aligny center");

			JPanel ZonaBotones = new JPanel();
			contentPane.add(ZonaBotones, BorderLayout.SOUTH);
			ZonaBotones.setLayout(new MigLayout("", "[grow][][]", "[]"));

			JButton btnAceptar = new JButton("Aceptar");
			ZonaBotones.add(btnAceptar, "cell 1 0,alignx center,growy");

			JButton btnCancelar = new JButton("Cancelar");
			btnCancelar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					cerrar();
				}
			});
			ZonaBotones.add(btnCancelar, "cell 2 0,growx,aligny center");
		}catch(NoServerConnectionException e){
			MensajeGenerico nuevo = new MensajeGenerico(e.getMessage(),devuelve());
			nuevo.setVisible(true);
		}catch(NoDatabaseConnection e){
			MensajeGenerico nuevoFrame = new MensajeGenerico(e.getMessage(),devuelve());
			nuevoFrame.setVisible(true);
		}
	}

	// Metodo cerrar Ventana
	public void cerrar() {
		this.setVisible(false);
	}

	// busca en lsita
	public ClientVO buscaEnLista(String a) {
		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i).getNombre().equals(a)) {
				return clientes.get(i);
			}
		}
		return null;
	}

	// Cargo Clientes a arraylist
	private ArrayList<ClientVO> cargoClientes() throws NoServerConnectionException, NoDatabaseConnection {
		ClientMgt cli = ServiceFacade.getInstance().getClientMgt();
		return cli.allClients();
	}

	public JFrame devuelve(){
		return this;
	}
}
