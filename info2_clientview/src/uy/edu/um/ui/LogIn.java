package uy.edu.um.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;

public class LogIn extends JFrame {

	private JPanel contentPane;
	private JTextField txtIngreseUsuario;
	private JPasswordField pwdIngreseContrasea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn frame = new LogIn();
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
	public LogIn() {
		setTitle("Ingreso Sistema");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 382, 238);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnCreditos = new JButton("INGRESAR");
		btnCreditos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JLabel lblUsuario = new JLabel("Usuario:");
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		
		txtIngreseUsuario = new JTextField();
		txtIngreseUsuario.setColumns(10);
		
		pwdIngreseContrasea = new JPasswordField();
		contentPane.setLayout(new MigLayout("", "[grow][75px][198px][grow]", "[grow][28px][28px][29px,grow]"));
		contentPane.add(btnCreditos, "cell 2 3,alignx right,aligny top");
		contentPane.add(lblContrasea, "cell 1 2,alignx left,aligny center");
		contentPane.add(lblUsuario, "cell 1 1,alignx left,aligny center");
		contentPane.add(pwdIngreseContrasea, "cell 2 2,growx,aligny top");
		contentPane.add(txtIngreseUsuario, "cell 2 1,growx,aligny top");
	}
}
