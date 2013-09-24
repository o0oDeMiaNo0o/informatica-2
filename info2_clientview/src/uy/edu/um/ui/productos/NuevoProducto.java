package uy.edu.um.ui.productos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;

import java.awt.Color;

import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.article.interfaces.ArticleMgt;
import uy.edu.um.ui.ClasesAuxiliares.TransparentPanel;
import uy.edu.um.value_object.article.ArticleVO;

import javax.swing.JButton;

import net.miginfocom.swing.MigLayout;

import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NuevoProducto extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldPrecio;
	private JLabel lblNewLabel;
	private JLabel lblPrecio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NuevoProducto frame = new NuevoProducto();
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
	public NuevoProducto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		TransparentPanel transparentPanel = new TransparentPanel();
		contentPane.add(transparentPanel, BorderLayout.CENTER);
		transparentPanel.setLayout(new MigLayout("", "[][92px,grow]",
				"[][][29px][][][][][]"));

		lblNewLabel = new JLabel("Nombre");
		transparentPanel.add(lblNewLabel, "cell 0 0,alignx trailing");

		textFieldNombre = new JTextField();
		transparentPanel.add(textFieldNombre, "cell 1 0,growx");
		textFieldNombre.setColumns(10);

		lblPrecio = new JLabel("Precio");
		transparentPanel.add(lblPrecio, "cell 0 1,alignx trailing");

		textFieldPrecio = new JTextField();
		transparentPanel.add(textFieldPrecio, "cell 1 1,growx");
		textFieldPrecio.setColumns(10);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				ArticleMgt a = ServiceFacade.getInstance().getArticleMgt();
				String nombre = textFieldNombre.getText();
				int precio = Integer.parseInt(textFieldPrecio.getText());
				ArticleVO toSend = a.createArticleVO(nombre, precio);
				a.setCliente(toSend);

			}
		});

		transparentPanel.add(btnAceptar, "cell 1 7,alignx right,aligny top");
	}

}
