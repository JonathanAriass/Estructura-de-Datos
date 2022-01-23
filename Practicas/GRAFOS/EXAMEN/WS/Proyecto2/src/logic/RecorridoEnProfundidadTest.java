package logic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Clase de pruebas del algoritmo de recorrido en profundidad
 * 
 * @author Jonathan Arias Busto (UO283586)
 * @version 2
 *
 */
class RecorridoEnProfundidadTest {

	Graph<Integer> graph1;
	Graph<Integer> graph2;
	
	@BeforeEach
	void setUp() throws Exception {
		graph1 = new Graph<Integer>(4);
		graph1.addNode(1);
		graph1.addNode(2);
		graph1.addNode(3);
		graph1.addNode(4);
		graph1.addEdge(1, 2, 2);
		graph1.addEdge(1, 3, 1);
		graph1.addEdge(2, 4, 3);
		graph1.addEdge(3, 2, 4);
		graph1.addEdge(4, 4, 5);
		graph1.addEdge(4, 3, 6);
		
		graph2 = new Graph<Integer>(5);
		graph2.addNode(1);
		graph2.addNode(2);
		graph2.addNode(3);
		graph2.addNode(4);
		graph2.addNode(5);
		graph2.addEdge(1, 2, 1);
		graph2.addEdge(1, 4, 3);
		graph2.addEdge(1, 5, 10);
		graph2.addEdge(2, 3, 5);
		graph2.addEdge(3, 5, 1);
		graph2.addEdge(4, 3, 2);
		graph2.addEdge(4, 5, 6);
	}

	/**
	 * GIVEN un grafo con 4 nodos
	 * WHEN se ejecuta el recorrido en profundidad desde el nodo 1
	 * THEN se comprueba que el resultado es el esperado
	 */
	@Test
	void recorridoEnProfundidadTest1() {
		String aux = "1\t2\t4\t3\t";
		assertEquals(aux, graph1.recorridoProfundidad(1));
	}
	
	/**
	 * GIVEN un grafo con 4 nodos
	 * WHEN se ejecuta el recorrido en profundidad desde el nodo 2
	 * THEN se comprueba que el resultado es el esperado
	 */
	@Test
	void recorridoEnProfundidadTest2() {
		String aux = "2\t4\t3\t";
		assertEquals(aux, graph1.recorridoProfundidad(2));
	}
	
	/**
	 * GIVEN un grafo con 4 nodos
	 * WHEN se ejecuta el recorrido en profundidad desde el nodo 3
	 * THEN se comprueba que el resultado es el esperado
	 */
	@Test
	void recorridoEnProfundidadTest3() {
		String aux = "3\t2\t4\t";
		assertEquals(aux, graph1.recorridoProfundidad(3));
	}
	
	/**
	 * GIVEN un grafo con 5 nodos
	 * WHEN se ejecuta el recorrido en profundidad desde el nodo 1
	 * THEN se comprueba que el resultado es el esperado
	 */
	@Test
	void recorridoEnProfundidadTest4() {
		String aux = "1\t2\t3\t5\t4\t";
		assertEquals(aux, graph2.recorridoProfundidad(1));
	}
	
	/**
	 * GIVEN un grafo con 5 nodos
	 * WHEN se ejecuta el recorrido en profundidad desde el nodo 3
	 * THEN se comprueba que el resultado es el esperado
	 */
	@Test
	void recorridoEnProfundidadTest5() {
		String aux = "3\t5\t";
		assertEquals(aux, graph2.recorridoProfundidad(3));
	}

	
}
