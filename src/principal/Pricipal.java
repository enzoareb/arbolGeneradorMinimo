package grafo;
import kruskal.Kruskal;
import medicion.SolverStress;


public class Main {

	public static void main(String[] args)
	{
		

		
/*
 * ALBOL GENERADOR MINIMO
 *               8        6
 *          1---------2-------3
 *        4/         3| \      \9
 *        /           |  \      \
 *       0            8   \4     4
 * 						   \
 *                          \
 *           7-------6-------5
 *               1       3
 * 		
 */

		
		Grafo grafo = new Grafo(9);
		grafo.agregarArista(0, 1, 4); // AB 4
		grafo.agregarArista(1, 2, 8); // BC 8
		grafo.agregarArista(2, 3, 6); // CD 6
		grafo.agregarArista(3, 4, 9); // DE 9
		grafo.agregarArista(4, 5, 10); // EF 10
		grafo.agregarArista(5, 6, 3); // FG 3
		grafo.agregarArista(6, 7, 1); // GH 1
		grafo.agregarArista(7, 8, 6); // HI 6
		grafo.agregarArista(7, 0, 8); // HA 8
		grafo.agregarArista(6, 8, 5); // GI 5
		grafo.agregarArista(8, 2, 3); // IC 3
		grafo.agregarArista(1, 7, 12); // BH 12
		grafo.agregarArista(2, 5, 4); // CF 4
		grafo.agregarArista(3, 5, 13); // DF 13
		
		
		System.out.println("Cantidad vertices: "+ grafo.GetVertices());
		System.out.println("Cantidad aristas: "+ grafo.GetAristas().size());
		System.out.println("Aristas:");
		System.out.println(grafo.GetAristas());
		System.out.println();
		
		System.out.println("KruskalBFS:");
		System.out.println("Cantidad vertices: "+ Kruskal.KruskalBFS(grafo).GetVertices());
		System.out.println("Cantidad aristas: "+ Kruskal.KruskalBFS(grafo).GetAristas().size());
		System.out.println(Kruskal.KruskalBFS(grafo).GetAristas());
		System.out.println();
	
		System.out.println("KruskalUnionFind:");
		System.out.println("Cantidad vertices: "+ Kruskal.KruskalUnionFind(grafo).GetVertices());
		System.out.println("Cantidad aristas: "+ Kruskal.KruskalUnionFind(grafo).GetAristas().size());
		System.out.println(Kruskal.KruskalUnionFind(grafo).GetAristas());
		System.out.println();
		
		System.out.println("-----GrafoAleatorio-----");
		
		Grafo grafoAleatorio = SolverStress.aleatorio2(5, 10);
		System.out.println("-----GrafoAleatorio SIN KRUSKAL-----");
		System.out.println("Cantidad vertices: "+ grafoAleatorio.GetVertices());
		System.out.println("Cantidad aristas: "+ grafoAleatorio.GetAristas().size());
		System.out.println("Aristas:");
		System.out.println(grafoAleatorio.GetAristas());
		System.out.println();
		
		System.out.println("-----GrafoAleatorio CON KRUSKAL-----");
		System.out.println("KruskalUnionFind:");
		System.out.println("Cantidad vertices: "+ Kruskal.KruskalUnionFind(grafoAleatorio).GetVertices());
		System.out.println("Cantidad aristas: "+ Kruskal.KruskalUnionFind(grafoAleatorio).GetAristas().size());
		System.out.println(Kruskal.KruskalUnionFind(grafoAleatorio).GetAristas());
		System.out.println();
		
		System.out.println("KruskalBFS:");
		System.out.println("Cantidad vertices: "+ Kruskal.KruskalBFS(grafoAleatorio).GetVertices());
		System.out.println("Cantidad aristas: "+ Kruskal.KruskalBFS(grafoAleatorio).GetAristas().size());
		System.out.println(Kruskal.KruskalBFS(grafoAleatorio).GetAristas());
		System.out.println();
		
		

	}

}

