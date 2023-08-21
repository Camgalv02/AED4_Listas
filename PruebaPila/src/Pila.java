public class Pila {
	
	class Nodo // esta clase nodo va a contener:
	{
		int info; //esta variable contiene la informacion
		//una variable de tipo entera llamada info
		Nodo sig; // y esta contiene un puntero al siguiente dato 
		// y una variable de tipo nodo llamada sig(siguiente)
		
		//las variables de tipo nodo estan formadas por la información que guaarda, y 
		//por el espacio que guarda la dirección al siguente nodo
	}

	private Nodo raiz; //este nodo va a estar vivo desde que se ejecuta el programa, 
						//hasta que se finaliza

	Pila() 
	{
		raiz = null;
	}

	public void insertar(int x) 
	{
		Nodo nuevo; // creamos una variable de tipo nodo que va a contener la informacion que se 
		nuevo = new Nodo(); //inserte en la lista
		/*tambien se puede declarar como [Nodo nuevo= new Nodo();]  */
		nuevo.info = x;// aca le decimos que a la propiedad que guarda la informacion en mi nodo 
						//le asigne el valor de x
		if (raiz == null) //preguntamos si raiz es nulo
		{ //si se cumple
			nuevo.sig = null; 
			raiz = nuevo;
		} 
		else 
		{ //si no se cumple queda como está
			nuevo.sig = raiz;
			raiz = nuevo;
		}
	}

	public int extraer() 
	{
		
		if (raiz != null) 
		{
			int informacion = raiz.info;
			raiz = raiz.sig;
			return informacion;
		}
		else 
		{
			return Integer.MAX_VALUE;
		}
	}

	public int retornar ()
 
	{
		if (raiz!=null)
		{
			int informacion = raiz.info;
			return informacion;
		}
		else
		{
			return Integer.MAX_VALUE;
		}
	}

	public void imprimir() 
	{//creamos un elemento de tipo nodo que va a apuntar a raiz
		//reco de recorriendo
		Nodo reco=raiz;
		System.out.println("Listado de todos los elementos de la pila: ");
		//imprimimos un titulo
		
		while (reco!=null) //mientras que el puntero no se caiga de la lista
		{
			System.out.print(reco.info+" - ");
			reco=reco.sig;
		}
			System.out.println();
	}

	public static void main(String[] ar) 
	{
		Pila pila1=new Pila();
		pila1.insertar(10);
		pila1.insertar(40);
		pila1.insertar(3);
		pila1.imprimir();
		System.out.println("Extraemos de la pila:"+pila1.extraer());
		pila1.imprimir();
		System.out.println("Retornamos primero de la pila:"+pila1.retornar());
		pila1.imprimir();
	}
}
