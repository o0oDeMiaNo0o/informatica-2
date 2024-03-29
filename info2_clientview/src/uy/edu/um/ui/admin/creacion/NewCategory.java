package uy.edu.um.ui.admin.creacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import uy.edu.um.exceptions.checks.*;
import uy.edu.um.imagenes.DirLocal;
import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.categories.interfaces.CategoryMgt;
import uy.edu.um.ui.admin.BasicoAdmin;
import uy.edu.um.ui.admin.MainAdmin;
import uy.edu.um.ui.clasesAuxiliares.ImagePanel;
import uy.edu.um.ui.clasesAuxiliares.TransparentPanel;
import uy.edu.um.ui.mensajes.MensajeGenerico;
import uy.edu.um.value_object.categories.CategoryVO;

public class NewCategory extends BasicoAdmin {

	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JLabel lblNewLabel;
	private JButton buttonAceptar;
	private JButton buttonCancelar;
	private TransparentPanel transparentPanelBotones;
	private ImagePanel imagePanel;
	private URL bernie = DirLocal.class.getResource("Bernie's.png");

	public NewCategory() {
		setTitle("Nueva Categoria");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		TransparentPanel transparentPanel = new TransparentPanel();
		contentPane.add(transparentPanel, BorderLayout.CENTER);
		transparentPanel.setLayout(new MigLayout("",
				"[grow][][92px,grow][grow]", "[][grow][]"));

		lblNewLabel = new JLabel("Nombre");
		transparentPanel.add(lblNewLabel, "cell 1 0,alignx left,aligny center");

		textFieldNombre = new JTextField();
		transparentPanel.add(textFieldNombre, "cell 2 0,growx");
		textFieldNombre.setColumns(10);

		TransparentPanel transparentPanel_1 = new TransparentPanel();
		contentPane.add(transparentPanel_1, BorderLayout.NORTH);
		transparentPanel_1.setLayout(new MigLayout("", "[1430px]", "[16px]"));

		imagePanel = new ImagePanel(bernie);
		transparentPanel_1.add(imagePanel,
				"cell 0 0,alignx center,aligny center");

		transparentPanelBotones = new TransparentPanel();
		contentPane.add(transparentPanelBotones, BorderLayout.SOUTH);
		transparentPanelBotones.setLayout(new MigLayout("", "[grow][]", "[]"));

		buttonAceptar = new JButton("Aceptar");
		buttonAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (!textFieldNombre.getText().isEmpty()) {
					// Agrego la categoria
					try {
						CategoryMgt cat = ServiceFacade.getInstance()
								.getCategoryMgt();
						CategoryVO nuevaCatVO = null;
						nuevaCatVO = cat.createCategoryVO(textFieldNombre
								.getText());
						cat.sendCategoryVO(nuevaCatVO);
						textFieldNombre.setText("");
						MainAdmin mainAd = new MainAdmin();
						mainAd.setVisible(true);
						MensajeGenerico test = new MensajeGenerico(
								"Categoria Agregada Correctamente", devuelve());
						test.setVisible(true);
						cerrar();
					} catch (NoServerConnectionException e) {
						MensajeGenerico test = new MensajeGenerico(e
								.getMessage(), NewCategory.this);
						test.setVisible(true);
					} catch (ExisteCategoryException e) {
						MensajeGenerico test = new MensajeGenerico(e
								.getMessage(), NewCategory.this);
						test.setVisible(true);
					} catch (HasBlanksException e) {
						MensajeGenerico test = new MensajeGenerico(e
								.getMessage(), NewCategory.this);
						test.setVisible(true);
					} catch (NoDatabaseConnection e) {
						MensajeGenerico test = new MensajeGenerico(e
								.getMessage(), NewCategory.this);
						test.setVisible(true);
					}
				} else {
					MensajeGenerico test = new MensajeGenerico("Nombre Vacio",
							devuelve());
					test.setVisible(true);
				}
			}
		});
		transparentPanelBotones.add(buttonAceptar,
				"cell 0 0,alignx right,aligny center");

		buttonCancelar = new JButton("Cancelar");
		buttonCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cerrar();
			}

		});
		transparentPanelBotones.add(buttonCancelar, "cell 1 0");
	}

	public JFrame devuelve() {
		return this;
	}

	public void cerrar() {
		this.dispose();

	}

}
