package model;

import java.util.List;

import dao.MutterDAO;

public class GetMutterListLogic {
	public List<Mutter> excute() {
		MutterDAO dao = new MutterDAO();
		List<Mutter> mutterList = dao.findAll();
		return mutterList;
	}

}
