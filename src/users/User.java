package users;

import java.io.Serializable;
import java.util.Scanner;

/**
 * 
 * @author Victor Fdez
 * @author Alejandro Esono
 *
 */

public abstract class User implements Comparable<User>, Serializable{

	protected String nombre;
	protected String pass;

	// CONSTRUCTOR
	public User(String nombre, String pass) {
		this.nombre = nombre;
		this.pass = pass;
	}

	// METODOS
	public boolean cambiarPass(String pass) {

		if (pass.length() >= 8) {
			this.pass = pass;
			return true;
		} else {
			return false;
		}
	}

	public boolean compruebaPass(String pass) {

		if (this.pass.equals(pass)) {
			return true;
		} else {
			return false;
		}
	}

	public abstract boolean permisosAdmin();

	public String getName() {
		return nombre;
	}

	@Override
	public int compareTo(User o) {
		return nombre.compareTo(o.getName());
	}

	public String getPass() {
		return pass;
	}

}
