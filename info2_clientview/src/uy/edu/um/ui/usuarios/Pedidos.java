package uy.edu.um.ui.usuarios;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import uy.edu.um.imagenes.DirLocal;
import uy.edu.um.ui.clasesAuxiliares.ImagePanel;
import javax.swing.BoxLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import uy.edu.um.ui.clasesAuxiliares.TransparentPanel;
import java.awt.GridLayout;
import javax.swing.JTable;

public class Pedidos extends JFrame {

	private JPanel contentPane;
	public URL DirFondo = DirLocal.class.getResource("Fondo2.jpg");
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pedidos frame = new Pedidos();
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
	public Pedidos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		ImagePanel imagePanel = new ImagePanel(DirFondo);
		contentPane.add(imagePanel, BorderLayout.CENTER);
		imagePanel.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow]"));
		
		JPanel panelPedido = new JPanel();
		panelPedido.setBorder(new LineBorder(Color.ORANGE, 3, true));
		imagePanel.add(panelPedido, "cell 1 1,grow");
		panelPedido.setLayout(new BorderLayout(0, 0));
		
		TransparentPanel transparentPanel = new TransparentPanel();
		panelPedido.add(transparentPanel, BorderLayout.NORTH);
		transparentPanel.setLayout(new MigLayout("", "[267px][267px]", "[16px]"));
		
		JLabel lblPedido = new JLabel("Pedido: ");
		transparentPanel.add(lblPedido, "flowx,cell 0 0,alignx left,aligny center");
		
		JLabel lblDynamic = new JLabel("Dynamic");
		transparentPanel.add(lblDynamic, "cell 0 0");
		
		JLabel lblTiempoEspera = new JLabel("Tiempo Espera:");
		transparentPanel.add(lblTiempoEspera, "flowx,cell 1 0");
		
		JLabel lblDynamic_1 = new JLabel("Dynamic");
		transparentPanel.add(lblDynamic_1, "cell 1 0");
		
		TransparentPanel transparentPanel_1 = new TransparentPanel();
		panelPedido.add(transparentPanel_1, BorderLayout.CENTER);
		
		table = new JTable();
		transparentPanel_1.add(table);
	}

}
