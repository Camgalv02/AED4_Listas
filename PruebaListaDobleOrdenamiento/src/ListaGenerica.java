public class ListaGenerica 
{

	class Nodo 
	{
		int info;
		Nodo ante, sig;
	}

	private Nodo raiz;

	ListaGenerica() 
	{
		raiz = null;
	}

	public void insertarPrincipio(int valor) 
	{
		Nodo nuevo = new Nodo();
		nuevo.info = valor;
		nuevo.ante = nuevo.sig = null;
		if (raiz == null) 
		{
			nuevo.sig = raiz;
			raiz = nuevo;
		} 
		else 
		{
			nuevo.sig = raiz;
			raiz.ante = nuevo;
			raiz = nuevo;
		}
	}

	public void insertarFinal(int valor) 
	{
		Nodo nuevo = new Nodo();
		nuevo.info = valor;
		nuevo.ante = nuevo.sig = null;
		if (raiz == null) 
		{
			raiz = nuevo;
		} 
		else 
		{
			Nodo reco = raiz;
			while (reco.sig != null) 
			{
				reco = reco.sig;
			}

			reco.sig = nuevo;
			nuevo.ante = reco;
		}
	}

	public void imprimirLista() 
	{
		Nodo reco = raiz;
		while (reco != null) 
		{
			System.out.print(reco.info + "-");
			reco = reco.sig;
		}
		System.out.println();
	}

	public int contarNodos() 
	{
		int cant = 0;
		Nodo reco = raiz;
		while (reco != null) 
		{
			cant++;
			reco = reco.sig;
		}
		return cant;
	}

	public void borrarNodo(int posi) 
	{
		if (posi <= contarNodos()) 
		{
			System.out.println("Borrando nodo posicion " + posi);
			if (posi == 1)  // borra el 1� nodo
			{
				Nodo x = raiz.sig;
				x.ante = null;
				raiz = x;
			} else {
				if (posi == contarNodos()) // borra el ultimo nodo
				{ 
					Nodo reco = raiz;
					while (reco.sig != null) 
					{
						reco = reco.sig;
					}
					Nodo x = reco.ante;
					x.sig = null;
				} 
				else // borra el nodo de la posicion indicada
				{ 
					Nodo reco = raiz;
					Nodo x = null;
					int contador = 1;
					while (contador < posi) 
					{
						contador++;
						x = reco;
						reco = reco.sig;
					}
					x.sig = reco.sig;
					reco.sig.ante = x;
				}
			}
			
		} 
		else 
		{
			System.out.println("No existe la posicion indicada..." + posi);
		}
	}

	public static void main(String[] args) 
	{
		ListaGenerica l = new ListaGenerica();
		System.out.println("INSERTAR AL PRINCIPIO");
		l.insertarPrincipio(1);
		l.insertarPrincipio(2);
		l.insertarPrincipio(3);
		System.out.print("Imprimir.... ");
		l.imprimirLista();
		System.out.println("Contador de nodos: " + l.contarNodos());
		System.out.println("INSERTAR AL FINAL");
		l.insertarFinal(4);
		l.insertarFinal(5);
		l.insertarFinal(6);
		System.out.print("Imprimir.... ");
		l.imprimirLista();
		System.out.println("Contador de nodos: " + l.contarNodos());
		System.out.println("--- BORRANDO NODOS ---");
		l.borrarNodo(8);
		l.borrarNodo(3);
		System.out.print("Imprimir.... ");
		l.imprimirLista();
		System.out.println("Contador de nodos: " + l.contarNodos());
		l.borrarNodo(1);
		System.out.print("Imprimir.... ");
		l.imprimirLista();
		System.out.println("Contador de nodos: " + l.contarNodos());
		l.borrarNodo(4);
		System.out.print("Imprimir.... ");
		l.imprimirLista();
	}
}