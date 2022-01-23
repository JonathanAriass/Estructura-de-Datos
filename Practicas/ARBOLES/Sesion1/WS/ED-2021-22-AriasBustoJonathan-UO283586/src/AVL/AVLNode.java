package AVL;

/**
 * Nodo de los arboles AVL
 * 
 * @author Jonathan Arias Busto (UO283586)
 *
 * @param <T>
 */
public class AVLNode <T extends Comparable <T>>{

	// si tengo un nodo null su altura es -1
	private static final int NULL_NODE = -1;
	
	private T info; // Contenido del nodo
	private AVLNode<T> left; // Nodo hijo izquierdo
	private AVLNode<T> right; // Nodo hijo derecho
	private int balanceFactor; // Factor de balance del nodo
	private int height; // Altura del nodo
	
	
	/**
	 * Constructor del nodo
	 * @param clave
	 */
	public AVLNode(T clave) {
		this.info = clave;
		this.left = null;
		this.right = null;
		this.balanceFactor = 0;
		this.height = 0;
	}
	
	/**
	 * Metodo que le da valor a la info del nodo
	 * 
	 * @param clave Informacion a añadir al nodo
	 */
	public void setInfo(T clave) {
		this.info = clave;
	}
	
	/**
	 * Metodo que devuelve la informacion del nodo
	 * 
	 * @return Informacion del nodo
	 */
	public T getInfo() {
		return this.info;
	}
	
	/**
	 * Metodo que da valor al hijo izquierdo del nodo
	 * 
	 * @param nodo Nodo a añadir por la izquierda del nodo
	 */
	public void setLeft(AVLNode<T> nodo) {
		this.left = nodo;
	}
	
	/**
	 * Metodo que da valor al hijo derecho del nodo
	 * 
	 * @param nodo Nodo a añadir por la derecha del nodo
	 */
	public void setRight(AVLNode<T> nodo) {
		this.right = nodo;
	}
	
	/**
	 * Metodo que devuelve el hijo izquierdo del nodo
	 * 
	 * @return Hijo izquierdo del nodo
	 */
	public AVLNode<T> getLeft() {
		return this.left;
	}
	
	/**
	 * Metodo que devuelve el hijo derecho del nodo
	 * 
	 * @return Hijo derecho del nodo
	 */
	public AVLNode<T> getRight() {
		return this.right;
	}

	/**
	 * Metodo que devuelve la altura del nodo
	 * 
	 * @return Altura del nodo
	 */
	public int getBFHeight() {
		return this.height;
	}
	
	/**
	 * Metodo que devuelve el factor de balance del nodo
	 * 
	 * @return Factor de balance de los nodos
	 */
	public int getBF() {
		return this.balanceFactor;
	}
	
	/**
	 * Metodo que actualiza el factor de balance y altura de los nodos
	 */
	public void updateHeight() {
		if (getLeft() == null) {
			if (getRight() == null) {
				this.balanceFactor = 0;
				this.height = 0;
			} else {
				this.balanceFactor = Math.max(NULL_NODE, getRight().height) - (NULL_NODE);
				this.height = right.getBFHeight() + 1;
			}
		} else {
			if (getRight() == null) {
				this.height = left.getBFHeight() + 1;
				this.balanceFactor = - 1 - Math.max(getLeft().height, NULL_NODE);
			} else {
				if (right.getBFHeight() > left.getBFHeight()) {
					this.balanceFactor = right.getBFHeight() - left.getBFHeight();
					this.height = right.getBFHeight() + 1;
				} else if(right.getBFHeight() == left.getBFHeight()) {
					this.balanceFactor = 0;
					this.height = right.getBFHeight() + 1;
				} else {
					this.balanceFactor = right.getBFHeight() - left.getBFHeight();
					this.height = left.getBFHeight() + 1;
				}
			}
		}
	}
	
	
	/**
	 * Metodo toString() del nodo que imprime la informacion del nodo con el formato:
	 * 
	 * Nodo:BF=Balance de factor
	 */
	public String toString() {
		return info.toString()+":BF="+getBF();
	}
	
}
