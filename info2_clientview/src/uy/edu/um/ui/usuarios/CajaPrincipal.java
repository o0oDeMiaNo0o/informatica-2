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
import uy.edu.um.ui.clasesAuxiliares.BasicoUsuario;
import uy.edu.um.ui.clasesAuxiliares.TransparentPanel;
import uy.edu.um.value_object.article.ArticleVO;

public class CajaPrincipal extends BasicoUsuario {

	ArrayList<ArticleVO> pedidoAux = new ArrayList<ArticleVO>(); // Array de
																	// pedido
	ArrayList<ArticleVO> listaArticulos = new ArrayList<ArticleVO>(); // Array
																		// de
																		// Articulos
	private final Action action = new SwingAction();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_4;
	private JTextField textField_2;
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
		llenararticulos();

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

		JLabel lblMens = new JLabel("Men\u00FAs");
		lblMens.setForeground(Color.WHITE);
		transparentPanelPedido.add(lblMens, "cell 1 2,alignx left");

		final JComboBox comboBoxM = new JComboBox();
		String[] textosMenu = cargaPedidos(0); // cargaPedidos
		comboBoxM.setModel(new DefaultComboBoxModel(textosMenu));
		transparentPanelPedido.add(comboBoxM, "cell 2 2,grow");

		final JSpinner spinnerM = new JSpinner();
		transparentPanelPedido.add(spinnerM, "cell 3 2,alignx center");

		textField = new JTextField();
		transparentPanelPedido.add(textField, "cell 4 2,growx");
		textField.setColumns(10);

		JLabel lblPizzas = new JLabel("Pizzas");
		lblPizzas.setForeground(Color.WHITE);
		transparentPanelPedido.add(lblPizzas, "cell 1 4,alignx left");

		final JComboBox comboBoxP = new JComboBox();
		String[] textosPizzas = cargaPedidos(100);
		comboBoxP.setModel(new DefaultComboBoxModel(textosPizzas));
		comboBoxP.setToolTipText("Desplegar Lista");
		transparentPanelPedido.add(comboBoxP, "cell 2 4,grow");

		final JSpinner spinnerP = new JSpinner();
		transparentPanelPedido.add(spinnerP, "cell 3 4,alignx center");

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		transparentPanelPedido.add(textField_1, "cell 4 4,growx");

		JLabel lblBebidas = new JLabel("Bebidas");
		lblBebidas.setForeground(Color.WHITE);
		transparentPanelPedido.add(lblBebidas, "cell 1 6,alignx left");

		final JComboBox comboBoxB = new JComboBox();
		comboBoxB.setModel(new DefaultComboBoxModel(new String[] {
				" ---- Desplegar Lista ----", "", "Bebida 1", "Bebida 2",
				"Bebida 3", "Bebida 4" }));
		transparentPanelPedido.add(comboBoxB, "cell 2 6,grow");

		JSpinner spinnerB = new JSpinner();
		transparentPanelPedido.add(spinnerB, "cell 3 6,alignx center");

		JLabel lblHamburguesas = new JLabel("Hamburguesas");
		lblHamburguesas.setForeground(Color.WHITE);
		transparentPanelPedido.add(lblHamburguesas, "cell 1 8,alignx left");

		final JComboBox comboBoxH = new JComboBox();
		String[] textosHamburguesas = cargaPedidos(200);
		comboBoxH.setModel(new DefaultComboBoxModel(textosHamburguesas));
		transparentPanelPedido.add(comboBoxH, "cell 2 8,grow");

		final JSpinner spinnerH = new JSpinner();
		transparentPanelPedido.add(spinnerH, "cell 3 8,alignx center");

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		transparentPanelPedido.add(textField_2, "cell 4 8,growx");

		JLabel lblEspeciales = new JLabel("Especiales");
		lblEspeciales.setForeground(Color.WHITE);
		transparentPanelPedido.add(lblEspeciales, "cell 1 10,alignx left");

		final JComboBox comboBoxE = new JComboBox();
		String[] textosEspeciales = cargaPedidos(300);
		comboBoxE.setModel(new DefaultComboBoxModel(textosEspeciales));
		transparentPanelPedido.add(comboBoxE, "flowx,cell 2 10,growx");

		final JSpinner spinnerE = new JSpinner();
		transparentPanelPedido.add(spinnerE, "cell 3 10,alignx center");

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		transparentPanelPedido.add(textField_4, "cell 4 10,growx");

		JRadioButton rdbtnLight = new JRadioButton("Light");
		rdbtnLight.setHorizontalAlignment(SwingConstants.RIGHT);
		rdbtnLight.setForeground(Color.WHITE);
		transparentPanelPedido.add(rdbtnLight,
				"flowx,cell 4 6,alignx center,aligny center");

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {
				" ---- Tama\u00F1o ----", "", "Peque\u00F1o", "Mediano",
				"Grande" }));
		transparentPanelPedido.add(comboBox,
				"cell 4 6,alignx center,aligny center");

		TransparentPanel transparentPanelBotonera = new TransparentPanel();
		getContentPane().add(transparentPanelBotonera, BorderLayout.SOUTH);
		transparentPanelBotonera.setLayout(new MigLayout("", "[grow][][][]",
				"[]"));

		JButton button_2 = new JButton("Agregar a Pedido");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String opMenu = (String) comboBoxM.getSelectedItem();
				cuentaMenus(opMenu, spinnerM); // Chequeo Menus
				String opPizzas = (String) comboBoxP.getSelectedItem();
				cuentaMenus(opPizzas, spinnerP); // Chequeo Pizzas String
				String opHamburguesas = (String) comboBoxH.getSelectedItem();
				cuentaMenus(opHamburguesas, spinnerH); // Chequeo Hamburguers
				String opEspeciales = (String) comboBoxE.getSelectedItem();
				cuentaMenus(opEspeciales, spinnerE); // Chequeo Especiales
				// String opBebidas = (String) comboBoxB.getSelectedItem();

			}
		});
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		transparentPanelPedido.add(button_2, "cell 5 6");

		JButton btnFacturar = new JButton("Facturar");
		transparentPanelBotonera.add(btnFacturar, "cell 1 0");

		JButton btnVerPedido = new JButton("Ver Pedido");
		transparentPanelBotonera.add(btnVerPedido, "cell 2 0");

		JButton btnCancelar = new JButton("Cancelar");
		transparentPanelBotonera.add(btnCancelar, "cell 3 0");

		TransparentPanel transparentPanelTabla = new TransparentPanel();
		getContentPane().add(transparentPanelTabla, BorderLayout.CENTER);
		transparentPanelTabla.setLayout(new MigLayout("", "[1px][grow][grow]",
				"[1px][grow]"));
		tablePrePedido = new JTable();
		
		transparentPanelTabla.add(tablePrePedido, "cell 1 1,grow");

	}

	// Metodos Auxiliares

	public void armarPedido() {
		Object[][] aux = new Object[pedidoAux.size()][2];
		for (int i = 0; i < pedidoAux.size() - 1; i++) {
			aux[i][0] = pedidoAux.get(i).getNombre();
			aux[i][1] = pedidoAux.get(i).getPrecio();
		}

		tablePrePedido.setModel(new DefaultTableModel(aux, new String[] {
				"Nombre", "Precio" }));

	}

	// Agrega pedidos a la orden
	public void cuentaMenus(String op, JSpinner m) {
		if ((!op.equals("---- Desplegar Lista ----")) && (!op.equals(""))) {
			ArticleVO aux = null;
			int valor = (Integer) m.getValue();

			for (int k = 0; k < valor; k++) {
				aux = buscaArticulo(listaArticulos, op);
				pedidoAux.add(aux);
				System.out.println("Agregado: ");
			}
		}

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

	private void llenararticulos() {
		ArticleVO a = new ArticleVO(1, "Menu 1", 250);
		ArticleVO b = new ArticleVO(2, "Menu 2", 250);
		ArticleVO c = new ArticleVO(3, "Menu 3", 100);
		ArticleVO d = new ArticleVO(4, "Menu 4", 100);
		ArticleVO e = new ArticleVO(150, "Pizza 1", 150);
		ArticleVO f = new ArticleVO(100, "Pizza 2", 150);

		listaArticulos.add(a);
		listaArticulos.add(b);
		listaArticulos.add(c);
		listaArticulos.add(d);
		listaArticulos.add(e);
		listaArticulos.add(f);

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
