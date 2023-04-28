package juego;

/**
 * 
 * @author Victor Fernández
 * @author Alejandro Esono
 *
 */

import ficheros.GestionaFicheros;
import preguntas.Opcion;
import preguntas.Pregunta;
import users.Partida;
import users.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*Clase que representa el juego trivial*/

public class TrivialJuego {
	// ATRIBUTOS
	private final List<Pregunta> preguntas;
	private final Player player;
	private Partida partida;

	// Constructor
	public TrivialJuego(List<Pregunta> preguntas, Player player, Partida partida) {
		this.preguntas = preguntas;
		this.player = player;
		this.partida = partida;
	}

	/**
	 * Esta función permite que un jugador juegue una partida de Trivial. La función
	 * presenta al jugador 5 preguntas de Trivial y permite que el jugador elija una
	 * respuesta para cada pregunta. Al final de la partida, se muestra la
	 * puntuación del jugador y se guarda la partida en un archivo.
	 * 
	 */
	public void jugar() {
		for (int i = 0; i < 5; i++) {
			Pregunta pregunta = preguntas.get(i);
			System.out.println(pregunta.getPregunta());
			Opcion[] opciones = pregunta.getOpciones();
			for (int j = 0; j < opciones.length; j++) {
				System.out.println(j + ". " + opciones[j]);
			}
			System.out.println("Elige una opción: ");
			Scanner sc = new Scanner(System.in);
			int opcion = sc.nextInt();
			if (pregunta.esCorrecta(opcion)) {
				partida.sumarPunto(1);
				System.out.println("Respuesta correcta");
			} else {
				System.out.println("La respuesta correcta es: " + pregunta.getOpcionCorrecta());
			}
		}
		System.out.println("Tu puntuación es: " + partida.getPuntuacion());
		GestionaFicheros.guardaPartida(partida);
	}
}