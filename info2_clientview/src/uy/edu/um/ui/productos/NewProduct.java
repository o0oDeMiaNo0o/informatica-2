package uy.edu.um.ui.productos;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.article.interfaces.ArticleMgt;
import uy.edu.um.services.categories.interfaces.CategoryMgt;
import uy.edu.um.ui.MensajeGenerico;
import uy.edu.um.ui.clasesAuxiliares.Helpers;
import uy.edu.um.ui.clasesAuxiliares.TransparentPanel;
import uy.edu.um.value_object.article.ArticleVO;
import uy.edu.um.value_object.categories.CategoryVO;

public class NewProduct extends JFrame {

	ArrayList<CategoryVO> categorias = cargaCategorias();
	String[] textos;
	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldPrecio;
	private JLabel lblNewLabel;
	private JLabel lblPrecio;
	private JLabel lblNroProducto;
	private JComboBox comboBoxCat;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewProduct frame = new NewProduct();
					frame.setLocationRelativeTo(null);
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
	public NewProduct() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		TransparentPanel transparentPanel = new TransparentPanel();
		contentPane.add(transparentPanel, BorderLayout.CENTER);
		transparentPanel.setLayout(new MigLayout("", "[][92px,grow]",
				"[][][][29px][][][][][]"));

		lblNroProducto = new JLabel("Categoria");
		transparentPanel.add(lblNroProducto,
				"cell 0 0,alignx trailing,aligny center");

		comboBoxCat = new JComboBox();
		String[] textosCat = cargaAlCombo(comboBoxCat);
		comboBoxCat.setModel(new DefaultComboBoxModel(textosCat));
		transparentPanel.add(comboBoxCat, "cell 1 0,growx");

		lblNewLabel = new JLabel("Nombre");
		transparentPanel.add(lblNewLabel, "cell 0 1,alignx left,aligny center");

		textFieldNombre = new JTextField();
		transparentPanel.add(textFieldNombre, "cell 1 1,growx");
		textFieldNombre.setColumns(10);

		lblPrecio = new JLabel("Precio");
		transparentPanel.add(lblPrecio, "cell 0 2,alignx left,aligny center");

		textFieldPrecio = new JTextField();
		transparentPanel.add(textFieldPrecio, "cell 1 2,growx");
		textFieldPrecio.setColumns(10);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				ArticleMgt a = ServiceFacade.getInstance().getArticleMgt();
				String nombre = textFieldNombre.getText();
				boolean bandera = false;
				while (bandera == false) {
					String precioAux = textFieldPrecio.getText();
					if (!nombre.equals("")) {
						if (Helpers.isNumeric(precioAux)) {
							if (!comboBoxCat.getSelectedItem().equals(
									"---- Desplegar Lista ----")) {
								BigDecimal precio = new BigDecimal(Integer
										.parseInt(textFieldPrecio.getText()));
								CategoryVO cat = buscaEnLista(comboBoxCat
										.getSelectedItem().toString());

								ArticleMgt test = ServiceFacade.getInstance().getArticleMgt();
								ArticleVO toSend = a.createArticleVO(nombre,precio,cat);
								test.sendArticle(toSend);
								
								MensajeGenerico mensaje = new MensajeGenerico(
										"Producto Agregado Correctamente");
								mensaje.setVisible(true);
								bandera = true;
							}
						} else {
							MensajeGenerico mensaje = new MensajeGenerico(
									"Precio No Numerico");
							mensaje.setVisible(true);
							bandera = true;
						}
					} else {
						MensajeGenerico mensaje = new MensajeGenerico(
								"Ingrese Nombre");
						mensaje.setVisible(true);
						bandera = true;
					}
				}

			}

		});

		transparentPanel.add(btnAceptar,
				"flowx,cell 1 8,alignx right,aligny top");

		btnCancelar = new JButton("Cancelar");
		transparentPanel.add(btnCancelar, "cell 1 8");
	}

	public ArrayList<CategoryVO> cargaCategorias() {
		CategoryMgt cat = ServiceFacade.getInstance().getCategoryMgt();
		return cat.allCategories();
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

	public CategoryVO buscaEnLista(String a) {
		for (int i = 0; i < categorias.size(); i++) {
			if (categorias.get(i).equals(a)) {
				return categorias.get(i);
			}
		}
		return null;
	}
}
