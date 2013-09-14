package src.uy.edu.um.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AgregarProducto extends JFrame {

	private JPanel contentPane;
	private JTextField Precio;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarProducto frame = new AgregarProducto();
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
	public AgregarProducto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 298);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel ZonaIngresoDatos = new JPanel();
		contentPane.add(ZonaIngresoDatos, BorderLayout.CENTER);
		ZonaIngresoDatos.setLayout(new MigLayout("", "[][grow][]", "[grow][][][][grow]"));
		
		JLabel lblNombreMenu = new JLabel("Nombre Menu");
		ZonaIngresoDatos.add(lblNombreMenu, "cell 0 1,alignx left,aligny center");
		
		textField = new JTextField();
		ZonaIngresoDatos.add(textField, "cell 1 1,growx,aligny center");
		textField.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio");
		ZonaIngresoDatos.add(lblPrecio, "cell 0 2,alignx left,aligny center");
		
		Precio = new JTextField();
		Precio.setToolTipText("Ingrese Valor Numerico\n");
		ZonaIngresoDatos.add(Precio, "cell 1 2,growx,aligny center");
		Precio.setColumns(10);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n");
		ZonaIngresoDatos.add(lblDescripcin, "cell 0 3,alignx left,aligny center");
		
		textField_1 = new JTextField();
		ZonaIngresoDatos.add(textField_1, "cell 1 3,growx,aligny center");
		textField_1.setColumns(10);
		
		JPanel ZonaBotones = new JPanel();
		contentPane.add(ZonaBotones, BorderLayout.SOUTH);
		ZonaBotones.setLayout(new MigLayout("", "[grow][92px][98px]", "[29px]"));
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setHorizontalAlignment(SwingConstants.RIGHT);
		ZonaBotones.add(btnAceptar, "cell 1 0,alignx left,aligny center");
		
		JButton btnCancelar = new JButton("Cancelar");
		ZonaBotones.add(btnCancelar, "cell 2 0,alignx left,aligny center");
	}

}
