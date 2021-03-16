package model;

import dao.AccountDAO;

public class RegistAccountLogic {
	public boolean execute(User user) {
		AccountDAO dao = new AccountDAO();
		boolean gouhi = dao.create(user);
		return gouhi;
	}

}
