package uy.edu.um.ui.admin.productos;

import java.awt.BorderLayout;
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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.MigLayout;

import org.junit.experimental.categories.Category;

import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.article.interfaces.ArticleMgt;
import uy.edu.um.services.categories.interfaces.CategoryMgt;
import uy.edu.um.ui.clasesAuxiliares.TransparentPanel;
import uy.edu.um.ui.usuarios.BasicoUsuario;
import uy.edu.um.value_object.article.ArticleVO;
import uy.edu.um.value_object.categories.CategoryVO;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class ProductList extends BasicoUsuario {
	private JTable tableArticulos;
	private JTextField textField;
	private ArrayList<CategoryVO> categorias = cargoCategorias();
	private ArrayList<ArticleVO> listaArticulos = cargoListado();
	private ArrayList<ArticleVO> listaTabla = new ArrayList<ArticleVO>();
	private String[] textos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductList frame = new ProductList();
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
	public ProductList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		TransparentPanel transparentPanel = new TransparentPanel();
		getContentPane().add(transparentPanel, BorderLayout.CENTER);
		transparentPanel.setLayout(new MigLayout("", "[grow][grow][grow]",
				"[grow][grow][grow]"));

		TransparentPanel transparentPanel_1 = new TransparentPanel();
		transparentPanel.add(transparentPanel_1, "cell 0 1,grow");
		transparentPanel_1.setLayout(new MigLayout("", "[grow][grow][grow]",
				"[grow][][][][grow]"));

		JLabel lblCategoria = new JLabel("Categoria");
		transparentPanel_1.add(lblCategoria, "cell 1 1,alignx center");

		final JComboBox comboBox = new JComboBox();
		String[] textosMenu = cargaAlCombo(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(textosMenu));
		transparentPanel_1.add(comboBox, "cell 1 2,growx");

		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (!comboBox.getSelectedItem().toString()
						.equals("---- Desplegar Lista ----")) {
					cargaALista(buscaEnLista(comboBox.getSelectedItem()
							.toString()));
					cargaATabla(); // Creo Tabla Con Pedido
									// Actual
				}
			}
		});
		transparentPanel_1.add(btnNewButton, "cell 1 3,alignx center");
		tableArticulos = new JTable();
		tableArticulos.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		tableArticulos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableArticulos.setEnabled(false);
		cargaATabla();
		transparentPanel.add(tableArticulos, "cell 1 1,grow");

		TransparentPanel transparentPanel_2 = new TransparentPanel();
		transparentPanel.add(transparentPanel_2, "cell 2 1,grow");
		transparentPanel_2.setLayout(new MigLayout("", "[grow][grow][grow]",
				"[grow][][][grow]"));

		JLabel lblIdProducto = new JLabel("Id Producto: ");
		transparentPanel_2.add(lblIdProducto,
				"cell 1 0,alignx center,aligny bottom");

		textField = new JTextField();
		transparentPanel_2.add(textField, "cell 1 1,growx,aligny center");
		textField.setColumns(10);

		JButton btnEditar = new JButton("Editar");
		transparentPanel_2.add(btnEditar, "flowx,cell 1 2,alignx center");

		JButton btnEliminar = new JButton("Eliminar");
		transparentPanel_2.add(btnEliminar, "cell 1 2,alignx center");
	}

	// Metodos Auxiliares

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

	// Cargo categorias a arraylist
	private ArrayList<CategoryVO> cargoCategorias() {
		CategoryMgt cat = ServiceFacade.getInstance().getCategoryMgt();
		return cat.allCategories();
	}

	// Cargo a Tabla Articulos
	public void cargaATabla() {
		Object[][] aux = null;
		if ((listaTabla != null)) {
			aux = new Object[listaTabla.size() + 1][3];
			aux[0][0] = "Id";
			aux[0][1] = "Nombre";
			aux[0][2] = "Precio";
			for (int i = 0; i < listaTabla.size(); i++) {
				aux[i + 1][0] = listaTabla.get(i).getId();
				aux[i + 1][1] = listaTabla.get(i).getNombre();
				aux[i + 1][2] = listaTabla.get(i).getPrecio();
			}

		} else {
			aux = new Object[1][3];
			aux[0][0] = "Id";
			aux[0][1] = "Nombre";
			aux[0][2] = "Precio";
		}
		tableArticulos.setModel(new DefaultTableModel(aux, new String[] { "Id",
				"Nombre", "Precio" }));

	}

	// Ve que categoria eligo
	public CategoryVO buscaEnLista(String a) {
		for (int i = 0; i < categorias.size(); i++) {
			if (categorias.get(i).getNombre().equals(a)) {
				return categorias.get(i);
			}
		}
		return null;

	}

	// Cargo articulos
	public void cargaALista(CategoryVO cat) {
		if (listaTabla != null) {
			listaTabla.clear();
		} else {
			for (int i = 0; i < listaArticulos.size(); i++) {
				if (listaArticulos.get(i).getCategory().getId() == cat.getId()) {
					listaTabla.add(listaArticulos.get(i));
				}
			}
		}
	}

	public ArrayList<ArticleVO> cargoListado() {
		ArticleMgt test = ServiceFacade.getInstance().getArticleMgt();
		ArrayList<ArticleVO> sol = new ArrayList<ArticleVO>(10);
		sol = test.allArticles();
		return sol;
	}

}
