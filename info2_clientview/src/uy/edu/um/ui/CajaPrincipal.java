package src.uy.edu.um.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class CajaPrincipal extends JFrame {

	private JPanel contentPane;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CajaPrincipal frame = new CajaPrincipal();
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
	public CajaPrincipal() {
		setTitle("Caja");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[grow][][grow]", "[grow][][][][][][grow]"));
		
		JButton btnPedidoLocal = new JButton("Pedido Local");
		panel.add(btnPedidoLocal, "cell 1 1,growx,aligny center");
		
		JButton btnDelivery = new JButton("Delivery");
		panel.add(btnDelivery, "cell 1 3,growx,aligny center");
		
		JButton btnAgregarCliemte = new JButton("Agregar Cliente");
		btnAgregarCliemte.setAction(action);
		btnAgregarCliemte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnAgregarCliemte, "cell 1 5,growx,aligny center");
		
		JButton btnNewButton = new JButton("Cerrar Sesi\u00F3n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnNewButton, BorderLayout.SOUTH);
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
