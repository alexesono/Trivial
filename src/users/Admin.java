package users;

import java.io.Serializable;

/**
 * 
 * @author Victor Fdez
 * @author Alejandro Esono
 *
 */

public class Admin extends User implements Serializable {
	
	public Admin(String nombre, String pass) {
		super(nombre, pass);
	}
	
	@Override
	public boolean permisosAdmin() {
		return true;
	}

	@Override
    public int compareTo(User o) {
        return 0;
    }
}
