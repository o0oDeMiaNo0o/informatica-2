package uy.edu.um.client_service.business.table.entities;

public class Table {

	private int numero;
	private boolean ocuapdo = false;

	public Table(int numero){
		this.numero = numero;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public boolean isOcuapdo() {
		return ocuapdo;
	}

	public void setOcuapdo(boolean ocuapdo) {
		this.ocuapdo = ocuapdo;
	}



}
