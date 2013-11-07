package uy.edu.um.ui.admin.creacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import uy.edu.um.exceptions.checks.HasBlanksException;
import uy.edu.um.exceptions.checks.NoServerConnectionException;
import uy.edu.um.imagenes.DirLocal;
import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.user.interfaces.UserMgt;
import uy.edu.um.ui.admin.BasicoAdmin;
import uy.edu.um.ui.clasesAuxiliares.TransparentPanel;
import uy.edu.um.ui.mensajes.MensajeGenerico;
import uy.edu.um.value_object.user.UserVO;

public class NewUser extends BasicoAdmin {
	private JTextField textFieldNombre;
	private JLabel lblNewLabel;
	private JButton btnCancelar;
	private JLabel lblContrasea;
	private JTextField textField;
	private JRadioButton rdbtnNewRadioButton;
	private URL bernie = DirLocal.class.getResource("Bernie's.png");
	private TransparentPanel transparentPanelBotones;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewUser frame = new NewUser();
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
	public NewUser() {
		setTitle("Nuevo Usuario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		TransparentPanel transparentPanel_1 = new TransparentPanel();
		getContentPane().add(transparentPanel_1, BorderLayout.CENTER);
		transparentPanel_1.setLayout(new MigLayout("", "[grow][][grow][grow]",
				"[][][][][grow]"));

		JLabel lblNombreUsuario = new JLabel("Nombre Usuario");
		transparentPanel_1.add(lblNombreUsuario, "cell 1 1,alignx left");

		textField_1 = new JTextField();
		transparentPanel_1.add(textField_1, "cell 2 1,growx");
		textField_1.setColumns(10);

		JLabel lblContrasea_1 = new JLabel("Contrase\u00F1a");
		transparentPanel_1.add(lblContrasea_1, "cell 1 2,alignx left");

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		transparentPanel_1.add(textField_2, "cell 2 2,growx");

		JRadioButton rdbtnEsAdministrador = new JRadioButton("Es Administrador");
		transparentPanel_1.add(rdbtnEsAdministrador, "cell 2 3,alignx right");

		TransparentPanel transparentPanel_2 = new TransparentPanel();
		getContentPane().add(transparentPanel_2, BorderLayout.SOUTH);
		transparentPanel_2.setLayout(new MigLayout("", "[][grow]", "[]"));

		JButton btnAceptar_1 = new JButton("Aceptar");
		btnAceptar_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (textField_1.getText().equals("")) {
					MensajeGenerico nuevo = new MensajeGenerico("Nombre Vacio",
							devuelve());
					nuevo.setVisible(true);
				} else if (textField_2.getText().equals("")) {
					MensajeGenerico nuevo = new MensajeGenerico(
							"Contrase–a Vacia", devuelve());
					nuevo.setVisible(true);
				} else {
					try{
					boolean admin = false;
					if (rdbtnNewRadioButton.isSelected()) {
						admin = true;
					}
					UserMgt nuevo = ServiceFacade.getInstance().getUserMgt();
					UserVO nuevoUser = null;
					try {
						nuevoUser = nuevo.createUserVO(textField_1.getText(), textField_2.getText(),
								admin);
					} catch (HasBlanksException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					nuevo.addUser(nuevoUser);
					}catch(NoServerConnectionException e){
						MensajeGenerico nuevo = new MensajeGenerico(e.getMessage(),devuelve());
						nuevo.setVisible(true);
					}
				}
			}
		});
		transparentPanel_2.add(btnAceptar_1,
				"flowx,cell 1 0,alignx right,aligny center");

		JButton btnCancelar_1 = new JButton("Cancelar");
		transparentPanel_2.add(btnCancelar_1, "cell 1 0,alignx right");

		transparentPanelBotones = new TransparentPanel();
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
								"Contrase–a Vacia", devuelve());
					}
				} else {
					MensajeGenerico test = new MensajeGenerico("Nombre Vacio",
							devuelve());
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

		TransparentPanel transparentPanel = new TransparentPanel();
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
	}

	private void cerrar() {
		this.dispose();

	}
	public JFrame devuelve(){
		return this;
	}

}
