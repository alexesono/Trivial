package juego;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import ficheros.GestionaFicheros;
import users.Admin;
import users.Player;
import users.User;

/**
 * 
 * @author Victor Fern�ndez
 * @author Alejandro Esono
 *
 */

public class TrivialMain {

	/**
	 * La clase TrivialMain es la clase principal que contiene el m�todo main para
	 * ejecutar el programa.
	 */

	private static ArrayList<User> users;

	/**
	 * 
	 * El m�todo main es el punto de entrada del programa.
	 * 
	 * Muestra el men� de opciones y permite al usuario elegir una opci�n.
	 * 
	 * @param args argumentos de la l�nea de comandos (no se utilizan)
	 * 
	 * @throws ClassNotFoundException si no se puede cargar la clase User
	 * 
	 * @throws IOException            si ocurre un error al leer o escribir en el
	 *                                archivo de usuarios
	 */
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		Scanner tecladoNum = new Scanner(System.in);
		Scanner teclado = new Scanner(System.in);
		boolean bucle = true;

		while (bucle == true) {

			menu();
			int eleccion = tecladoNum.nextInt();

			switch (eleccion) {
			case 1: {
				registroPlayer();
				break;
			}
			case 2: {
				registroAdmin();
				break;
			}
			case 3: {
				inicioSesion();
				break;
			}
			case 0: {
				System.out.println("Has elegido salir");
				bucle = false;
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + eleccion);
			}
		}

	}

	public static void menu() {
		System.out.println("");
		System.out.println("MENU");
		System.out.println("1.Registro Player");
		System.out.println("2.Registro Admin");
		System.out.println("3.Inicio de sesi�n");
		System.out.println("0.Salir");
		System.out.print("Elige una opci�n: ");
	}

	/**
	 * 
	 * El m�todo registroPlayer permite al usuario registrar una cuenta de jugador.
	 * Se pide al usuario que introduzca un nombre y una contrase�a (dos veces para
	 * confirmarla). Se comprueba que la contrase�a tenga al menos 8 caracteres y
	 * que las dos contrase�as coincidan. Si el usuario no existe todav�a, se a�ade
	 * a la lista de usuarios y se guarda en el archivo de usuarios.
	 * 
	 * @throws IOException            si ocurre un error al leer o escribir en el
	 *                                archivo de usuarios
	 * @throws ClassNotFoundException si no se puede cargar la clase User
	 */
	private static void registroPlayer() throws IOException, ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		users = GestionaFicheros.cargaUsers();
		System.out.println("Introduce nombre");
		String nombre = sc.nextLine();
		System.out.println("Introduce contrase�a");
		String pass = sc.nextLine();
		System.out.println("Repite contrase�a");
		String pass2 = sc.nextLine();
		if (pass.equals(pass2)) {
			if (pass.length() >= 8) {
				User user = new Player(nombre, pass);
				if (!users.contains(user)) {
					users.add(user);
					GestionaFicheros.guardaUsers(users);
				} else {
					System.out.println("El usuario ya existe");
				}
			} else {
				System.out.println("La contrase�a debe tener al menos 8 caracteres");
			}
		} else {
			System.out.println("Las contrase�as no coinciden");
		}
	}

	/**
	 * 
	 * Realiza el registro de un administrador. Pide al usuario que introduzca un
	 * nombre de usuario y dos veces la contrase�a, y si las contrase�as coinciden y
	 * tienen al menos 8 caracteres, se crea un nuevo objeto Admin y se a�ade a la
	 * lista de usuarios. Si la lista ya contiene el usuario, se muestra un mensaje
	 * de error.
	 * 
	 * @throws IOException si ocurre un error al cargar o guardar la lista de
	 *                     usuarios en el fichero.
	 */
	private static void registroAdmin() throws IOException {
		Scanner sc = new Scanner(System.in);
		users = GestionaFicheros.cargaUsers();
		System.out.println("Introduce nombre");
		String nombre = sc.nextLine();
		System.out.println("Introduce contrase�a");
		String pass = sc.nextLine();
		System.out.println("Repite contrase�a");
		String pass2 = sc.nextLine();
		if (pass.equals(pass2) && pass.length() >= 8) {
			User user = new Admin(nombre, pass);
			if (!users.contains(user)) {
				users.add(user);
				GestionaFicheros.guardaUsers(users);
			} else {
				System.out.println("El usuario ya existe");
			}
		} else {
			System.out.println("La contrase�a debe tener al menos 8 caracteres");
		}
	}

	/**
	 * 
	 * Esta funci�n permite a un usuario iniciar sesi�n en el juego Trivial. Se le
	 * solicita al usuario que ingrese su nombre y contrase�a. Si la contrase�a
	 * ingresada tiene menos de 8 caracteres, se muestra un mensaje de error y la
	 * funci�n finaliza. Si el nombre y contrase�a ingresados corresponden a un
	 * jugador registrado, se inicia una partida de TrivialJuego. Si el nombre y
	 * contrase�a ingresados corresponden a un administrador registrado, se abre la
	 * interfaz de administraci�n. Si el usuario no existe en el sistema, se muestra
	 * un mensaje de error.
	 * 
	 * @throws IOException            si ocurre un error al leer o escribir en el
	 *                                archivo de usuarios.
	 * @throws ClassNotFoundException si ocurre un error al cargar la clase User.
	 */
	private static void inicioSesion() throws IOException, ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		users = GestionaFicheros.cargaUsers();
		System.out.println("Introduce nombre");
		String nombre = sc.nextLine();
		System.out.println("Introduce contrase�a");
		String pass = sc.nextLine();
		if (pass.length() < 8) {
			System.out.println("La contrase�a no es correcta");
			return;
		}
		if (users.contains(new Player(nombre, pass))) {
			int i = users.indexOf(new Player(nombre, pass));
			TrivialJuego trivialJuego = new TrivialJuego(null, (Player) users.get(i), null);
			trivialJuego.jugar();
		} else if (users.contains(new Admin(nombre, pass))) {
			int i = users.indexOf(new Admin(nombre, pass));
			TrivialAdmin trivialAdmin = new TrivialAdmin(users.get(i));
			trivialAdmin.administrar();
		} else {
			System.out.println("El usuario no existe");
		}
	}
}
