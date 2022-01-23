package logic;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Clase de pruebas del algoritmo de Dijkstra implementado en la clase Graph
 * 
 * @author Jonathan Arias Busto (UO283586)
 * @version 2
 *
 */
class DijkstraTest {

	Graph<Integer> graph1;
	Graph<Integer> graph2;
	Graph<Integer> fullGraph;
	
	/**
	 * Setup para poder usar en los diferentes test
	 */
	@BeforeEach
	void setUp() throws Exception {
		/**
		 * Grafo de la forma:
		 * 
		 * F T F T T     0 1 0 3 10
		 * F F T F F	 0 0 5 0 0
		 * F F F F T     0 0 0 0 1 
		 * F F T F T     0 0 2 0 6
		 * F F F F F     0 0 0 0 0
		 */
		graph1 = new Graph<Integer>(5);
		graph1.addNode(1);
		graph1.addNode(2);
		graph1.addNode(3);
		graph1.addNode(4);
		graph1.addNode(5);
		graph1.addEdge(1, 2, 1);
		graph1.addEdge(1, 4, 3);
		graph1.addEdge(1, 5, 10);
		graph1.addEdge(2, 3, 5);
		graph1.addEdge(3, 5, 1);
		graph1.addEdge(4, 3, 2);
		graph1.addEdge(4, 5, 6);
		
		
		/**
		 * Grafo de la forma:
		 * 
		 * F T F T     0 4 0 1 
		 * F F T F 	   0 0 1 0 
		 * F F F F     0 0 0 0 
		 * F T T F     0 2 4 0
		 */
		graph2 = new Graph<Integer>(4);
		graph2.addNode(1);
		graph2.addNode(2);
		graph2.addNode(3);
		graph2.addNode(4);
		graph2.addEdge(1, 2, 4);
		graph2.addEdge(1, 4, 1);
		graph2.addEdge(2, 3, 1);
		graph2.addEdge(4, 3, 4);
		graph2.addEdge(4, 2, 2);
		
		
		/**
		 * Grafo de la forma:
		 * 
		 * F T T F T F      0 3 4 0 8 0
		 * F F F T F F   	0 0 0 5 0 0
		 * F T F F T F      0 0 0 0 3 0
		 * F F F F F F   	0 0 0 0 0 0
		 * F F F T F T   	0 0 0 7 0 3
		 * F F F T F F      0 0 0 2 0 0
		 */
		fullGraph = new Graph<Integer>(6);
		fullGraph.addNode(1);
		fullGraph.addNode(2);
		fullGraph.addNode(3);
		fullGraph.addNode(4);
		fullGraph.addNode(5);
		fullGraph.addNode(6);
		fullGraph.addEdge(1, 2, 3);
		fullGraph.addEdge(1, 3, 4);
		fullGraph.addEdge(1, 5, 8);
		fullGraph.addEdge(2, 5, 5);
		fullGraph.addEdge(3, 5, 3);
		fullGraph.addEdge(5, 4, 7);
		fullGraph.addEdge(5, 6, 3);
		fullGraph.addEdge(6, 4, 2);
	}

	/**
	 * GIVEN un grafo
	 * WHEN se invoca al algoritmo de Dijkstra
	 * THEN se comprueba que el vector de costes sea el esperado
	 */
	@Test
	void test1() {
		double[] res = {0, 1, 5, 3, 6};
		double[] aux = graph1.dijkstra(1);
		for (int i=0; i<res.length; i++) {
			assertEquals(aux[i], res[i]);
		}
	}
	
	/**
	 * GIVEN un grafo predefinido
	 * WHEN se invoca al algoritmo de Dijkstra
	 * THEN se comprueba que el vector de costes sea el esperado
	 */
	@Test
	void test2() {
		double[] res = {0, 3, 4, 12, 7, 10};
		double[] aux = fullGraph.dijkstra(1);
		assertArrayEquals(res, aux);
	}

	/**
	 * GIVEN un grafo predefinido
	 * WHEN se invoca al algoritmo de Dijkstra
	 * THEN se comprueba que el vector de costes sea el esperado
	 */
	@Test
	void test3() {
		double[] res = {0, 3, 4, 1};
		double[] aux = graph2.dijkstra(1);
		assertArrayEquals(res, aux);
	}
}
