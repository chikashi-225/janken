package model;

import java.io.Serializable;

public class User implements Serializable {
	private String name;
	private int pass;

	public User() {}
	public User (String name, int pass) {
		this.name = name;
		this.pass = pass;
	}

	public String getName() { return name; }
	public int getPass() { return pass; }


}
