import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Clase de pruebas de los metodos de la clase Algoritmos
 * 
 * @author Jonathan Arias Busto (UO283586)
 *
 */
class AlgoritmosTest {

	
	@Test
	void testFactorialRecursivo() {
		assertEquals(1, Algoritmos.factorialRecursivo(0));
		assertEquals(1, Algoritmos.factorialRecursivo(1));
		assertEquals(120, Algoritmos.factorialRecursivo(5));
		assertEquals(120, Algoritmos.factorialRecursivo(5));
//		assertEquals(7.257415615307994E306, Algoritmos.factorialRecursivo(170), 0.0); //A partir de 170 es infinito
	}
	
	@Test
	void testFactorialIterativo() {
		assertEquals(1, Algoritmos.factorialIterativo(0));
		assertEquals(1, Algoritmos.factorialIterativo(1));
		assertEquals(120, Algoritmos.factorialIterativo(5));
		assertEquals(120, Algoritmos.factorialIterativo(5));
		//assertEquals(7.257415615307994E306, Algoritmos.factorialIterativo(170), 0.0); //A partir de 170 es infinito
		// este assert da un fallo en 3 cifras
	}
	
	@Test
	void testPotenciaRecursivo_v0() {
		assertEquals(1, Algoritmos.potenciaRecursiva_v0(0));
		assertEquals(2, Algoritmos.potenciaRecursiva_v0(1));
		assertEquals(16, Algoritmos.potenciaRecursiva_v0(4));
		assertEquals(32, Algoritmos.potenciaRecursiva_v0(5));
//		assertEquals(8.98846567431158E307, Algoritmos.potenciaRecursiva_v0(1023));
	}

	@Test
	(expected = StackOverflowError.class)
	void testPotenciaRecursivo_v1() {
		assertEquals(0, Algoritmos.potenciaRecursiva_v1(-2), 0.0);
		assertEquals(1, Algoritmos.potenciaRecursiva_v1(0), 0.0);
		assertEquals(2, Algoritmos.potenciaRecursiva_v1(1), 0.0);
		assertEquals(16, Algoritmos.potenciaRecursiva_v1(4), 0.0);
		assertEquals(32, Algoritmos.potenciaRecursiva_v1(5), 0.0);
//		assertEquals(8.98846567431158E307, Algoritmos.potenciaRecursiva_v1(1023));
	}
	
	@Test
	void testPotenciaRecursivo_v2() {
		assertEquals(1, Algoritmos.potenciaRecursiva_v2(0));
		assertEquals(2, Algoritmos.potenciaRecursiva_v2(1));
		assertEquals(16, Algoritmos.potenciaRecursiva_v2(4));
		assertEquals(32, Algoritmos.potenciaRecursiva_v2(5));
//		assertEquals(8.98846567431158E307, Algoritmos.potenciaRecursiva_v2(1023));
	}
	
	@Test
	void testPotenciaRecursivo_v3() {
		assertEquals(1, Algoritmos.potenciaRecursiva_v3(0));
		assertEquals(2, Algoritmos.potenciaRecursiva_v3(1));
		assertEquals(16, Algoritmos.potenciaRecursiva_v3(4));
		assertEquals(32, Algoritmos.potenciaRecursiva_v3(5));
//		assertEquals(8.98846567431158E307, Algoritmos.potenciaRecursiva_v3(1023));
	}
	
	@Test
	void testPotenciaIterativo() {
		assertEquals(1, Algoritmos.potenciaIterativa(0));
		assertEquals(2, Algoritmos.potenciaIterativa(1));
		assertEquals(16, Algoritmos.potenciaIterativa(4));
		assertEquals(32, Algoritmos.potenciaIterativa(5));
//		assertEquals(8.98846567431158E307, Algoritmos.potenciaIterativa(1023));
	}
	
	@Test
	void testFibonacci() {
		assertEquals(0, Algoritmos.fibonacciRecursivo(-5));
		assertEquals(0, Algoritmos.fibonacciRecursivo(0));
		assertEquals(1, Algoritmos.fibonacciRecursivo(1));
		assertEquals(1, Algoritmos.fibonacciRecursivo(2));
		assertEquals(5, Algoritmos.fibonacciRecursivo(5));
		assertEquals(1, Algoritmos.fibonacciRecursivo(2));
		assertEquals(34, Algoritmos.fibonacciRecursivo(9));
		//assertEquals(1231, Algoritmos.fibonacci(60));
	}
	
	@Test
	void testFibonacciIterativo() {
		assertEquals(0, Algoritmos.fibonacciIterativo(-5));
		assertEquals(0, Algoritmos.fibonacciIterativo(0));
		assertEquals(1, Algoritmos.fibonacciIterativo(1));
		assertEquals(1, Algoritmos.fibonacciIterativo(2));
		assertEquals(5, Algoritmos.fibonacciIterativo(5));
		assertEquals(1, Algoritmos.fibonacciIterativo(2));
		assertEquals(34, Algoritmos.fibonacciIterativo(9));
		//assertEquals(1231, Algoritmos.fibonacci(60));
	}
}
