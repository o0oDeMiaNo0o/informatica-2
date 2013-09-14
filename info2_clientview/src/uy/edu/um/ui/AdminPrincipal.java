package uy.edu.um.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class AdminPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPrincipal frame = new AdminPrincipal();
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
	public AdminPrincipal() {
		setTitle("Vista Administrador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 387, 362);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[grow][][grow]",
				"[grow][][][][][][][][grow]"));

		JButton btnEditarMenu = new JButton("Editar Menu");
		panel.add(btnEditarMenu, "cell 1 1,growx,aligny center");

		JButton btnEditarUsuarios = new JButton("Editar Usuarios");
		panel.add(btnEditarUsuarios, "cell 1 3,growx,aligny center");

		JButton btnAccesoClientes = new JButton("Acceso Clientes");
		btnAccesoClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				NuevoClienteVIP nuevo = new NuevoClienteVIP();
				nuevo.setVisible(true);
				ocultar();

			}
		});
		btnAccesoClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnAccesoClientes, "cell 1 5,growx,aligny center");

		JButton btnTomarPedidos = new JButton("Tomar Pedido");
		panel.add(btnTomarPedidos, "cell 1 7,growx,aligny center");

		JButton btnCerrarSesin = new JButton("Cerrar Sesi\u00F3n");
		btnCerrarSesin.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				LogIn nuevo = new LogIn();
				nuevo.setVisible(true);
				cerrar();
				
			}
		});
		contentPane.add(btnCerrarSesin, BorderLayout.SOUTH);
	}

	public void ocultar() {
		this.setVisible(false);
	}

	public void cerrar() {
		this.dispose();
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
		}
	}
}
