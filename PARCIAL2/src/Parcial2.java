
public class Parcial2 {

	class Nodo 
	{
		Nodo izquierda, derecha;
		int informacion;
	}

	int cantidad, altura;
	Nodo raiz;

	/**** PUNTO 1: INSERTAR ARBOL BINARIO ORDENADO *****/

	public void insertar(int informacion) 
	{
		Nodo nuevo;
		nuevo = new Nodo();

		nuevo.informacion = informacion;
		nuevo.izquierda = null;
		nuevo.derecha = null;

		if (raiz == null) 
		{
			raiz = nuevo;
			System.out.println(nuevo.informacion + "   <<< Nodo RAIZ del arbol \n");
		} else {
			
			Nodo anterior = null;
			Nodo recorrido = raiz;
			
			while (recorrido != null) 
			{
				anterior = recorrido;
				if (informacion < recorrido.informacion)
					recorrido = recorrido.izquierda;
				else
					recorrido = recorrido.derecha;

			}
			
			if (informacion < anterior.informacion) 
			{
				anterior.izquierda = nuevo;
				System.out.println(nuevo.informacion + " <= Por IZQUIERDA del Nodo => " + anterior.informacion);
			} else {
				anterior.derecha = nuevo;
				System.out.println(nuevo.informacion + " <= Por DERECHA del Nodo => " + anterior.informacion);
			}
		}
	}

	/**** PUNTO 2: MOSTRAR EL MAYOR Y EL MENOR VALOR DEL SUBARBOL IZQUIERDO ****/

	public void mayorValor() 
	{
		if (raiz.izquierda != null) 
		{
			Nodo recorrido = raiz.izquierda;
			while (recorrido.derecha != null)
				recorrido = recorrido.derecha;
			System.out.println("\n=> MAYOR valor del Subarbol izquierdo: " + recorrido.informacion);
		} else {
			System.out.println(">>> El Subarbol izquierdo esta vacio <<<");

		}
	}

	public void menorValor() 
	{
		if (raiz.izquierda != null) 
		{
			Nodo recorrido = raiz.izquierda;
			
			while (recorrido.izquierda != null)
				recorrido = recorrido.izquierda;
			
			System.out.println("\n=> MENOR valor del Subarbol izquierdo: " + recorrido.informacion);
		} else {
			System.out.println(">>> El Subarbol izquierdo esta vacio <<<");

		}
	}

	/**** PUNTO 3: IMPLEMETAR EL METODO PRIMEROS TRES NIVELES ****/

	public boolean existePrimerosTresNiveles(int informacion) 
	{
		Nodo recorrido = raiz;
		int nivel = 0;
		while (recorrido != null && nivel < 3) 
		{
			if (informacion == recorrido.informacion)
				return true;
			
			else if (informacion > recorrido.informacion)
				recorrido = recorrido.derecha;
			else
				recorrido = recorrido.izquierda;
			nivel++;
			
		}
		return false;
	}

	/****
	 * PUNTO 4: MOSTRAR LA CANTIDAD DE NODOS HOJA QUE TIENE EL SUBARBOL IZQUIERDO
	 ****/

	private void cantidadNodosHoja(Nodo reco) {

		if (reco != null) 
		{
			if (reco.izquierda == null && reco.derecha == null)
				cantidad++;
			
			cantidadNodosHoja(reco.izquierda);
			cantidadNodosHoja(reco.derecha);
		}
	}

	public int cantidadNodosHoja() 
	{
		cantidad = 0;
		cantidadNodosHoja(raiz.izquierda);
		return cantidad;
	}

	/**** PUNTO 5: BORRAR EL MAYOR VALOR DEL SUBARBOL IZQUIERDO ****/

	public void borrarMayorValorIzq() 
	{
		if (raiz.izquierda != null) 
		{
			Nodo recorrido = raiz.izquierda;
			Nodo atras = raiz;
			
			while (recorrido.derecha != null) 
			{
				atras = recorrido;
				recorrido = recorrido.derecha;
			}
			atras.derecha = recorrido.izquierda;
		} else {
			System.out.println("=> El Subarbol izquierdo esta vacio <=");
		}
	}

	/**** IMPRIMIR ****/
	
	private void imprimir(Nodo recorrido) 
	{
		if (recorrido != null) 
		{
			System.out.print(recorrido.informacion + " ");
			imprimir(recorrido.izquierda);
			imprimir(recorrido.derecha);
		}
		
		imprimir(raiz);
		System.out.println();
	}

	public static void main(String[] args) 
	{
		Parcial2 arb = new Parcial2();
		System.out.println("****  VALORES DEL ARBOL  **** \n");
		arb.insertar(10); // La raiz
		arb.insertar(7);
		arb.insertar(9);
		arb.insertar(20);
		arb.insertar(15);
		arb.mayorValor();
		arb.menorValor();
		
		System.out.println("\n=> Cantidad Nodos Hoja del Subarbol izquierdo: " + arb.cantidadNodosHoja() );
		System.out.println("\n=> Borrando Nodo Mayor del Subarbol izquierdo ");
		
		arb.borrarMayorValorIzq();

		if (arb.existePrimerosTresNiveles(20))
			System.out.println("\n=> Existe Valor: 20 ");
		else
			System.out.println("\n=> No Existe Valor: 20 ");

	}

}
