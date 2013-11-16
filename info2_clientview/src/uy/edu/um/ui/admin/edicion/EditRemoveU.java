package uy.edu.um.ui.admin.edicion;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import uy.edu.um.exceptions.checks.HasBlanksException;
import uy.edu.um.exceptions.checks.NoDatabaseConnection;
import uy.edu.um.exceptions.checks.NoServerConnectionException;
import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.categories.interfaces.CategoryMgt;
import uy.edu.um.services.user.interfaces.UserMgt;
import uy.edu.um.ui.mensajes.MensajeGenerico;
import uy.edu.um.value_object.categories.CategoryVO;
import uy.edu.um.value_object.user.UserVO;

public class EditRemoveU extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldPass;
	private ArrayList<CategoryVO> categorias;
	String[] textos;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * 
	 * @param toSend
	 */
	public EditRemoveU(final UserVO user, JPanel cPanel,
			final boolean editable, String mensaje) {
		try {
			categorias = cargoCategorias();
			setTitle("Confirma");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 561, 300);
			this.setLocationRelativeTo(cPanel);
			contentPane = new JPanel();
			setContentPane(contentPane);
			contentPane.setLayout(new BorderLayout(0, 0));

			JPanel ZonaEdicion = new JPanel();
			contentPane.add(ZonaEdicion, BorderLayout.CENTER);
			ZonaEdicion.setLayout(new MigLayout("", "[grow][][388.00px][grow]",
					"[grow][16px][][grow]"));
			if (!mensaje.equals("")) {
				JLabel lblNewLabelMensaje = new JLabel(mensaje);
				lblNewLabelMensaje.setFont(new Font("Lucida Grande",
						Font.PLAIN, 21));
				ZonaEdicion.add(lblNewLabelMensaje, "cell 2 0,alignx center");
			}

			JLabel lblNombre = new JLabel("Nombre");
			ZonaEdicion.add(lblNombre, "cell 1 1,alignx left,aligny center");

			textFieldNombre = new JTextField();
			textFieldNombre.setEnabled(false);
			textFieldNombre.setEditable(false);
			textFieldNombre.setText(user.getUser());
			ZonaEdicion.add(textFieldNombre, "cell 2 1,growx");
			textFieldNombre.setColumns(10);

			JLabel lblPrecio = new JLabel("Contrase\u00F1a");
			ZonaEdicion.add(lblPrecio, "cell 1 2,alignx left,aligny center");

			textFieldPass = new JTextField();
			textFieldPass.setText(user.getPassword());
			textFieldPass.setEditable(editable);
			textFieldPass.setColumns(10);
			ZonaEdicion.add(textFieldPass, "cell 2 2,growx,aligny center");

			final JCheckBox esAdmin = new JCheckBox("Es Administrador");
			ZonaEdicion.add(esAdmin, "cell 2 3,alignx right,aligny top");
			esAdmin.setSelected(user.isAdmin());
			esAdmin.setEnabled(editable);

			JPanel ZonaBotones = new JPanel();
			contentPane.add(ZonaBotones, BorderLayout.SOUTH);
			ZonaBotones.setLayout(new MigLayout("", "[grow][][]", "[]"));

			JButton btnAceptar = new JButton("Aceptar");
			btnAceptar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					boolean bandera = false;
					while (bandera == false) {
						String password = textFieldPass.getText();
						if (!password.equals("")) {
							UserMgt nuevo = ServiceFacade.getInstance()
									.getUserMgt();
							if (editable == true) {
								UserVO usrEdit = null;
								try {
									usrEdit = nuevo.createUserVO(
											user.getUser(),
											textFieldPass.getText(),
											esAdmin.isSelected());
									nuevo.editUserVO(usrEdit);
									cerrar();
								} catch (HasBlanksException e1) {
									// TODO Auto-generated catch block
									MensajeGenerico mensaje = new MensajeGenerico(
											e1.getMessage(), devuelve());
									mensaje.setVisible(true);
								} catch (NoServerConnectionException e1) {
									// TODO Auto-generated catch block
									MensajeGenerico mensaje = new MensajeGenerico(
											e1.getMessage(), devuelve());
									mensaje.setVisible(true);
								} catch (NoDatabaseConnection e1) {
									// TODO Auto-generated catch block
									MensajeGenerico mensaje = new MensajeGenerico(
											e1.getMessage(), devuelve());
									mensaje.setVisible(true);
								}

								MensajeGenerico mensaje = new MensajeGenerico(
										"Usuario Editado Correctamente",
										devuelve());
								mensaje.setVisible(true);
								bandera = true;
							} else {
								try {
									nuevo.removeUserVO(user);
								} catch (NoServerConnectionException e1) {
									// TODO Auto-generated catch block
									MensajeGenerico mensaje = new MensajeGenerico(
											e1.getMessage(), devuelve());
									mensaje.setVisible(true);
								} catch (NoDatabaseConnection e1) {
									// TODO Auto-generated catch block
									MensajeGenerico mensaje = new MensajeGenerico(
											e1.getMessage(), devuelve());
									mensaje.setVisible(true);
								}
								cerrar();
								MensajeGenerico mensaje = new MensajeGenerico(
										"Usuario Eliminado Correctamente",
										devuelve());
								mensaje.setVisible(true);
								bandera = true;
							}
						}
						bandera = true;
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
		} catch (NoServerConnectionException e) {
			MensajeGenerico nuevo = new MensajeGenerico(e.getMessage(),
					devuelve());
			nuevo.setVisible(true);
		} catch (NoDatabaseConnection e) {
			MensajeGenerico nuevoFrame = new MensajeGenerico(e.getMessage(),
					devuelve());
			nuevoFrame.setVisible(true);
		}

	}

	// Metodo cerrar Ventana
	public void cerrar() {
		this.setVisible(false);
	}

	// Cargar al combo box
	private String[] cargaAlCombo(JComboBox a) {
		ArrayList<String> aux = new ArrayList<String>();
		aux.add("---- Desplegar Lista ----");
		aux.add("");
		int j = 0;
		while (j < categorias.size()) {
			aux.add(categorias.get(j).getNombre());
			j++;
		}
		textos = new String[aux.size() + 1];
		for (int i = 0; i < textos.length - 1; i++) {
			textos[i] = aux.get(i);
		}
		return textos;
	}

	// busca en lsita
	public CategoryVO buscaEnLista(String a) {
		for (int i = 0; i < categorias.size(); i++) {
			if (categorias.get(i).getNombre().equals(a)) {
				return categorias.get(i);
			}
		}
		return null;
	}

	// Cargo categorias a arraylist
	private ArrayList<CategoryVO> cargoCategorias()
			throws NoServerConnectionException, NoDatabaseConnection {
		CategoryMgt cat = ServiceFacade.getInstance().getCategoryMgt();
		return cat.allCategories();
	}

	public JFrame devuelve() {
		return this;
	}
}
