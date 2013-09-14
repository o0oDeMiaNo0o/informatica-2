package src.uy.edu.um.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Color;

public class ErrorLogIn extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private final JButton btnAceptar = new JButton("Aceptar");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ErrorLogIn dialog = new ErrorLogIn();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ErrorLogIn() {
		setResizable(false);
		setBounds(100, 100, 326, 107);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 326, 82);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JLabel lblUsuarioYoContrasea = new JLabel("Usuario y/o Contrase\u00F1a incorrectos.");
			lblUsuarioYoContrasea.setBackground(new Color(248, 248, 255));
			lblUsuarioYoContrasea.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lblUsuarioYoContrasea.setBounds(27, 16, 271, 19);
			contentPanel.add(lblUsuarioYoContrasea);
		}
		btnAceptar.setBounds(117, 47, 92, 29);
		contentPanel.add(btnAceptar);
	}

}
