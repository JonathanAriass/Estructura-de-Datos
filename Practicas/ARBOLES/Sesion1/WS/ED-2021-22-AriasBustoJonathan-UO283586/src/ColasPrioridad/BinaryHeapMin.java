package ColasPrioridad;

/**
 * Clase que representa la cola de prioridad
 * 
 * @author Jonathan Arias Busto (UO283586)
 *
 * @param <T>
 */
public class BinaryHeapMin<T extends Comparable<T>> implements PriorityQueue<T> {

	private T[] monticulo; // Vector de elementos de un determinado tamaño
	private int numElementos; // Numero de elementos insertados en el vector
	
	/**
	 * Constructor de la cola de prioridad que recibe como parametro el tamaño de esta
	 * 
	 * @param n Numero de elementos de la cola
	 */
	@SuppressWarnings("unchecked")
	public BinaryHeapMin(int n) {
		this.numElementos = 0;
		this.monticulo = (T[]) new Comparable[n]; // hay que inicializarlo comparable
	}
	
	/**
	 * Metodo que añade un elemento a la cola y que en caso de ser necesario realiza un filtrado ascendente
	 * 
	 * @return <p>-2: si el elemento es null</p><p>-1: en caso de que no haya mas espacio en la cola</p><p>0: si se añade correctamente</p>
	 */
	@Override
	public int add(T elemento) {
		if (elemento == null) return -2;
		if (monticulo.length == numElementos) return -1;
		addAux(elemento);
		return 0;
	}

	/**
	 * Metodo auxiliar que lleva a cabo el añadir un elemento a la cola
	 * 
	 * @param elemento Elemento a añadir
	 */
	private void addAux(T elemento) {
		if (numElementos == 0) {
			monticulo[0] = elemento; 
			numElementos++;
		} else {
			monticulo[numElementos] = elemento;
			numElementos++;
			filtradoAscendente(numElementos-1);
		}
	}

	/**
	 * Metodo que realiza un filtrado ascendente. El filtrado ascendente consiste en actualizar la cola para 
	 * que todos los elementos esten en orden, siendo esto que los numeros mas pequeños esten siempre mas arriba.
	 * 
	 * @param pos Posicion para la que se tiene que hacer el filtrado
	 */
	private void filtradoAscendente(int pos) {
		int posAux = pos; // posicion del nodo a filtrar
		int posPadre = (posAux-1)/2; // posicion padre
		T padre =  monticulo[(posAux-1)/2]; // padre
		while (monticulo[posAux].compareTo(padre) < 0) {
			T hijo = monticulo[posAux]; // hijo
			monticulo[posAux] = padre; // se cambia el hijo por el padre
			monticulo[posPadre] = hijo; // se cambia el padre por el hijo
			posAux = posPadre; // se actualiza la posicion del nodo a filtrar
			if ((posPadre-1)/2 >= 0) {
				posPadre = (posPadre-1)/2; // se actualiza la posicion del padre
				padre = monticulo[posPadre]; // se actualiza el padre
			}
		}
	}
	
	/**
	 * Se extrae y devuelve el elemento 0 de la cola. Despues de extraer este elemento se añade el ultimo elemento de la cola en 
	 * la posicion 0 y se realiza un filtrado descendente de la posicion 0.
	 * 
	 * @return Elemento de la posicion 0 de la cola
	 */
	@Override
	public T poll() {
		if (numElementos == 0) return null;
		
		return sacarAux();
	}

	/**
	 * Metodo que realiza la accion de sacar el elemento como tal.
	 * 
	 * @return Elemento de la posicion 0 de la cola
	 */
	private T sacarAux() {
		if (numElementos == 1) {
			T aux = monticulo[0];
			monticulo[0] = null;
			numElementos--;
			return aux;
		}
		T aux = monticulo[0];
		monticulo[0] = monticulo[numElementos-1];
		monticulo[numElementos-1] = null;
		numElementos--;
		filtradoDescendente(0);
		return aux;
	}

	/**
	 * Metodo que realiza un filtrado descendiente desde una posicion pasada como parametro
	 * 
	 * (Es un metodo muy robusto por lo que en mi caso prefiero que sean muchas lineas de codigo pero asi aseguro que no haya ninguna fuga
	 * de posiciones a la hora de realizar operaciones con los elementos de la cola).
	 * 
	 * @param pos Posicion desde la que se quiere realizar el filtrado descendiente
	 */
	private void filtradoDescendente(int pos) {
		int posAux = pos; // posicion del nodo a filtrar
		T padre = monticulo[posAux]; // padre
		int posHijo1 = 0;
		int posHijo2 = 0;
		T hijo1 = null;
		T hijo2 = null;
		if (posAux*2+1 < numElementos) {
			posHijo1 = posAux*2+1; // posicion hijoIzquierdo
			hijo1 =  monticulo[posHijo1]; // hijo izquierdo
		}
		if (posAux*2+2 < numElementos) {
			posHijo2 = posAux*2+2; // posicion hijoDerecho				
			hijo2 =  monticulo[posHijo2]; // hijo derecho
		}
		if (hijo1!=null && hijo2==null) {
			if (padre.compareTo(hijo1) > 0) {
				monticulo[posAux] = hijo1; // se cambia el padre por el hijo izquierdo
				monticulo[posHijo1] = padre; // se cambia el hijo izquierdo por el padre
			}
		} else if (hijo1 == null && hijo2 != null) {
			if (padre.compareTo(hijo2) > 0) {
				monticulo[posAux] = hijo2; // se cambia el padre por el hijo derecho
				monticulo[posHijo2] = padre; // se cambia el hijo derecho por el padre
			}
		} else if (hijo1 == null && hijo2 == null) return; // en caso de que no haya mas hijos se acaba la accion
		else {
			while (padre.compareTo(hijo1) > 0 || padre.compareTo(hijo2) > 0) {
				
				if (hijo1.compareTo(hijo2) < 0) {
					monticulo[posAux] = hijo1; // se cambia el padre por el hijo izquierdo
					monticulo[posHijo1] = padre; // se cambia el hijo izquierdo por el padre
					posAux = posHijo1; // se cambia la posicion del padre (nueva posicion: posicion hijo izquierdo)
				} else {
					monticulo[posAux] = hijo2; // se cambia el padre por el hijo derecho
					monticulo[posHijo2] = padre; // se cambia el hijo derecho por el padre
					posAux = posHijo2; // se cambia la posicion del padre (nueva posicion: posicion hijo derecho)
				}
				// en caso de que el padre siga teniendo hijos se actualizan estas posiciones
				if (posAux*2+1 < numElementos && monticulo[posAux*2+1] != null) {
					posHijo1 = posAux*2+1; // posicion hijoIzquierdo
					hijo1 =  monticulo[posHijo1]; // hijo izquierdo
				}
				if (posAux*2+2 < numElementos && monticulo[posAux*2+2] != null) {
					posHijo2 = posAux*2+2; // posicion hijoDerecho				
					hijo2 =  monticulo[posHijo2]; // hijo derecho
				}
				if (posAux*2+1 >= numElementos && posAux*2+2 >= numElementos) {
					break; // en caso de que ya no se puede hacer mas se sale del bucle y se acaba el filtrado
				} else {
					if (monticulo[posAux*2+1] == null && monticulo[posAux*2+2] == null) break;
				}
			}
		}
	}
	
	/**
	 * Metodo que elimina un elemento de la cola
	 * 
	 * @return <p>-2: si el elemento es null o no hay elementos en la cola</p><p>-1: en caso de que no este el elemento en la cola</p><p>0: si se elimina correctamente</p>
	 */
	@Override
	public int remove(T elemento) {
		if (numElementos == 0 || elemento == null) return -2;
		if (!isElementoInMonticulo(elemento)) return -1;
		removeAux(elemento);
		return 0;
	}

	/**
	 * Metodo auxiliar que se encarga de eliminar un elemento de la cola
	 * 
	 * @param elemento Elemento a eliminar de la cola
	 */
	private void removeAux(T elemento) {
		if (numElementos == 1) {monticulo[0] = null; numElementos--;}
		else {
			int aux = searchElemento(elemento);
			if (aux != -1) {
				monticulo[aux] = monticulo[numElementos-1];
				monticulo[numElementos-1] = null;
				numElementos--;
				filtradoDescendente(aux);
			}
		}
	}
	
	/**
	 * Metodo auxiliar que sirve para obtener el indice de un elemento concreto
	 * 
	 * @param elemento Elemento a obtener el indice
	 * @return El indice del elemento
	 */
	private int searchElemento(T elemento) {
		for (int i=0;i<numElementos;i++) {
			if (elemento.equals(monticulo[i])) return i;
		}
		return -1;
	}

	/**
	 * Metodo que determina si hay un elemento en la cola
	 * 
	 * @param elemento Elemento a buscar
	 * @return <p>true: si existe el elemento en la cola</p><p>false: si no existe dicho elemento en la cola</p>
	 */
	private boolean isElementoInMonticulo(T elemento) {
		for (int i=0;i<numElementos;i++) {
			if (elemento.equals(monticulo[i])) return true;
		}
		return false;
	}

	/**
	 * Metodo que comprueba si la cola esta vacia
	 * 
	 * @return <p>true: si la cola esta vacia</p><p>false: si la cola no esta vacia</p>
	 */
	@Override
	public boolean isEmpty() {
		return monticulo.length == 0 ? true : false;
	}

	/**
	 * Metodo que limpia la cola al completo (asignar null a todos las posiciones de la lista)
	 */
	@Override
	public void clear() {
		for (int i=0;i<numElementos;i++) {
			monticulo[i] = null;
		}
	}

	/**
	 * Metodo que cambia la prioridad de una posicion de la cola.
	 * 
	 * @param pos Posicion de la cual cambiar la prioridad
	 * @param elemento Nueva prioridad a incluir en dicha posicion
	 * @return <p>-2: si el elemento es null o la posicion es invalida</p><p>-1: en caso de que no haya elementos en la cola</p><p>0: si se cambia correctamente</p>
	 */
	@Override
	public int cambiarPrioridad(int pos, T elemento) {
		if (elemento == null || pos < 0 || pos > numElementos) return -2;
		if (numElementos == 0) return -1;
		cambiarPrioridadAux(pos, elemento);
		return 0;
	}

	/**
	 * Metodo auxiliar que se encarga de cambiar la prioridad en caso de que se pueda
	 * 
	 * @param pos Posicion de la cual cambiar la prioridad
	 * @param elemento Nueva prioridad a incluir por la anterior
	 */
	private void cambiarPrioridadAux(int pos, T elemento) {
		T aux = monticulo[pos];
		monticulo[pos] = elemento;
		if (elemento.compareTo(aux) < 0) {
			filtradoAscendente(pos);
		} else {
			filtradoDescendente(pos);
		}
	}

	/**
	 * Metodo que devuelve una cadena con la informacion de la cola
	 * 
	 * @return Cadena con toda la informacion de la cola
	 */
	@Override
	public String toString() {
		String aux = "";
		if (numElementos > 0) {
			for (int i=0;i<numElementos;i++) {
				aux = aux + monticulo[i] + "\t";					
			}
			return aux.substring(0,aux.length()-1);
		} else {
			return aux;			
		}
	}

}
