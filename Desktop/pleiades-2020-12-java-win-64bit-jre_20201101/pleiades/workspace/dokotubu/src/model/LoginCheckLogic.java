package model;

import dao.AccountDAO;

public class LoginCheckLogic {
	public UserCheck execute(User user) {
		AccountDAO dao = new AccountDAO();
		UserCheck uc = dao.findByUser(user);
		return uc;
	}

}
