package uy.edu.um.ui.usuarios;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import uy.edu.um.value_object.article.ArticleVO;

public class SeleccionaMesa extends JFrame {

	private JPanel contentPane;
	ArrayList<ArticleVO> pedido;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeleccionaMesa frame = new SeleccionaMesa(null);
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
	public SeleccionaMesa(ArrayList<ArticleVO> pedido) {
		
		this.pedido = pedido;
		
		setTitle("Seleccionar Mesa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JButton btnOk = new JButton("Aceptar");
		contentPane.add(btnOk, BorderLayout.SOUTH);

		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new MigLayout("", "[grow][32px][52px,grow][grow]",
				"[grow][27px][][grow]"));

		JLabel lblMesa = new JLabel("Mesa");
		panel.add(lblMesa, "cell 1 1,alignx left,aligny center");

		JComboBox comboBox = new JComboBox();
		panel.add(comboBox, "flowx,cell 2 1,growx,aligny top");

		JButton btnVerMapa = new JButton("Ver Mapa");
		panel.add(btnVerMapa, "cell 2 2,alignx center");
	}

}
