package users;

/**
 * 
 * @author Victor Fernández 
 * @author Alejandro Esono
 *
 */

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * 
 * @author Victor Fdez
 * @author Alejandro Esono
 *
 */

import java.util.Date;

import preguntas.Pregunta;

public class Partida {
    private LocalDate fecha;
    private Player player;
    private int puntuacion;

    public Partida(Player player, ArrayList<Pregunta> preguntas) {
        this.fecha = LocalDate.now();
        this.player = player;
        this.puntuacion = 0;
    }

    public int sumarPunto(int puntos){
        this.puntuacion += puntos;
        return this.puntuacion;
    }
    
    public int getPuntuacion() {
		// TODO Auto-generated method stub
		return puntuacion;
	}
    
    @Override
    public String toString() {
        return "Partida{" +
                "date = " + fecha +
                ", puntuacion = " + puntuacion +
                ", player = " + player +
                '}';
    }

	
}
