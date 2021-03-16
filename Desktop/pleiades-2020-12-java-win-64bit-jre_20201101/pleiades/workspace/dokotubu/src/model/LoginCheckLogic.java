package model;

import dao.AccountDAO;

public class LoginCheckLogic {
	public UserCheck execute() {
		AccountDAO dao = new AccountDAO();
		UserCheck uc = dao.findByUser();
		return uc;
	}

}
