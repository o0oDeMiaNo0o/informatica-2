package uy.edu.um.ui.usuarios;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.people.clients.interfaces.ClientMgt;
import uy.edu.um.ui.MensajeGenerico;
import uy.edu.um.ui.clasesAuxiliares.BasicoUsuario;
import uy.edu.um.ui.clasesAuxiliares.Helpers;
import uy.edu.um.ui.clasesAuxiliares.TransparentPanel;
import uy.edu.um.value_object.people.client.ClientVO;
import javax.swing.JSpinner;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Font;

public class NewCliente extends BasicoUsuario {

	private JTextField textFieldNom;
	private JTextField textFieldCi;
	private JTextField textFieldEmail;
	private JTextField textFieldAp;
	private JTextField textFieldTel;
	private JTextField textFieldDir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewCliente frame = new NewCliente();
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
	public NewCliente() {
		super();

		TransparentPanel transparentPanel = new TransparentPanel();
		getContentPane().add(transparentPanel, BorderLayout.CENTER);
		transparentPanel.setLayout(new MigLayout("", "[][][grow][][grow]",
				"[][][][][][][][][][][][][grow][]"));

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.WHITE);
		transparentPanel.add(lblNombre, "cell 1 1,alignx left,aligny center");

		textFieldNom = new JTextField();
		transparentPanel.add(textFieldNom, "cell 2 1,growx");
		textFieldNom.setColumns(10);

		JLabel label = new JLabel("Apellido");
		label.setForeground(Color.WHITE);
		transparentPanel.add(label, "cell 3 1,alignx left,aligny center");

		textFieldAp = new JTextField();
		textFieldAp.setColumns(10);
		transparentPanel.add(textFieldAp, "cell 4 1,growx");

		JLabel lblCi = new JLabel("CI");
		lblCi.setForeground(Color.WHITE);
		transparentPanel.add(lblCi, "cell 1 3,alignx left,aligny center");

		textFieldCi = new JTextField();
		textFieldCi.setColumns(10);
		transparentPanel.add(textFieldCi, "flowx,cell 2 3,growx");

		JLabel label_1 = new JLabel("Tel\u00E9fono");
		label_1.setForeground(Color.WHITE);
		transparentPanel.add(label_1, "cell 3 3,alignx left,aligny center");

		textFieldTel = new JTextField();
		textFieldTel.setColumns(10);
		transparentPanel.add(textFieldTel, "cell 4 3,growx");

		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setForeground(Color.WHITE);
		transparentPanel.add(lblEmail, "cell 1 5,alignx left,aligny center");

		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		transparentPanel.add(textFieldEmail, "cell 2 5,growx");

		JLabel label_2 = new JLabel("Direcci\u00F3n");
		label_2.setForeground(Color.WHITE);
		transparentPanel.add(label_2, "cell 3 5,alignx left,aligny center");

		textFieldDir = new JTextField();
		textFieldDir.setColumns(10);
		transparentPanel.add(textFieldDir, "cell 4 5,growx");

		final JSpinner spinner = new JSpinner();
		transparentPanel.add(spinner, "cell 2 7");

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!textFieldNom.getText().isEmpty()) {
					if (Helpers.isNumeric(textFieldCi.getText())) {
						if (!textFieldEmail.getText().isEmpty()) {
							if (!textFieldAp.getText().isEmpty()) {
								if (Helpers.isNumeric(textFieldTel.getText())) {
									if (!textFieldDir.getText().isEmpty()) {
										ClientMgt client = ServiceFacade
												.getInstance().getClientMgt();
										ClientVO cliente = client.createClientVO(
												textFieldNom.getText(),
												textFieldAp.getText(), Integer
														.parseInt(textFieldCi
																.getText()),
												Integer.parseInt(textFieldTel
														.getText()),
												textFieldDir.getText(),
												textFieldEmail.getText(),
												Integer.parseInt(spinner
														.getValue().toString()));
										client.sendClientVO(cliente);
										MensajeGenerico new10 = new MensajeGenerico(
												"Cliente Agregado", contentPane);
										new10.setVisible(true);
									} else {
										MensajeGenerico new6 = new MensajeGenerico(
												"Direccion Vacia", contentPane);
										new6.setVisible(true);
									}
								} else {
									MensajeGenerico new5 = new MensajeGenerico(
											"Telefono Vacio o No Numerico",
											contentPane);
									new5.setVisible(true);
								}
							} else {
								MensajeGenerico new4 = new MensajeGenerico(
										"Apellido Vacio", contentPane);
								new4.setVisible(true);
							}
						} else {
							MensajeGenerico new3 = new MensajeGenerico(
									"Email Vacio", contentPane);
							new3.setVisible(true);
						}

					} else {
						MensajeGenerico new2 = new MensajeGenerico(
								"Ci Vacio o No Numerico", contentPane);
						new2.setVisible(true);
					}
				} else {
					MensajeGenerico new1 = new MensajeGenerico("Nombre Vacio",
							contentPane);
					new1.setVisible(true);
				}

			}
		});

		JLabel lblDescuento = new JLabel("Descuento");
		lblDescuento.setForeground(Color.WHITE);
		transparentPanel.add(lblDescuento, "cell 1 7");

		Component horizontalStrut = Box.createHorizontalStrut(20);
		transparentPanel.add(horizontalStrut, "flowx,cell 2 7,alignx left");
		transparentPanel.add(btnAceptar,
				"flowx,cell 4 13,alignx right,aligny center");

		JButton btnCancelar = new JButton("Cancelar");
		transparentPanel.add(btnCancelar,
				"cell 4 13,alignx right,aligny center");

		JLabel lblNoIngresarDigito = new JLabel(
				"No ingresar Digito Verificador");
		lblNoIngresarDigito.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblNoIngresarDigito.setForeground(Color.WHITE);
		transparentPanel.add(lblNoIngresarDigito, "cell 2 3");
	}

}
