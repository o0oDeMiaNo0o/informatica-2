package uy.edu.um.ui.cocina;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.Timer;

import uy.edu.um.exceptions.checks.NoDatabaseConnection;
import uy.edu.um.exceptions.checks.NoServerConnectionException;
import uy.edu.um.services.ServiceFacade;
import uy.edu.um.services.order.interfaces.OrderMgt;
import uy.edu.um.ui.mensajes.MensajeGenerico;
import uy.edu.um.value_object.oreder.OrderVO;

public class ControlaDelivery {

	Timer timer = null;
	ArrayList<OrderVO> ordenes = null;

	public ControlaDelivery() {

		this.timer = new Timer(15000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrderMgt del = ServiceFacade.getInstance().getOrderMgt();
				try {
					ordenes = del.allDeliveries();
				} catch (NoServerConnectionException e1) {
					MensajeGenerico msg = new MensajeGenerico(e1.getMessage(),
							null);
					msg.setVisible(true);
				} catch (NoDatabaseConnection e1) {
					MensajeGenerico msg = new MensajeGenerico(e1.getMessage(),
							null);
					msg.setVisible(true);
				}
				if (ordenes.size() != 0) {
					if (ordenes.size() >= 10 || chequeaTiempo(ordenes)) {
						for (int i = 0; i < ordenes.size(); i++) {
							try {
								del.enPreparacion(ordenes.get(i));
							} catch (NoServerConnectionException e1) {
								MensajeGenerico msg = new MensajeGenerico(
										e1.getMessage(), null);
								msg.setVisible(true);
							} catch (NoDatabaseConnection e1) {
								MensajeGenerico msg = new MensajeGenerico(
										e1.getMessage(), null);
								msg.setVisible(true);
							}
						}
					}
				}
			}

		});

		timer.start();
	}

	private boolean chequeaTiempo(ArrayList<OrderVO> ordenes) {

		Calendar cal = new GregorianCalendar();
		int horaA = cal.get(cal.HOUR_OF_DAY);
		int horas = ordenes.get(0).getTime().getHours();
		int HORA = horaA - horas;
		if (HORA > 1) {
			return true;
		} else {
			return false;
		}
	}

}
