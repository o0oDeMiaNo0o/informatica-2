package uy.edu.um.client_service.business.administrator.managers;

import uy.edu.um.client_service.business.administrator.entities.Administrator;
import uy.edu.um.client_service.business.administrator.interfaces.AdministratorMgt;
import uy.edu.um.value_object.administraor.AdministratorVO;

public class AdministratorMgr implements AdministratorMgt{

	@Override
	public void addAdministrator(Administrator a) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAdministrator(Administrator a) {
		// TODO Auto-generated method stub

	}

	@Override
	public void editAdministrator(Administrator a) {
		// TODO Auto-generated method stub

	}

	@Override
	public Administrator getAdministrator(AdministratorVO a) {
		String user = a.getUser();
		String password = a.getPassword();
		Administrator toReturn = new Administrator(user,password);
		return toReturn;
	}

	@Override
	public void validatePassword(Administrator a) {
		// TODO Auto-generated method stub

	}

}
