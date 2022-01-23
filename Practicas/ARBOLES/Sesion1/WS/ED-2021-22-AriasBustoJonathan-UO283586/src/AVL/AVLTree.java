package AVL;

import java.util.ArrayList;

import BST.BSTNode;

/**
 * Clase de arbol AVL
 * 
 * @author Jonathan Arias Busto (UO283586)
 *
 * @param <T>
 */
public class AVLTree <T extends Comparable<T>> {

	// Variable usada para el recorrido inOrder
	private String inOrder = "";
		
	// Variable usada para el recorrido preOrder
	private String preOrder = "";
		
	// Variable usada para el recorrido postOrder
	private String postOrder = "";
	
	private AVLNode<T> raiz; // Raiz del arbol AVL
	
	public AVLTree() {
		this.raiz = null;
	}
	
	/**
	 * VA a devolver null si la clave o el arbol en el que busco es null o no encuentra el elemento
	 * Si lo encuentra va a devolver el nodo completo
	 * @param clave Clave a buscar
	 * @return Nodo del arbol 
	 */
	public AVLNode<T> searchNode(T clave) {
		if (clave == null || this.raiz == null) return null;
		
		return search(raiz, clave);
	} //Se puede copiar el de BSTree
	
	
	private AVLNode<T> search(AVLNode<T> raiz2, T clave) {
		if (raiz2 == null) {
			return null;
		} else {
			if (clave.compareTo(raiz2.getInfo()) == 0) {
				return raiz2;
			} else {
				if (clave.compareTo(raiz2.getInfo()) > 0) {
					return search(raiz2.getRight(), clave);
				} else {
					if (clave.compareTo(raiz2.getInfo()) < 0) {
						return search(raiz2.getLeft(), clave);
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * Metodo que añade un nodo al arbol
	 * 
	 * @param clave Nodo a añadir 
	 * @return Numero que indica el resultado de añadir el nodo al arbol
	 */
	public int addNode(T clave) {
		if (clave == null) return -2;
		if (searchNode(clave) != null) return -1;
		if (raiz == null) {
			this.raiz = new AVLNode(clave);
			return 0;
		}
		else {
			this.raiz = addNodeR(this.raiz, clave);
		}
		return 0;
	}
	
	/**
	 * Metodo recursivo de addNode()
	 * 
	 * @param raiz2 Raiz desde la que añadir el nodo
	 * @param clave Clave del nodo
	 * @return Nodo con toda su informacion
	 */
	private AVLNode<T> addNodeR(AVLNode<T> raiz2, T clave) {
		if (raiz2 == null) {
			return null;
		} else {
			if (clave.compareTo(raiz2.getInfo()) < 0) {
				if (raiz2.getLeft() != null) {
					raiz2.setLeft(addNodeR(raiz2.getLeft(), clave));
					return updateAndBalanceIfNecesary(raiz2);
				} else {
					raiz2.setLeft(new AVLNode(clave));
					return updateAndBalanceIfNecesary(raiz2);
				}
			} else {
				if (clave.compareTo(raiz2.getInfo()) > 0) {
					if (raiz2.getRight() != null) {
						raiz2.setRight(addNodeR(raiz2.getRight(), clave));
						return updateAndBalanceIfNecesary(raiz2);
					} else {
						raiz2.setRight(new AVLNode(clave));
						return updateAndBalanceIfNecesary(raiz2);	
					}
				}
			}
		}
		return updateAndBalanceIfNecesary(raiz2);
	}

	/**
	 * Metodo que updatea y balancea el arbol por completo en caso de necesitar rotaciones o actualizaciones
	 * 
	 * @param nodo Nodo para el cual updatear y balancear
	 * @return Nodo actualizado
	 */
	private AVLNode<T> updateAndBalanceIfNecesary(AVLNode<T> nodo) {
		nodo.updateHeight();
		if (nodo.getBF() == -2) {
			if (nodo.getLeft().getBF() == 1) {
				nodo = doubleLeftRotation(nodo);
			} else {
				nodo = singleLeftRotation(nodo);
			}
		}
		else if (nodo.getBF() == 2) {
			if (nodo.getRight().getBF() == -1) {
				nodo = doubleRightRotation(nodo);
			} else {
				nodo = singleRightRotation(nodo);
			}
		}
		return nodo;
	}
	
	/**
	 * Metodo que realiza una rotacion simple a la izquierda
	 * 
	 * @param nodo Nodo para el cual hacer la rotacion
	 * @return Nodo rotado
	 */
	private AVLNode<T> singleLeftRotation(AVLNode<T> nodo) {
		AVLNode<T> aux = nodo.getLeft();
		nodo.setLeft(aux.getRight());
		aux.setRight(updateAndBalanceIfNecesary(nodo));
		aux.updateHeight();
		return aux;
	}
	
	/**
	 * Metodo que realiza una rotacion simple a la derecha
	 * 
	 * @param nodo Nodo para el cual hacer la rotacion
	 * @return Nodo rotado
	 */
	private AVLNode<T> singleRightRotation(AVLNode<T> nodo) {
		AVLNode<T> aux = nodo.getRight();
		nodo.setRight(aux.getLeft());
		aux.setLeft(updateAndBalanceIfNecesary(nodo));
		aux.updateHeight();
		return aux;
	}
	
	
	private AVLNode<T> doubleLeftRotation(AVLNode<T> nodo) {
		AVLNode<T> nodoAux = nodo;
		AVLNode<T> aux = nodo.getLeft();
		nodoAux.setLeft(singleRightRotation(aux));
		nodoAux = singleLeftRotation(nodoAux);
		nodoAux.updateHeight();
		return nodoAux;
	}
	
	/**
	 * RDD es una rotacionSimpleIzquierda del subarbol derecho que se tiene que añadir al nodo raiz por la derecha
	 * y luego una rotacion simple derecha de la raizs
	 * @param nodo
	 * @return
	 */
	private AVLNode<T> doubleRightRotation(AVLNode<T> nodo) {
		AVLNode<T> nodoAux = nodo;
		AVLNode<T> aux = nodo.getRight();
		nodoAux.setRight(singleLeftRotation(aux));
		nodoAux = singleRightRotation(nodoAux);
		nodoAux.updateHeight();
		return nodoAux;
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
	private String preOrderR(AVLNode<T> raiz2) {
		if (raiz2 == null) return "";
		
		preOrder += raiz2.getInfo() + ":BF=" + raiz2.getBF() + "\t";
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
	private String postOrderR(AVLNode<T> raiz2) {
		if (raiz2 == null) return "";
		
		postOrderR(raiz2.getLeft());
		postOrderR(raiz2.getRight());
		postOrder += raiz2.getInfo() + ":BF=" + raiz2.getBF() + "\t";
		
		
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
	private String inOrderR(AVLNode<T> raiz2) {
		if (raiz2 == null) return "";
		
		inOrderR(raiz2.getLeft());
		inOrder += raiz2.getInfo() + ":BF=" + raiz2.getBF() + "\t";
		inOrderR(raiz2.getRight());
		
		return inOrder;
	}

	/**
	 * Metodo que elimina un nodo del arbol
	 * 
	 * @param clave Clave a borrar
	 * @return Numero dependiendo del resultado de la ejecucion del programa
	 */
	public int removeNode(T clave) {
		if (this.raiz == null || clave == null) return -2;
		if (searchNode(clave) == null) return -1;
		this.raiz = removeNodeR(this.raiz, clave);
		return 0;
	}

	/**
	 * Metodo recursivo auxiliar para borrar un nodo
	 * 
	 * @param raiz2 Raiz desde el que borrar el nodo
	 * @param clave Clave a ser eliminada
	 * @return Nodo con la informacion actualizada
	 */
	private AVLNode<T> removeNodeR(AVLNode<T> raiz2, T clave) {
		if (raiz2 == null) return raiz2;
		if (clave.compareTo(raiz2.getInfo()) > 0) {
			raiz2.setRight(removeNodeR(raiz2.getRight(), clave));
			return updateAndBalanceIfNecesary(raiz2);
		} 
		else if (clave.compareTo(raiz2.getInfo()) < 0) {
			raiz2.setLeft(removeNodeR(raiz2.getLeft(), clave));
			return updateAndBalanceIfNecesary(raiz2);
		} 
		else {
			if (raiz2.getLeft() == null && raiz2.getRight() == null) {
				return null;
			} 
			else if (raiz2.getRight() != null && raiz2.getLeft() == null) {
				raiz2.setInfo(searchSucesor(raiz2).getInfo());
				raiz2.setRight(removeNodeR(raiz2.getRight(), raiz2.getInfo()));
				return updateAndBalanceIfNecesary(raiz2);
			} 
			else {
				raiz2.setInfo(searchPredecesor(raiz2).getInfo());
				raiz2.setLeft(removeNodeR(raiz2.getLeft(), raiz2.getInfo()));
				return updateAndBalanceIfNecesary(raiz2);
			}
		}
	}
	
	/**
	 * Metodo que busca el sucesor para borrar un nodo
	 * 
	 * @param raiz2 Raiz desde el que buscar un sucesor
	 * @return El sucesor 
	 */
	private AVLNode<T> searchSucesor(AVLNode<T> raiz2) {
		raiz2 = raiz2.getRight();
		while (raiz2.getLeft() != null) {
			raiz2 = raiz2.getLeft();
		}
		return raiz2;
	}

	/**
	 * Metodo que busca el predecesor para borrar un nodo
	 * 
	 * @param raiz2 Raiz desde el que buscar un predecesor
	 * @return El predecesor
	 */
	private AVLNode<T> searchPredecesor(AVLNode<T> raiz2) {
		raiz2 = raiz2.getLeft();
		while (raiz2.getRight() != null) {
			raiz2 = raiz2.getRight();
		}
		return raiz2;
	}
	
	/////////////////////////////////////////////////////////
	// 					TAREAS ADICIONALES	1			   //
	/////////////////////////////////////////////////////////
	private AVLNode<T> auxPadre = null;

	public AVLNode<T> padreDe(T clave) {
		if (clave == null) return null;
		auxPadre = null;
		AVLNode<T> aux = padreDeAux(this.raiz, clave);
		return aux;
	}

	
	private AVLNode<T> padreDeAux(AVLNode<T> raiz2, T clave) {
		if (raiz2 == null) {
			return null;
		} else {
			if (clave.compareTo(raiz2.getInfo()) == 0) {
				return auxPadre;
			} else {
				if (clave.compareTo(raiz2.getInfo()) > 0) {
					auxPadre = raiz2;
					return padreDeAux(raiz2.getRight(), clave);
				} else {
					if (clave.compareTo(raiz2.getInfo()) < 0) {
						auxPadre = raiz2;
						return padreDeAux(raiz2.getLeft(), clave);
					}
				}
			}
		}
		return auxPadre;
	}
	
	
	private AVLNode<T> hermano = null;
	
	public AVLNode<T> hermanoDe(T clave) {
		if (clave == null) return null;
		hermano = null;
		AVLNode<T> aux = hermanoDeAux(this.raiz, clave);
		return aux;
	}

	private AVLNode<T> hermanoDeAux(AVLNode<T> raiz2, T clave) {
		if (raiz2 == null) {
			return null;
		} else {
			if (clave.compareTo(raiz2.getInfo()) == 0) {
				return hermano;
			} else {
				if (clave.compareTo(raiz2.getInfo()) > 0) {
					hermano = raiz2.getLeft();
					return hermanoDeAux(raiz2.getRight(), clave);
				} else {
					if (clave.compareTo(raiz2.getInfo()) < 0) {
						hermano = raiz2.getRight();
						return hermanoDeAux(raiz2.getLeft(), clave);
					}
				}
			}
		}
		return hermano;

	}
	
	
	
	
	
	//////////////////////////////////////////////////////////
	//					METODOS EXTRAS						//
	//////////////////////////////////////////////////////////
	
	//NODOS DE UN NIVEL
	private ArrayList<AVLNode<T>> auxListaNiveles = new ArrayList<AVLNode<T>>();
	
	public ArrayList<AVLNode<T>> nodosNivel(int nivel) {
		auxListaNiveles.clear();
		nodosNivelAux(nivel, raiz);
		return auxListaNiveles;
	}

	private void nodosNivelAux(int nivel, AVLNode<T> raiz) {
		if (raiz == null) return;
		else if (nivel == 0) {
			auxListaNiveles.add(raiz);
		} else {
			nodosNivelAux(nivel-1, raiz.getLeft());
			nodosNivelAux(nivel-1, raiz.getRight());
		}
	}
	
	// NUMERO DE NODOS EN NIVEL
	public int numeroNodosNivel(int nivel) {
		ArrayList<AVLNode<T>> aux = nodosNivel(nivel);
		return aux.size();
	}
	
	// NIVEL DE NODO DADO
	private Integer nivelNodoAux = 0;
	
	public Integer nivelNodo(T clave) {
		nivelNodoAux = 0;
		nivelNodoAux(clave, raiz);
		return nivelNodoAux;
	}

	private AVLNode<T> nivelNodoAux(T clave, AVLNode<T> raiz2) {
		if (raiz2 == null) {
			return null;
		} else {
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
	
	// NUMERO DE NIVELES
	public int numeroNiveles() {
		return numeroNivelesAux(raiz);
	}
	
	private int numeroNivelesAux(AVLNode<T> raiz2) {
		if (raiz2 == null) return 0;
		else {
			return Math.max(numeroNivelesAux(raiz2.getLeft()), numeroNivelesAux(raiz2.getRight())) + 1;
		}
	}
	
	//CAMINO INTERNO (LONGITUD DE CAMINO INTERNO (LCI))
	public int LCI() {
		int aux = 0;
		for (int i=1;i<=this.numeroNiveles();i++) {
			aux += i*numeroNodosNivel(i-1);
		}
		
		return aux;
	}
	
	
	// NUMERO DE ARISTAS
	/** Implementar un método que devuelva el número de aristas que hay
	 * desde clave1 hasta clave2 teniendo en cuenta que no hay ciclos y
	 * clave1 siempre es un ancestro de clave2. Devolverá el numero de
	 * aristas o 0 si clave1 es null o clave2 es null o el árbol es null o clave1 y
	 * clave2 son iguales
	 */
	private int auxAristas = 0;
	
	public int numAristas(T clave1, T clave2) {
		auxAristas = 0;
		numAristasAux(clave1, clave2);
		return auxAristas;
	}
	
	public boolean numAristasAux(T clave1, T clave2) {
		if (clave1 == null) {
			return false;
		}
		
		
		if (clave1 == clave2) {
			return true;
		}
		
		boolean foundLeft = false;
		if (searchNode(clave1).getLeft() == null) {
		}
		else {
			foundLeft = numAristasAux(searchNode(clave1).getLeft().getInfo(), clave2);			
		}
		if (foundLeft) {
			auxAristas++;
			return foundLeft;
		}
		
		boolean foundRight = false;
		
		if (searchNode(clave1).getRight() == null) {}
		else {
			foundRight = numAristasAux(searchNode(clave1).getRight().getInfo(), clave2);
		}
		if (foundRight) {
			auxAristas++;
			return foundRight;
		}
		return false;
	}
	
	// NUMERO NODOS ARBOL
	private int numNodos = 0;
	
	public int numeroNodos() {
		numNodos = 0;
		numeroNodosAux(this.raiz);
		return numNodos;
	}
	
	
	private void numeroNodosAux(AVLNode<T> raiz2) {
		if (raiz2 == this.raiz) numNodos++;
		if (raiz2 == null) {return;}
		else {
			if (raiz2.getLeft() != null) {
				numNodos++;
				numeroNodosAux(raiz2.getLeft());
			}
			if (raiz2.getRight() != null) {
				numNodos++;
				numeroNodosAux(raiz2.getRight());
			}
		}
	}

	
	// NODO ES HOJA
	public boolean esHoja(AVLNode<T> node) {
		if (node.getLeft() == null && node.getRight() == null) return true;
		return false;
	}
	
	// NUMERO INTERMEDIO DE NODOS DEL ARBOL
	private int numNodosInter = 0;
	
	public double mediaIntermedios() {
		numNodosInter = 0;
		mediaIntermediosAux(this.raiz);
		return (double) numNodosInter/numeroNodos();
	}

	private void mediaIntermediosAux(AVLNode<T> raiz2) {
		if (raiz2 == null) return;
		
		mediaIntermediosAux(raiz2.getLeft());
		
		if (!raiz2.getInfo().equals(this.raiz.getInfo()) && !esHoja(raiz2)) {
			numNodosInter++;
		}
		
		mediaIntermediosAux(raiz2.getRight());
	}
	
}
