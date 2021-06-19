package TDAPila;

public class LinkedStack<E> implements Stack<E> {
    protected int size;
    protected Node<E> head;
 
    
    public LinkedStack() {
    	size= 0;
        head=null;
   
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
			throw new EmptyStackException("La pila esta vacia: top()");
		}
		
		return head.element;
	}

	@Override
	public void push(E element) {
		head = new Node<E>(element,head);
	    size++;
			
		
	}

	@Override
	public E pop() throws EmptyStackException {
		if(isEmpty()) {
			throw new EmptyStackException("La pila esta vacia: pop()");
		}
		E element = head.element;
		Node<E> aux = head;
		head = head.getSiguiente();
		aux.setSiguiente(null);
		size--;
		return element;
	}

}
