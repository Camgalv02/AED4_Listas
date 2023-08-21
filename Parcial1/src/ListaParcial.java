
public class ListaParcial 
{

	class Nodo 
	{
		int info;
		Nodo anterior, siguiente;
	}

	private Nodo raiz;

	public ListaParcial () 
	{
		raiz=null;
	}

	public int cantidad() 
	{
		int cantidad = 0;
		Nodo recorrido = raiz;
		while (recorrido != null) 
		{
			recorrido = recorrido.siguiente;
			cantidad++;
		}
		return cantidad;
	}

	// consigna1: crear método insertar

	public void insertarNodo(int valor1, int valor2) 
	{
		Nodo new1 = new Nodo();
		new1.info = valor1;
		Nodo new2 = new Nodo();
		new2.info = valor2;

		new1.anterior = null;
		new1.siguiente = new2;

		new2.anterior = new1;
		new2.siguiente = null;

		if (raiz == null) 
		{
			raiz = new1;
			new1.anterior = raiz;

		}
		else 
		{
			if (cantidad() == 4) 
			{
				Nodo recorrido = raiz;
				while (recorrido.siguiente != null) {
					recorrido = recorrido.siguiente;
				}
				recorrido.siguiente = new1;
				new1.anterior = recorrido;
			}
			else 
			{
				new2.siguiente = raiz;
				raiz.anterior = new2;
				new1.anterior = raiz;
				raiz = new1;
			}
		}
	}

	
	// consigna2: sumar nodos impares
	public void sumarNodosImpares()

	{
		Nodo recorrido = raiz;
		int suma = 0;
		while (recorrido != null) 
		{
			suma = suma + recorrido.info;
			recorrido = recorrido.siguiente.siguiente;
		}
		System.out.println(suma);
	}

	// consigna3: borrar el primer nodo y el último
	public void borrarNodo(int pos) 
	{
		if (pos <= cantidad()) 
		{
			if (pos == 1) 
			{
				raiz = raiz.siguiente;
				if (raiz != null)
					raiz.anterior = null;
			} 
			else 
			{
				Nodo recorrido;
				recorrido = raiz;
				
				for (int f = 1; f <= pos - 2; f++) {
					recorrido = recorrido.siguiente;
				}
				Nodo proximo = recorrido.siguiente;
				proximo = proximo.siguiente;
				recorrido.siguiente = proximo;
				if (proximo != null)
					proximo.anterior = recorrido;
			}

			if (raiz != null) 
			{
				if (raiz.siguiente == null) 
				{
					raiz = null;
				}
				else 
				{
					Nodo recorrido = raiz;
					while (recorrido.siguiente != null) 
					{
						recorrido = recorrido.siguiente;
					}
					recorrido = recorrido.anterior;
					recorrido.siguiente = null;
				}
			}

		}
	}
	
	// consigna4: intercambiar el primer y ultimo nodo
	public void intercambiarNodos(int posicion1, int posicion5) 
	{
		if (posicion1 <= cantidad() && posicion5 <= cantidad())
		{
			Nodo recorrido1 = raiz;
			
			for (int f = 2; f < posicion1; f++)
				recorrido1 = recorrido1.siguiente;
			
			Nodo recorrido2 = raiz;
			
			for (int f = 1; f < posicion5; f++)
				recorrido2 = recorrido2.siguiente;
			
			int varAuxiliar = recorrido1.info;
			recorrido1.info = recorrido2.info;
			recorrido2.info = varAuxiliar;
		}
	}

	//consigna5: borrar elementos que coincidan con el primer nodo
	public void borrarCoincidencias() 
	{
		int auxiliar= raiz.info;
		Nodo recorrido = raiz.siguiente;
		Nodo recorridoAnterior = raiz;
		
		do 
		{
			if (recorrido.info == auxiliar) 
			{
				recorrido = recorrido.siguiente;
				recorridoAnterior.siguiente = recorrido;
				recorrido.anterior = recorridoAnterior;
			} 
			else 
			{
				recorridoAnterior = recorridoAnterior.siguiente;
				recorrido = recorrido.siguiente;
			}
			
		}
		while (recorrido.siguiente != null);
	}

	// imprimir lista
	public void imprimir() 
	{
		Nodo recorrido = raiz;
		while (recorrido != null) 
		{
			System.out.print(recorrido.info + "-");
			recorrido = recorrido.siguiente;
		}
		System.out.println();
	}

	
	public static void main(String[] ar) 
	{
		ListaParcial lp = new ListaParcial();
		

		System.out.println("Consigna 1: Insertando Nodos...");
		lp.insertarNodo(10, 20);
		lp.insertarNodo(5, 8);
		lp.insertarNodo(200, 4);
		lp.insertarNodo(1, 2);
		lp.imprimir();
		
		System.out.println();
		
		System.out.println("Consigna 2: Sumando los Nodos Impares...");
		
		lp.sumarNodosImpares();
		
		System.out.println();
		
		System.out.println("Consigna 3: Borrando el Primer Nodo y el Ultimo Nodo de la Lista...");
		lp.borrarNodo(1);
		lp.imprimir();
		
		System.out.println();
		
		System.out.println("Consigna 4: Intercambiando el Primer Nodo con el Ultimo Nodo de la Lista...");
		lp.intercambiarNodos(1, 6);
		lp.imprimir();
		
		System.out.println();
		
		System.out.println("Consigna 5: Borrando Todos los Nodos que Coincidan con el Primer Nodo de la Lista...");
		lp.borrarCoincidencias();
		lp.imprimir();
		

		
	}

}
