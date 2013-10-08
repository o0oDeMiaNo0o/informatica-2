package uy.edu.um.ui.usuarios;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.MigLayout;
import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.article.interfaces.ArticleMgt;
import uy.edu.um.services.categories.interfaces.CategoryMgt;
import uy.edu.um.ui.MensajeGenerico;
import uy.edu.um.ui.clasesAuxiliares.BasicoUsuario;
import uy.edu.um.ui.clasesAuxiliares.TransparentPanel;
import uy.edu.um.value_object.article.ArticleVO;
import uy.edu.um.value_object.categories.CategoryVO;

public class CajaPrincipal extends BasicoUsuario {

	ArrayList<ArticleVO> pedidoAux = new ArrayList<ArticleVO>(); // Array de
																	// pedido
	ArrayList<ArticleVO> listaArticulos = cargoListado(); // Array
															// de
															// Articulos
	ArrayList<CategoryVO> categoria = cargoCategorias();

	private ArrayList<JLabel> coleccion;

	private final Action action = new SwingAction();
	private JTable table;
	private String[] textos;
	private JTable tablePrePedido;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CajaPrincipal frame = new CajaPrincipal();
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
	public CajaPrincipal() {
		super();
		setTitle("Pedido");
		// llenararticulos();

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
		/*
		 * /* JLabel lblMens = new JLabel("Men\u00FAs");
		 * lblMens.setForeground(Color.WHITE);
		 * transparentPanelPedido.add(lblMens, "cell 1 2,alignx left");
		 * 
		 * 
		 * final JComboBox comboBoxM = new JComboBox(); String[] textosMenu =
		 * cargaPedidos(100); // cargaPedidos comboBoxM.setModel(new
		 * DefaultComboBoxModel(textosMenu));
		 * transparentPanelPedido.add(comboBoxM, "cell 2 2,grow");
		 * 
		 * final JSpinner spinnerM = new JSpinner();
		 * transparentPanelPedido.add(spinnerM, "cell 3 2,alignx center");
		 * 
		 * textField = new JTextField(); transparentPanelPedido.add(textField,
		 * "cell 4 2,growx"); textField.setColumns(10);
		 * 
		 * 
		 * JLabel lblPizzas = new JLabel("Pizzas");
		 * lblPizzas.setForeground(Color.WHITE);
		 * transparentPanelPedido.add(lblPizzas, "cell 1 4,alignx left");
		 * 
		 * final JComboBox comboBoxP = new JComboBox(); String[] textosPizzas =
		 * cargaPedidos(300); comboBoxP.setModel(new
		 * DefaultComboBoxModel(textosPizzas));
		 * comboBoxP.setToolTipText("Desplegar Lista");
		 * transparentPanelPedido.add(comboBoxP, "cell 2 4,grow");
		 * 
		 * final JSpinner spinnerP = new JSpinner();
		 * transparentPanelPedido.add(spinnerP, "cell 3 4,alignx center");
		 * 
		 * textField_1 = new JTextField(); textField_1.setColumns(10);
		 * transparentPanelPedido.add(textField_1, "cell 4 4,growx");
		 * 
		 * 
		 * JLabel lblBebidas = new JLabel("Bebidas");
		 * lblBebidas.setForeground(Color.WHITE);
		 * transparentPanelPedido.add(lblBebidas, "cell 1 6,alignx left");
		 * 
		 * final JComboBox comboBoxB = new JComboBox(); String[] textosBebidas =
		 * cargaPedidos(500); comboBoxB.setModel(new
		 * DefaultComboBoxModel(textosBebidas));
		 * transparentPanelPedido.add(comboBoxB, "cell 2 6,grow");
		 * 
		 * JSpinner spinnerB = new JSpinner();
		 * transparentPanelPedido.add(spinnerB, "cell 3 6,alignx center");
		 * 
		 * 
		 * JLabel lblHamburguesas = new JLabel("Hamburguesas");
		 * lblHamburguesas.setForeground(Color.WHITE);
		 * transparentPanelPedido.add(lblHamburguesas, "cell 1 8,alignx left");
		 * 
		 * final JComboBox comboBoxH = new JComboBox(); String[]
		 * textosHamburguesas = cargaPedidos(200); comboBoxH.setModel(new
		 * DefaultComboBoxModel(textosHamburguesas));
		 * transparentPanelPedido.add(comboBoxH, "cell 2 8,grow");
		 * 
		 * final JSpinner spinnerH = new JSpinner();
		 * transparentPanelPedido.add(spinnerH, "cell 3 8,alignx center");
		 * 
		 * textField_2 = new JTextField(); textField_2.setColumns(10);
		 * transparentPanelPedido.add(textField_2, "cell 4 8,growx");
		 * 
		 * JLabel lblEspeciales = new JLabel("Especiales");
		 * lblEspeciales.setForeground(Color.WHITE);
		 * transparentPanelPedido.add(lblEspeciales, "cell 1 10,alignx left");
		 * 
		 * final JComboBox comboBoxE = new JComboBox(); String[]
		 * textosEspeciales = cargaPedidos(400); comboBoxE.setModel(new
		 * DefaultComboBoxModel(textosEspeciales));
		 * transparentPanelPedido.add(comboBoxE, "flowx,cell 2 10,growx");
		 * 
		 * final JSpinner spinnerE = new JSpinner();
		 * transparentPanelPedido.add(spinnerE, "cell 3 10,alignx center");
		 * 
		 * textField_4 = new JTextField(); textField_4.setColumns(10);
		 * transparentPanelPedido.add(textField_4, "cell 4 10,growx");
		 */

		TransparentPanel transparentPanelBotonera = new TransparentPanel();
		getContentPane().add(transparentPanelBotonera, BorderLayout.SOUTH);
		transparentPanelBotonera.setLayout(new MigLayout("", "[grow][][][]",
				"[]"));

		TransparentPanel transparentPanelTabla = new TransparentPanel();
		getContentPane().add(transparentPanelTabla, BorderLayout.CENTER);
		transparentPanelTabla.setLayout(new MigLayout("",
				"[1px][grow][grow][grow]", "[1px][grow]"));

		tablePrePedido = new JTable();
		armarPedido(); // Creo Tabla Con Pedido Actual
		transparentPanelTabla.add(tablePrePedido, "cell 2 1,grow");

		JButton button_2 = new JButton("Agregar a Pedido");
		/*
		 * button_2.addMouseListener(new MouseAdapter() { //@Override public
		 * void mouseClicked(MouseEvent arg0) { String opMenu = (String)
		 * comboBoxM.getSelectedItem(); if (cuentaMenus(opMenu, spinnerM)) { //
		 * Chequeo Menus resetearPosicion(comboBoxM, spinnerM); } String
		 * opPizzas = (String) comboBoxP.getSelectedItem(); if
		 * (cuentaMenus(opPizzas, spinnerP)) { // Chequeo Pizzas String
		 * resetearPosicion(comboBoxP, spinnerP); } String opHamburguesas =
		 * (String) comboBoxH.getSelectedItem(); if (cuentaMenus(opHamburguesas,
		 * spinnerH)) { // Chequeo // Hamburguers resetearPosicion(comboBoxH,
		 * spinnerH); } String opEspeciales = (String)
		 * comboBoxE.getSelectedItem(); if (cuentaMenus(opEspeciales, spinnerE))
		 * { // Chequeo Especiales resetearPosicion(comboBoxE, spinnerE); }
		 * armarPedido(); // String opBebidas = (String)
		 * comboBoxB.getSelectedItem();
		 * 
		 * }
		 * 
		 * });
		 */
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		transparentPanelPedido.add(button_2, "cell 5 6");

		JButton btnFacturar = new JButton("Facturar");
		btnFacturar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});

		JButton btnNewButton = new JButton("Agregar a Mesa");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (pedidoAux.size() == 0) {
					MensajeGenerico mensaje = new MensajeGenerico(
							"Pedido Vacio");
				} else {
					SeleccionaMesa nueva = new SeleccionaMesa(pedidoAux);
				}
			}
		});
		transparentPanelBotonera.add(btnNewButton,
				"cell 1 0,alignx center,aligny center");
		transparentPanelBotonera.add(btnFacturar,
				"cell 2 0,alignx center,aligny center");

		JButton btnVaciar = new JButton("Vaciar Pedido");
		btnVaciar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				vaciarPedido();
				armarPedido();
			}
		});
		transparentPanelBotonera.add(btnVaciar,
				"cell 3 0,alignx center,aligny center");

	}

	// Metodos Auxiliares

	// Carga Articulos a arraylist
	public ArrayList<ArticleVO> cargoListado() {
		ArticleMgt test = ServiceFacade.getInstance().getArticleMgt();
		ArrayList<ArticleVO> sol = new ArrayList<ArticleVO>(10);
		sol = test.allArticles();
		return sol;
	}

	// Cargo categorias a arraylist
	private ArrayList<CategoryVO> cargoCategorias() {
		CategoryVO test = new CategoryVO("Menu", 1);
		CategoryVO test2 = new CategoryVO("Hamburguesas", 2);

		ArrayList<CategoryVO> sol = new ArrayList<CategoryVO>();
		sol.add(test);
		sol.add(test2);
		return sol;

		/*
		 * CategoryMgt test = ServiceFacade.getInstance().getCategoryMgt();
		 * ArrayList<CategoryVO> sol = new ArrayList<CategoryVO>(10); sol =
		 * test.allCategories(); return sol;
		 */
	}

	// Crea coleccion de labels
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

				// Combobox's
				final JComboBox comboBoxTemp = new JComboBox();
				String[] textosMenu = cargaPedidos(categoria.get(i).getId()); // cargaPedidos
				comboBoxTemp.setModel(new DefaultComboBoxModel(textosMenu));
				posicion = "cell 2 " + j + ",grow";
				a.add(comboBoxTemp, posicion);

				// Spinners
				final JSpinner spinnerTemp = new JSpinner();
				posicion = "cell 3 " + j + ",alignx center";
				a.add(spinnerTemp, posicion);

				// JText's
				final JTextField textFieldTemp = new JTextField();
				textFieldTemp.setColumns(10);
				posicion = "cell 4 " + j + ",growx";
				a.add(textFieldTemp, posicion);

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

	}

	private void resetearPosicion(JComboBox comboBox, JSpinner spinner) {
		comboBox.setSelectedIndex(0);
		spinner.setValue(0);
	}

	public void armarPedido() {
		Object[][] aux;
		if ((pedidoAux.size() != 0)) {
			aux = new Object[pedidoAux.size() + 1][3];
			aux[0][0] = "Nro Producto";
			aux[0][1] = "Nombre";
			aux[0][2] = "Precio";
			for (int i = 0; i < pedidoAux.size(); i++) {
				if (pedidoAux.get(i) != null) {
					aux[i + 1][0] = pedidoAux.get(i).getNumProducto();
					aux[i + 1][1] = pedidoAux.get(i).getNombre();
					aux[i + 1][2] = pedidoAux.get(i).getPrecio();
				}
			}
		} else {
			aux = new Object[1][3];
			aux[0][0] = "Nro Producto";
			aux[0][1] = "Nombre";
			aux[0][2] = "Precio";
		}
		tablePrePedido.setModel(new DefaultTableModel(aux, new String[] {
				"Nro Producto", "Nombre", "Precio" }));

	}

	// Agrega pedidos a la orden
	public boolean cuentaMenus(String op, JSpinner m) {
		boolean bandera = false;
		if ((!op.equals("---- Desplegar Lista ----")) && (!op.equals(""))) {
			ArticleVO aux = null;
			int valor = (Integer) m.getValue();

			for (int k = 0; k < valor; k++) {
				aux = buscaArticulo(listaArticulos, op);
				pedidoAux.add(aux);
				bandera = true;
			}
		}
		return bandera;

	}

	// Carga pedidos y los agrega a los comboBox
	public String[] cargaPedidos(int seccion) {
		int limite = seccion + 99;
		ArrayList<String> aux = new ArrayList<String>();
		aux.add("---- Desplegar Lista ----");
		aux.add("");
		int j = 0;
		boolean bandera = false;
		while ((j < listaArticulos.size()) && (bandera == false)) {
			if ((seccion <= listaArticulos.get(j).getNumProducto())
					&& (limite >= listaArticulos.get(j).getNumProducto())) {
				aux.add(listaArticulos.get(j).getNombre());
				j++;
			} else if (seccion > listaArticulos.get(j).getNumProducto()) {
				j++;
			} else {
				bandera = true;
			}
		}
		textos = new String[aux.size() + 1];
		for (int i = 0; i < textos.length - 1; i++) {
			textos[i] = aux.get(i);
		}
		return textos;

	}

	public ArticleVO buscaArticulo(ArrayList<ArticleVO> a, String b) {
		ArticleVO aux = null;
		for (int i = 0; i < a.size(); i++) {
			if (a.get(i).getNombre().equals(b)) {
				aux = a.get(i);
			}
		}
		return aux;
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
		}
	}
}
