package AVL;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import BST.BSTNode;

class AVLNodeTest {

	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void test() {
		AVLNode<Integer> n = new AVLNode<Integer>(10);
		System.out.println(n.toString());
		n.setLeft(new AVLNode<Integer>(2));
//		n.setRight(new AVLNode<Integer>(12));
		System.out.println(n.getLeft().toString());
//		System.out.println(n.getRight().toString());
	
		System.out.println("Despues de actualizar");
		n.updateHeight();
		System.out.println(n.toString());
		System.out.println(n.getLeft().toString());
//		System.out.println(n.getRight().toString());
	}
	
	@Test
	void padreDeTest() {
		AVLTree<Integer> t = new AVLTree<Integer>();
		t.addNode(6);
		t.addNode(5);
		t.addNode(3);
		t.addNode(4);
		t.addNode(7);
		t.addNode(9);
		assertEquals(null, t.hermanoDe(5));
		assertEquals(6, t.hermanoDe(9).getInfo());
		assertEquals(3, t.hermanoDe(7).getInfo());
		assertEquals(null, t.hermanoDe(4));
		assertEquals(7, t.padreDe(9).getInfo());
		assertEquals(5, t.padreDe(7).getInfo());
		assertEquals(5, t.padreDe(3).getInfo());
		assertEquals(null, t.padreDe(10));
		assertEquals(3, t.padreDe(4).getInfo());
//		ArrayList<AVLNode<Integer>> aux = new ArrayList<AVLNode<Integer>>();
//		aux = t.nodosNivel(2);
//		for (AVLNode<Integer> element : aux) {
//			System.out.print(element.getInfo() + "\t");
//		}
		System.out.println(t.nivelNodo(5));
		System.out.println(t.numeroNiveles());
		System.out.println(t.LCI());
		System.out.println(t.numAristas(5, 4));
		System.out.println("Num nodos: " + t.numeroNodos());
		System.out.println("Num nodos Intermedios: " + t.mediaIntermedios());
	}
	
	
	@Test
	void testExamenTeoria() {
		AVLTree<Integer> t = new AVLTree<Integer>();
		t.addNode(20);
		t.addNode(1);
		t.addNode(15);
		t.addNode(5);
		t.addNode(3);
		t.addNode(4);
		t.addNode(0);
		t.addNode(19);
		t.addNode(18);
		t.addNode(17);
		t.addNode(16);
		System.out.println(t.inOrder());
		t.removeNode(17);
		System.out.println(t.inOrder());
		t.removeNode(5);
		System.out.println(t.inOrder());
	}
	
//	@Test
//	void testNodosNivel() {
//		ArrayList<BSTNode<Integer>> aux = new ArrayList<BSTNode<Integer>>();
//		aux = t.nodosNivel(2);
//		for (BSTNode<Integer> element : aux) {
//			System.out.print(element.getInfo() + "\t");
//		}
//	}
	

}
