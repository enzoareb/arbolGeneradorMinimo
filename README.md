# arbolGeneradorMinimo
Programa destinado a la generacion de arboles generadores minimos por medio de diferentes algoritmos siendo estos : Prim , Kruskal y Union-Find. Con el fin de evaluar el tiempo de ejecucion de cada uno

#Descripción del trabajo

El trabajo práctico consiste en desarrollar una aplicación orientado a medir la diferencia en los tiempos de ejecución del Algoritmo de Kruskal para el problema de árbol generador mínimo con y sin el uso de la estructura de datos Union-Find.

#Diseño

Estructura de la aplicación
La estructura de la aplicación está conformada por diferentes paquetes que separan las funcionalidades de la misma. De esta manera podemos encontrar un paquete BFS donde se haya la clase que se encarga del recorrido del grafo determinando si el mismo es conexo; un paquete Grafo donde se hayan las clases que se encargan de la estructuración del mismo; un paquete Kruskal donde se encuentra la clase donde se implementa el algoritmo; un paquete Union_Find donde se encuentra la clase que implementa los métodos de root, union y find; un paquete Medición donde se encuentran las clases encargadas de medir el tiempo de los algoritmos y la creación aleatoria de los grafos, y un paquete  Principal donde se encuentra la clase que ejecuta la aplicación y así medir los tiempos de los algoritmos implementados.
Adicionalmente, por cada clase implementada se crea su correspondiente Test Suite para testear los métodos implementados.
Explicación de las clases
La aplicación consta de 15 clases en diferentes paquetes acorde a su funcionalidad y responsabilidad,

#Paquete BFS
Clase BFS: Se implementa el algoritmo BFS (Breath-First-Search) para el recorrido de los grafos desde un vértice inicial de manera ascendente obteniendo los vértices alcanzables desde el mismo y permite determinar si un grafo es conexo.
Clase Assert: Contiene el método iguales para la suite de test del algoritmo BFS.
Clase BFSTest: Contienen el suite de test de la clase BFS.

#Paquete Grafo
Clase Arista: Se encarga de crear una arista que tiene asociado un vértice inicial, final y un peso asociado a la misma.
Clase Grafo: Se encarga inicializar un grafo de n cantidad de vértices sin ninguna arista asociada. Para la representación del mismo se utiliza una lista de vecinos asociadas con cada vértice. Esta clase permite también poder agregar y quitar aristas dentro del grafo.
Clase GrafoTest: Contienen el suite de test de la clase Grafo.

#Paquete Kruskal
Clase Kruskal: Dentro de esta clase se implementa el algoritmo de Kruskal para hallar arboles generadores minimos tanto con Union-Find como BFS.
Clase KruskalTest: Contienen el suite de test de la clase Kruskal.

#Paquete Prim
Clase Prim: Dentro de esta clase se implementa el algoritmo de Prim para hayar arboles generadores minimos.
Clase PrimTest: Contienen el suite de test de la clase Prim.

#Paquete Union-Find
Clase Union-Find: Dentro de esta clase se encuentran los métodos de raíz, find (para saber si dos vértices se encuentran dentro de la misma componente conexa) y el método unión que se encarga de unir dos raíces haciendo que uno apunte a la raíz del otro.
Clase Union-FindTest: Contienen el suite de test de la clase Kruskal.

#Paquete Medición
Clase Aleatorio: Dentro de esta clase se emplea dos algoritmos para la creación aleatoria de grafos de manera aleatoria. En el primer método se agregan aristas de manera aleatoria.
Clase AleatorioTest: Contienen el suite de test de la clase Aleatorio.
Clase Tiempo: Esta clase contiene los métodos para medir el tiempo en la implementación de los dos algoritmos de Kruskal, con BFS y con Union -Find utilizando el método System.currentTimeMillis() que devuelve el tiempo en milisegundos.
Clase TiempoStress: Esta clase se encarga de implementar los grafos de manera aleatoria y a la vez hallar el árbol generador mínimo de cada grafo creado mediante los algoritmos de Kruskal implementados mediante la consola. 

#Paquete Principal
Clase Principal: Dentro de esta clase se generan los grafos aleatoriamente y se obtienen los tiempos medidos luego de ejecutar los algoritmos de Kruskal y Prim implementados.

#Desarrollo y decisiones de implementación

Para medir los tiempos de ejecución del algoritmo de Kruskal, se optó por crear una clase Tiempo la cual recibe como parámetro el grafo sobre el cual se ejecuta dicho algoritmo, y además contiene un método para resolver cada algoritmo por separado, donde se mide el tiempo antes de ejecutarlo y el posterior para obtener así el tiempo total que duró el mismo para generar un árbol generador mínimo a partir del grafo que recibe dicha clase.
Además, se implementaron dos algoritmos de generación de grafos de manera aleatoria donde uno genera aristas mediante un random con la posibilidad de agregar una arista por cada par de vértices y un peso elegido de manera aleatoria; y el otro método aleatorio crea un grafo con la cantidad de vértices y aristas pasados por parámetro, el cual va agregando aristas asegurándose que sea conexo teniendo en cuenta las aristas faltantes a agregar (las cuales se eligen aleatoriamente), que en caso de no existir dentro del grafo, se las agrega. Cabe destacar que a la hora de agregar una arista a la array de aristas las agregamos por peso, con el buscarIndice(), y si es la más grande de todas las aristas, entonces retorna indice -1. A la hora de ejecutar los algoritmos para medir los tiempos, al ejecutar el ciclo que contenia grafos de 100 a 2000 vertices, inclusive el algoritmo con kruskal union find se mantuvo 9 horas en ejecucion y no logoro siquiera llegar a los 1900 vertices. Esto es debido a que las aristas se generan con un random.nesfloat < 01, es decir, el 10% de un grado completo. En otras palabras tarda en generar los grafos ya que por ejemplo, un grafo con 1800 vertices genera 162000 aristas. En la imagen se evidencia la ejecucion desde las 15:15 horas hasta las 00 hrs.

Por ende, se descarta la ejecución con los algoritmos aleatorio 1 de 100 a 2000 vertices.
Por otro lado, se tomó la decisión de crear una clase TiempoStress, la cual se encarga de implementar los métodos donde se generan grafos de distintos tamaños y luego se llaman a los métodos correspondientes de Kruskal para generar los árboles generadores mínimos y así obtener el tiempo que transcurre en ejecutarse el algoritmo.  
Por último, si bien la diferencia de tiempo es notoria cuando se ejecuta el algoritmo de Kruskal mediante BFS y Union-Find, para poder evidenciar la mejoría de la performance de este algoritmo, se implementó el algoritmo de Prim. Con la implementación de este algoritmo, el cual también genera árboles generadores mínimos, se evidencia que el tiempo para generar estos subgrafos, el tiempo que tarda es muchísimo más alto que utilizando los algoritmos de kruskal implementados, debido a que el Algoritmo de Prim, tiene una complejidad de O(n*m) en el peor caso, mientras que KruskalBFS tiene una complejidad de O(m) y KruskalUnion-Find tiene una complejidad de O(log n). Para poder medir los tiempos del mismo se propuso implementar uso de threads, pero no pudo realizarse, ya que, al ejecutar los threads que llaman a los métodos correspondientes, el código no compilaba adecuadamente, arrojando excepciones dentro de los métodos implementados. Por ende, se procedió a medir los tiempos de manera individual y manual.
	
#Conclusiones

Se concluyó el trabajo logrando cumplir con los objetivos propuestos para el mismo, obteniendo una performance del algoritmo de Kruskal comparativa con UnionFind como estructura de datos y otra sin apoyarse de la misma, con BFS. Además de lograr establecer diferentes formas de generación aleatorio de grafos, como también la implementación del algoritmo de Prim a modo de 3ro en discusión y en contraste a los otros dos.
