package uy.edu.um.services.table.interfaces;

import java.util.ArrayList;

import uy.edu.um.value_object.table.TableVO;

public interface TableMgt {

	public void addTable();

	public ArrayList<TableVO> allTables();

	public void setOcupado(TableVO t);
}
