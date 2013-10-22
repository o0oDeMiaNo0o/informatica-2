package uy.edu.um.ui.admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import uy.edu.um.ui.MensajeGenerico;
import uy.edu.um.ui.clasesAuxiliares.TransparentPanel;

public class NewUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JLabel lblNewLabel;
	private JButton btnCancelar;
	private JLabel lblContrasea;
	private JTextField textField;
	private JRadioButton rdbtnNewRadioButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewUsuario frame = new NewUsuario();
					frame.setLocationRelativeTo(null);
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
	public NewUsuario() {
		setTitle("Nuevo Usuario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		TransparentPanel transparentPanel = new TransparentPanel();
		contentPane.add(transparentPanel, BorderLayout.CENTER);
		transparentPanel.setLayout(new MigLayout("", "[][92px,grow]",
				"[][][][29px][][][][][]"));

		lblNewLabel = new JLabel("Nombre");
		transparentPanel.add(lblNewLabel, "cell 0 1,alignx left,aligny center");

		textFieldNombre = new JTextField();
		transparentPanel.add(textFieldNombre, "cell 1 1,growx");
		textFieldNombre.setColumns(10);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (!textFieldNombre.getText().isEmpty()) {
					if (!textField.getText().isEmpty()) {
						boolean admin = rdbtnNewRadioButton.isSelected();

					} else {
						MensajeGenerico test = new MensajeGenerico(
								"Contrase–a Vacia", contentPane);
					}
				} else {
					MensajeGenerico test = new MensajeGenerico("Nombre Vacio",
							contentPane);
				}
			}
		});

		lblContrasea = new JLabel("Contrase\u00F1a");
		transparentPanel.add(lblContrasea, "cell 0 2,alignx left");

		textField = new JTextField();
		textField.setColumns(10);
		transparentPanel.add(textField, "cell 1 2,growx");

		rdbtnNewRadioButton = new JRadioButton("Es Administrador");
		transparentPanel
				.add(rdbtnNewRadioButton, "cell 1 3,alignx right,growy");
		transparentPanel.add(btnAceptar,
				"flowx,cell 1 8,alignx right,aligny top");

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cerrar();
			}

		});
		transparentPanel.add(btnCancelar, "cell 1 8");
	}

	private void cerrar() {
		this.dispose();

	}

}
