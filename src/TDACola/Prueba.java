package TDACola;

import Operaciones.OperacionesPilasColas;

/**
 * 
 * @author Sergio Antozzi
 *
 */
public class Prueba {

	public static void main(String[] args) {
		LinkedQueue<Integer> cola = new LinkedQueue<Integer>();
		cola.enqueue(1);
		cola.enqueue(2);
		cola.enqueue(3);
		cola.enqueue(4);
		cola.enqueue(5);
		
		System.out.println(cola);
		cola.invertir();
		System.out.println(cola);

		Queue<Character> colaCar = new LinkedQueue<Character>();
	    String cadena = "ab$baab";
		for(int i=0;i<cadena.length();i++) {
			colaCar.enqueue(cadena.charAt(i));
		}
		System.out.println("Chequear formato "+cadena+" $ :"+OperacionesPilasColas.chequearFormato(colaCar, '$'));
		cadena = "aaabzaaabaaabxbaaabaaazbaaaxabzababxbabazba";
		System.out.println("Chequear cadena "+cadena+" : "+ OperacionesPilasColas.chequearCadena(cadena));
		
	}
	

}
