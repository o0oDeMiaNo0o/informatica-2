package uy.edu.um.ui.admin.creacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import uy.edu.um.imagenes.DirLocal;
import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.table.interfaces.TableMgt;
import uy.edu.um.ui.MensajeGenerico;
import uy.edu.um.ui.admin.BasicoAdmin;
import uy.edu.um.ui.clasesAuxiliares.TransparentPanel;
import uy.edu.um.ui.clasesAuxiliares.ImagePanel;

import java.net.URL;
import javax.swing.SpinnerNumberModel;

public class NewTable extends BasicoAdmin {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JButton btnCancelar;
	private JSpinner spinner;
	private TransparentPanel transparentPanelBotones;
	private TransparentPanel transparentPanelImagen;
	private ImagePanel imagePanel;

	private URL bernie = DirLocal.class.getResource("Bernie's.png");

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
		transparentPanel.setLayout(new MigLayout("", "[grow][][92px][grow]",
				"[][grow][]"));

		lblNewLabel = new JLabel("Cantidad Mesas");
		transparentPanel.add(lblNewLabel,
				"cell 1 0,alignx center,aligny center");

		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0),
				null, new Integer(1)));
		transparentPanel.add(spinner, "cell 2 0,alignx center,aligny center");

		transparentPanelBotones = new TransparentPanel();
		contentPane.add(transparentPanelBotones, BorderLayout.SOUTH);
		transparentPanelBotones.setLayout(new MigLayout("", "[440px,grow]",
				"[29px]"));

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				int valor = (Integer) spinner.getValue();
				if (valor != 0) {
					// Agrego Mesa
					TableMgt test = ServiceFacade.getInstance().getTableMgt();
					for (int i = 0; i < valor; i++) {
						test.addTable();
					}

					MensajeGenerico test1 = new MensajeGenerico(spinner
							.getValue() + " mesas agregadas correctamente",
							contentPane);
					test1.setVisible(true);
					spinner.setValue(0);
				} else {
					MensajeGenerico test = new MensajeGenerico("Numero Vacio",
							contentPane);
					test.setVisible(true);
				}
			}
		});
		transparentPanelBotones.add(btnAceptar,
				"cell 0 0,alignx right,aligny center");

		btnCancelar = new JButton("Cancelar");
		transparentPanelBotones.add(btnCancelar,
				"cell 0 0,alignx right,aligny top");

		transparentPanelImagen = new TransparentPanel();
		contentPane.add(transparentPanelImagen, BorderLayout.NORTH);
		transparentPanelImagen.setLayout(new MigLayout("", "[100px,grow]",
				"[96px]"));

		imagePanel = new ImagePanel(bernie);
		transparentPanelImagen.add(imagePanel,
				"cell 0 0,alignx center,aligny center");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cerrar();
			}

		});

	}

	private void cerrar() {
		this.dispose();

	}

}
