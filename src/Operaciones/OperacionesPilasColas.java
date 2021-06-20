package Operaciones;

import TDACola.EmptyQueueException;
import TDACola.LinkedQueue;
import TDACola.Queue;
import TDAPila.EmptyStackException;
import TDAPila.LinkedStack;
import TDAPila.Stack;
/**
 * 
 * @author Sergio Antozzi
 *
 */
public class OperacionesPilasColas {
	/**
	 * determina si q respeta el siguiente
	 * formato: AXA'A, donde A es una cadena de caracteres formada por 1 o m´as caracteres y A'
	 * corresponde al inverso de A
	 * @param q
	 * @param x
	 * @return
	 * O(n2) tengo que verificar luego
	 */
	public static boolean chequearFormato(Queue<Character> q, char x) {
		boolean vale=true;
		Stack<Character> pila = new LinkedStack<Character>();
		Queue<Character> cola = new LinkedQueue<Character>();
		//como no esta el caracter x interpreto que si la cola esta vacia entones el resultado es falso
		if(q.isEmpty())
			vale = false;
		else if(q.size()==1) {
			try {
				if(q.front()!=x)
					vale=false;
			} catch (EmptyQueueException e) {
				e.getMessage();
			}
		}else {
			while(!q.isEmpty()&&vale) {
				vale = carga(pila,cola,q,x);
				if(vale) {
					vale = comprueba(pila,cola,q,x);
				}
			}
		}


		return vale;
	}


	private static boolean carga(Stack<Character> pila, Queue<Character> cola, Queue<Character> q,char x) {
		boolean vale= false;
		boolean corte = false;
		try {
			char caracter = q.dequeue();
			while(caracter!=x&&!corte&&!q.isEmpty()) {
				pila.push(caracter);
				cola.enqueue(caracter);
				//si el primer caracter de q fuera x, no hay forma que se cumpla axa'a, por eso valido cuando entra a while
				vale= true;
				caracter = q.dequeue();
			}
		} catch (EmptyQueueException e) {
			e.getMessage();
		}
		return vale;
	}



	private static boolean comprueba(Stack<Character> pila, Queue<Character> cola, Queue<Character> q, char x) {
		boolean vale= true;
		while(!pila.isEmpty()&&vale&&!q.isEmpty()) {
			try {
				vale = pila.pop()==q.dequeue();

			} catch (EmptyStackException | EmptyQueueException e) {
				e.getMessage();
			}
		}
		if(vale) {
			while(!cola.isEmpty()&&vale&&!q.isEmpty()) {
				try {
					vale = q.dequeue()==cola.dequeue();
				} catch (EmptyQueueException e) {
					e.getMessage();
				}
			}
		}
		if(!pila.isEmpty()||!cola.isEmpty())
			vale=false;

		return vale;
	}

	/**
	 * Recibe dos colas de pilas de caracteres C1
	 * y C2, y retorne una nueva cola de pilas Cout que sea la unión de los elementos de C1 y C2
	 * @param <E>
	 * @param c1
	 * @param c2
	 * @return
	 */
	public static <E> Queue<Stack<E>> aplanar2(Queue<Stack<E>> c1, Queue<Stack<E>> c2){
		Queue<Stack<E>> colaPlana = new LinkedQueue<Stack<E>>();
		while(!c1.isEmpty()&&!c2.isEmpty()) {
			try {
				if(cantidad(c1.front())<=cantidad(c2.front())){
					colaPlana.enqueue(c1.dequeue());
				}else
					colaPlana.enqueue(c2.dequeue());
			} catch (EmptyQueueException e) {
				System.out.println(e.getMessage());
			}
		}

		while(!c1.isEmpty()) {
			try {
				colaPlana.enqueue(c1.dequeue());
			} catch (EmptyQueueException e) {
				System.out.println(e.getMessage());
			}
		}

		while(!c2.isEmpty()) {
			try {
				colaPlana.enqueue(c2.dequeue());
			} catch (EmptyQueueException e) {
				System.out.println(e.getMessage());
			}
		}


		return colaPlana;
	}

	private static <E> int cantidad(Stack<E> pila) {
		int cantidad = 0;
		Stack<E> aux = new LinkedStack<E>();
		while(!pila.isEmpty()) {
			try {
				aux.push(pila.pop());
				cantidad++;
			} catch (EmptyStackException e) {
				System.out.println(e.getMessage());
			}
		}
		while(!pila.isEmpty()) {
			try {
				pila.push(aux.pop());
			} catch (EmptyStackException e) {
				System.out.println(e.getMessage());
			}
		}
		return cantidad;
	}
	/**
	 *  Determina si cad respeta el formato A1 x A'1 x A2 x A'2 x ... x An x A'n donde:
	 *
	 *  -El metasímbolo Ai representa una cadena de la forma CzCC, con C perteneciente a
	 *   {a,b}*, es decir, si C = abb entonces, CzCC = abbzabbabb.
	 *   
	 *  -El metasímbolo A'i representa la cadena Ai invertida, es decir si Ai = bzbb entonces
	 *   A'i = bbzb.
	 * @param cad
	 * @return
	 */
	public static boolean chequearCadena(String cad) {
		/*
		 * La idea de este algoritmo es masar cad completo a una cola contenedor,
		 * luego a medida que se va recorriendo la misma se van agregando los caracteres a la pila , a
		 * cola 1 y cola2 hasta encontrar la z,
		 * en ese caso empieza la comprobacion, que consiste en comparar la pila contenedora con cola1 y luego con cola2,
		 * hasta encontrar la x compara la cola contenedor con la pila
		 * 
		 * */



		boolean aRetornar= true;
		boolean corte= false;
		boolean finCarga = false;
		Stack<Character> pila = new LinkedStack<Character>();
		Queue<Character> contenedor = new LinkedQueue<Character>();
		Queue<Character> cola1 = new LinkedQueue<Character>();
		Queue<Character> cola2 = new LinkedQueue<Character>();
		//minimo valido zxz
		if(cad.length()>=3) {

			agregoCadenaALaCola(cad,contenedor);
			while(!contenedor.isEmpty()&&aRetornar) {
				aRetornar = cargarColasyPila(pila,cola1,cola2,contenedor);
				if(aRetornar)
					aRetornar = compararColas(cola1,cola2,contenedor,pila);
				if(aRetornar)
					aRetornar = compararPila(pila,contenedor);
			}
		}else {
			aRetornar= false;
		}


		return aRetornar;
	}


	private static boolean compararPila(Stack<Character> pila, Queue<Character> contenedor) {
		char caracter='x';
		boolean aRetornar = true;
		if(!contenedor.isEmpty()) {
			try {
				caracter = contenedor.dequeue();
				if(caracter=='x') {
					while(!contenedor.isEmpty()&&aRetornar&&!pila.isEmpty()) {
			        	try {
							aRetornar = contenedor.dequeue() == pila.pop();
							
						} catch (EmptyQueueException e) {
							System.out.println(e.getMessage()+" en contenedor");
						}catch(EmptyStackException e) {
							System.out.println(e.getMessage()+" en pila");
						}
			        }
				}else {
					aRetornar = false;
				}
			} catch (EmptyQueueException e) {
				System.out.println(e.getMessage()+" verificando si esta la x");
			}
		}
		
		if(!pila.isEmpty())
			aRetornar=false;
		return aRetornar;
	}


	private static boolean compararColas(Queue<Character> cola1, Queue<Character> cola2, Queue<Character> contenedor,Stack<Character> pila) {
        boolean aRetornar = true;
		while(!cola1.isEmpty()&&aRetornar&&!contenedor.isEmpty()) {
        	try {
        		char caracter = contenedor.dequeue();
				aRetornar = caracter == cola1.dequeue();
				pila.push(caracter);
			} catch (EmptyQueueException e) {
				System.out.println(e.getMessage()+" en cola1 o contenedor");
			}
        }
		
		if(aRetornar) {
			while(!cola2.isEmpty()&&aRetornar&&!contenedor.isEmpty()) {
	        	try {
	        		char caracter = contenedor.dequeue();
					aRetornar = caracter == cola2.dequeue();
					pila.push(caracter);
				} catch (EmptyQueueException e) {
					System.out.println(e.getMessage()+" en cola2 o contenedor");
				}
	        }
		}
		if(!cola1.isEmpty()||!cola2.isEmpty())
			aRetornar=false;
			
		return aRetornar;
	}


	private static boolean cargarColasyPila(Stack<Character> pila, Queue<Character> cola1, Queue<Character> cola2,
			Queue<Character> contenedor) {

		boolean aRetornar=true;
		boolean corte = false;
		boolean estaZ=false;

		try {
         //este if es para cuando hay dos cadenas concatenadas con una x de por medio
         if(contenedor.front()=='x')
        	 contenedor.dequeue();
         
			while(!contenedor.isEmpty()&&!corte&&!estaZ) {

				char caracter = contenedor.dequeue();

				pila.push(caracter);
				if(caracter!='z') {
					cola1.enqueue(caracter);
					cola2.enqueue(caracter);
				}else
					estaZ=true;

				if(caracter =='x') {
					corte=true;
				}
			}	

		} catch (EmptyQueueException e) {
			System.out.println(e.getMessage());
		} 
		if(corte&&!estaZ) {
			aRetornar=false;
		}
		return aRetornar;

	}


	private static void agregoCadenaALaCola(String cad,Queue<Character> cola) {
		for(int i=0;i<cad.length();i++) {
			cola.enqueue(cad.charAt(i));
		}

	}


}
