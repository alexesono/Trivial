package preguntas;

/**
 * 
 * @author Victor Fdez
 * @author Alejandro Esono
 *
 */

public class Opcion {

	//ATRIBUTOS
	private String enunciado;
	private boolean correcta;
	
	//METODOS
	public Opcion(String enunciado, boolean correcta) {
        this.enunciado = enunciado;
        this.correcta = correcta;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public boolean esCorrecta() {
        return correcta;
    }
    
    @Override
    public String toString() {
        return enunciado;
    }
	
}
