package TDACola;

public class ArrayQueue<E> implements Queue<E> {
    protected final int LONGITUD= 10;
	protected E[] contenedor;
	protected int ini;
	protected int fin;
	
	@SuppressWarnings("unchecked")
	public ArrayQueue() {
		contenedor = (E[]) new Object[LONGITUD];
		ini = 0;
		fin = 0;
	}
	
	@Override
	public int size() {
		return (contenedor.length-ini+fin)%contenedor.length;
	}

	@Override
	public boolean isEmpty() {
		return size()==0;
	}

	@Override
	public E front() throws EmptyQueueException {
		if(isEmpty()) {
			throw new EmptyQueueException("La cola esta vacia: front");
		}
		return contenedor[ini];
	}

	@Override
	public void enqueue(E element) {
		//contenedor.lenght -1 ya que si pej, contenedor tiene tamaño 10, despues de
		//agregar el ultimo elemento en contenedor[9], f = (9+1)%10 que es 0 => ini =fin ergo size()=0;
		if(size()==contenedor.length-1) {
			resize();
		}
		contenedor[fin]= element;
		fin = (fin+1)%contenedor.length;
		
		
	}

	private void resize() {
		@SuppressWarnings("unchecked")
		E[] nuevoContenedor = (E[])new Object[size()*2];
		for(int i = 0;i<contenedor.length;i++) {
           nuevoContenedor[i]= contenedor[(ini+i)%contenedor.length];			
		}
		//importante que primero se modifique fin, ya que size() depende de ini, y si lo modifico antes de fin, es un error
		fin= size();
		ini = 0;
		contenedor = nuevoContenedor;
	}

	@Override
	public E dequeue() throws EmptyQueueException {
		if(isEmpty()) {
			throw new EmptyQueueException("La cola esta vacia: dequeue");
		}
		E aRetornar = contenedor[ini];
		contenedor[ini]=null;
		ini = (ini+1)%contenedor.length;
		return aRetornar;
	}

}
