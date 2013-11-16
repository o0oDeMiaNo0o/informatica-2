package uy.edu.um.value_object.chat;

public class ChatVO {
	private String mensaje;
	private boolean cocina; //false se muestra en Usuario
	
	public ChatVO(String msj, boolean cocina){
		this.mensaje = msj;
		this.cocina = cocina;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public boolean isCocina() {
		return cocina;
	}

	public void setCocina(boolean cocina) {
		this.cocina = cocina;
	}
	
	
}
