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
import uy.edu.um.exceptions.checks.ExisteCategoryException;
import uy.edu.um.exceptions.checks.HasBlanksException;
import uy.edu.um.exceptions.checks.NoServerConnectionException;
import uy.edu.um.imagenes.DirLocal;
import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.categories.interfaces.CategoryMgt;
import uy.edu.um.ui.admin.BasicoAdmin;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewCategory frame = new NewCategory();
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
					try{
						CategoryMgt cat = ServiceFacade.getInstance()
						.getCategoryMgt();
						CategoryVO nuevaCatVO = null;
						try {
							nuevaCatVO = cat
							.createCategoryVO(textFieldNombre.getText());
						} catch (ExisteCategoryException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (HasBlanksException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						cat.sendCategoryVO(nuevaCatVO);
						textFieldNombre.setText("");
						MensajeGenerico test = new MensajeGenerico(
								"Categoria Agregada Correctamente", devuelve());
						test.setVisible(true);
					}catch(NoServerConnectionException e){
						MensajeGenerico test = new MensajeGenerico(e.getMessage(),
								devuelve());
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

	private void cerrar() {
		this.dispose();

	}

}
