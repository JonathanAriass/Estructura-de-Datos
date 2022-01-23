package logic;

/**
 * CLASE QUE NO SE DEBE DE MIRAR, YA QUE ES UNA CLASE DONDE SE EJECUTAN LOS METODOS
 * PARA SER PROBADOS EN CONSOLA
 * 
 * @author Jonathan Arias Busto (UO283586)
 * @version 2
 *
 */
public class Main {

	public static void main(String[] args) {
//		Graph graph1 = new Graph<Integer>(5);
//		graph1.addNode(1);
//		graph1.addNode(2);
//		graph1.addNode(3);
//		graph1.addNode(4);
//		graph1.addEdge(1, 2, 2);
//		graph1.addEdge(1, 3, 1);
//		graph1.addEdge(3, 2, 4);
//		System.out.println(graph1.toString());
		
		Graph<Integer> fullGraph = new Graph<Integer>(6);
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
//		fullGraph.toString();
		fullGraph.floyd();
		System.out.println(fullGraph.floydToString());
		
//		System.out.print(1);
//		System.out.println(fullGraph.pathAux(1, 4));
		
		System.out.println(fullGraph.path(1, 4));
//		System.out.println(fullGraph.path(2, 4));
//		System.out.println(fullGraph.path(1, 5));
		
//		System.out.println("-" + 4);
		
//		Graph graph = new Graph<Integer>(3);
//		System.out.println(graph.floyd());
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		Graph<Integer> graph = new Graph<Integer>(4);
		graph.addNode(1);
		graph.addNode(2);
		graph.addNode(3);
		graph.addNode(4);
		graph.addEdge(1, 2, 3);
		graph.addEdge(2, 3, 2);
		graph.addEdge(3, 4, 4);
		graph.floyd();
//		System.out.println(graph.floydToString());
		
//		System.out.println(graph.path(1, 4));
		System.out.println(graph.path(1, 3));
		
		
		Graph<Integer> graph2 = new Graph<Integer>(5);
		
		graph2.addNode(1);
		graph2.addNode(2);
		graph2.addNode(3);
		graph2.addNode(4);
		graph2.addNode(5);
		graph2.addEdge(1, 2, 1);
		graph2.addEdge(2, 3, 2);
		graph2.addEdge(3, 4, 2);
		graph2.addEdge(3, 5, 4);
		graph2.addEdge(4, 2, 1);
	    graph2.addEdge(4, 3, 3);
		graph2.addEdge(5, 4, 5);
		graph2.floyd();
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println(graph2.floydToString());
		System.out.println(graph2.path(1, 3));
		
		
		Graph<Integer> recorridoProfundidad = new Graph<Integer>(4);
		recorridoProfundidad.addNode(1);
		recorridoProfundidad.addNode(2);
		recorridoProfundidad.addNode(3);
		recorridoProfundidad.addNode(4);
		recorridoProfundidad.addEdge(1, 2, 2);
		recorridoProfundidad.addEdge(1, 3, 1);
		recorridoProfundidad.addEdge(2, 4, 3);
		recorridoProfundidad.addEdge(3, 2, 4);
		recorridoProfundidad.addEdge(4, 3, 6);
		recorridoProfundidad.addEdge(4, 4, 5);
		System.out.println("\n");
		System.out.println(recorridoProfundidad.recorridoProfundidad(1));
		System.out.println("\n");
		System.out.println(recorridoProfundidad.recorridoProfundidad(2));
	}

}
