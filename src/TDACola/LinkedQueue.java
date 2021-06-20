package TDACola;

public class LinkedQueue<E> implements Queue<E> {
    protected Node<E> head;
    protected Node<E> tail;
    protected int size;
    
    public LinkedQueue() {
    	head=null;
    	tail=null;
    	size=0;
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
	public E front() throws EmptyQueueException {
		if(isEmpty()) {
			throw new EmptyQueueException("La cola esta vacia: front");
		}
		return head.element;
	}

	@Override
	public void enqueue(E element) {
		if(isEmpty()) {
			head = new Node<E>(element);
			tail=head;
		}else {
			tail.setSiguiente(new Node<E>(element));
		    tail = tail.getSiguiente();
		}
		size++;
	}

	@Override
	public E dequeue() throws EmptyQueueException {
		if(isEmpty()) {
			throw new EmptyQueueException("La cola esta vacia: dequeue");
		}
		E aRetornar = head.element;
		if(size==1) {
			head= null;
			tail=head;
			
		}else {
		Node<E> aux = head;
		head = head.getSiguiente();
		aux.setSiguiente(null);
		}
		size--;
		return aRetornar;
	}
	public void	invertir() {
		if(size>1) {
			invertirRecu(head);
		}
	}
	private void invertirRecu(Node<E> aux) {
		if(aux==tail) {
			head=aux;
		}else {
			invertirRecu(aux.getSiguiente());
			tail.setSiguiente(aux);
			tail= aux;
			aux.setSiguiente(null);
		}
		
	}
	public String toString() {
		String aRetornar = "";
		Node<E> actual = head;
		
		while(actual!=null) {
			aRetornar += actual.element+" ";
			actual = actual.getSiguiente();
		}
		
		
		return aRetornar;
	}

}
