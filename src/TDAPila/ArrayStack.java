package TDAPila;
/**
 * 
 * @author Sergio Antozzi
 *
 * @param <E>
 */
public class ArrayStack<E> implements Stack<E> {
    protected static final int 	LONGITUD=10;	
	protected E[] contenedor;
	protected int size;
	
	@SuppressWarnings("unchecked")
	public ArrayStack() {
		contenedor = (E[]) new Object[LONGITUD];
	    size = 0;
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size==0;
	}

	@Override
	public E top() throws EmptyStackException {
	  if(isEmpty()) {
		  throw new EmptyStackException("La Pila est� Vacia: top");
	  }	
		return contenedor[size-1];
	}

	@Override
	public void push(E element) {
		if(size==contenedor.length) {
			rezise();
		}
		contenedor[size++]=element;

	}

	private void rezise() {
		@SuppressWarnings("unchecked")
		E[] contenedorMasGrande = (E[])new Object[size*2]; 
		for(int i=0; i<size;i++) {
			contenedorMasGrande[i]= contenedor[i]; 
		}
		contenedor = contenedorMasGrande;
		
	}

	@Override
	public E pop() throws EmptyStackException {
		if(isEmpty()) {
			throw new EmptyStackException("La pila esta vacia: pop");
		}
		E element = contenedor[size-1];
		contenedor[size-1]=null;
		size--;
		return element;
	}
	/**
	 * Punto 4 del pr�ctico 3
	 * ----------------------
	 * T(n) invertir() = n/2 = O(n)
	*/
	public void invertir() {
		for(int i = 0; i<size/2;i++) {
			E aux= contenedor[size-1-i];
			contenedor[size-1-i]= contenedor[i];
			contenedor[i]= aux;
		}
	}
	
	public String toString() {
		String aRetornar = "";
		for(int i=size-1;i>=0;i--) {
			aRetornar +=contenedor[i]+" ";
		}
		return aRetornar;
	}

}
