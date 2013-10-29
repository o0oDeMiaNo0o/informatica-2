package uy.edu.um.ui.usuarios;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JLabel;

import net.miginfocom.swing.MigLayout;
import uy.edu.um.imagenes.DirLocal;
import uy.edu.um.ui.clasesAuxiliares.ImagePanel;
import uy.edu.um.ui.clasesAuxiliares.TransparentPanel;
import uy.edu.um.value_object.user.UserVO;

public class MainUsuario extends BasicoUsuario {
	private URL dirFondo = DirLocal.class.getResource("Bernie's.png");
	private UserVO user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainUsuario frame = new MainUsuario(null);
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
	public MainUsuario(UserVO user) {

		this.user = user; // User

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane.setLayout(new BorderLayout(0, 0));

		TransparentPanel transparentPanel = new TransparentPanel();
		contentPane.add(transparentPanel, BorderLayout.NORTH);
		transparentPanel.setLayout(new MigLayout("", "[100px,grow]", "[96px]"));

		ImagePanel imagePanel = new ImagePanel(dirFondo);
		transparentPanel
				.add(imagePanel, "cell 0 0,alignx center,aligny center");

		TransparentPanel transparentPanel_1 = new TransparentPanel();
		getContentPane().add(transparentPanel_1, BorderLayout.CENTER);
		transparentPanel_1.setLayout(new MigLayout("", "[grow][][grow]",
				"[][][][grow][]"));

		JLabel lblBienvenidoAlPanel = new JLabel(
				"Bienvenido Al Panel De Usuario");
		lblBienvenidoAlPanel.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		transparentPanel_1.add(lblBienvenidoAlPanel, "cell 1 1,alignx center");

		JLabel lblUstedSeLogueo = new JLabel("Usted Se Logueo Como : ");
		transparentPanel_1.add(lblUstedSeLogueo,
				"flowx,cell 1 2,alignx center,aligny center");

		JLabel lblNewLabel = new JLabel("New label");
		transparentPanel_1.add(lblNewLabel,
				"cell 1 2,alignx center,aligny center");

		JLabel lblParaElegirAcciones = new JLabel(
				"Para Elegir Acciones, Ir A Esquina Superior Izquierda De Pantalla");
		transparentPanel_1.add(lblParaElegirAcciones, "cell 1 4,alignx center");
	}

}
