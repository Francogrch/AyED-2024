## Grafos
Grafo: modelo para representar relaciones entre elementos de un conjunto.

- Grafo dirigos: las relaciones entre vertices no es simentrica (direccion)
- Grafo no dirigidos: las relaciones entre vertices es simentrica (No flecha, no direccion)

Un vertice es adyacente si existe una arista que los conecta
### Grados:
- Grafo no dirigido: El grado de un nodo, es el numero de arcos que inciden en el.
- Grafo dirigido: grados de salida y grados de entrada. Y El grado del vertice es la suma entre los grados de salida y entrada. 

El grado de un grafo es el maximo grado de entre sus nodos.

### Camino
Camino: Pueden repetir nodos.

Longitud de camino: numero de arcos del camino

Camino simple: caminino en el que todos su vertices son diferentes, excepto, el primero y el ultimo que son distintos.

### Ciclo
Camino que se repite un nodo o varios.
Longitud del ciclo cantidad de nodos 
Bucle: ciclo de longitud 1.
Grafos aciclicos: grafos sin ciclos

### Subgrafo
Es un grafo que pertenece a un grafo mas grande.

Subgrafo inducid: es in grafo que pertenece a un grafo mas grande, en relacion a sus vertices y aristas iguales.

Grafo pesado: cada arista tiene ascociado un valor

### Conectividad
Un grafo no dirigdo es conexo si hay un camino entre cada par de vertices. Osea, no hay un subgrafo no conectado o sueltos.

- Bosque: es un grafo sin ciclos
- Arbol libre: es un bosque conexo
- Arbol: es un arbol libre en el que un nodo se ha designado como raiz

Un grafo dirigdo se denomina fuertemento conexo si existe un camino desde cualquier vertice a cualquier otro vertice


Debilmenete conexo 

### Representaciones

#### Matriz  de Adyacencia
Una matriz que define las relaciones entre los vertices
#### Lista de Adyacencia
Cada nodo de la lista es una lista de aristas donde la posicion es el numero del nodo
Desventaja: recorrer toda la lista para saber si pertenece o no.

## Recorridos
### En profundidad (DFS)
Estrategia:
- Partir de un vertice determinado
- Cuando se visita un nuevo vertice, explorar cada camino que salga de el 
- Hasta que no se haya finalizado de explorar uno de los caminos no se comienza con el siguiente
- Un camino deja de explorarse cuando se llega a un vertice ya visitado 
- Si existian vertices nbo alcanzables desde v el recorrido queda incompleta entonces, se debe seleccionar algun vertice como nuevo vertice de partida y repetir el proceso.

Esquema recursivo:
1. Marcar todos los vertices como no visitados
2. Elegir vertice u como punta de partida
3. marcar u como visitado
4. Para cada uno de los adayacentes, si no fue visitado, se llama con ese arco a la recursion
~~~
dfs(v: vertice)
marcar v como visitado
para cada nodo w adyacente a V
    si no esta visitado
        dfs(w)


main: dfs (grafo)
    inicializar marca en flase (arreglo de booleans)
    para cada vertice v del grafo:
        si v no esta visitado
            dfs(v);
~~~
### Amplitud (BFS)
#### Estrategia
- Partir de algin vertice u, visitar u, y despuesz, visitar cada uno de los vertices adyacentes a u
- Repetir el proceso para cada nodo adayacente a u, siguiente el orden en que fueron visitados.

1. Encolar el vertice origun u
2. marcar el vertice u como visitado
3. Mientras la cola no este vacia 
4.  Desencolar u de la cola
5.   Para cada adyacente de U
6.          si no fue visitado
7.              encolar y marcar como visitado


### Bosque de expacion (DFS)
### Back
Se marca cuando un vertice tiene adyacente un vertice que ya fue visitado

### Forward
Se marca cuando se vuelve de la recursion y quedo una arista con un vertice que ya estaba visitado

### Cross
Slatos entre vertices sin conexion, no se marca



### Dijkstra
Cuando hay pesos negativos, no se puede ejecutar dikstra si hay una arista con peso negativo apuntando a un vertice ya visitado 
Vertice | Distancia | Padre | Conocido
### Prim
Grafo no dirijido y conexo
Vertice | Distancia | Padre | Conocido
No suma las aristas
TE: 
- v^2 -> tabla
- E Log V -> heap 
### Kruskal
Es una lista de aristas
Se ordenan de menor a mayor (min heap)
Se va armando el grafo sin hacer ciclos
TE: e log V


# Resumen por temas
## Caminos minimos
- Grafo sin peso: Recorrido BFS(Cola y Tabla Vertice|Distancia|Padre)
- Grafo con peso +: Dijkstra (suma de pesos de vertices)
- Grafo con peso -: Prim (solo peso del vertice)
- Grafo con peso aciclico: Topologico (Tabla grados entrada)


## DFS
- Vector de booleano visitado
Algoritmo

## BFS
- Vector de booleano visitado
ALgoritmo

## Ordenacion topologica(vector, pila, dfs)
### Vector
Vector de grados de entrada de cada vertice
- Se toma el vertice que tiene 0 (Va a la salida)
- Se baja en 1 los adyacentes
- Se repite hasta que te queda el vector en 0
Ej: 
~~~
E F G B A 
0 2 3 4 1
E 2 2 3 0
~~~
### Pila
?
### DFS
- Se hace recorrido dfs hasta llegar a hoja
- En post orden se enumera de menor a mayor
- Se repite hasta que todos los nodos esten enumerados

- Por ultimo, en la salida, se ordena de mayor a menor
## Dijktra
Es una tabla que tiene:
Vertice | Distancia | Padre | Visitado
- Se toma el vertice con la distancia menor de los no visitados
- Se modifican los adyacentes (no visitados) si la distancia + coste de arista es menor a la distancia guardada
- Se marca como visitado
- Repetir hasta que todo este visitado
- Por ultimo, en la columna de Orden, quedan las arista del camino minimo
## Prim
Es una tabla o HEAP que tiene:
Vertice | Coste | Padre | Visitado
- Se toma el vertice con la coste menor de los no visitados
- Se modifican los adyacentes (no visitads) si el coste es menor que el guardado
- Se marca como visitado
- Se repite hasta que todo este visitado
- Por ultima, quedan las aristas del camino minimo

TE:
TABLA -> V^2
HEAP -> E log V
## Kruskal
- Se hace una min heap con todas las aristas
- Se unen vertices de menor a mayor, siempre y cuando no se genere un ciclo.
- Se repite hasta el final de la heap.

## Floyd
Son dos matrices:
- matriz de costos minimos
- matriz de vertices intermedios

TE: |V|^3
