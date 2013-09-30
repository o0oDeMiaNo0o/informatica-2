package uy.edu.um.ui.usuarios;

import java.awt.EventQueue;

import javax.swing.JPanel;

import uy.edu.um.ui.clasesAuxiliares.BasicoUsuario;
import java.awt.BorderLayout;
import uy.edu.um.ui.clasesAuxiliares.TransparentPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Color;

public class AgregarCliente extends BasicoUsuario {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarCliente frame = new AgregarCliente();
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
	public AgregarCliente() {
		super();
		contentPane.setLayout(new BorderLayout(0, 0));
		
		TransparentPanel transparentPanel = new TransparentPanel();
		getContentPane().add(transparentPanel, BorderLayout.CENTER);
		transparentPanel.setLayout(new MigLayout("", "[][]", "[][][][][][][][][][][][]"));
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.WHITE);
		transparentPanel.add(lblNombre, "cell 1 1,alignx left,aligny center");
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setForeground(Color.WHITE);
		transparentPanel.add(lblApellido, "cell 1 3,alignx left,aligny center");
		
		JLabel lblCi = new JLabel("CI");
		lblCi.setForeground(Color.WHITE);
		transparentPanel.add(lblCi, "cell 1 5,alignx left,aligny center");
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setForeground(Color.WHITE);
		transparentPanel.add(lblEmail, "cell 1 7,alignx left,aligny center");
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono");
		lblTelfono.setForeground(Color.WHITE);
		transparentPanel.add(lblTelfono, "cell 1 9,alignx left,aligny center");
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n");
		lblDireccin.setForeground(Color.WHITE);
		transparentPanel.add(lblDireccin, "cell 1 11,alignx left,aligny center");
	}

}
