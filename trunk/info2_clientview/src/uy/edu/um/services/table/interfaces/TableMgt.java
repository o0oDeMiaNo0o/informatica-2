package uy.edu.um.services.table.interfaces;

import uy.edu.um.value_object.table.TableVO;

public interface TableMgt {

	public void addTable(TableVO t);

	public TableVO createTableVO(int numero);

}
