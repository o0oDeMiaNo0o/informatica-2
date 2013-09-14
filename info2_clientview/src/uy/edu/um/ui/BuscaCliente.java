package src.uy.edu.um.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

public class BuscaCliente extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscaCliente frame = new BuscaCliente();
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
	public BuscaCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel Botonera = new JPanel();
		contentPane.add(Botonera, BorderLayout.SOUTH);
		
		JButton btnBuscar = new JButton("Buscar");
		Botonera.add(btnBuscar);
		
		JButton btnNewButton = new JButton("Salir");
		Botonera.add(btnNewButton);
		
		JPanel PanelCentral = new JPanel();
		contentPane.add(PanelCentral, BorderLayout.CENTER);
		PanelCentral.setLayout(new MigLayout("", "[61px][grow]", "[grow][16px][][][grow]"));
		
		JLabel label = new JLabel("");
		PanelCentral.add(label, "cell 0 0");
		
		JCheckBox chckbxCi = new JCheckBox("CI");
		PanelCentral.add(chckbxCi, "cell 0 1,alignx left,aligny center");
		
		JCheckBox chckbxNombre = new JCheckBox("Nombre");
		PanelCentral.add(chckbxNombre, "cell 0 2,alignx left,aligny center");
		
		textField = new JTextField();
		PanelCentral.add(textField, "cell 1 2,growx,aligny center");
		textField.setColumns(10);
		
		JCheckBox chckbxTelfono = new JCheckBox("Tel\u00E9fono");
		PanelCentral.add(chckbxTelfono, "cell 0 3,alignx left,aligny center");
	}

}
