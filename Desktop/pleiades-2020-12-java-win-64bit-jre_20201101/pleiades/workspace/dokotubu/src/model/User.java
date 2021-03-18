package model;

import java.io.Serializable;

public class User implements Serializable {
	private String name;
	private String pass;

	public User() {}
	public User (String name, String pass) {
		this.name = name;
		this.pass = pass;
	}

	public String getName() { return name; }
	public String getPass() { return pass; }

	public boolean equals(Object o) {
		if(this == o) { return true;}
		if(o instanceof User) {
			User user = (User)o;
			if(this.name.equals(user.name) && this.pass.equals(user.pass)) {
				return true;
			}
		}
		return false;
	}


}
