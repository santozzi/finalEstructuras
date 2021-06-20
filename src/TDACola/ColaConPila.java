package TDACola;

import Operaciones.OperacionesConPila;
import TDAPila.EmptyStackException;
import TDAPila.LinkedStack;
import TDAPila.Stack;

public class ColaConPila<E> implements Queue<E> {
    protected Stack<E> pilaContenedora;
    public ColaConPila() {
    	pilaContenedora = new LinkedStack<E>();
    }
	@Override
	public int size() {
		return pilaContenedora.size();
	}

	@Override
	public boolean isEmpty() {
		return pilaContenedora.isEmpty();
	}

	@Override
	public E front() throws EmptyQueueException {
		if(isEmpty()) {
			throw new EmptyQueueException("Cola vacia: front");
		}
		E aRetornar = null;
		try {
			aRetornar=pilaContenedora.top();
		} catch (EmptyStackException e) {
			System.out.println(e.getMessage());
		}
		return aRetornar;
	}

	@Override
	public void enqueue(E element) {
		if(isEmpty()) {
			pilaContenedora.push(element);
		}else {
			OperacionesConPila.invertir(pilaContenedora);
			pilaContenedora.push(element);
			OperacionesConPila.invertir(pilaContenedora);
		}

	}

	@Override
	public E dequeue() throws EmptyQueueException {
		if(isEmpty()) {
			throw new EmptyQueueException("Cola vacia: dequeue");
		}
		E aRetornar = null;
		try {
			aRetornar = pilaContenedora.pop();
		} catch (EmptyStackException e) {
			System.out.println(e.getMessage());
		}
		return aRetornar;
	}

}
