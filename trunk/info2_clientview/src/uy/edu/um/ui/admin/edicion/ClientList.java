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
import uy.edu.um.services.people.clients.interfaces.ClientMgt;
import uy.edu.um.ui.MensajeGenerico;
import uy.edu.um.ui.admin.BasicoAdmin;
import uy.edu.um.ui.clasesAuxiliares.TransparentPanel;
import uy.edu.um.value_object.people.client.ClientVO;

public class ClientList extends BasicoAdmin {

	private JTable table;
	private JTextField textFieldID;
	private ArrayList<ClientVO> clientes = cargoClientes();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientList frame = new ClientList();
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
	public ClientList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		TransparentPanel transparentPanel = new TransparentPanel();
		getContentPane().add(transparentPanel, BorderLayout.CENTER);
		transparentPanel.setLayout(new MigLayout("", "[grow][]", "[grow]"));

		TransparentPanel transparentPanel_2 = new TransparentPanel();
		transparentPanel.add(transparentPanel_2, "cell 1 0,grow");
		transparentPanel_2.setLayout(new MigLayout("", "[grow][][grow]",
				"[grow][][][grow]"));

		JLabel lblICliente = new JLabel("Id Cliente: ");
		transparentPanel_2.add(lblICliente, "flowx,cell 1 1,alignx center");

		textFieldID = new JTextField();
		textFieldID.setColumns(10);
		transparentPanel_2.add(textFieldID, "cell 1 1,alignx center");

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int i = table.getSelectedRow();
				if (i > 0) {
					textFieldID.setText("" + clientes.get(i - 1).getId());
				}
			}
		});
		table.setSurrendersFocusOnKeystroke(true);
		transparentPanel.add(table, "cell 0 0,grow");

		JButton btnEliminarCategoria = new JButton("Eliminar Cliente");
		btnEliminarCategoria.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (buscaCategoria(textFieldID.getText())) {
				} else {
					MensajeGenerico nuevo = new MensajeGenerico(
							"Categoria No Existe", contentPane);
					nuevo.setVisible(true);
				}
			}

		});

		JButton btnEditarCliente = new JButton("Editar Cliente");
		transparentPanel_2.add(btnEditarCliente, "flowx,cell 1 2");
		transparentPanel_2.add(btnEliminarCategoria,
				"cell 1 2,alignx center,aligny top");
		cargaATabla();
	}

	// Metodos Auxiliares

	// Busca categoria elegida
	private boolean buscaCategoria(String text) {
		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i).getId() == Integer.parseInt(text)) {
				return true;
			}
		}
		return false;
	}

	// Cargo categorias a arraylist
	private ArrayList<ClientVO> cargoClientes() {
		ClientMgt nuevo = ServiceFacade.getInstance().getClientMgt();
		return nuevo.allClients();
	}

	// Cargo a Tabla Clientes
	public void cargaATabla() {
		Object[][] aux = null;
		if ((clientes.size() != 0)) {
			aux = new Object[clientes.size() + 1][7];
			aux[0][0] = "Id";
			aux[0][1] = "Nombre";
			aux[0][2] = "Apellido";
			aux[0][3] = "Direccion";
			aux[0][4] = "Telefono";
			aux[0][5] = "Email";
			aux[0][6] = "Descuento";
			for (int i = 0; i < clientes.size(); i++) {
				aux[i + 1][0] = clientes.get(i).getId();
				aux[i + 1][1] = clientes.get(i).getNombre();
				aux[i + 1][2] = clientes.get(i).getApellido();
				aux[i + 1][3] = clientes.get(i).getDireccion();
				aux[i + 1][4] = clientes.get(i).getTel();
				aux[i + 1][5] = clientes.get(i).getEmail();
				aux[i + 1][6] = clientes.get(i).getDescuento();
			}

		} else {
			aux = new Object[1][7];
			aux[0][0] = "Id";
			aux[0][1] = "Nombre";
			aux[0][2] = "Apellido";
			aux[0][3] = "Direccion";
			aux[0][4] = "Telefono";
			aux[0][5] = "Email";
			aux[0][6] = "Descuento";
		}
		table.setModel(new DefaultTableModel(aux, new String[] { "Id",
				"Nombre", "Apellido", "Direccion", "Telefono", "Email",
				"Descuento" }));
	}

	// Ve que categoria eligo
	public ClientVO buscaEnLista(String a) {
		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i).getNombre().equals(a)) {
				return clientes.get(i);
			}
		}
		return null;

	}

}
