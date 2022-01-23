import java.io.IOException;

/**
 * Clase principal que ejecuta el metodo test de la clase TestBench
 * Clase utilizada para conseguir tiempos de ejecucion para diferentes cargas y
 * asi poder ver que tendencia tienen los diferentes algoritmos con sus diferentes
 * tipos de complejidades.
 * 
 * @author Jonathan Arias Busto (UO283586)
 *
 */
public class Main {

	/**
	 * Metodo principal para ejecutar los metodo de la clase TestBench
	 * 
	 * En este caso hay una linea comentada para acordarme de como se ejecuta el otro metodo
	 * 
	 * @param args Parametro
	 * @throws IOException Se lanza la excepcion en caso de que se produzca un error en entrada salida
	 */
	public static void main(String[] args) throws IOException {
		// si quiero utilizar este primero tengo que cambiar el testAlgoritmo a int.class y int el parametro de carga
		//System.out.println(TestBench.testAlgorithm("Algoritmos", "potenciaRecursiva_v0doNothing", 10));
		TestBench.test("CSV_results_potenciav0(0,50)", 5, 0, 50, "Algoritmos", "potenciaRecursiva_v0doNothing");
	}

}
