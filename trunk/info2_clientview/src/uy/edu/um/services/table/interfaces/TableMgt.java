package uy.edu.um.services.table.interfaces;

import java.util.ArrayList;

import uy.edu.um.value_object.oreder.OrderVO;
import uy.edu.um.value_object.table.TableVO;

public interface TableMgt {

	public void addTable();

	public ArrayList<TableVO> allTables();

	public void setOcupado(TableVO t);

	public void removeTable(TableVO t);

	public void setLibre(TableVO t);

}
