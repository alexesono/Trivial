package users;

/**
 * 
 * @author Victor Fdez
 * @author Alejandro Esono
 *
 */

public class Player extends User{

	public Player(String nombre, String pass) {
		super(nombre, pass);
	}
	
	public boolean permisosAdmin() {
		return false;
	}

	 @Override
	    public int compareTo(User o) {
	        return 0;
	    }

	    @Override
	    public String toString() {
	        return "Player{" +
	                "name = '" + nombre + '\'' +
	                '}';
	    }
	
}
