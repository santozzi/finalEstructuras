package TDACola;

public class Node<E> {
     protected Node<E> siguiente;
     protected E element;
	public Node( E element,Node<E> siguiente) {
		this.siguiente = siguiente;
		this.element = element;
	}
	public Node(E element) {
		this(element,null);
	}
	public Node<E> getSiguiente() {
		return siguiente;
	}
	public void setSiguiente(Node<E> siguiente) {
		this.siguiente = siguiente;
	}
	public E getElement() {
		return element;
	}
	public void setElement(E element) {
		this.element = element;
	}
     

}
