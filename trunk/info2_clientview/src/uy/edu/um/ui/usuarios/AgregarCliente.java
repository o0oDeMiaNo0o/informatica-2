package uy.edu.um.ui.usuarios;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import uy.edu.um.ui.clasesAuxiliares.BasicoUsuario;
import uy.edu.um.ui.clasesAuxiliares.TransparentPanel;

public class AgregarCliente extends BasicoUsuario {

	private JTextField textFieldNom;
	private JTextField textFieldCi;
	private JTextField textFieldEmail;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarCliente frame = new AgregarCliente();
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
	public AgregarCliente() {
		super();

		TransparentPanel transparentPanel = new TransparentPanel();
		getContentPane().add(transparentPanel, BorderLayout.CENTER);
		transparentPanel.setLayout(new MigLayout("", "[][][grow][][grow]", "[][][][][][][][][][][][][grow][]"));

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.WHITE);
		transparentPanel.add(lblNombre, "cell 1 1,alignx left,aligny center");

		textFieldNom = new JTextField();
		transparentPanel.add(textFieldNom, "cell 2 1,growx");
		textFieldNom.setColumns(10);

		JLabel label = new JLabel("Apellido");
		label.setForeground(Color.WHITE);
		transparentPanel.add(label, "cell 3 1,alignx left,aligny center");

		textField = new JTextField();
		textField.setColumns(10);
		transparentPanel.add(textField, "cell 4 1,growx");

		JLabel lblCi = new JLabel("CI");
		lblCi.setForeground(Color.WHITE);
		transparentPanel.add(lblCi, "cell 1 3,alignx left,aligny center");

		textFieldCi = new JTextField();
		textFieldCi.setColumns(10);
		transparentPanel.add(textFieldCi, "flowx,cell 2 3,growx");

		JLabel label_1 = new JLabel("Tel\u00E9fono");
		label_1.setForeground(Color.WHITE);
		transparentPanel.add(label_1, "cell 3 3,alignx left,aligny center");

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		transparentPanel.add(textField_1, "cell 4 3,growx");

		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setForeground(Color.WHITE);
		transparentPanel.add(lblEmail, "cell 1 5,alignx left,aligny center");

		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		transparentPanel.add(textFieldEmail, "cell 2 5,growx");
		
		JLabel label_2 = new JLabel("Direcci\u00F3n");
		label_2.setForeground(Color.WHITE);
		transparentPanel.add(label_2, "cell 3 5,alignx left,aligny center");

		JLabel label_3 = new JLabel("-");
		label_3.setForeground(Color.WHITE);
		transparentPanel.add(label_3, "cell 2 3");

		textField_3 = new JTextField();
		transparentPanel.add(textField_3, "cell 2 3,alignx center");
		textField_3.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		transparentPanel.add(textField_2, "cell 4 5,growx");

		JButton btnAceptar = new JButton("Aceptar");
		transparentPanel.add(btnAceptar,
				"flowx,cell 4 13,alignx right,aligny center");

		JButton btnCancelar = new JButton("Cancelar");
		transparentPanel.add(btnCancelar,
				"cell 4 13,alignx right,aligny center");
	}

}
