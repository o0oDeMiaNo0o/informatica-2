package uy.edu.um.ui.admin.listas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.MigLayout;
import uy.edu.um.exceptions.checks.NoDatabaseConnection;
import uy.edu.um.exceptions.checks.NoServerConnectionException;
import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.people.clients.interfaces.ClientMgt;
import uy.edu.um.ui.admin.BasicoAdmin;
import uy.edu.um.ui.admin.edicion.EditRemoveC;
import uy.edu.um.ui.clasesAuxiliares.TextFieldAutocompletar;
import uy.edu.um.ui.clasesAuxiliares.TransparentPanel;
import uy.edu.um.ui.mensajes.MensajeGenerico;
import uy.edu.um.value_object.people.client.ClientVO;

public class ClientList extends BasicoAdmin {

	private JTable table;
	private JTextField textFieldID;
	private ArrayList<ClientVO> clientes;
	private Timer timer = null;

	public ClientList() throws NoServerConnectionException,
			NoDatabaseConnection {
		clientes = cargoClientes();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		TransparentPanel transparentPanel = new TransparentPanel();
		getContentPane().add(transparentPanel, BorderLayout.CENTER);
		transparentPanel
				.setLayout(new MigLayout("", "[grow][grow][]", "[grow]"));

		TransparentPanel transparentPanel_1 = new TransparentPanel();
		transparentPanel.add(transparentPanel_1, "cell 0 0,grow");
		transparentPanel_1.setLayout(new MigLayout("", "[][grow][]",
				"[grow][][][grow]"));

		JLabel lblBsquedaRpida = new JLabel("B\u00FAsqueda R\u00E1pida");
		transparentPanel_1.add(lblBsquedaRpida, "cell 1 1,alignx center");

		TextFieldAutocompletar textFieldAutocompletar = new TextFieldAutocompletar(
				devuelveNombres());
		textFieldAutocompletar.setText("");
		transparentPanel_1.add(textFieldAutocompletar, "flowx,cell 1 2,growx");

		JButton btnBuscar = new JButton("Buscar");
		transparentPanel_1.add(btnBuscar, "cell 2 2");

		TransparentPanel transparentPanel_2 = new TransparentPanel();
		transparentPanel.add(transparentPanel_2, "cell 2 0,grow");
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
					textFieldID.setText("" + clientes.get(i - 1).getCi());
				}
			}
		});
		table.setSurrendersFocusOnKeystroke(true);
		transparentPanel.add(table, "cell 1 0,grow");

		JButton btnEliminarCategoria = new JButton("Eliminar Cliente");
		btnEliminarCategoria.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ClientVO cliente = buscaEnLista(textFieldID.getText());
				if (cliente != null) {
					EditRemoveC nuevo = new EditRemoveC(cliente, contentPane,
							false, "Desea Eliminar Este Usuario");
					nuevo.setVisible(true);
				} else {
					MensajeGenerico nuevo = new MensajeGenerico(
							"Cliente No Existe", devuelve());
					nuevo.setVisible(true);
				}
			}

		});

		JButton btnEditarCliente = new JButton("Editar Cliente");
		btnEditarCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ClientVO cliente = buscaEnLista(textFieldID.getText());
				if (cliente != null) {
					EditRemoveC nuevo = new EditRemoveC(cliente, contentPane,
							true, "");
					nuevo.setVisible(true);
				} else {
					MensajeGenerico nuevo = new MensajeGenerico(
							"Cliente No Existe", devuelve());
					nuevo.setVisible(true);
				}
			}
		});

		transparentPanel_2.add(btnEditarCliente, "flowx,cell 1 2");
		transparentPanel_2.add(btnEliminarCategoria,
				"cell 1 2,alignx center,aligny top");
		cargaATabla();

		this.timer = new Timer(5000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					clientes = cargoClientes();
				} catch (NoDatabaseConnection e1) {
					MensajeGenerico msg = new MensajeGenerico(e1.getMessage(),
							ClientList.this);
					msg.setVisible(true);
				} catch (NoServerConnectionException e1) {
					MensajeGenerico msg = new MensajeGenerico(e1.getMessage(),
							ClientList.this);
					msg.setVisible(true);
				}
				table.removeAll();
				cargaATabla();
				table.invalidate();
				table.validate();
				table.repaint();
			}

		});
		timer.start();
	}

	// Metodos Auxiliares

	// Devuelve lista de nombres clientes
	private ArrayList<String> devuelveNombres() {
		ArrayList<String> aux = new ArrayList<String>();
		for (int i = 0; i < clientes.size(); i++) {
			aux.add(clientes.get(i).getNombre());
		}
		return aux;
	}

	// Cargo clientes a arraylist
	private ArrayList<ClientVO> cargoClientes() throws NoDatabaseConnection,
			NoServerConnectionException {
		ClientMgt nuevo = ServiceFacade.getInstance().getClientMgt();
		ArrayList<ClientVO> clients = new ArrayList<ClientVO>(2);
		clients = nuevo.allClients();
		return clients;
	}

	// Cargo a Tabla Clientes
	public void cargaATabla() {
		Object[][] aux = null;
		if ((clientes.size() != 0)) {
			aux = new Object[clientes.size() + 1][7];
			aux[0][0] = "Ci";
			aux[0][1] = "Nombre";
			aux[0][2] = "Apellido";
			aux[0][3] = "Direccion";
			aux[0][4] = "Telefono";
			aux[0][5] = "Email";
			aux[0][6] = "Descuento";
			for (int i = 0; i < clientes.size(); i++) {
				aux[i + 1][0] = clientes.get(i).getCi();
				aux[i + 1][1] = clientes.get(i).getNombre();
				aux[i + 1][2] = clientes.get(i).getApellido();
				aux[i + 1][3] = clientes.get(i).getDireccion();
				aux[i + 1][4] = clientes.get(i).getTel();
				aux[i + 1][5] = clientes.get(i).getEmail();
				aux[i + 1][6] = clientes.get(i).getDescuento().toString();
			}

		} else {
			aux = new Object[1][7];
			aux[0][0] = "Ci";
			aux[0][1] = "Nombre";
			aux[0][2] = "Apellido";
			aux[0][3] = "Direccion";
			aux[0][4] = "Telefono";
			aux[0][5] = "Email";
			aux[0][6] = "Descuento";
		}
		table.setModel(new DefaultTableModel(aux, new String[] { "Ci",
				"Nombre", "Apellido", "Direccion", "Telefono", "Email",
				"Descuento" }));
	}

	// Ve que clinte es elegido eligo
	public ClientVO buscaEnLista(String a) {
		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i).getCi() == Integer.parseInt(a)) {
				return clientes.get(i);
			}
		}
		return null;

	}

	public JFrame devuelve() {
		return this;
	}
}
