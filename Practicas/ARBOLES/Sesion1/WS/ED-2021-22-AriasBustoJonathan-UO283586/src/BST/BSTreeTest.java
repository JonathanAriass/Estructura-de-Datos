package BST;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class BSTreeTest {

	static BSTree<Integer> t; // ejemplo inventado
	static BSTree<Integer> x; // ejemplo PDF ejercicio pagina 41 
	static BSTree<Integer> z; // arbol para borrar nodos
	static BSTree<Integer> p; // arbol del profesor
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		t = new BSTree<Integer>();
		t.addNode(5);
		t.addNode(2);
		t.addNode(1);
		t.addNode(4);
		t.addNode(7);
		t.addNode(9);
		
		x = new BSTree<Integer>();
		x.addNode(50);
		x.addNode(25);
		x.addNode(75);
		x.addNode(10);
		x.addNode(40);
		x.addNode(60);
		x.addNode(90);
		x.addNode(35);
		x.addNode(45);
		x.addNode(70);
		x.addNode(42);
		
		z = new BSTree<Integer>();
		z.addNode(6);
		z.addNode(2);
		z.addNode(8);
		z.addNode(1);
		z.addNode(4);
		z.addNode(3);
		z.addNode(5);
		z.addNode(7);
		z.addNode(9);
		
		p = new BSTree<Integer>();
		assertEquals(0,p.addNode(10));
		assertEquals(0,p.addNode(5));
		assertEquals(0,p.addNode(15));
		assertEquals(0,p.addNode(2));
		assertEquals(0,p.addNode(6));
		assertEquals(0,p.addNode(14));
		assertEquals(0,p.addNode(11));
		assertEquals(0,p.addNode(16));
	}

	//TEST DEL EJEMPLO INVENTADO
	@Test
	void inOrderTest() {
		String aux = "3\t4\t5\t7\t9";
		assertEquals(aux, t.inOrder());
	}

	@Test
	void preOrderTest() {
		String aux = "5\t4\t3\t7\t9";
		assertEquals(aux, t.preOrder());
	}
	
	@Test
	void postOrderTest() {
		String aux = "3\t4\t9\t7\t5";
		assertEquals(aux, t.postOrder());
	}
	
	//TEST DEL EJEMPLO DE EJERCICIO VISTO EN CLASE
	@Test
	void inOrdeRTest2() {
		String aux = "10\t25\t35\t40\t42\t45\t50\t60\t70\t75\t90";
		assertEquals(aux, x.inOrder());
	}
	
	@Test
	void preOrderTest2() {
		String aux = "50\t25\t10\t40\t35\t45\t42\t75\t60\t70\t90";
		assertEquals(aux, x.preOrder());
	}
	
	@Test
	void postOrderTest2() {
		String aux = "10\t35\t42\t45\t40\t25\t70\t60\t90\t75\t50";
		assertEquals(aux, x.postOrder());
	}
	
	@Test
	void inOrderTest3() {
		assertEquals("2\t5\t6\t10\t11\t14\t15\t16", p.inOrder());
		p.removeNode(14);
		assertEquals("2\t5\t6\t10\t11\t15\t16", p.inOrder());
	}
	
//	@Test
//	void inOrderTestZ() {
//		String aux = "1\t2\t3\t4\t5\t6\t7\t8\t9";
//		assertEquals(aux, z.inOrder());
//	}
	
	@Test
	void removeNode() {
		assertEquals(0, z.removeNode(4));
		String aux = "1\t2\t3\t5\t6\t7\t8\t9";
		assertEquals(aux, z.inOrder());
		String aux2 = "6\t2\t1\t3\t5\t8\t7\t9";
		assertEquals(aux2, z.preOrder());
	}
	
	@Test
	void testNodosNivel() {
		ArrayList<BSTNode<Integer>> aux = new ArrayList<BSTNode<Integer>>();
//		aux = t.nodosNivel(2);
//		for (BSTNode<Integer> element : aux) {
//			System.out.print(element.getInfo() + "\t");
//		}
		System.out.println(t.nivelNodo(5));
		System.out.println(t.searchNode(4).getInfo());
	}
}
