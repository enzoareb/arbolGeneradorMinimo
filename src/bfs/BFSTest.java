package bfs;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

import grafo.Grafo;

public class BFSTest {
	
	private Grafo inicializarEjemplo() 
	{
		Grafo g = new Grafo(5);
		g.agregarArista(0, 1, 1);
		g.agregarArista(0, 2, 2);
		g.agregarArista(2, 3, 3);
		return g;
	}

	@Test (expected=IllegalArgumentException.class)
	public void grafoNullTest() 
	{
		BFS.esConexo(null);
	}
	
	@Test
	public void grafoNoConexoTest()
	{
		Grafo g = inicializarEjemplo();
		assertFalse(BFS.esConexo(g));
	}
	
	@Test
	public void grafoVacioTest()
	{
		Grafo g = new Grafo(0);
		assertTrue(BFS.esConexo(g));
	}
	
	@Test
	public void grafoConexoTest()
	{
		Grafo g = inicializarEjemplo();
		g.agregarArista(3, 4, 1);
		assertTrue(BFS.esConexo(g));
	}
	
	@Test
	public void alcanzablesTest()
	{
		Grafo g = inicializarEjemplo();
		Set<Integer> alcanzables = BFS.alcanzables(g, 0);
		
		int[] esperado = {0, 1, 2, 3};
		Assert.iguales(esperado, alcanzables);
	}
	
	@Test
	public void alcanzablesTodosTest()
	{
		Grafo g = inicializarEjemplo();
		g.agregarArista(3, 4, 1);
		
		Set<Integer> alcanzables = BFS.alcanzables(g, 0);
		
		int[] esperado = {0, 1, 2, 3, 4};
		Assert.iguales(esperado, alcanzables);
	}
	
	@Test
	public void alcanzablesNingunoTest()
	{
		Grafo g = inicializarEjemplo();
		
		Set<Integer> alcanzables = BFS.alcanzables(g, 4);
		
		int[] esperado = {4};
		Assert.iguales(esperado, alcanzables);
	}

}
