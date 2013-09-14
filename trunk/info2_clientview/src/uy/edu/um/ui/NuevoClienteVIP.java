package src.uy.edu.um.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JSplitPane;

public class NuevoClienteVIP extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNom;
	private JTextField textFieldTel;
	private JTextField textFieldEmail;
	private JTextField textFieldCi;
	private JTextField textFieldDir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NuevoClienteVIP frame = new NuevoClienteVIP();
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
	public NuevoClienteVIP() {
		setTitle("Nuevo Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 449, 269);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][grow][]", "[grow][][][][][][grow][baseline]"));
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lblNombre, "cell 0 1,alignx left,aligny center");
		
		textFieldNom = new JTextField();
		contentPane.add(textFieldNom, "cell 1 1,growx");
		textFieldNom.setColumns(10);
		
		JLabel lblCi = new JLabel("Ci");
		contentPane.add(lblCi, "cell 0 2,alignx left,aligny center");
		
		textFieldCi = new JTextField();
		contentPane.add(textFieldCi, "cell 1 2,growx");
		textFieldCi.setColumns(10);
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n");
		contentPane.add(lblDireccion, "cell 0 3,alignx trailing,aligny center");
		
		textFieldDir = new JTextField();
		contentPane.add(textFieldDir, "cell 1 3,growx");
		textFieldDir.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Tel\u00E9fono");
		contentPane.add(lblTelefono, "cell 0 4,alignx left,aligny center");
		
		textFieldTel = new JTextField();
		contentPane.add(textFieldTel, "cell 1 4,growx");
		textFieldTel.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail");
		contentPane.add(lblEmail, "cell 0 5,alignx left,aligny center");
		
		textFieldEmail = new JTextField();
		contentPane.add(textFieldEmail, "cell 1 5,growx");
		textFieldEmail.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnAceptar, "flowx,cell 1 7,alignx trailing");
		
		JButton btnCancelar = new JButton("Cancelar");
		contentPane.add(btnCancelar, "cell 1 7,alignx right,aligny center");
	}

}
