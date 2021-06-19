package TDAPila;

import Operaciones.OperacionesConPila;

public class TestPropio {
	public static void main(String[] args) {
		ArrayStack<Integer> pila1 = new ArrayStack<Integer>();
		int cantidad =10;
		//Testeando push y size
		
		for(int i=0;i<cantidad;i++) {
			if(pila1.size()!=i)
				System.out.println("error de tamaño");
			
			pila1.push(i);
			
			System.out.println("Ingresando: "+ i);
			
		}
		System.out.println(pila1);
		pila1.invertir();
		System.out.println(pila1);
		int[] arregloAInvertir = {1,2,3,4,5,6};
		for(int i= 0; i<arregloAInvertir.length;i++) {
			System.out.print(arregloAInvertir[i]+" ");
		}
		OperacionesConPila.invertirArreglo(arregloAInvertir);
		System.out.println();
		for(int i= 0; i<arregloAInvertir.length;i++) {
			System.out.print(arregloAInvertir[i]+" ");
		}
		System.out.println();
		OperacionesConPila.invertir(pila1);
		System.out.println(pila1);
		System.out.println("Aplanar");
		Stack<String> p1 = new ArrayStack<String>();
		Stack<String> p2 = new ArrayStack<String>();
		Stack<String> pn = new ArrayStack<String>();
		Stack<Stack<String>> ppe = new ArrayStack<Stack<String>>();
		p1.push("e1p1");
		p1.push("exp1");
		
		p2.push("e1p2");
		p2.push("eyp2");
		
		pn.push("e1pn");
		pn.push("ezpn");
		
		ppe.push(p1);
		ppe.push(p2);
		ppe.push(pn);
		System.out.println(ppe);
		System.out.println(OperacionesConPila.aplanar(ppe));
		
		
		
		
		
		
		/*
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
      */  
		
	}

	
}
