package uy.edu.um.ui.productos;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.article.interfaces.ArticleMgt;
import uy.edu.um.ui.MensajeGenerico;
import uy.edu.um.ui.clasesAuxiliares.Helpers;
import uy.edu.um.ui.clasesAuxiliares.TransparentPanel;
import uy.edu.um.value_object.article.ArticleVO;

import javax.swing.JComboBox;

public class NewProduct extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldPrecio;
	private JLabel lblNewLabel;
	private JLabel lblPrecio;
	private JLabel lblNroProducto;
	private JComboBox comboBoxCat;

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
									"--- Desplegar Lista ---")) {
								int precio = Integer.parseInt(textFieldPrecio
										.getText());
								int categoria = buscaCategoria(comboBoxCat
										.getSelectedItem());
								bandera = true;
								ArticleVO toSend = a.createArticleVO(categoria,
										nombre, precio);
								a.setCliente(toSend);
								MensajeGenerico mensaje = new MensajeGenerico(
										"Producto Agregado Correctamente");
								mensaje.setVisible(true);
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

		transparentPanel.add(btnAceptar, "cell 1 8,alignx right,aligny top");
	}

	private int buscaCategoria(Object selectedItem) {
		// TODO Auto-generated method stub
		return 0;
	}

}
