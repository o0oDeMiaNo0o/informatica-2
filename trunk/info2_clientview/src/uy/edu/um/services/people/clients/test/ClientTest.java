package uy.edu.um.services.people.clients.test;

import java.math.BigDecimal;

import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.people.clients.interfaces.ClientMgt;
import uy.edu.um.value_object.people.client.ClientVO;

public class ClientTest {
	public static void main(String[] args) {
		String nombre = "bernardo";
		String apellido = "forrisi";
		String direccion = "asd";
		String mail = "mliston";
		int ci = 12345;
		int tel = 12345345;
		BigDecimal descuento = new BigDecimal(34);

		ClientMgt cMgt = ServiceFacade.getInstance().getClientMgt();

		ClientVO toSend = cMgt.createClientVO(nombre, apellido, ci, tel, direccion, mail, descuento);

		cMgt.addClientVO(toSend);

		System.out.println("cliente agregado");
	}
}
