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
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}

		}

		);

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

				// Combobox's
				final JComboBox comboBoxTemp = new JComboBox();
				String[] textosMenu = cargaPedidos(categoria.get(i)); // cargaPedidos
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
			aux[0][0] = "Categoria";
			aux[0][1] = "Nombre";
			aux[0][2] = "Precio";
			for (int i = 0; i < pedidoAux.size(); i++) {
				if (pedidoAux.get(i) != null) {
					aux[i + 1][0] = pedidoAux.get(i).getCategory().getNombre();
					aux[i + 1][1] = pedidoAux.get(i).getNombre();
					aux[i + 1][2] = pedidoAux.get(i).getPrecio();
				}
			}
		} else {
			aux = new Object[1][3];
			aux[0][0] = "Categoria";
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
	public String[] cargaPedidos(CategoryVO cat) {
		ArrayList<String> aux = new ArrayList<String>();
		aux.add("---- Desplegar Lista ----");
		aux.add("");
		int j = 0;
		while ((j < listaArticulos.size())) {
			if (listaArticulos.get(j).getCategory() == cat) {
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
