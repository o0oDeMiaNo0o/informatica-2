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
import uy.edu.um.services.categories.interfaces.CategoryMgt;
import uy.edu.um.ui.MensajeGenerico;
import uy.edu.um.ui.clasesAuxiliares.TransparentPanel;
import uy.edu.um.value_object.categories.CategoryVO;
import javax.swing.JSpinner;

public class NewTable extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JButton btnCancelar;
	private JSpinner spinner;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewTable frame = new NewTable();
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
	public NewTable() {
		setTitle("Nueva Categoria");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		TransparentPanel transparentPanel = new TransparentPanel();
		contentPane.add(transparentPanel, BorderLayout.CENTER);
		transparentPanel.setLayout(new MigLayout("", "[grow][][92px][grow]", "[][][][29px][][][][][]"));

		lblNewLabel = new JLabel("Cantidad Mesas");
		transparentPanel.add(lblNewLabel, "cell 1 1,aligny baseline");
		
		spinner = new JSpinner();
		transparentPanel.add(spinner, "cell 2 1,alignx center,aligny center");
		
				JButton btnAceptar = new JButton("Aceptar");
				btnAceptar.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						if(!textFieldNombre.getText().isEmpty()){
							//Agrego la categoria
							CategoryMgt cat = ServiceFacade.getInstance().getCategoryMgt();
							CategoryVO nuevaCatVO = cat.createCategoryVO(textFieldNombre.getText());
							cat.sendCategoryVO(nuevaCatVO);
						}else {
							MensajeGenerico test = new MensajeGenerico("Nombre Vacio");
						}
					}
				});
				transparentPanel.add(btnAceptar, "flowx,cell 3 8,alignx right,aligny top");
				
				btnCancelar = new JButton("Cancelar");
				btnCancelar.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						cerrar();
					}

					
				});
				transparentPanel.add(btnCancelar, "cell 3 8");
	}

	private void cerrar() {
		this.dispose();
		
	}

}
