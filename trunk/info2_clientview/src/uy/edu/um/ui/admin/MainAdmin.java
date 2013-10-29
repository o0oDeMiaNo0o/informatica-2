package uy.edu.um.ui.admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import uy.edu.um.imagenes.DirLocal;
import uy.edu.um.ui.clasesAuxiliares.ImagePanel;
import uy.edu.um.ui.clasesAuxiliares.TransparentPanel;
import uy.edu.um.value_object.user.UserVO;

public class MainAdmin extends BasicoAdmin {

	private JPanel contentPane;
	private URL dirFondo = DirLocal.class.getResource("Bernie's.png");
	private UserVO user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainAdmin frame = new MainAdmin(null);
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
	public MainAdmin(UserVO user) {

		this.user = user; // User Actual

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		TransparentPanel transparentPanel = new TransparentPanel();
		contentPane.add(transparentPanel, BorderLayout.CENTER);
		transparentPanel.setLayout(new MigLayout("", "[grow][][grow]",
				"[][][][][grow]"));

		JLabel lblBienvenidoAlPanel = new JLabel(
				"Bienvenido Al Panel De Administraci\u00F3n");
		lblBienvenidoAlPanel.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		transparentPanel.add(lblBienvenidoAlPanel, "cell 1 1");

		JLabel lblUstedSeLogeo = new JLabel("Usted Se Logueo Como : ");
		transparentPanel.add(lblUstedSeLogeo, "flowx,cell 1 3,alignx center");

		JLabel lblNewLabel = new JLabel(user.getUser());
		transparentPanel.add(lblNewLabel,
				"cell 1 3,alignx center,aligny center");

		TransparentPanel transparentPanel_1 = new TransparentPanel();
		contentPane.add(transparentPanel_1, BorderLayout.NORTH);
		transparentPanel_1.setLayout(new MigLayout("", "[1430px]", "[350px]"));

		ImagePanel imagePanel = new ImagePanel(dirFondo);
		transparentPanel_1.add(imagePanel,
				"cell 0 0,alignx center,aligny center");
	}

}
