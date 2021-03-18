package model;

import dao.AccountDAO;

public class LoginCheckLogic {
	public User execute(User user) {
		AccountDAO dao = new AccountDAO();
		User user1 = dao.findByUser(user);
		return user1;
	}

}
