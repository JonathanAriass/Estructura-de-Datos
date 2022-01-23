package BST;

/**
 * Clase que representa un nodo de un arbol BST
 * 
 * @author Jonathan Arias Busto (UO283586)
 *
 * @param <T>
 */
public class BSTNode <T extends Comparable <T>> {

	// El contenido del nodo que sera de tipo generico
	private T info;
	// Nodo hijo izquierdo
	private BSTNode<T> left;
	// Nodo hijo derecho
	private BSTNode<T> right;
	
	/**
	 * Constructor del nodo el cual añade una info de este nodo y hace un set de los hijos
	 * a null
	 * 
	 * @param clave Clave del nodo
	 */
	public BSTNode(T clave) {
		setInfo(clave);
		setLeft(null);
		setRight(null);
	}
	
	/**
	 * Metodo que devuelve la informacion del nodo
	 * 
	 * @return Informacion del nodo
	 */
	public T getInfo() {
		return info;
	}
	
	/**
	 * Metodo que setea la informacion del nodo
	 * 
	 * @param info Informacion del nodo
	 */
	public void setInfo(T info) {
		this.info = info;
	}
	
	/**
	 * Metodo que devuelve el hijo izquierdo del nodo
	 * 
	 * @return Nodo hijo izquierdo
	 */
	public BSTNode<T> getLeft() {
		return left;
	}
	
	/**
	 * Metodo que setea el hijo izquierdo del nodo
	 * 
	 * @param left Nodo que pasara a ser hijo izquierdo
	 */
	public void setLeft(BSTNode<T> left) {
		this.left = left;
	}
	
	/**
	 * Metodo que devuelve el hijo derecho del nodo
	 * 
	 * @return Nodo hijo derecho
	 */
	public BSTNode<T> getRight() {
		return right;
	}
	
	/**
	 * Metodo que setea el hijo derecho del nodo
	 * 
	 * @param left Nodo que pasara a ser hijo derecho
	 */
	public void setRight(BSTNode<T> right) {
		this.right = right;
	}
	
	/**
	 * Metodo toString() que devuelve la informacion del nodo
	 * 
	 * @return Cadena con la informacion del nodo
	 */
	public String toString() {
		return info.toString();
	}
	
}
