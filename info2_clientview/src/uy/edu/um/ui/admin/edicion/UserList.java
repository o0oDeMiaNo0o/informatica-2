package uy.edu.um.ui.admin.edicion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.MigLayout;
import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.categories.interfaces.CategoryMgt;
import uy.edu.um.services.user.interfaces.UserMgt;
import uy.edu.um.ui.MensajeGenerico;
import uy.edu.um.ui.admin.BasicoAdmin;
import uy.edu.um.ui.clasesAuxiliares.TransparentPanel;
import uy.edu.um.value_object.article.ArticleVO;
import uy.edu.um.value_object.categories.CategoryVO;
import uy.edu.um.value_object.user.UserVO;

public class UserList extends BasicoAdmin {
	private ArrayList<UserVO> listaUser = cargoListado();
	private String[] textos;
	private JTable table;
	private JTextField textFieldNombre;
	private UserVO user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserList frame = new UserList(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @param user
	 */
	public UserList(UserVO user) {

		this.user = user; // Usuario Actual

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		TransparentPanel transparentPanel = new TransparentPanel();
		getContentPane().add(transparentPanel, BorderLayout.CENTER);
		transparentPanel.setLayout(new MigLayout("", "[][grow][]", "[grow]"));

		TransparentPanel transparentPanel_2 = new TransparentPanel();
		transparentPanel.add(transparentPanel_2, "cell 2 0,grow");
		transparentPanel_2.setLayout(new MigLayout("", "[]", "[grow][][grow]"));

		JLabel lblIdUsuario = new JLabel("Usuario: ");
		transparentPanel_2.add(lblIdUsuario, "flowx,cell 0 1,alignx center");

		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		transparentPanel_2.add(textFieldNombre, "cell 0 1,alignx center");

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int i = table.getSelectedRow();
				if (i > 0) {
					textFieldNombre
							.setText("" + listaUser.get(i - 1).getUser());
				}
			}
		});
		table.setSurrendersFocusOnKeystroke(true);
		transparentPanel.add(table, "cell 1 0,grow");

		JButton btnEditarUsuario = new JButton("Editar Usuario");
		btnEditarUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (buscaUsuario(textFieldNombre.getText())) {
					EditRemoveU nuevo = new EditRemoveU(
							devuelveUser(textFieldNombre.getText()),
							contentPane, true, "");
					nuevo.setVisible(true);
				} else {
					MensajeGenerico nuevo = new MensajeGenerico(
							"Producto No Existe", contentPane);
					nuevo.setVisible(true);
				}
			}

		});
		transparentPanel_2.add(btnEditarUsuario,
				"flowx,cell 0 2,alignx center,aligny top");

		JButton btnEliminarUsuario = new JButton("Eliminar Usuario");
		btnEliminarUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (buscaUsuario(textFieldNombre.getText())) {
					EditRemoveU nuevo = new EditRemoveU(
							devuelveUser(textFieldNombre.getText()),
							contentPane, false, "Desea Eliminar Este Usuario?");
					nuevo.setVisible(true);
				} else {
					MensajeGenerico nuevo = new MensajeGenerico(
							"Producto No Existe", contentPane);
					nuevo.setVisible(true);
				}
			}
		});
		transparentPanel_2.add(btnEliminarUsuario,
				"cell 0 2,alignx center,aligny top");
		cargaATabla();
	}

	// Metodos Auxiliares

	private boolean buscaUsuario(String text) {
		for (int i = 0; i < listaUser.size(); i++) {
			if (listaUser.get(i).getUser().equals(text)) {
				return true;
			}
		}
		return false;
	}

	private UserVO devuelveUser(String name) {
		for (int i = 0; i < listaUser.size(); i++) {
			if (listaUser.get(i).getUser().equals(name)) {
				return listaUser.get(i);
			}
		}
		return null;
	}

	// Cargo a Tabla Users
	public void cargaATabla() {
		Object[][] aux = null;
		if ((listaUser.size() != 0)) {
			aux = new Object[listaUser.size() + 1][3];
			aux[0][0] = "Nombre";
			aux[0][1] = "Contrase–a";
			aux[0][2] = "Es Administrador";
			for (int i = 0; i < listaUser.size(); i++) {
				aux[i + 1][0] = listaUser.get(i).getUser();
				aux[i + 1][1] = listaUser.get(i).getPassword();
				aux[i + 1][2] = Boolean.toString(listaUser.get(i).isAdmin());
			}

		} else {
			aux = new Object[1][3];
			aux[0][0] = "Nombre";
			aux[0][1] = "Contrase–a";
			aux[0][2] = "Es Administrador";
		}
		table.setModel(new DefaultTableModel(aux, new String[] { "Nombre",
				"Contrase–a", "Es Administrador" }));
	}

	public ArrayList<UserVO> cargoListado() {
		UserMgt usr = ServiceFacade.getInstance().getUserMgt();
		return usr.allUsers();
	}

}
