package uy.edu.um.value_object.table;

import java.io.Serializable;

public class TableVO implements Serializable{

	private int numero;
	private boolean ocupado = false;

	public TableVO(){}
	
	public TableVO(int id, boolean oc){
		this.numero=id;
		this.ocupado=oc;
	}

	public TableVO(int numero){
		this.numero = numero;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}

}
