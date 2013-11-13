package uy.edu.um.services.table.interfaces;

import java.util.ArrayList;

import uy.edu.um.exceptions.checks.NoDatabaseConnection;
import uy.edu.um.exceptions.checks.NoServerConnectionException;
import uy.edu.um.value_object.oreder.OrderVO;
import uy.edu.um.value_object.table.TableVO;

public interface TableMgt {

	public void addTable() throws NoServerConnectionException, NoDatabaseConnection;

	public ArrayList<TableVO> allTables() throws NoServerConnectionException, NoDatabaseConnection;

	public void setOcupado(TableVO t) throws NoServerConnectionException, NoDatabaseConnection;

	public void removeTable(TableVO t) throws NoServerConnectionException, NoDatabaseConnection;

	public void setLibre(TableVO t) throws NoServerConnectionException, NoDatabaseConnection;

}
