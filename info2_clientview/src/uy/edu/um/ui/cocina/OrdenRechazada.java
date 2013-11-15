package uy.edu.um.ui.cocina;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;

import net.miginfocom.swing.MigLayout;
import uy.edu.um.ui.clasesAuxiliares.JKeyboardPane;
import uy.edu.um.value_object.oreder.OrderVO;

public class OrdenRechazada extends JFrame {
	JPopupMenu pop;
	JKeyboardPane teclado;

	public OrdenRechazada(final OrderVO orden) {

		setMinimumSize(new Dimension(700, 400));

		colocarSkin();

		JPanel pafuera = new JPanel();
		pafuera.setPreferredSize(new Dimension(200, 30));
		pafuera.setLayout(new MigLayout("", "[grow]", "[][grow][grow][]"));
		getContentPane().add(pafuera);

		final JTextPane textPane = new JTextPane();
		textPane.setBorder(new LineBorder(Color.ORANGE, 4, true));

		JLabel lblMensaje = new JLabel("Mensaje");
		lblMensaje.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		pafuera.add(lblMensaje, "cell 0 0,alignx center,aligny center");
		pafuera.add(textPane, "cell 0 1,grow");

		JKeyboardPane keyboardPane = new JKeyboardPane(textPane);
		pafuera.add(keyboardPane, "flowx,cell 0 2,alignx center,aligny center");

		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				orden.setEstado(2);
				cerrar();
			}
		});
		pafuera.add(btnEnviar, "flowx,cell 0 3,alignx center");

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				cerrar();
			}
		});
		pafuera.add(btnCancelar, "cell 0 3");

	}

	public void colocarSkin() {
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}

	public static void main(String arg[]) {
		OrdenRechazada p = new OrdenRechazada(null);
		p.setVisible(true);
		p.setBounds(0, 0, 300, 200);
		p.setLocationRelativeTo(null);
		p.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void cerrar() {
		this.dispose();
	}
}
