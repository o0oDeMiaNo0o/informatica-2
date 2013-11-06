package uy.edu.um.services.table.interfaces;

import java.util.ArrayList;

import uy.edu.um.exceptions.checks.NoServerConnectionException;
import uy.edu.um.value_object.oreder.OrderVO;
import uy.edu.um.value_object.table.TableVO;

public interface TableMgt {

	public void addTable() throws NoServerConnectionException;

	public ArrayList<TableVO> allTables() throws NoServerConnectionException;

	public void setOcupado(TableVO t) throws NoServerConnectionException;

	public void removeTable(TableVO t) throws NoServerConnectionException;

	public void setLibre(TableVO t) throws NoServerConnectionException;

}
