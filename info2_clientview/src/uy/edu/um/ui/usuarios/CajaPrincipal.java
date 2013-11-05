package uy.edu.um.ui.usuarios;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.MigLayout;
import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.article.interfaces.ArticleMgt;
import uy.edu.um.services.categories.interfaces.CategoryMgt;
import uy.edu.um.services.order.interfaces.OrderMgt;
import uy.edu.um.ui.CurrentUser;
import uy.edu.um.ui.clasesAuxiliares.Java2sAutoComboBox;
import uy.edu.um.ui.clasesAuxiliares.TextFieldAutocompletar;
import uy.edu.um.ui.clasesAuxiliares.TransparentPanel;
import uy.edu.um.ui.mensajes.ConfirmFacturar;
import uy.edu.um.ui.mensajes.MensajeGenerico;
import uy.edu.um.value_object.article.ArticleVO;
import uy.edu.um.value_object.articleOrder.ArticleOrderVO;
import uy.edu.um.value_object.categories.CategoryVO;
import uy.edu.um.value_object.oreder.OrderVO;
import uy.edu.um.value_object.table.TableVO;
import uy.edu.um.value_object.user.UserVO;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.util.List;
import java.awt.Component;
import javax.swing.Box;

public class CajaPrincipal extends BasicoUsuario {

	UserVO user;

	ArrayList<ArticleOrderVO> pedidoAux = new ArrayList<ArticleOrderVO>(); // Array
																			// de
																			// pedido
	ArrayList<ArticleVO> listaArticulos = cargoListado(); // Array
															// de
															// Articulos
	ArrayList<CategoryVO> categoria = cargoCategorias();
	private ArrayList<ArticleVO> pedidoArticle = new ArrayList<ArticleVO>(); // Array
																				// con
																				// articulos
																				// solo
																				// para
																				// mostrar
																				// en
																				// la
																				// tabla

	ArrayList<JSpinner> spinners = new ArrayList<JSpinner>(categoria.size());
	ArrayList<JComboBox> combos = new ArrayList<JComboBox>(categoria.size());
	ArrayList<JTextField> esp = new ArrayList<JTextField>(categoria.size());
	String espTotal = "";

	private String[] textos;
	private JTable tablePrePedido;
	TextFieldAutocompletar textFieldEliminar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CajaPrincipal frame = new CajaPrincipal(null, null);
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
	public CajaPrincipal(ArrayList<ArticleOrderVO> pedido, final TableVO mesa) {

		super();

		this.user = CurrentUser.getUser();

		if (pedido != null) {
			pedidoAux = pedido;
			pedidoArticle = cargaArticleVO(pedidoAux);
		}

		setTitle("Pedido");

		TransparentPanel transparentPanelPedido = new TransparentPanel();
		getContentPane().add(transparentPanelPedido, BorderLayout.NORTH);
		transparentPanelPedido.setLayout(new MigLayout("", "[][][][][grow][]",
				"[][][][][][][][][][][][][][grow]"));

		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setForeground(Color.WHITE);
		transparentPanelPedido.add(lblCantidad,
				"cell 3 1,alignx center,aligny center");

		JLabel lblEspecificaciones = new JLabel("Especificaciones");
		lblEspecificaciones.setForeground(Color.WHITE);
		transparentPanelPedido.add(lblEspecificaciones,
				"cell 4 1,alignx center,aligny center");

		creaElementos(transparentPanelPedido);

		TransparentPanel transparentPanelBotonera = new TransparentPanel();
		getContentPane().add(transparentPanelBotonera, BorderLayout.SOUTH);
		transparentPanelBotonera.setLayout(new MigLayout("", "[grow][][][]",
				"[]"));

		TransparentPanel transparentPanelTabla = new TransparentPanel();
		getContentPane().add(transparentPanelTabla, BorderLayout.CENTER);
		transparentPanelTabla.setLayout(new MigLayout("", "[1px][][grow][]",
				"[1px][grow]"));

		tablePrePedido = new JTable();
		tablePrePedido.setBorder(new LineBorder(Color.ORANGE, 2, true));
		tablePrePedido.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		tablePrePedido.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablePrePedido.setEnabled(false);
		tablePrePedido.setRowSelectionAllowed(false);
		armarPedido(); // Creo Tabla Con Pedido Actual

		TransparentPanel transparentPanel = new TransparentPanel();
		transparentPanelTabla.add(transparentPanel, "cell 1 1,grow");
		transparentPanel.setLayout(new MigLayout("", "[]", "[][grow][][grow]"));

		Component horizontalStrut = Box.createHorizontalStrut(300);
		transparentPanel.add(horizontalStrut, "cell 0 0");

		JLabel lblBusquedaRpida = new JLabel("B\u00FAsqueda R\u00E1pida");
		lblBusquedaRpida.setForeground(Color.WHITE);
		transparentPanel.add(lblBusquedaRpida,
				"cell 0 1,alignx center,aligny bottom");

		final TextFieldAutocompletar textoAutocompletado = new TextFieldAutocompletar(
				devuelveProductos());
		textoAutocompletado.setText("");
		transparentPanel.add(textoAutocompletado, "cell 0 2,growx");

		JButton btnAgregarAPedido = new JButton("Agregar A Pedido");
		btnAgregarAPedido.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ArticleVO nuevo = buscaArticuloString(listaArticulos,
						textoAutocompletado.getText());
				ArticleOrderVO aux = new ArticleOrderVO(nuevo, 1);
				pedidoAux.add(aux);
				pedidoArticle.add(nuevo);
				armarPedido();

			}
		});
		transparentPanel.add(btnAgregarAPedido,
				"cell 0 3,alignx center,aligny top");
		transparentPanelTabla.add(tablePrePedido, "cell 2 1,grow");

		TransparentPanel transparentPanel_1 = new TransparentPanel();
		transparentPanelTabla.add(transparentPanel_1, "cell 3 1,grow");
		transparentPanel_1.setLayout(new MigLayout("", "[grow]",
				"[grow][][][][grow]"));

		Component horizontalStrut_1 = Box.createHorizontalStrut(300);
		transparentPanel_1.add(horizontalStrut_1, "cell 0 0");

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.WHITE);
		transparentPanel_1.add(lblNombre, "cell 0 1,alignx center");

		textFieldEliminar = new TextFieldAutocompletar(devuelvePedido());
		textFieldEliminar.setEditable(false);
		textFieldEliminar.setText("");
		transparentPanel_1.add(textFieldEliminar, "cell 0 2,growx");

		JButton btnNewButton_1 = new JButton("Eliminar De Lista");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				magic(textFieldEliminar.getText());
			}

		});
		transparentPanel_1.add(btnNewButton_1, "cell 0 3,alignx center");

		JButton button_2 = new JButton("Agregar a Pedido");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (cuentaCantidad() != 0) {
					agregarAPedido();
					armarPedido();
					resetearPosicion();
				}
			}

		});
		double cat = categoria.size();
		double pos = (cat / 2);
		if (pos % 1 != 0) {
			pos = pos - (pos % 1);
		}
		int j = 2;
		for (int i = 0; i < pos; i++) {
			j = j + 2;
		}

		transparentPanelPedido.add(button_2, "cell 5 " + j);

		if (mesa != null) {
			JButton btnFacturar = new JButton("Facturar");
			btnFacturar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					OrderVO toSend = enviarPedido(pedidoAux, mesa, espTotal,
							user);
					ConfirmFacturar nuevo = new ConfirmFacturar(toSend.getTable(),
							devuelve());
					nuevo.setVisible(true);
				}
			});
			transparentPanelBotonera.add(btnFacturar,
					"cell 2 0,alignx center,aligny center");
		} else {

			JButton btnNewButton = new JButton("Agregar a Mesa");
			btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if (pedidoAux.size() == 0) {
						MensajeGenerico mensaje = new MensajeGenerico(
								"Pedido Vacio", devuelve());
						mensaje.setVisible(true);
					} else {
						Mesas nueva = new Mesas(pedidoAux, espTotal);
						nueva.setVisible(true);
						cerrar();
					}
				}

			});
			transparentPanelBotonera.add(btnNewButton,
					"cell 2 0,alignx center,aligny center");
		}

		JButton btnVaciar = new JButton("Vaciar Pedido");
		btnVaciar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				vaciarPedido();
				armarPedido();
				// cargarAutoEliminar();
			}

		});
		transparentPanelBotonera.add(btnVaciar,
				"cell 1 0,alignx center,aligny center");

		JButton btnCancelar = new JButton("Cancelar");
		btnVaciar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cerrar();
			}
		});
		transparentPanelBotonera.add(btnCancelar,
				"cell 3 0,alignx center,aligny center");

	}

	// Metodos Auxiliares

	// hago amgia
	private void magic(String text) {
		boolean bandera = false;
		for (int i = 0; i < pedidoArticle.size(); i++) {
			if ((bandera == false)
					&& (pedidoArticle.get(i).getNombre().equals(text))) {
				pedidoArticle.remove(i);
				bandera = true;
			}
		}
		for (int i = 0; i < pedidoAux.size(); i++) {
			if (pedidoAux.get(i).getArticle().getNombre().equals(text)) {
				pedidoAux.remove(i);
			}

		}
		armarPedido();
		textFieldEliminar.setDataList(devuelvePedido());
	}

	// Para el textfield automatico
	private void cargarAutoEliminar() {
		textFieldEliminar.setDataList(devuelvePedido());
		textFieldEliminar.setEditable(true);
	}

	// Devuelve nombres articulos de pedido
	public ArrayList<String> devuelvePedido() {
		ArrayList<String> aux = new ArrayList<String>();
		for (int i = 0; i < pedidoAux.size(); i++) {
			aux.add(pedidoAux.get(i).getArticle().getNombre());
		}
		return aux;
	}

	// Devuelve articulos para el jText autocompletado
	private ArrayList<String> devuelveProductos() {
		ArrayList<String> aux = new ArrayList<String>();
		for (int i = 0; i < listaArticulos.size(); i++) {
			aux.add(listaArticulos.get(i).getNombre());
		}
		return aux;
	}

	private ArrayList<ArticleVO> cargaArticleVO(
			ArrayList<ArticleOrderVO> pedidoAux) {
		ArrayList<ArticleVO> aux = null;
		for (int i = 0; i < pedidoAux.size(); i++) {
			for (int j = 0; j < pedidoAux.get(i).getCantidad(); j++) {
				aux.add(pedidoAux.get(i).getArticle());
			}
		}
		return aux;
	}

	// Carga Articulos a arraylist
	public ArrayList<ArticleVO> cargoListado() {
		ArticleMgt test = ServiceFacade.getInstance().getArticleMgt();
		return test.allArticles();
	}

	// Cargo categorias a arraylist
	private ArrayList<CategoryVO> cargoCategorias() {
		CategoryMgt cat = ServiceFacade.getInstance().getCategoryMgt();
		return cat.allCategories();
	}

	// Crea Elementos dependiendo de categoria
	private void creaElementos(TransparentPanel a) {
		if (categoria.size() != 0) {
			String posicion = null;

			int j = 2;
			for (int i = 0; i < categoria.size(); i++) {

				// Labels
				JLabel lblTemp = new JLabel(categoria.get(i).getNombre());
				lblTemp.setForeground(Color.WHITE);
				posicion = "cell 1 " + j + ",alignx left";
				a.add(lblTemp, posicion);

				// Spinners
				final JSpinner spinnerTemp = new JSpinner();
				posicion = "cell 3 " + j + ",alignx center";
				a.add(spinnerTemp, posicion);
				spinners.add(spinnerTemp);

				// Combobox's
				JComboBox comboBoxTemp = new JComboBox();
				String[] textosMenu = cargaPedidos(categoria.get(i)); // cargaPedidos
				comboBoxTemp.setModel(new DefaultComboBoxModel(textosMenu));
				comboBoxTemp.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent arg0) {
						spinnerTemp.setValue(1);
					}
				});
				posicion = "cell 2 " + j + ",grow";
				a.add(comboBoxTemp, posicion);
				combos.add(comboBoxTemp);

				// JText's
				JTextField textFieldTemp = new JTextField();
				textFieldTemp.setColumns(10);
				posicion = "cell 4 " + j + ",growx";
				a.add(textFieldTemp, posicion);
				esp.add(textFieldTemp);

				j = j + 2;

				// coleccion.add(lblTemp);
			}
		} else {
			JLabel lblTemp = new JLabel(
					"NO EXISTEN CATEGORIAS (MENUS/Agregar Nuevo)");
			lblTemp.setForeground(Color.WHITE);
			a.add(lblTemp, "cell 1 2,alignx left");
		}
	}

	protected void vaciarPedido() {
		pedidoAux.clear();
		pedidoArticle.clear();

	}

	private void resetearPosicion() {
		for (int i = 0; i < combos.size(); i++) {
			combos.get(i).setSelectedIndex(0);
			spinners.get(i).setValue(0);
			esp.get(i).setText("");
		}
	}

	// Agrega a pedidoAux

	private void agregarAPedido() {
		ArrayList<ArticleOrderVO> aux = pedidoAux;
		for (int i = 0; i < combos.size(); i++) {
			cuentaMenus(combos.get(i), spinners.get(i), esp.get(i));
		}
		cargarAutoEliminar();

	}

	// Cuenta cuantos menus se repiten
	private int cuentaCantidad() {
		int cantidad = 0;
		for (int i = 0; i < spinners.size(); i++) {
			int cantAux = Integer.parseInt(spinners.get(i).getValue()
					.toString());
			if (cantAux != 0) {
				cantidad = cantidad + cantAux;
			}

		}
		if (pedidoAux.size() != 0) {
			cantidad = cantidad + pedidoAux.size();
		}
		return cantidad;
	}

	// Agrega pedidos a la orden(pedidoAux)
	public boolean cuentaMenus(JComboBox op, JSpinner m, JTextField t) {
		boolean bandera = false;
		int valor = (Integer) m.getValue();
		if ((!op.getSelectedItem().equals("---- Desplegar Lista ----"))
				&& (!op.getSelectedItem().equals("")) && (valor != 0)) {
			ArticleOrderVO aux = null;
			for (int i = 0; i < valor; i++) {
				pedidoArticle.add(buscaArticuloCombo(listaArticulos, op));
			}
			aux = new ArticleOrderVO(buscaArticuloCombo(listaArticulos, op),
					valor);
			pedidoAux.add(aux);
			if ((t.getText() != null) && (!t.getText().equals(""))) {
				espTotal = espTotal + op.getSelectedItem().toString() + ": "
						+ t.getText() + "\n ";
			}
			bandera = true;
		}
		return bandera;
	}

	// Arma el pedido y lo carga a la tabla
	public void armarPedido() {
		Object[][] aux = null;
		if ((pedidoArticle.size() != 0)) {
			aux = new Object[pedidoArticle.size() + 1][3];
			aux[0][0] = "Categoria";
			aux[0][1] = "Nombre";
			aux[0][2] = "Precio";
			for (int i = 0; i < pedidoArticle.size(); i++) {

				aux[i + 1][0] = pedidoArticle.get(i).getCategory().getNombre();
				aux[i + 1][1] = pedidoArticle.get(i).getNombre();
				aux[i + 1][2] = pedidoArticle.get(i).getPrecio();
			}

		} else {
			aux = new Object[1][4];
			aux[0][0] = "Categoria";
			aux[0][1] = "Nombre";
			aux[0][2] = "Precio";
		}
		tablePrePedido.setModel(new DefaultTableModel(aux, new String[] {
				"Categoria", "Nombre", "Precio" }));

	}

	// Carga pedidos y los agrega a los comboBox
	public String[] cargaPedidos(CategoryVO cat) {
		ArrayList<String> aux = new ArrayList<String>();
		aux.add("---- Desplegar Lista ----");
		aux.add("");
		int j = 0;
		while ((j < listaArticulos.size())) {
			if (listaArticulos.get(j).getCategory().getId() == cat.getId()) {
				aux.add(listaArticulos.get(j).getNombre());
			}
			j++;
		}
		textos = new String[aux.size() + 1];
		for (int i = 0; i < textos.length - 1; i++) {
			textos[i] = aux.get(i);
		}
		return textos;

	}

	// Busca ArticleVO de la lista
	public ArticleVO buscaArticuloString(ArrayList<ArticleVO> a, String b) {
		ArticleVO aux = null;
		for (int i = 0; i < a.size(); i++) {
			if (a.get(i).getNombre().equals(b)) {
				aux = a.get(i);
			}
		}
		return aux;
	}

	public ArticleVO buscaArticuloCombo(ArrayList<ArticleVO> a, JComboBox b) {
		ArticleVO aux = null;
		for (int i = 0; i < a.size(); i++) {
			String test = a.get(i).getNombre();
			if (a.get(i).getNombre().equals(b.getSelectedItem().toString())) {
				aux = a.get(i);
			}
		}
		return aux;
	}

	// Cerrar Ventana
	public void cerrar() {
		this.dispose();

	}

	// Creo y envio OrderVO
	private OrderVO enviarPedido(ArrayList<ArticleOrderVO> pedidoAux,
			TableVO mesa, String esp, UserVO user) {
		OrderMgt nueva = ServiceFacade.getInstance().getOrderMgt();
		// compilo debe haber algo mal
		OrderVO toSend = nueva.createOrderVO(pedidoAux, mesa,
				CurrentUser.getUser(), esp, 0);
		return toSend;

	}

	// Devuelve este JFrame para cerrarlo dsp
	private JFrame devuelve() {
		return this;
	}

}
