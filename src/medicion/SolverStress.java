package medicion;

import java.util.ArrayList;
import java.util.Random;

import bfs.BFS;
import grafo.Grafo;
import kruskal.Kruskal;

public class SolverStress {
	public static void main(String[] args)
	{
		
		TestStressKruskalBFS(100, 300, 20);
		System.out.println();
		System.out.println();
		//TestStressKruskalUnionFind(100, 300, 200);
		System.out.println();
		System.out.println();
		TestStressKruskalBFS2(1000, 1500, 50);
	}
	
	//--------------------------------------GENERACION NUMERO ALEATORIO------------------------------------//
	public static void TestStressKruskalUnionFind(int vertices, int aristas, int tamaño) {
		ArrayList<Grafo> grafosPrueba = llenarDeGrafosAleatorios(vertices,aristas , tamaño);
		
		long inicio = System.currentTimeMillis();
		
		for (int i = 0; i < grafosPrueba.size(); i++) {
			Solver solver = new Solver(grafosPrueba.get(i));
			solver.resolverKruskalUnionFind();
			System.out.println("Tiempo Parcial(Grafo n�): "+ i +" tiempo:" + Solver.darTiempo());
		}
		
		long total = System.currentTimeMillis() - inicio;
		System.out.println("Tiempo total:" + total);
	
	}
	public static void TestStressKruskalBFS(int vertices, int aristas, int tamaño) {
		ArrayList<Grafo> grafosPrueba = llenarDeGrafosAleatorios(vertices,aristas , tamaño);
		
		long inicio = System.currentTimeMillis();
		
		for (int i = 0; i < grafosPrueba.size(); i++) {
			Solver solver = new Solver(grafosPrueba.get(i));
			solver.resolverKruskalBFS();
			System.out.println("Tiempo Parcial(Grafo n�): "+ i +" tiempo:" + Solver.darTiempo());
		}
		
		long total = System.currentTimeMillis() - inicio;
		System.out.println("Tiempo total:" + total);
	
	}
	
	public static void TestStressKruskalBFS2(int vertices, int aristas, int tamaño) {
		ArrayList<Grafo> grafosPrueba = llenarDeGrafosAleatorios(vertices,aristas , tamaño);
		
		long inicio = System.currentTimeMillis();
		
		for (int i = 0; i < grafosPrueba.size(); i++) {

			long inicio2 = System.currentTimeMillis();
			Kruskal.KruskalBFS(grafosPrueba.get(i));
			long total2 = System.currentTimeMillis() - inicio2;
			System.out.println("Tiempo Parcial(Grafo n�): "+ i +" tiempo:" + total2);
		}
		
		long total = System.currentTimeMillis() - inicio;
		System.out.println("Tiempo total:" + total);
	
	}
	//--------------------------------------GENERACION NUMERO ALEATORIO------------------------------------//
	public static float getRandom(int n) {
		float scale = (float) Math.pow(10, 1);
        float pesoAleatorio = Math.round(((float)Math.random()*n+1)*scale)/scale;
        
        return pesoAleatorio;
    }

	//--------------------------------------GENERACION GRAFO ALEATORIO------------------------------------//
		public static Grafo aleatorio(int n) {
			
			Random random = new Random(0);
			Grafo grafo = new Grafo(n);
			for (int i = 0; i < n; i++)
				
				for (int j = i + 1; j < n; j++)
					//agrega aristas aleatoriamente
					if( random.nextFloat() < 0.6 ) {
						 
						//el peso de la arista es random tambien
						grafo.agregarArista(i, j, getRandom(n));
					}
			return grafo;
		}
		
		
	//--------------------------------------GENERACION GRAFO ALEATORIO 2------------------------------------//
		
		public static Grafo aleatorio2(int n, int m) {
			
			if(n == 1)
				throw new IllegalArgumentException("No se pueden agregar aristas a un grafo de un �nico v�rtice.");
			
			if(m < n-1)
				throw new IllegalArgumentException("No es posible crear un grafo conexo.");
			
			if(m > cantMaxAristas(n))
				throw new IllegalArgumentException("No puede haber m�s de " + cantMaxAristas(n) + " aristas." );
				
			Grafo grafo = new Grafo(n);
			
			int i = 0;
			while(m > i) {
				int n1 = (int)(Math.random()*n);
				int n2 = (int)(Math.random()*n);
				
				if( (n1 != n2) && !grafo.existeArista(n1, n2)) {
					grafo.agregarArista(n1, n2, getRandom(n));
					i = i + 1;
				}
			}
			if(BFS.esConexo(grafo))
				return grafo;
			
			return aleatorio2(n, m);
			
		}


	private static int cantMaxAristas(int n) {
		  return factorial(n)/(factorial(2)*(factorial((n-2))));
	}
	
	private static int factorial(int n) {
	    int fact=1;
	    for (int i = 1; i < n; i++) {
	        fact *= i;
	    }
	    return fact;
	}
	
	private static ArrayList<Grafo> llenarDeGrafosAleatorios(int vertices, int aristas, int tamaño){
		ArrayList<Grafo>listaGrafosAleatorios = new ArrayList<Grafo>(tamaño);
		
		for (int i = 0; i < tamaño; i++) {
			
			listaGrafosAleatorios.add(aleatorio2(vertices, aristas));
			
		}
		return listaGrafosAleatorios;
	}
	
	//--------------------------------------RESOLVER ALOGORITMOS------------------------------------//
	
}
