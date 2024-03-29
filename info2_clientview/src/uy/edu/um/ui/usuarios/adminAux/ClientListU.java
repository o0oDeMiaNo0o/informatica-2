package uy.edu.um.ui.usuarios.adminAux;

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
import uy.edu.um.exceptions.checks.NoDatabaseConnection;
import uy.edu.um.exceptions.checks.NoServerConnectionException;
import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.people.clients.interfaces.ClientMgt;
import uy.edu.um.ui.clasesAuxiliares.TextFieldAutocompletar;
import uy.edu.um.ui.clasesAuxiliares.TransparentPanel;
import uy.edu.um.ui.mensajes.MensajeGenerico;
import uy.edu.um.ui.usuarios.BasicoUsuario;
import uy.edu.um.ui.usuarios.Facturacion;
import uy.edu.um.value_object.people.client.ClientVO;
import uy.edu.um.value_object.table.TableVO;

public class ClientListU extends BasicoUsuario {

	private JTable table;
	private JTextField textFieldID;
	private ArrayList<ClientVO> clientes;

	public ClientListU(final TableVO mesa) {
		try {
			clientes = cargoClientes();
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 300);

			TransparentPanel transparentPanel = new TransparentPanel();
			getContentPane().add(transparentPanel, BorderLayout.CENTER);
			transparentPanel.setLayout(new MigLayout("", "[grow][grow][]",
					"[grow]"));

			TransparentPanel transparentPanel_1 = new TransparentPanel();
			transparentPanel.add(transparentPanel_1, "cell 0 0,grow");
			transparentPanel_1.setLayout(new MigLayout("", "[][grow][]",
					"[grow][][][grow]"));

			JLabel lblBsquedaRpida = new JLabel("B\u00FAsqueda R\u00E1pida");
			transparentPanel_1.add(lblBsquedaRpida, "cell 1 1,alignx center");

			TextFieldAutocompletar textFieldAutocompletar = new TextFieldAutocompletar(
					devuelveNombres());
			textFieldAutocompletar.setText("");
			transparentPanel_1.add(textFieldAutocompletar,
					"flowx,cell 1 2,growx");

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

			JButton btnAceptar = new JButton("Aceptar");
			btnAceptar.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					ClientVO cliente = buscaEnLista(textFieldID.getText());
					if (cliente != null) {
						if (mesa != null) {
							Facturacion nuevo1 = null;
							try {
								nuevo1 = new Facturacion(mesa, cliente);
								nuevo1.setVisible(true);
								cerrar();
							} catch (NoServerConnectionException ex) {
								MensajeGenerico newFrame = new MensajeGenerico(
										ex.getMessage(), ClientListU.this);
								newFrame.setVisible(true);
							} catch (NoDatabaseConnection ex) {
								MensajeGenerico newFrame = new MensajeGenerico(
										ex.getMessage(), ClientListU.this);
								newFrame.setVisible(true);
							}
						} else {
							ClientMgt nuevo = ServiceFacade.getInstance()
									.getClientMgt();
							try {
								nuevo.removeClientVO(cliente);
							} catch (NoServerConnectionException e1) {
								MensajeGenerico newFrame = new MensajeGenerico(
										e1.getMessage(), ClientListU.this);
								newFrame.setVisible(true);
							} catch (NoDatabaseConnection e1) {
								MensajeGenerico newFrame = new MensajeGenerico(
										e1.getMessage(), ClientListU.this);
								newFrame.setVisible(true);
							}
							MensajeGenerico msg = new MensajeGenerico(
									"Cliente Eliminado Correctamente",
									ClientListU.this);
							msg.setVisible(true);
						}
					} else {
						MensajeGenerico nuevo = new MensajeGenerico(
								"Cliente No Existe", ClientListU.this);
						nuevo.setVisible(true);
					}
				}
			});
			transparentPanel_2.add(btnAceptar, "flowx,cell 1 2,alignx center");

			JButton btnCancelar = new JButton("Cancelar");
			btnCancelar.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					Facturacion nuevo = null;
					try {
						nuevo = new Facturacion(mesa, null);
					} catch (NoServerConnectionException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (NoDatabaseConnection e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					nuevo.setVisible(true);
					cerrar();
				}
			});
			transparentPanel_2.add(btnCancelar, "cell 1 2");
			cargaATabla();
		} catch (NoServerConnectionException e) {
			MensajeGenerico nuevo = new MensajeGenerico(e.getMessage(),
					ClientListU.this);
			nuevo.setVisible(true);
		} catch (NoDatabaseConnection e) {
			MensajeGenerico nuevoFrame = new MensajeGenerico(e.getMessage(),
					ClientListU.this);
			nuevoFrame.setVisible(true);
		}
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
	private ArrayList<ClientVO> cargoClientes()
			throws NoServerConnectionException, NoDatabaseConnection {
		ClientMgt nuevo = ServiceFacade.getInstance().getClientMgt();
		return nuevo.allClients();
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
				if (clientes.get(i).getDescuento().toString() != null) {
					aux[i + 1][6] = clientes.get(i).getDescuento().toString();
				} else {
					aux[i + 1][6] = 0;
				}
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
