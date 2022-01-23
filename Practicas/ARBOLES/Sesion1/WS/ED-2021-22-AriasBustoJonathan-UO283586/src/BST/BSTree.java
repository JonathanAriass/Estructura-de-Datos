package BST;

import java.util.ArrayList;

/**
 * Clase que representa un arbol BST
 * 
 * @author Jonathan Arias Busto (UO283586)
 *
 * @param <T>
 */
public class BSTree<T extends Comparable<T>> {

	// Nodo raiz del arbol BST
	private BSTNode<T> raiz;
	
	// Variable usada para el recorrido inOrder
	private String inOrder = "";
	
	// Variable usada para el recorrido preOrder
	private String preOrder = "";
	
	// Variable usada para el recorrido postOrder
	private String postOrder = "";
	
	/**
	 * Constructor del arbol
	 */
	public BSTree() {
		this.raiz = null;
	}
	
	/**
	 * Metodo que busca una clave y en caso de encontrarla devuelve el nodo
	 * Devuelve null:
	 * 1.- raiz null
	 * 2.- clave no encontrada
	 * 3.- clave null
	 * 
	 * @param clave Clave del nodo que se quiere buscar
	 * @return O null en caso de que la clave sea invalida o no haya nodos en el arbol. En otro caso se devuelve el nodo
	 */
	public BSTNode<T> searchNode(T clave) {
		if (clave == null || this.raiz == null) return null;
		
		return searchNodeR(raiz, clave);
	}
	
	/**
	 * Metodo que busca un nodo dada la raiz del arbol
	 * 
	 * @param raiz Raiz del arbol
 	 * @param clave Clave del nodo a buscar
	 * @return El nodo en caso de existir y en caso negativo se devuelve null
	 */
	private BSTNode<T> searchNodeR(BSTNode<T> raiz, T clave) {
		// no hay arbol y que no se encuentra el elemento
		if (raiz == null) {
			return null;
		} else {
			if (clave.compareTo(raiz.getInfo()) == 0) {
				return raiz;
			} else {
				if (clave.compareTo(raiz.getInfo()) > 0) {
					return searchNodeR(raiz.getRight(), clave);
				} else {
					if (clave.compareTo(raiz.getInfo()) < 0) {
						return searchNodeR(raiz.getLeft(), clave);
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * 0 si añade correctamente el nodo al arbol
	 * -2 si la clave es null
	 * -1 si intenta insertar una clave que ya existe, no se permiten claven duplicadas
	 * 
	 * @param clave Nodo que se quiere añadir al arbol
	 * @return <p>-2: si la clave es nula</p><p>-1: si la clave ya existe en el arbol</p><p>0: si se añade correctamente</p>
	 */
	public int addNode(T clave) {
		if (clave == null) return -2;
		else if (searchNode(clave) != null) return -1;
		if (raiz == null) {
			raiz = new BSTNode(clave);
			return 0;
		}
		
		else {
			addNodeR(this.raiz, clave);
		}
		
		return 0;
	}
	
	/**
	 * Metodo auxiliar para añadir un hijo que calcula de forma recursiva la posicion
	 * en la que este debe de estar
	 * 
	 * @param raiz2 La raiz del arbol
	 * @param clave Hijo que se quiere añadir
	 */
	private void addNodeR(BSTNode<T> raiz2, T clave) {
		if (raiz2 == null) {
			return;
		} else {
			if (clave.compareTo(raiz2.getInfo()) < 0) {
				if (raiz2.getLeft() != null) {
					addNodeR(raiz2.getLeft(), clave);
				} else {
					raiz2.setLeft(new BSTNode(clave));
				}
			} else {
				if (clave.compareTo(raiz2.getInfo()) > 0) {
					if (raiz2.getRight() != null) {
						addNodeR(raiz2.getRight(), clave);
					} else {
						raiz2.setRight(new BSTNode(clave));
					}
				}
			}
		}
	}

	/**
	 * Metodo que devuelve el orden del arbol (preOrder)
	 * 
	 * @return Cadena con el arbol en preOrder
	 */
	public String preOrder() {
		this.preOrder = "";
		String cadena = preOrderR(raiz);
		return cadena.substring(0,cadena.length()-1);
	}
	
	/**
	 * Metodo recursivo auxiliar para hacer el recorrido en preOrder
	 * 
	 * @param raiz2 Raiz del arbol
	 * @return Cadena con la informacion del recorrido en preOrder
	 */
	private String preOrderR(BSTNode<T> raiz2) {
		if (raiz2 == null) return "";
		
		preOrder += raiz2.getInfo() + "\t";
		preOrderR(raiz2.getLeft());
		preOrderR(raiz2.getRight());
		
		
		return preOrder;
	}

	/**
	 * Metodo que devuelve el orden del arbol (postOrder)
	 * 
	 * @return Cadena con el arbol en postOrder
	 */
	public String postOrder() {
		this.postOrder = "";
		String cadena = postOrderR(raiz);
		return cadena.substring(0,cadena.length()-1);
	}
	
	/**
	 * Metodo recursivo auxiliar para hacer el recorrido en postOrder
	 * 
	 * @param raiz2 Raiz del arbol
	 * @return Cadena con la informacion del recorrido en postOrder
	 */
	private String postOrderR(BSTNode<T> raiz2) {
		if (raiz2 == null) return "";
		
		postOrderR(raiz2.getLeft());
		postOrderR(raiz2.getRight());
		postOrder += raiz2.getInfo() + "\t";
		
		
		return postOrder;
	}

	/**
	 * Metodo que devuelve el orden del arbol (inOrder)
	 * 
	 * @return Cadena con el arbol en inOrder
	 */
	public String inOrder() {
		this.inOrder = "";
		String cadena = inOrderR(raiz);
		return cadena.substring(0,cadena.length()-1);
	}
	
	/**
	 * Metodo recursivo auxiliar para hacer el recorrido en inOrder
	 * 
	 * @param raiz2 Raiz del arbol
	 * @return Cadena con la informacion del recorrido en inOrder
	 */
	private String inOrderR(BSTNode<T> raiz2) {
		if (raiz2 == null) return "";
		
		inOrderR(raiz2.getLeft());
		inOrder += raiz2.getInfo() + "\t";
		inOrderR(raiz2.getRight());
		
		return inOrder;
	}

	/**
	 * Borra un nodo del arbol y devuelve:
	 * 0 si se borra el elemento
	 * -2 si la clave que se intenta borrar es null o intento borrar una clave en un arbol vacio
	 * -1 si intento borrar una clave que no existe
	 * 
	 * @param clave Clave que se tiene que eliminar
	 * @return <p>-2: raiz o clave son null</p><p>-1: la clave no esta en el arbol</p><p>0: si se elimina correctamente</p>
	 */
	public int removeNode(T clave) {
		if (this.raiz == null || clave == null) return -2;
		if (searchNode(clave) == null) return -1;
		removeNodeR(this.raiz, clave);
		return 0;
	}

	/**
	 * Metodo auxiliar recursivo que elimina un nodo del arbol
	 * 
	 * @param raiz2 Raiz desde la que se ejecuta el metodo
	 * @param clave Clave que se elimina 
	 * @return Se devuelve el nodo que tiene que ser asignado al padre
	 */
	private BSTNode<T> removeNodeR(BSTNode<T> raiz2, T clave) {
		if (raiz2 == null) return raiz2;
		if (clave.compareTo(raiz2.getInfo()) > 0) {
			raiz2.setRight(removeNodeR(raiz2.getRight(), clave));
		} 
		else if (clave.compareTo(raiz2.getInfo()) < 0) {
			raiz2.setLeft(removeNodeR(raiz2.getLeft(), clave));
		} 
		else {
			if (raiz2.getLeft() == null && raiz2.getRight() == null) {
				raiz2 = null;
			}
			else if (raiz2.getRight() != null && raiz2.getLeft() == null) {
				raiz2.setInfo(searchSucesor(raiz2).getInfo());
				raiz2.setRight(removeNodeR(raiz2.getRight(), raiz2.getInfo()));
			} 
			else {
				raiz2.setInfo(searchPredecesor(raiz2).getInfo());
				raiz2.setLeft(removeNodeR(raiz2.getLeft(), raiz2.getInfo()));
			}
		}
		return raiz2;
	}

	/**
	 * Metodo que busca el sucesor de un nodo pasado como parametro
	 * 
	 * @param raiz2 Raiz de la que buscar el sucesor
	 * @return Se devuelve el nodo sucesor
	 */
	private BSTNode<T> searchSucesor(BSTNode<T> raiz2) {
		raiz2 = raiz2.getRight();
		while (raiz2.getLeft() != null) {
			raiz2 = raiz2.getLeft();
		}
		return raiz2;
	}

	/**
	 * Metodo que busca el antecesor de un nodo pasado como parametro
	 * 
	 * @param raiz2 Raiz de la que buscar el predecesor
	 * @return Se devuelve el nodo predecesor
	 */
	private BSTNode<T> searchPredecesor(BSTNode<T> raiz2) {
		raiz2 = raiz2.getLeft();
		while (raiz2.getRight() != null) {
			raiz2 = raiz2.getRight();
		}
		return raiz2;
	}
	
	//////////////////////////////////////////////////////////
	//						TEST EXTRAS						//
	//////////////////////////////////////////////////////////
	
	private ArrayList<BSTNode<T>> auxListaNiveles = new ArrayList<BSTNode<T>>();
	
	public ArrayList<BSTNode<T>> nodosNivel(int nivel) {
		auxListaNiveles.clear();
		nodosNivelAux(nivel, raiz);
		return auxListaNiveles;
	}

	private void nodosNivelAux(int nivel, BSTNode<T> raiz) {
		if (raiz == null) return;
		else if (nivel == 0) {
			auxListaNiveles.add(raiz);
		} else {
			nodosNivelAux(nivel-1, raiz.getLeft());
			nodosNivelAux(nivel-1, raiz.getRight());
		}
	}
	
	private Integer nivelNodoAux = 0;
	
	public Integer nivelNodo(T clave) {
		nivelNodoAux = 0;
		nivelNodoAux(clave, raiz);
		return nivelNodoAux;
	}

	private BSTNode<T> nivelNodoAux(T clave, BSTNode<T> raiz2) {
		if (raiz2 != null) {
			if (clave.compareTo(raiz2.getInfo()) == 0) {
				return raiz2;
			} else {
				if (clave.compareTo(raiz2.getInfo()) > 0) {
					nivelNodoAux++;
					return nivelNodoAux(clave, raiz2.getRight());
				} else {
					if (clave.compareTo(raiz2.getInfo()) < 0) {
						nivelNodoAux++;
						return nivelNodoAux(clave, raiz2.getLeft());
					}
				}
			}
		}
		return null;
	}
	
	
}
