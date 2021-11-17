package grafo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Grafo {

	private ArrayList<Set<Integer>> vecinos;
	private ArrayList<Arista> aristas;
	private static int []A;
	private int cantVertices; 
	
	public Grafo(int vertices) {
		
		// se crea un array de aristas vacio al comienzo
		aristas = new ArrayList<Arista>();

		// se crea el arreglo de componentes conexas
		A = new int[vertices];

		vecinos = new ArrayList<Set<Integer>>(vertices);

		for (int i = 0; i < vertices; i++) {
			// al comienzo cada vertice no tiene vecinos
			vecinos.add(new HashSet<Integer>());

			// al comienzo cada vertice pertenece a su propia componente conexa
			A[i] = i;
		}

		cantVertices = vertices;
	}
	
	
	//---------------------------------METODOS DE ARISTAS---------------------------------------//
	
	
	public void agregarArista(int i, int j, float peso)// agrego el peso de la arista al parametro
	{	
		//chequeo que la arista no exista
		if (existeArista(i, j) || existeArista(j, i)) {
			throw new IllegalArgumentException("se intento ingresar una arista ya existente");
		}
		/*----------------SE AGREGA A LA LISTA DE ARISTAS-----------------*/
		// se agrega la arista nueva a la array de aristas
		Arista aristaNueva = new Arista(i, j, peso); // creo una arista

		// buscas la posicion donde la arista corresponde de acuerdo a su peso
		int indice = buscarIndice(aristaNueva.getPeso());

		///////////////////////CHEQUEAR////////////////////////////
		// la agregas en la posicion donde corresponde de acuerdo a su peso
		if (indice == -1)
			aristas.add(aristaNueva);
		else
			aristas.add(indice, aristaNueva);

		/*-----------------LO AGREGO A LA LISTA DE VECINOS----------------*/
		verificarArista(i, j, "agregar");
		
		vecinos.get(i).add(j);
		vecinos.get(j).add(i);
	}
	
	public void eliminarArista(int i, int j) {
		
		/*----------------SE ELIMINA A LA LISTA DE ARISTAS-----------------*/
		Arista aristaAux = new Arista(i, j, 0);// creo un arco auxiliar donde no me importa el peso

		// recorro la array hasta hallar la arista
		for (int k = 0; k < aristas.size(); k++) {
			if (aristaAux.getInicial() == aristas.get(k).getInicial()
					&& aristaAux.getTerminal() == aristas.get(k).getTerminal())

				// si tienen el mismo i j entonces lo elimino del array
				aristas.remove(aristas.get(k));
		}

		/*-----------------LO ELIMINO A LA LISTA DE VECINOS----------------*/
		verificarArista(i, j, "eliminar");
		vecinos.get(i).remove(j);
		vecinos.get(j).remove(i);

	}
	
	private void verificarArista(int i, int j, String tipo) 
	{	
		//chequeo que no se bucle
		if (i == j)
			throw new IllegalArgumentException("Se intento "+tipo+" una arista con i=j : "+i +"/"  + j);
		
			
		verificarVertice(i, tipo);
		verificarVertice(j, tipo);

	}
	
	public boolean existeArista (int i, int j){
		Arista aristaAux = new Arista(i, j, 0);// creo un arco auxiliar donde no me importa el peso
		// recorro la array hasta hallar la arista
		for (int k = 0; k < aristas.size(); k++) {
			if (aristaAux.getInicial() == aristas.get(k).getInicial()
					&& aristaAux.getTerminal() == aristas.get(k).getTerminal())
					return true;
		}
		return false; 
	}
	
	
	private int buscarIndice(float peso) {
		for(int indice = 0; indice < aristas.size(); indice++) {
			if(peso < aristas.get(indice).getPeso())
				return indice;
		}
		//en el caso de que sea el de mayor peso retorna -1
		return -1;
	}

	//---------------------------------METODOS DE VERTICES---------------------------------------//
	
	public Set<Integer> vecinos(int i)
	{
		verificarVertice(i, " un vertice ");
		
		return vecinos.get(i);
	}

	public int grado (int i)
	{ 
		return vecinos.get(i).size();
	}

	private void verificarVertice(int i, String tipo) 
	{	
		//chequear que el vertice no este fuera de rango
		if (i < 0 || i >= cantVertices)
			throw new IllegalArgumentException("Se intento usar "+tipo+" con valores, fuera de rango: "+ i);
	}
	
	public boolean existeVecino (int i, int j){
		return vecinos.get(i).contains(j) && vecinos.get(j).contains(i);
	}
	//--------------------------------------GETTERS Y SETTERS---------------------------------------//
	public int GetVertices()
	{
		return cantVertices;
	}
	
	public ArrayList<Arista> GetAristas(){
		return aristas;
	}
	
	public int[] GetA(){
		return A;
	}
	
}
