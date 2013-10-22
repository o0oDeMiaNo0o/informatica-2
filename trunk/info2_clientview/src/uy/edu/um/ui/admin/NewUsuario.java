package uy.edu.um.ui.admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import uy.edu.um.imagenes.DirLocal;
import uy.edu.um.ui.MensajeGenerico;
import uy.edu.um.ui.clasesAuxiliares.ImagePanel;
import uy.edu.um.ui.clasesAuxiliares.TransparentPanel;

public class NewUsuario extends BasicoAdmin {

	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JLabel lblNewLabel;
	private JButton btnCancelar;
	private JLabel lblContrasea;
	private JTextField textField;
	private JRadioButton rdbtnNewRadioButton;
	private TransparentPanel transparentPanel_1;
	private ImagePanel imagePanel;
	private URL bernie = DirLocal.class.getResource("Bernie's.png");
	private TransparentPanel transparentPanelBotones;

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
		transparentPanel.setLayout(new MigLayout("",
				"[grow][][92px,grow][grow]", "[][][29px][grow][]"));

		lblNewLabel = new JLabel("Nombre");
		transparentPanel.add(lblNewLabel, "cell 1 0,alignx left,aligny center");

		textFieldNombre = new JTextField();
		transparentPanel.add(textFieldNombre, "cell 2 0,growx");
		textFieldNombre.setColumns(10);

		lblContrasea = new JLabel("Contrase\u00F1a");
		transparentPanel.add(lblContrasea, "cell 1 1,alignx left");

		textField = new JTextField();
		textField.setColumns(10);
		transparentPanel.add(textField, "cell 2 1,growx");

		rdbtnNewRadioButton = new JRadioButton("Es Administrador");
		transparentPanel
				.add(rdbtnNewRadioButton, "cell 2 2,alignx right,growy");

		transparentPanel_1 = new TransparentPanel();
		contentPane.add(transparentPanel_1, BorderLayout.NORTH);

		imagePanel = new ImagePanel(bernie);
		transparentPanel_1.add(imagePanel);

		transparentPanelBotones = new TransparentPanel();
		contentPane.add(transparentPanelBotones, BorderLayout.SOUTH);
		transparentPanelBotones.setLayout(new MigLayout("", "[grow]", "[]"));

		JButton btnAceptar = new JButton("Aceptar");
		transparentPanelBotones.add(btnAceptar,
				"flowx,cell 0 0,alignx right,aligny center");
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

		btnCancelar = new JButton("Cancelar");
		transparentPanelBotones.add(btnCancelar, "cell 0 0");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cerrar();
			}

		});
	}

	private void cerrar() {
		this.dispose();

	}

}
