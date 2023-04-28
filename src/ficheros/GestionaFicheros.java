package ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

import preguntas.Opcion;
import preguntas.Pregunta;
import users.Partida;
import users.User;

/**
 * 
 * @author Victor Fernández
 * @author Alejandro Esono
 *
 */

public class GestionaFicheros {

	private static final File filePreguntas = new File("Files/preguntas.txt");
	private static final File fileUsers = new File("Files/user.dat");
	private static final File filePartidas = new File("Files/partidas.txt");

	// METODOS

	/**
	 * 
	 * Guarda los usuarios en un archivo de objetos.
	 * 
	 * @param users lista de usuarios a guardar
	 */
	public static void guardaUsers(ArrayList<User> users) {
		try {
			FileOutputStream fos = new FileOutputStream(fileUsers);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(users);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * Carga los usuarios desde un archivo de objetos.
	 * 
	 * @return lista de usuarios cargada
	 */
	public static ArrayList<User> cargaUsers() {
		ArrayList<User> users = new ArrayList<>();
		try {
			FileInputStream fis = new FileInputStream(fileUsers);
			ObjectInputStream ois = new ObjectInputStream(fis);
			users = (ArrayList<User>) ois.readObject();
			// users = new ArrayList<>(Arrays.asList((User[]) in.readObject()));
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return users;
	}

	/**
	 * 
	 * Carga las preguntas desde un archivo de texto.
	 * 
	 * @return lista de preguntas cargada
	 * @throws IOException si hay algún problema con el archivo
	 */
	public static ArrayList<Pregunta> cargaPreguntas() throws IOException {
		ArrayList<Pregunta> preguntas = new ArrayList<>();
		if (!filePreguntas.exists()) {
			filePreguntas.createNewFile();
		}
		try {
			FileReader fr = new FileReader(filePreguntas);
			BufferedReader br = new BufferedReader(fr);
			String linea;
			while ((linea = br.readLine()) != null) {
				String pregunta = linea;
				String opcionCorrecta = br.readLine();
				String opcion2 = br.readLine();
				String opcion3 = br.readLine();
				String opcion4 = br.readLine();
				Opcion[] opciones = { new Opcion(opcionCorrecta, true), new Opcion(opcion2, false),
						new Opcion(opcion3, false), new Opcion(opcion4, false) };
				preguntas.add(new Pregunta(pregunta, opciones));

				Collections.shuffle(preguntas);

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return preguntas;
	}

	/**
	 * 
	 * Guarda la partida en un archivo de texto.
	 * 
	 * @param partida partida a guardar
	 */
	public static void guardaPartida(Partida partida) {
		try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(filePartidas, true)))) {
			pw.println(partida.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * Lee las partidas guardadas en un archivo de texto.
	 * 
	 * @return lista de partidas leída
	 */
	public static ArrayList<String> leePartidas() {
		ArrayList<String> partidas = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(filePartidas))) {
			String partida = br.readLine();
			while (partida != null) {
				partidas.add(partida);
				partida = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return partidas;
	}

}
