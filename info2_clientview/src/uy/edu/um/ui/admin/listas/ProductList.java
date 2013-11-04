package uy.edu.um.ui.admin.listas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
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
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.MigLayout;
import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.article.interfaces.ArticleMgt;
import uy.edu.um.services.categories.interfaces.CategoryMgt;
import uy.edu.um.ui.admin.BasicoAdmin;
import uy.edu.um.ui.admin.edicion.EditRemoveA;
import uy.edu.um.ui.clasesAuxiliares.TransparentPanel;
import uy.edu.um.value_object.article.ArticleVO;
import uy.edu.um.value_object.categories.CategoryVO;
import uy.edu.um.value_object.user.UserVO;
import uy.edu.um.ui.clasesAuxiliares.TextFieldAutocompletar;
import uy.edu.um.ui.mensajes.MensajeGenerico;

import java.util.List;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class ProductList extends BasicoAdmin {
	private ArrayList<CategoryVO> categorias = cargoCategorias();
	private ArrayList<ArticleVO> listaArticulos = cargoListado();
	private ArrayList<ArticleVO> listaTabla = new ArrayList<ArticleVO>();
	private String[] textos;
	private JTable table;
	private JTextField textFieldID;

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
	 * 
	 * @param user
	 */
	public ProductList() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		TransparentPanel transparentPanel = new TransparentPanel();
		getContentPane().add(transparentPanel, BorderLayout.CENTER);
		transparentPanel.setLayout(new MigLayout("", "[][grow][]", "[grow]"));

		TransparentPanel transparentPanel_1 = new TransparentPanel();
		transparentPanel.add(transparentPanel_1, "cell 0 0,grow");
		transparentPanel_1.setLayout(new MigLayout("",
				"[grow][grow][][][grow]", "[grow][][][][grow]"));

		JLabel lblCategorias = new JLabel("Categorias:");
		transparentPanel_1.add(lblCategorias, "cell 1 1,alignx trailing");

		final JComboBox comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if ((!comboBox.getSelectedItem().toString()
						.equals("---- Desplegar Lista ----"))) {
					cargaALista(buscaEnLista(comboBox.getSelectedItem()
							.toString()));
					cargaATabla();
				}
			}
		});

		String[] textosMenu = cargaAlCombo(comboBox); // cargaCategorias
		comboBox.setModel(new DefaultComboBoxModel(textosMenu));
		transparentPanel_1.add(comboBox, "cell 2 1,alignx center");

		JLabel lblBsquedaRapida = new JLabel("B\u00FAsqueda Rapida");
		transparentPanel_1.add(lblBsquedaRapida,
				"cell 1 3 2 1,alignx center,aligny center");

		final TextFieldAutocompletar textFieldAutocompletar = new TextFieldAutocompletar(
				devuelveLista());
		textFieldAutocompletar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				textFieldAutocompletar.setText("");
			}
		});
		textFieldAutocompletar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					listaTabla = devuelvoParaTabla(textFieldAutocompletar
							.getText());
					cargaATabla();
				}
			}
		});
		textFieldAutocompletar.setText("");
		transparentPanel_1.add(textFieldAutocompletar,
				"cell 1 4 2 1,growx,aligny top");

		TransparentPanel transparentPanel_2 = new TransparentPanel();
		transparentPanel.add(transparentPanel_2, "cell 2 0,grow");
		transparentPanel_2.setLayout(new MigLayout("", "[]", "[grow][][grow]"));

		JLabel label = new JLabel("Id Articulo: ");
		transparentPanel_2.add(label, "flowx,cell 0 1,alignx center");

		textFieldID = new JTextField();
		textFieldID.setColumns(10);
		transparentPanel_2.add(textFieldID, "cell 0 1,alignx center");

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int i = table.getSelectedRow();
				if (i > 0) {
					textFieldID.setText("" + listaTabla.get(i - 1).getId());
				}
			}
		});
		table.setSurrendersFocusOnKeystroke(true);
		transparentPanel.add(table, "cell 1 0,grow");

		JButton button = new JButton("Editar Producto");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (buscaArticulo(textFieldID.getText())) {
					EditRemoveA nuevo = new EditRemoveA(
							devuelveArticulo(Integer.parseInt(textFieldID
									.getText())), devuelve(), true, "");
					nuevo.setVisible(true);
				} else {
					MensajeGenerico nuevo = new MensajeGenerico(
							"Producto No Existe", contentPane);
					nuevo.setVisible(true);
				}
			}

		});
		transparentPanel_2.add(button,
				"flowx,cell 0 2,alignx center,aligny top");

		JButton button_1 = new JButton("Eliminar Producto");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (buscaArticulo(textFieldID.getText())) {
					EditRemoveA nuevo = new EditRemoveA(
							devuelveArticulo(Integer.parseInt(textFieldID
									.getText())), devuelve(), false,
							"Desea Eliminar El Siguiente Articulo?");
					nuevo.setVisible(true);
				} else {
					MensajeGenerico nuevo = new MensajeGenerico(
							"Producto No Existe", contentPane);
					nuevo.setVisible(true);
				}
			}
		});
		transparentPanel_2.add(button_1, "cell 0 2,alignx center,aligny top");
		cargaATabla();
	}

	// Metodos Auxiliares

	private boolean buscaArticulo(String text) {
		for (int i = 0; i < listaArticulos.size(); i++) {
			if (listaArticulos.get(i).getId() == Integer.parseInt(text)) {
				return true;
			}
		}
		return false;
	}

	private ArticleVO devuelveArticulo(int id) {
		for (int i = 0; i < listaArticulos.size(); i++) {
			if (listaArticulos.get(i).getId() == id) {
				return listaArticulos.get(i);
			}
		}
		return null;
	}

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
		if ((listaTabla.size() != 0)) {
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
		table.setModel(new DefaultTableModel(aux, new String[] { "Categoria",
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
		if (listaTabla.size() != 0) {
			listaTabla.clear();
		}
		for (int i = 0; i < listaArticulos.size(); i++) {
			if (listaArticulos.get(i).getCategory().getId() == cat.getId()) {
				listaTabla.add(listaArticulos.get(i));
			}
		}
	}

	public ArrayList<ArticleVO> cargoListado() {
		ArticleMgt test = ServiceFacade.getInstance().getArticleMgt();
		ArrayList<ArticleVO> sol = new ArrayList<ArticleVO>(10);
		sol = test.allArticles();
		return sol;
	}

	// Metodo para la busqueda facil
	private ArrayList<String> devuelveLista() {
		ArrayList<String> aux = new ArrayList<String>();
		for (int i = 0; i < listaArticulos.size(); i++) {
			aux.add(listaArticulos.get(i).getNombre());
		}
		return aux;
	}

	// Cambio la lista de la tabla siguiendo un parametro
	private ArrayList<ArticleVO> devuelvoParaTabla(String a) {
		ArrayList<ArticleVO> aux = new ArrayList<ArticleVO>();
		for (int i = 0; i < listaArticulos.size(); i++) {
			if (listaArticulos.get(i).getNombre().equals(a)) {
				aux.add(listaArticulos.get(i));
			}
		}
		return aux;
	}

	// devueve frame
	private JFrame devuelve() {
		return this;
	}

}
