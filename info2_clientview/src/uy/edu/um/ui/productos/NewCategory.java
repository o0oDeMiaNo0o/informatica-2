package uy.edu.um.ui.productos;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

public class NewCategory extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JLabel lblNewLabel;
	private JButton btnCancelar;

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
		transparentPanel.setLayout(new MigLayout("", "[][92px,grow]",
				"[][][][29px][][][][][]"));

		lblNewLabel = new JLabel("Nombre");
		transparentPanel.add(lblNewLabel, "cell 0 1,alignx left,aligny center");

		textFieldNombre = new JTextField();
		transparentPanel.add(textFieldNombre, "cell 1 1,growx");
		textFieldNombre.setColumns(10);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(!textFieldNombre.getText().isEmpty()){
					//Agrego la categoria
					CategoryMgt cat = ServiceFacade.getInstance().getCategoryMgt();
					CategoryVO nuevaCatVO = cat.createCategoryVO(textFieldNombre.getText());
					cat.sendCategoryVO(nuevaCatVO);
					textFieldNombre.setText("");
					MensajeGenerico test = new MensajeGenerico("Categoria Agregada Correctamente",contentPane);
					test.setVisible(true);
				}else {
					MensajeGenerico test = new MensajeGenerico("Nombre Vacio",contentPane);
					test.setVisible(true);
				}
			}
		});
		transparentPanel.add(btnAceptar, "flowx,cell 1 8,alignx right,aligny top");
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cerrar();
			}

			
		});
		transparentPanel.add(btnCancelar, "cell 1 8");
	}

	private void cerrar() {
		this.dispose();
		
	}

}
