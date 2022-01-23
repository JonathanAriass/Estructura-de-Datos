/**
 * Clase de algoritmos implementados de forma recursiva e iterativa
 * 
 * @author Jonathan Arias Busto (UO283586)
 *
 */
public class Algoritmos {

	/**
	 * Metodo factorial que calcula el factorial de un numero de forma recursiva
	 * 
	 * @param n Numero del cual se calcula el factorial
	 * @return Se devuelve un numero de tipo double siendo el resultado este
	 */
	public static double factorialRecursivo(double n) {
//		doNothing();
		if (n == 0) {
			return 1;
		}
		return n*factorialRecursivo(n-1);
	}
	
	/**
	 * Metodo factorial que calcula el factorial de un numero de forma iterativa
	 * 
	 * @param n Numero del cual se calcula el factorial
	 * @return Se devuelve un numero de tipo double siendo el resultado este
	 */
	public static double factorialIterativo(double n) {
		if (n == 0) {
			return 1;
		}
		double res = 1;
		while (n != 0) {
			res = res * n;
			n--;
		}
		return res;
	}
	
	
	/**
	 * Metodo que calcula la potencia en base dos de n exponente de forma recursiva
	 * 
	 * Version 0
	 * 
	 * @param n Exponente de la operacion a hacer
	 * @return Devuelve el resultado de elevar a 2, n veces
	 */
	public static double potenciaRecursiva_v0(int n) {
		if (n == 0) {
			return 1;
		}
		return potenciaRecursiva_v0(n-1)*2;
	}
	
	/**
	 * Metodo que calcula la potencia en base dos de n exponente de forma recursiva
	 * 
	 * Version 1
	 * 
	 * @param n Exponente de la operacion a hacer
	 * @return Devuelve el resultado de elevar a 2, n veces
	 */
	public static double potenciaRecursiva_v1(int n) {
		if (n == 0) {
			return 1;
		}
		return (potenciaRecursiva_v1(n-1) + potenciaRecursiva_v1(n-1));
	}
	
	/**
	 * Metodo que calcula la potencia en base dos de n exponente de forma recursiva
	 * 
	 * Version 2
	 * 
	 * @param n Exponente de la operacion a hacer
	 * @return Devuelve el resultado de elevar a 2, n veces
	 */
	public static double potenciaRecursiva_v2(int n) {
		if (n == 0) {
			return 1;
		}
		if (n % 2 == 0) {
			return (potenciaRecursiva_v2(n/2) * potenciaRecursiva_v2(n/2));
		} else {
			return (potenciaRecursiva_v2(n/2) * potenciaRecursiva_v2(n/2)*2);
		}
	}
	
	/**
	 * Metodo que calcula la potencia en base dos de n exponente de forma recursiva
	 * 
	 * Version 3
	 * 
	 * @param n Exponente de la operacion a hacer
	 * @return Devuelve el resultado de elevar a 2, n veces
	 */
	public static double potenciaRecursiva_v3(int n) {
		if (n == 0) {
			return 1;
		}
		long result = (long)potenciaRecursiva_v3(n/2);
		if (n % 2 == 0) {
			return (result*result);
		} else {
			return (result*result*2);
		}
	}
	
	/**
	 * Metodo que calcula la potencia en base dos de n exponente de forma recursiva e incluye el
	 * metodo doNothing() para calcular el tiempo de ejecucion del mismo
	 * 
	 * Version 0
	 * 
	 * @param n Exponente de la operacion a hacer
	 * @return Devuelve el resultado de elevar a 2, n veces
	 */
	public static int potenciaRecursiva_v0doNothing(int n) {
		doNothing();
		if (n == 0) {
			return 1;
		}
		return potenciaRecursiva_v0doNothing(n-1)*2;
	}
	
	/**
	 * Metodo que calcula la potencia en base dos de n exponente de forma recursiva e incluye el metodo
	 * doNothing() para calcular el tiempo de ejecucion del mismo
	 * 
	 * Version 1
	 * 
	 * @param n Exponente de la operacion a hacer
	 * @return Devuelve el resultado de elevar a 2, n veces
	 */
	public static int potenciaRecursiva_v1doNothing(int n) {
		doNothing();
		if (n == 0) {
			return 1;
		}
		return (potenciaRecursiva_v1doNothing(n-1) + potenciaRecursiva_v1doNothing(n-1));
	}
	
	/**
	 * Metodo que calcula la potencia en base dos de n exponente de forma recursiva e incluye 
	 * el metodo doNothing() para calcular el tiempo de ejecucion del mismo
	 * 
	 * Version 2
	 * 
	 * @param n Exponente de la operacion a hacer
	 * @return Devuelve el resultado de elevar a 2, n veces
	 */
	public static int potenciaRecursiva_v2doNothing(int n) {
		doNothing();
		if (n == 0) {
			return 1;
		}
		if (n % 2 == 0) {
			return (potenciaRecursiva_v2doNothing(n/2) * potenciaRecursiva_v2doNothing(n/2));
		} else {
			return (potenciaRecursiva_v2doNothing(n/2) * potenciaRecursiva_v2doNothing(n/2)*2);
		}
	}
	
	/**
	 * Metodo que calcula la potencia en base dos de n exponente de forma recursiva e incluye el
	 * metodo doNothing() para calcular el tiempo de ejecucion del mismo
	 * 
	 * Version 3
	 * 
	 * @param n Exponente de la operacion a hacer
	 * @return Devuelve el resultado de elevar a 2, n veces
	 */
	public static int potenciaRecursiva_v3doNothing(int n) {
		doNothing();
		if (n == 0) {
			return 1;
		}
		int result = potenciaRecursiva_v3doNothing(n/2);
		if (n % 2 == 0) {
			return (result*result);
		} else {
			return (result*result*2);
		}
	}
	
	
	
	/**
	 * Metodo que calcula la potencia en base dos de n exponente de forma iterativa
	 * 
	 * @param n Exponente de la operacion a hacer
	 * @return Devuelve el resultado de elevar a 2, n veces
	 */
	public static double potenciaIterativa(double n) {
		if (n == 0) {
			return 1;
		}
		double res = 1;
		for (double i=n;i>0;i--) {
			res = res * 2;
		}
		return res;
	}
	
	
	
	/**
	 * Metodo que calcula el numero n de la serie de fibonacci de forma recursiva
	 * 
	 * @param n Numero de la serie de fibonacci a calcular
	 * @return Numero n de la serie de fibonacci
	 */
	public static double fibonacciRecursivo(double n) {
		if (n <= 0) {
			return 0;
		}
		else if (n == 1) {
			return 1;
		}
		return fibonacciRecursivo(n-1) + fibonacciRecursivo(n-2);
	}
	
	/**
	 * Metodo que calcula el numero n de la serie de fibonacci de forma iterativa
	 * 
	 * @param n Numero de la serie de fibonacci a calcular
	 * @return Numero n de la serie de fibonacci
	 */
	public static double fibonacciIterativo(double n) {
		if (n <= 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		double res = 0;
		double primero = 0;
		double segundo = 1;
		for (int i=2;i<=n;i++) {
			res = primero + segundo;
			primero = segundo;
			segundo = res;		
		}
		return res;
	}
	
	
	
	/**
	 * Metodo que para el hilo principal de ejecucion 250 ms para poder hacer calculo
	 * de tiempos en diferentes algoritmos
	 */
	private static void doNothing() {
		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * Metodo que representa un algoritmo de complejidad lineal O(n)
	 * 
	 * @param n Carga del metodo
	 */
	public static void linealDoNothing(int n) {
		for (int i=0;i<n;i++) {
			doNothing();
		}
	}
	
	/**
	 * Metodo que representa un algoritmo de complejidad cuadratica O(n^2)
	 * 
	 * @param n Carga del metodo
	 */
	public static void cuadraticaDoNothing(int n) {
		for (int i=0;i<n;i++) {
			for (int j=0; j<n;j++) {
				doNothing();				
			}
		}
	}
	
	/**
	 * Metodo que representa un algoritmo de complejidad cubica O(n^3)
	 * 
	 * @param n Carga del metodo
	 */
	public static void cubicaDoNothing(int n) {
		for (int i=0;i<n;i++) {
			for (int j=0;j<n;j++) {
				for (int k=0;k<n;k++) {
					doNothing();
				}
			}
		}
	}

	/**
	 * Metodo que representa un algoritmo de complejidad logaritmica O(log2 n)
	 * 
	 * @param n Carga del metodo
	 */
	public static void logaritmicaDoNothing(int n) {
		int i = n;
		while (i > 0) {
			doNothing();
			i = i/2;
		}
	}
	
}
