package preguntas;

/**
 * 
 * @author Victor Fdez
 * @author Alejandro Esono
 *
 */

public class Pregunta {

	private String pregunta;
	private Opcion[] opcion;

	// CONSTRUCTOR
	public Pregunta(String pregunta, Opcion[] opcion) {
		this.pregunta = pregunta;
		this.opcion = opcion;
	}

	//GETTERS Y SETTERS
	public String getPregunta() {
		return pregunta;
	}

	public Opcion[] getOpciones() {
		return opcion;
	}

	// METODOS
	public String getOpcionCorrecta() {
        String correcta = "";
        for (Opcion opcion : opcion) {
            if (opcion.esCorrecta()) {
                correcta = opcion.getEnunciado();
            }
        }
        return correcta;
    }

	public boolean esCorrecta(int respuesta) {
        return opcion[respuesta].esCorrecta();
    }

}
