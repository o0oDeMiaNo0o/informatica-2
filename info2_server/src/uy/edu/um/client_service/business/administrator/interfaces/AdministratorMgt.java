package uy.edu.um.client_service.business.administrator.interfaces;

import uy.edu.um.client_service.business.administrator.entities.Administrator;
import uy.edu.um.value_object.administraor.AdministratorVO;

public interface AdministratorMgt {

	public void addAdministrator(Administrator a);

	public void editAdministrator(Administrator a);

	public Administrator getAdministrator(AdministratorVO a);

	public void deleteAdministrator(Administrator a);

	public void validatePassword(Administrator a);
}
