package uy.edu.um.client_service.business.table.entities;

public class Table {

	private int numero;
	private boolean ocupado = false;

	public Table(int numero){
		this.numero = numero;
	}
	public Table(int numero,boolean ocupado){
		this.numero = numero;
		this.ocupado=ocupado;
	}
	
	

	public int getNumero() {
		return numero;
	}
	

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public boolean isOcuapdo() {
		return ocupado;
	}

	public void setOcuapdo(boolean ocuapdo) {
		this.ocupado = ocuapdo;
	}



}
