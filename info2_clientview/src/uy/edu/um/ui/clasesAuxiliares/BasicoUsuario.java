package uy.edu.um.ui.ClasesAuxiliares;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;

import java.awt.Color;

public class BasicoUsuario extends JFrame {

	private ImagePanel contentPane;
	private String DirFondo = "/Users/facundoliston/Documents/FACULTAD/UM/Informatica2/info2_clientview/src/uy/edu/um/imagenes/Fondo2.jpg";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BasicoUsuario frame = new BasicoUsuario();
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
	public BasicoUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new ImagePanel(DirFondo);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//Menu Opciones
				JMenuBar menuBar = new JMenuBar();
				menuBar.setBackground(Color.DARK_GRAY);
				setJMenuBar(menuBar);
				
				JMenu menuUsuario = new JMenu("Opciones Usuario");
				menuUsuario.setForeground(Color.BLACK);
				menuUsuario.setBackground(Color.DARK_GRAY);
				menuBar.add(menuUsuario);
				
				JMenuItem menuItem_4 = new JMenuItem("Agregar Usuarios");
				menuUsuario.add(menuItem_4);
				
				JMenuItem menuItem_5 = new JMenuItem("Ver Lista Usuarios");
				menuUsuario.add(menuItem_5);
				
				JMenuItem menuItem_6 = new JMenuItem("Eliminar Usuarios");
				menuUsuario.add(menuItem_6);
				
				JMenuItem menuItem_7 = new JMenuItem("Salir");
				menuItem_7.setForeground(Color.BLACK);
				menuItem_7.setBackground(Color.RED);
				menuUsuario.add(menuItem_7);
				
				JMenu menuCaja = new JMenu("Caja");
				menuCaja.setBackground(Color.DARK_GRAY);
				menuBar.add(menuCaja);
				
				JMenuItem mntmPedidoLocal = new JMenuItem("Realizar Pedido");
				menuCaja.add(mntmPedidoLocal);
				
				JMenuItem mntmDelivery = new JMenuItem("Calcelar Pedido");
				menuCaja.add(mntmDelivery);
				
				JMenu menuMenus = new JMenu("Men\u00FAs");
				menuMenus.setBackground(Color.DARK_GRAY);
				menuBar.add(menuMenus);
				
				JMenuItem menuItem = new JMenuItem("Agregar Nuevo");
				menuMenus.add(menuItem);
				
				JMenuItem menuItem_1 = new JMenuItem("Editar");
				menuMenus.add(menuItem_1);
				
				JMenuItem menuItem_2 = new JMenuItem("Listado");
				menuMenus.add(menuItem_2);
				
				JMenuItem menuItem_3 = new JMenuItem("Eliminar");
				menuMenus.add(menuItem_3);
				
				JMenu menuCocina = new JMenu("Cocina");
				menuCocina.setBackground(Color.DARK_GRAY);
				menuBar.add(menuCocina);
				
				JMenuItem mntmVerCocina = new JMenuItem("Ver Cocina");
				menuCocina.add(mntmVerCocina);
				
				JMenuItem mntmEnviarMensaje = new JMenuItem("Enviar Mensaje");
				menuCocina.add(mntmEnviarMensaje);
	}

}
