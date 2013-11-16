package uy.edu.um.client_service.business.chat.entities;

public class Chat {

	private String msj;
	private boolean cocina;

	public Chat(String msj, boolean cocina){
		this.msj = msj;
		this.cocina = cocina;
	}

	public String getMsj() {
		return msj;
	}

	public void setMsj(String msj) {
		this.msj = msj;
	}

	public boolean isCocina() {
		return cocina;
	}

	public void setCocina(boolean cocina) {
		this.cocina = cocina;
	}

}
