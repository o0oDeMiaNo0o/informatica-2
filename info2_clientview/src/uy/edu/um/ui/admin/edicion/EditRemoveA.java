package uy.edu.um.ui.admin.edicion;

import java.awt.BorderLayout;
import java.awt.Font;
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

import net.miginfocom.swing.MigLayout;
import uy.edu.um.exceptions.checks.ExisteArticleException;
import uy.edu.um.exceptions.checks.NoServerConnectionException;
import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.article.interfaces.ArticleMgt;
import uy.edu.um.services.categories.interfaces.CategoryMgt;
import uy.edu.um.ui.admin.listas.ProductList;
import uy.edu.um.ui.clasesAuxiliares.Helpers;
import uy.edu.um.ui.mensajes.MensajeGenerico;
import uy.edu.um.value_object.article.ArticleVO;
import uy.edu.um.value_object.categories.CategoryVO;

public class EditRemoveA extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldPrecio;
	private ArrayList<CategoryVO> categorias;
	String[] textos;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 *
	 * @param toSend
	 */
	public EditRemoveA(final ArticleVO articulo, final JFrame cPanel,
			final boolean editable, String mensaje) {
		try{
		categorias = cargoCategorias();
		setTitle("Confirma");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 561, 300);
		this.setLocationRelativeTo(cPanel);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel ZonaEdicion = new JPanel();
		contentPane.add(ZonaEdicion, BorderLayout.CENTER);
		ZonaEdicion.setLayout(new MigLayout("", "[grow][][388.00px][grow]",
				"[grow][][][16px][][grow]"));
		if (!mensaje.equals("")) {
			JLabel lblNewLabelMensaje = new JLabel(mensaje);
			lblNewLabelMensaje
					.setFont(new Font("Lucida Grande", Font.PLAIN, 21));
			ZonaEdicion.add(lblNewLabelMensaje, "cell 2 0,alignx center");
		}

		JLabel lblId = new JLabel("Id");
		ZonaEdicion.add(lblId, "cell 1 1");

		JLabel lblNewLabel = new JLabel("" + articulo.getId());
		ZonaEdicion.add(lblNewLabel, "cell 2 1");

		JLabel lblCategoria = new JLabel("Categoria");
		ZonaEdicion.add(lblCategoria, "cell 1 2,alignx left,aligny center");

		final JComboBox comboBox = new JComboBox();
		String[] textosMenu = cargaAlCombo(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(textosMenu));
		comboBox.setSelectedItem(articulo.getCategory().getNombre());
		comboBox.setEditable(editable);
		ZonaEdicion.add(comboBox, "cell 2 2,growx");

		JLabel lblNombre = new JLabel("Nombre");
		ZonaEdicion.add(lblNombre, "cell 1 3,alignx left,aligny center");

		textFieldNombre = new JTextField();
		textFieldNombre.setText(articulo.getNombre());
		textFieldNombre.setEditable(editable);
		ZonaEdicion.add(textFieldNombre, "cell 2 3,growx");
		textFieldNombre.setColumns(10);

		JLabel lblPrecio = new JLabel("Precio");
		ZonaEdicion.add(lblPrecio, "cell 1 4,alignx left,aligny center");

		textFieldPrecio = new JTextField();
		textFieldPrecio.setText(articulo.getPrecio().toString());
		textFieldPrecio.setEditable(editable);
		textFieldPrecio.setColumns(10);
		ZonaEdicion.add(textFieldPrecio, "cell 2 4,growx,aligny center");

		JPanel ZonaBotones = new JPanel();
		contentPane.add(ZonaBotones, BorderLayout.SOUTH);
		ZonaBotones.setLayout(new MigLayout("", "[grow][][]", "[]"));

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				ArticleMgt a = ServiceFacade.getInstance().getArticleMgt();

				if (editable == true) {
					String nombre = textFieldNombre.getText();
					boolean bandera = false;
					while (bandera == false) {
						String precioAux = textFieldPrecio.getText();
						if (!nombre.equals("")) {
							if (Helpers.isNumeric(precioAux)) {
								if (!comboBox.getSelectedItem().equals(
								"---- Desplegar Lista ----")) {
									if (editable == true) {
										try{
											BigDecimal precio = new BigDecimal(
													Integer.parseInt(textFieldPrecio
															.getText()));
											CategoryVO cat = buscaEnLista(comboBox
													.getSelectedItem().toString());
											ArticleVO toSend = null;
											try {
												toSend = a.createArticleVOid(
														articulo.getId(), nombre,
														precio, cat);
											} catch (ExisteArticleException e1) {
												MensajeGenerico nuevo = new MensajeGenerico(e1.getMessage(),devuelve());
												nuevo.setVisible(true);
											}

											a.editArticle(toSend);

											ProductList nuevo = new ProductList();
											nuevo.setVisible(true);
											cPanel.dispose();

											MensajeGenerico mensaje = new MensajeGenerico(
													"Producto Editado Correctamente",
													devuelve());
											mensaje.setVisible(true);
											bandera = true;
										}catch(NoServerConnectionException e2){
											MensajeGenerico nuevo = new MensajeGenerico(e2.getMessage(),devuelve());
											nuevo.setVisible(true);
										}
									} else {
										MensajeGenerico mensaje = new MensajeGenerico(
												"Producto Eliminado Correctamente",
												devuelve());
										mensaje.setVisible(true);
										bandera = true;
									}
								}
							} else {
								MensajeGenerico mensaje = new MensajeGenerico(
										"Precio No Numerico", devuelve());
								mensaje.setVisible(true);
								bandera = true;
							}
						} else {
							MensajeGenerico mensaje = new MensajeGenerico(
									"Ingrese Nombre", devuelve());
							mensaje.setVisible(true);
							bandera = true;
						}
					}
					cerrar();
				} else {
					try{
						a.removeArticle(articulo);
						MensajeGenerico mensaje = new MensajeGenerico(
								"Producto Editado Correctamente", devuelve());
						mensaje.setVisible(true);
						cerrar();
					}catch(NoServerConnectionException e3){
						MensajeGenerico nuevo = new MensajeGenerico(e3.getMessage(),devuelve());
						nuevo.setVisible(true);
					}
				}
			}

		});
		ZonaBotones.add(btnAceptar, "cell 1 0,alignx center,growy");

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cerrar();
			}
		});
		ZonaBotones.add(btnCancelar, "cell 2 0,growx,aligny center");
		}catch(NoServerConnectionException e){
			MensajeGenerico nuevo = new MensajeGenerico(e.getMessage(),devuelve());
			nuevo.setVisible(true);
		}
	}

	// Metodo cerrar Ventana
	public void cerrar() {
		this.setVisible(false);
	}

	// Cargar al combo box
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

	// busca en lsita
	public CategoryVO buscaEnLista(String a) {
		for (int i = 0; i < categorias.size(); i++) {
			if (categorias.get(i).getNombre().equals(a)) {
				return categorias.get(i);
			}
		}
		return null;
	}

	// Cargo categorias a arraylist
	private ArrayList<CategoryVO> cargoCategorias() throws NoServerConnectionException {
		CategoryMgt cat = ServiceFacade.getInstance().getCategoryMgt();
		return cat.allCategories();
	}

	public JFrame devuelve(){
		return this;
	}
}
