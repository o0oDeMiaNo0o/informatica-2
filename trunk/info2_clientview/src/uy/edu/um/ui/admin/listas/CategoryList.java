package uy.edu.um.ui.admin.listas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.MigLayout;
import uy.edu.um.exceptions.checks.NoDatabaseConnection;
import uy.edu.um.exceptions.checks.NoServerConnectionException;
import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.categories.interfaces.CategoryMgt;
import uy.edu.um.ui.admin.BasicoAdmin;
import uy.edu.um.ui.clasesAuxiliares.TransparentPanel;
import uy.edu.um.ui.mensajes.MensajeGenerico;
import uy.edu.um.value_object.categories.CategoryVO;

public class CategoryList extends BasicoAdmin {
	private ArrayList<CategoryVO> categorias;
	private JTable table;
	private JTextField textFieldID;
	private Timer timer = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CategoryList frame = new CategoryList();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CategoryList() throws NoDatabaseConnection,
			NoServerConnectionException {
		getContentPane().setBackground(Color.LIGHT_GRAY);

		categorias = cargoCategorias();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		final TransparentPanel transparentPanel = new TransparentPanel();
		getContentPane().add(transparentPanel, BorderLayout.CENTER);
		transparentPanel.setLayout(new MigLayout("", "[grow][grow][]",
				"[grow][grow][grow]"));

		TransparentPanel transparentPanel_2 = new TransparentPanel();
		transparentPanel.add(transparentPanel_2, "cell 2 1,grow");
		transparentPanel_2.setLayout(new MigLayout("", "[grow][][grow]",
				"[grow][][][grow]"));

		JLabel lblIdCategoria = new JLabel("Id Categoria: ");
		transparentPanel_2.add(lblIdCategoria, "flowx,cell 1 1,alignx center");

		textFieldID = new JTextField();
		textFieldID.setColumns(10);
		transparentPanel_2.add(textFieldID, "cell 1 1,alignx center");

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int i = table.getSelectedRow();
				if (i > 0) {
					textFieldID.setText("" + categorias.get(i - 1).getId());
				}
			}
		});
		table.setSurrendersFocusOnKeystroke(true);
		transparentPanel.add(table, "cell 1 1,grow");

		JButton btnEliminarCategoria = new JButton("Eliminar Categoria");
		btnEliminarCategoria.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				CategoryVO cat = buscaCategoria(textFieldID.getText());
				if (cat != null) {
					CategoryMgt nuevo = ServiceFacade.getInstance()
							.getCategoryMgt();
					try {
						nuevo.borrarCateogry(cat);
						// transparentPanel.removeAll();
						categorias = cargoCategorias();
						cargaATabla();
						transparentPanel.invalidate();
						transparentPanel.validate();
						transparentPanel.repaint();
						MensajeGenerico msg = new MensajeGenerico(
								"Categoria Eliminada Correctamente",
								CategoryList.this);
						msg.setVisible(true);
					} catch (NoServerConnectionException e) {
						// TODO Auto-generated catch block
						MensajeGenerico msg = new MensajeGenerico(e
								.getMessage(), CategoryList.this);
						msg.setVisible(true);
					} catch (NoDatabaseConnection e) {
						// TODO Auto-generated catch block
						MensajeGenerico msg = new MensajeGenerico(e
								.getMessage(), CategoryList.this);
						msg.setVisible(true);
					}
				} else {
					MensajeGenerico nuevo = new MensajeGenerico(
							"Categoria No Existe", devuelve());
					nuevo.setVisible(true);
				}
			}

		});
		transparentPanel_2.add(btnEliminarCategoria,
				"cell 1 1,alignx center,aligny top");
		cargaATabla();

		this.timer = new Timer(5000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					categorias = cargoCategorias();
				} catch (NoDatabaseConnection e1) {
					// TODO Auto-generated catch block
					MensajeGenerico newFrame = new MensajeGenerico(
							e1.getMessage(), CategoryList.this);
					newFrame.setVisible(true);
				} catch (NoServerConnectionException e1) {
					MensajeGenerico newFrame = new MensajeGenerico(
							e1.getMessage(), CategoryList.this);
					newFrame.setVisible(true);
				}
				table.removeAll();
				cargaATabla();
				table.invalidate();
				table.validate();
				table.repaint();
			}

		});
		timer.start();
	}

	// Metodos Auxiliares

	// Busca categoria elegida
	private CategoryVO buscaCategoria(String text) {
		for (int i = 0; i < categorias.size(); i++) {
			if (categorias.get(i).getId() == Integer.parseInt(text)) {
				return categorias.get(i);
			}
		}
		return null;
	}

	// Cargo categorias a arraylist
	private ArrayList<CategoryVO> cargoCategorias()
			throws NoDatabaseConnection, NoServerConnectionException {
		CategoryMgt cat = ServiceFacade.getInstance().getCategoryMgt();
		ArrayList<CategoryVO> categories = new ArrayList<CategoryVO>(2);
		categories = cat.allCategories();
		return categories;
	}

	// Cargo a Tabla Categorias
	public void cargaATabla() {
		Object[][] aux = null;
		if ((categorias.size() != 0)) {
			aux = new Object[categorias.size() + 1][2];
			aux[0][0] = "Id";
			aux[0][1] = "Nombre";
			for (int i = 0; i < categorias.size(); i++) {
				aux[i + 1][0] = categorias.get(i).getId();
				aux[i + 1][1] = categorias.get(i).getNombre();
			}

		} else {
			aux = new Object[1][3];
			aux[0][0] = "Id";
			aux[0][1] = "Nombre";
		}
		table.setModel(new DefaultTableModel(aux, new String[] { "Categoria",
				"Nombre" }));
	}

	// Ve que categoria eligo
	public CategoryVO buscaEnLista(String a) {
		for (int i = 0; i < categorias.size(); i++) {
			if (categorias.get(i).getNombre().equals(a)) {
				return categorias.get(i);
			}
		}
		return null;

	}

	public JFrame devuelve() {
		return this;
	}

}
