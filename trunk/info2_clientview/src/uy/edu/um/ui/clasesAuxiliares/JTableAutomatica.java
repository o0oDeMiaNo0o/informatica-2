package uy.edu.um.ui.clasesAuxiliares;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import uy.edu.um.value_object.article.ArticleVO;

public class JTableAutomatica extends AbstractTableModel {

	private String[] columnNames = { "idArticulo", "Nombre", "Categoria",
			"Descripcion", "Precio" };
	private ArrayList<ArticleVO> datalist;

	public JTableAutomatica(ArrayList<ArticleVO> datalist) {
		this.datalist = datalist;
	}

	public int getColumnCount() {
		return this.columnNames.length;
	}

	public int getRowCount() {
		return this.datalist.size();
	}

	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}
}