package grafo;

import static org.junit.Assert.*;



import org.junit.Test;



public class GrafoTest {
	
	private Grafo grafoEjemplo(){
		Grafo g = new Grafo(5);
		g.agregarArista(0, 1, 1);
		g.agregarArista(1, 2, 2);
		g.agregarArista(2, 3, 3);
		g.agregarArista(3, 0, 4);
		return g;
	}
	
	@Test
	public void cantVerticesTest() {
		Grafo grafo =grafoEjemplo();
		assertEquals(5,grafo.GetVertices() );
	}
	
	@Test
	public void cantVecinosDeTest() {
		Grafo grafo =grafoEjemplo();
		assertEquals(2,grafo.vecinos(3).size() );
		assertEquals(0, grafo.vecinos(4).size());
	}
	
	@Test
	public void agregarAristaTest() 
	{
		Grafo g = new Grafo(5); // Setup
		g.agregarArista(0, 2, 1); // Exercise
		assertTrue(g.existeArista(0, 2)); // Verify
		assertTrue(g.existeVecino(0, 2));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void agregarAristaExistenteTest() {
		Grafo grafo = new Grafo(4);
		grafo.agregarArista(1, 2, 0);
		grafo.agregarArista(1, 2, 0);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void AristaExistenteOpuestaTest() {
		Grafo grafo = new Grafo(4);
		grafo.agregarArista(1, 2, 0);
		grafo.agregarArista(2, 1, 0);
		
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void agregarAristaVerticeIgual()
	{
		Grafo g = new Grafo(5);
		g.agregarArista(0, 0, 1);
	}

	@Test (expected=IllegalArgumentException.class)
	public void agregarAristaFueraDeRangoSuperior()
	{
		Grafo g = new Grafo(5);
		g.agregarArista(5, 0, 1);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void agregarAristaFueraDeRangoInferior()
	{
		Grafo g = new Grafo(5);
		g.agregarArista(-1, 0, 1);
	}
	
	@Test
	public void agregarVecinoSimetriaTest() 
	{
		Grafo g = new Grafo(5); // Setup
		g.agregarArista(2, 1, 1); // Exercise
		assertTrue(g.existeVecino(1, 2)); // Verify
	}
	
	@Test
	public void eliminarAristaTest() 
	{
		Grafo g = new Grafo(5);
		g.agregarArista(2, 1, 1);
		g.eliminarArista(2, 1);
		assertFalse(g.existeArista(2, 1));
		assertFalse(g.existeVecino(2, 1));
	}

	@Test
	public void eliminarAristaInexistenteTest() {
		Grafo grafo = new Grafo(4);
		
		grafo.eliminarArista(2, 1);
		assertFalse(grafo.existeArista(2, 1));
	}
	
	@Test
	public void gradoTest()
	{
		Grafo g = grafoEjemplo();
		assertEquals(2, g.grado(1));
	}

	@Test
	public void gradoCeroTest()
	{
		Grafo g = grafoEjemplo();
		assertEquals(0, g.grado(4));
	}
	
	


}
