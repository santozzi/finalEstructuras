package Operaciones;


import TDAPila.ArrayStack;
import TDAPila.Stack;
import TDAPila.EmptyStackException;
/**
 * 
 * @author Sergio Antozzi
 *
 */
public class OperacionesConPila {
	/**
	 * Permite invertir el contenido del arreglo (a) 
	 * Ejercicio 5 a) del práctico 3
	 * T(n)invertirArreglo = 2n  = O(n)
	 * @param a arreglo de enteros a invertir
	 */
	public static void invertirArreglo(int [] a) {
		Stack<Integer> pilaDeEnteros = new ArrayStack<Integer>();
		for(int i = 0;i<a.length;i++) {
			
			pilaDeEnteros.push(a[i]);
			
		}
		for(int i = 0;i<a.length;i++) {
			try {
			   a[i]=pilaDeEnteros.pop();
			}catch(EmptyStackException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	/**
	 * Invierte el contendo de una pila (p)
	 * T(n)invertir = 3n= O(n)
	 * @param <E>
	 * @param p
	 */
	public static <E> void invertir(Stack<E> p) {
		Stack<E> pila1 = new ArrayStack<E>();
		Stack<E> pila2 = new ArrayStack<E>();
		while(!p.isEmpty()){
			try {
				pila1.push(p.pop());
			} catch (EmptyStackException e) {
				System.out.println(e.getMessage());
			}
		}
		while(!pila1.isEmpty()){
			try {
				pila2.push(pila1.pop());
			} catch (EmptyStackException e) {
				System.out.println(e.getMessage());
			}
		}
		while(!pila2.isEmpty()){
			try {
				p.push(pila2.pop());
			} catch (EmptyStackException e) {
				System.out.println(e.getMessage());
			}
		}
		
	}
	/**
	 * Sea ppe =<< ep 11;...; ep x1 >; < ep 12;... ; ep y2 >;... ; < ep 1n; . . . ; ep zn >> una pila que contiene las pilas p1; . . . ; pn
	 * (siendo pn la pila en el tope de ppe), y a su vez, considere que cada una de estas pilas contienen los elementos 
	 * e1; . . . ; ex, e1; . . . ; ey, e1; . . . ; ez (siendo ex; ey y ez los topes de cada una de las pilas) respectivamente.
     * Luego, pe =< ep 11; . . . ; ep x1; ep 12; . . . ; ep y2; . . . ; ep 1n; . . . ; ep zn >, siendo ep zn el tope de pe.
	 * @param <E>
	 * @param ppe
	 * @return pe
	 * T(n)aplanar = n2 + n = O(n2)
	 */
	public static <E> Stack<E> aplanar(Stack<Stack<E>> ppe){
		Stack<E> pe = new ArrayStack<E>();
		while(!ppe.isEmpty()){
			try {
				Stack<E> aux =ppe.pop();
				while(!aux.isEmpty()) {
					pe.push(aux.pop());
				}
				
			} catch (EmptyStackException e) {
				System.out.println(e.getMessage());
			}
		}
		invertir(pe);
		return  pe;
	} 
}
