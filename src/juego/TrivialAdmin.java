package juego;

/**
 * 
 * @author Victor Fernández
 * @author Alejandro Esono
 *
 */

import ficheros.GestionaFicheros;
import users.User;

import java.io.IOException;
import java.util.List;

/*Clase que administra el juego trivial*/

public class TrivialAdmin implements Comparable<TrivialAdmin> {
	private User user;

	public TrivialAdmin(User user) {
		this.user = user;
	}

	/**
	 * 
	 * Esta función muestra las opciones de administración disponibles para un
	 * usuario administrador. Muestra la cantidad de partidas jugadas y los usuarios
	 * registrados.
	 * 
	 * @throws IOException            si ocurre un error de entrada o salida de
	 *                                datos.
	 * @throws ClassNotFoundException si la clase no se encuentra en el archivo.
	 */
	public void administrar() throws IOException, ClassNotFoundException {
		System.out.println("Bienvenido administrador");
		System.out.println("Partidas jugadas: ");
		List<String> partidas = GestionaFicheros.leePartidas();
		for (String partida : partidas) {
			System.out.println(partida);
		}
		System.out.println("Usuarios registrados: ");
		List<User> users = GestionaFicheros.cargaUsers();
		for (User user : users) {
			System.out.println("-" + user.getName());
		}
	}

	/**
	 * Método que compara a los usuarios para poder ordenarlos
	 *
	 * @param trivialAdmin
	 * @return
	 */
	@Override
	public int compareTo(TrivialAdmin trivialAdmin) {
		return this.user.getName().compareTo(trivialAdmin.user.getName());
	}
}