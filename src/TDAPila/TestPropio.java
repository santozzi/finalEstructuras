package TDAPila;

public class TestPropio {

	public static void main(String[] args) {
		Stack<Integer> pila1 = new ArrayStack<Integer>();
		int cantidad =100;
		//Testeando push y size
		
		for(int i=0;i<cantidad;i++) {
			if(pila1.size()!=i)
				System.out.println("error de tamaño");
			
			pila1.push(i);
			
			System.out.println("Ingresando: "+ i);
			
		}
		if(pila1.size()==cantidad-1) {
			System.out.println("size y push OK");
		}
		//top y pop
		for(int i=0;i<cantidad;i++) {
			try {
			System.out.println("Mirantdo y borrando: "+pila1.top());
			System.out.println(pila1.pop()+" Borrado");
			
			}catch(EmptyStackException e ) {
			   System.out.println(e.getMessage());
			}
			
			
			}
		if(pila1.isEmpty()) {
			System.out.println("La pila esta vacia OK");
		}
        
	}

}
