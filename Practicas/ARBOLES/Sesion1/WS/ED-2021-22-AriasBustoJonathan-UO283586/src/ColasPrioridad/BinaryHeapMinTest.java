package ColasPrioridad;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Clase de pruebas de las colas de prioridad
 * 
 * @author Jonathan Arias Bustoc (UO283586)
 *
 */
class BinaryHeapMinTest {
	
	@Test
	void testAdd1() {
		BinaryHeapMin<Integer> bh = new BinaryHeapMin<Integer>(5);	
		assertEquals(0, bh.add(1));
		assertEquals("1", bh.toString());
	}
	
	@Test
	void testAdd2() {
		BinaryHeapMin<Integer> bh1 = new BinaryHeapMin<Integer>(2);	
		assertEquals(0, bh1.add(2));
		assertEquals(0, bh1.add(4));
		assertEquals(-2, bh1.add(null));
		assertEquals(-1, bh1.add(5));
		assertEquals("2\t4", bh1.toString());
	}
	
	@Test
	void testAdd3() {
		BinaryHeapMin<Integer> bh1 = new BinaryHeapMin<Integer>(5);	
		assertEquals(0, bh1.add(2));
		assertEquals(0, bh1.add(6));
		assertEquals(0, bh1.add(7));
		assertEquals(0, bh1.add(3));
		assertEquals(0, bh1.add(2));
		assertEquals(-1, bh1.add(2));
		assertEquals("2\t2\t7\t6\t3", bh1.toString());
	}
	
	@Test
	void testAdd4() {
		BinaryHeapMin<Integer> bh1 = new BinaryHeapMin<Integer>(15);	
		assertEquals(0, bh1.add(7));
		assertEquals(0, bh1.add(9));
		assertEquals(0, bh1.add(10));
		assertEquals(0, bh1.add(12));
		assertEquals(0, bh1.add(15));
		assertEquals(0, bh1.add(30));
		assertEquals(0, bh1.add(25));
		assertEquals(0, bh1.add(3));
		assertEquals("3\t7\t10\t9\t15\t30\t25\t12", bh1.toString());
	}
	
	@Test
	void testAdd5() {
		BinaryHeapMin<Integer> bh1 = new BinaryHeapMin<Integer>(15);
//		assertEquals(0, bh1.add(5));
//		assertEquals(0, bh1.add(2));
//		assertEquals(0, bh1.add(1));
//		assertEquals(0, bh1.add(3));
		assertEquals(0, bh1.add(7));
		assertEquals(0, bh1.add(9));
		assertEquals(0, bh1.add(10));
		assertEquals(0, bh1.add(12));
		assertEquals(0, bh1.add(15));
		assertEquals(0, bh1.add(30));
		assertEquals(0, bh1.add(25));
		assertEquals(0, bh1.add(3));
		assertEquals(0, bh1.add(14));
		assertEquals(0, bh1.add(17));
		assertEquals(0, bh1.add(20));
		assertEquals(0, bh1.add(35));
		assertEquals(0, bh1.add(37));
		assertEquals(0, bh1.add(27));
//		assertEquals("3\t7\t10\t9\t15\t30\t25\t12", bh1.toString());		
		System.out.println(bh1.toString());
		bh1.poll();
//		bh1.remove(3);
		System.out.println(bh1.toString());
	}

	@Test
	void testRemove1() {
		BinaryHeapMin<Integer> bh1 = new BinaryHeapMin<Integer>(3);
		assertEquals(-2, bh1.remove(2));
		assertEquals(0, bh1.add(2));
		assertEquals(-1, bh1.remove(1));
		assertEquals(0, bh1.remove(2));
		
		assertEquals("", bh1.toString());
	}
	
	@Test
	void testRemove2() {
		BinaryHeapMin<Integer> bh1 = new BinaryHeapMin<Integer>(3);
		assertEquals(-2, bh1.remove(2));
		assertEquals(0, bh1.add(4));
		assertEquals(0, bh1.add(2));
		assertEquals(0, bh1.add(5));
		assertEquals("2\t4\t5", bh1.toString());
		assertEquals(-1, bh1.remove(10));
		assertEquals(0, bh1.remove(2));
		assertEquals("4\t5", bh1.toString());
	}
	
	@Test
	void testRemove3() {
		BinaryHeapMin<Integer> bh1 = new BinaryHeapMin<Integer>(15);
		assertEquals(-2, bh1.remove(2));
		assertEquals(0, bh1.add(7));
		assertEquals(0, bh1.add(9));
		assertEquals(0, bh1.add(10));
		assertEquals(0, bh1.add(12));
		assertEquals(0, bh1.add(15));
		assertEquals(0, bh1.add(30));
		assertEquals(0, bh1.add(25));
		assertEquals(0, bh1.add(3));
		assertEquals("3\t7\t10\t9\t15\t30\t25\t12", bh1.toString());
		assertEquals(0, bh1.remove(3));
		assertEquals("7\t9\t10\t12\t15\t30\t25", bh1.toString());
		assertEquals(0, bh1.remove(10));
		assertEquals("7\t9\t25\t12\t15\t30", bh1.toString());
	}
	
	@Test
	void testCambiarPrioridad1() {
		BinaryHeapMin<Integer> bh1 = new BinaryHeapMin<Integer>(3);
		assertEquals(0, bh1.add(4));
		assertEquals(0, bh1.add(2));
		assertEquals(0, bh1.add(5));
		assertEquals(0, bh1.cambiarPrioridad(1, 9));
		assertEquals("2\t9\t5", bh1.toString());
	}
	
	@Test
	void testCambiarPrioridad2() {
		BinaryHeapMin<Integer> bh1 = new BinaryHeapMin<Integer>(10);
		assertEquals(0, bh1.add(7));
		assertEquals(0, bh1.add(9));
		assertEquals(0, bh1.add(10));
		assertEquals(0, bh1.add(12));
		assertEquals(0, bh1.add(15));
		assertEquals(0, bh1.add(30));
		assertEquals(0, bh1.add(25));
		assertEquals(0, bh1.add(3));
		assertEquals(0, bh1.cambiarPrioridad(0, 80));
		assertEquals("7\t9\t10\t12\t15\t30\t25\t80", bh1.toString());
	}
	
	@Test
	void testCambiarPrioridad3() {
		BinaryHeapMin<Integer> bh1 = new BinaryHeapMin<Integer>(10);
		assertEquals(0, bh1.add(7));
		assertEquals(0, bh1.add(9));
		assertEquals(0, bh1.add(10));
		assertEquals(0, bh1.add(12));
		assertEquals(0, bh1.add(15));
		assertEquals(0, bh1.add(30));
		assertEquals(0, bh1.add(25));
		assertEquals(0, bh1.add(3));
		assertEquals(0, bh1.cambiarPrioridad(4, 1));
		assertEquals("1\t3\t10\t9\t7\t30\t25\t12", bh1.toString());
	}
	
	@Test
	void testCambiarPrioridad4() {
		BinaryHeapMin<Integer> bh1 = new BinaryHeapMin<Integer>(10);
		assertEquals(0, bh1.add(7));
		assertEquals(0, bh1.add(9));
		assertEquals(0, bh1.add(10));
		assertEquals(0, bh1.add(12));
		assertEquals(0, bh1.add(15));
		assertEquals(0, bh1.add(30));
		assertEquals(0, bh1.add(25));
		assertEquals(0, bh1.add(3));
		assertEquals(0, bh1.cambiarPrioridad(6, 1));
		assertEquals("1\t7\t3\t9\t15\t30\t10\t12", bh1.toString());
	}
	
	@Test
	void testPoll1() {
		BinaryHeapMin<Integer> bh1 = new BinaryHeapMin<Integer>(10);
		assertEquals(0, bh1.add(7));
		assertEquals(0, bh1.add(9));
		assertEquals(0, bh1.add(10));
		assertEquals(0, bh1.add(12));
		assertEquals(0, bh1.add(15));
		assertEquals(0, bh1.add(30));
		assertEquals(0, bh1.add(25));
		assertEquals(0, bh1.add(3));
		assertEquals(3, bh1.poll());
		assertEquals("7\t9\t10\t12\t15\t30\t25", bh1.toString());
	}
	
	
	/////////////////////////////////////////////////////////////////////////
	//  				TEST CON OBJETOS TIPO DOCUMENTO					   //
	/////////////////////////////////////////////////////////////////////////
	
	@Test
	void testAddDocumento1() {
		BinaryHeapMin<Documento> bh1 = new BinaryHeapMin<Documento>(10);
		assertEquals(0, bh1.add(new Documento(3, "The Hacker Playbook 2", "Libro sobre pentesting.")));
		assertEquals(0, bh1.add(new Documento(1, "Historia de España", "Libro historico.")));
		assertEquals(0, bh1.add(new Documento(5, "El jardin olvidado", "Libro sobre drama.")));
		assertEquals("Historia de España\tThe Hacker Playbook 2\tEl jardin olvidado", bh1.toString());
	}
	
	@Test
	void testRemoveDocumento1() {
		BinaryHeapMin<Documento> bh1 = new BinaryHeapMin<Documento>(10);
		assertEquals(0, bh1.add(new Documento(3, "The Hacker Playbook 2", "Libro sobre pentesting.")));
		assertEquals(0, bh1.add(new Documento(1, "Historia de España", "Libro historico.")));
		assertEquals(0, bh1.add(new Documento(5, "El jardin olvidado", "Libro sobre drama.")));
		assertEquals("Historia de España\tThe Hacker Playbook 2\tEl jardin olvidado", bh1.toString());
		assertEquals(-1, bh1.remove(new Documento(1, "Historia de ", "Libro historico.")));
		assertEquals(0, bh1.remove(new Documento(1, "Historia de España", "Libro historico.")));
		assertEquals("The Hacker Playbook 2\tEl jardin olvidado", bh1.toString());
	}
	
	@Test
	void tesCambiarPrioridadDocumento1() {
		BinaryHeapMin<Documento> bh1 = new BinaryHeapMin<Documento>(10);
		assertEquals(0, bh1.add(new Documento(3, "The Hacker Playbook 2", "Libro sobre pentesting.")));
		assertEquals(0, bh1.add(new Documento(2, "Historia de España", "Libro historico.")));
		assertEquals(0, bh1.add(new Documento(5, "El jardin olvidado", "Libro sobre drama.")));
		assertEquals("Historia de España\tThe Hacker Playbook 2\tEl jardin olvidado", bh1.toString());
		assertEquals(0, bh1.cambiarPrioridad(2, new Documento(1, "SpiderMan", "Pelicula de ficcion.")));
		assertEquals("SpiderMan\tThe Hacker Playbook 2\tHistoria de España", bh1.toString());
	}
	
}
