package uy.edu.um.value_object.table;

import java.io.Serializable;

public class TableVO implements Serializable{

	private int numero;
	private boolean ocupado = false;

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
