package tp1.ejercicio7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import tp1.ejercicio3.Estudiante;

public class TestArrayList {

	public static void puntoD() {
		Estudiante estu1 = new Estudiante("Pepe","Garcia","3A","pepe@gmail.com","Calle 50 312");
		Estudiante estu2 = new Estudiante("Pepa","Gonzalez","3B","pepa@gmail.com","Calle 30 312");
		Estudiante estu3 = new Estudiante("Charles","Mercado","4G","Charles@gmail.com","Calle 22 312");
		ArrayList<Estudiante> array = new ArrayList<Estudiante>();
		array.add(estu1);
		array.add(estu2);
		array.add(estu3);
		
		ArrayList<Estudiante> array2 = new ArrayList<Estudiante>(array);
		//array2.addAll(array)
		// Tambien funciona
		
		
		
		System.out.println("Original----------------------");
		System.out.println("Array 1");
		imprimir(array);

		System.out.println("Array 2");
		imprimir(array2);
		
		System.out.println("Modificado----------------------");
		estu1.setNombre("MODIFICADO");
		
		System.out.println("Array 1");
		imprimir(array);

		System.out.println("Array 2");
		imprimir(array2);
		
		/*¿Qué conclusiones obtiene a partir de lo realizado?
		 * ¿Cuántas formas de copiar una lista existen? ¿Qué diferencias existen entre ellas?
		 * Para poder copiar una lista, abria que copiar elemento por elemento, en el caso que sean objetos, ya que al ser objetos, lo que se guarda en la lista son los punteros a esos objetos, y si los modificamos se modifica el objeto en si.
		 * 
		 * */
		
		Estudiante estu4 = new Estudiante("Nuevo","Estudiante","4G","Charles@gmail.com","Calle 22 312");
		array.add(estu4);
		System.out.println("Nuevo estudiante");
		
		imprimir(array);
	}
	
	// Modifico la lista OJO!
	public static boolean esCapicuaR(List<Integer> list) {
		if (list.size()<=1) {
			return true;
		}else {
			if (list.get(0) == list.get(list.size()-1)) {
				list.remove(0);
				list.remove(list.size()-1);
				return esCapicuaR(list);
			}else {
				return false;
			}
		}
	}
	
	// -127 a 128 equals es igual al ==
	public static boolean esCapicua(List<Integer> lista) {
		if (lista.size() % 2 != 0) {
			ArrayList<Integer> copia = new ArrayList<Integer>(lista);
			return esCapicuaR(copia);
		}
		else {
			return false;
		}
	} 
	
	public static void invertir(ArrayList<Integer> list, int n) {
		if (n < list.size()/2) {
			int posEspejo = list.size() - (n + 1);
			Integer tmp = list.get(posEspejo);
			
			list.add(posEspejo,list.get(n));
			list.remove(posEspejo+1);
			list.add(n,tmp);
			list.remove(n+1);
			invertir(list,n+1);
		}
	}
	public static void invertirArrayList(ArrayList<Integer> list) {
		invertir(list,0);
	};
	
	public static int sumarLink(LinkedList<Integer> list) {
		if (!list.isEmpty()) {
			int num = list.get(0);
			list.remove(0);
			return (int) (num + sumarLink(list));
		}
		return 0;
	}
	public static int sumarLinkedList(LinkedList<Integer> list) {
		return sumarLink(new LinkedList<Integer>(list));
	}
	
	public static void imprimir(ArrayList<Estudiante> array) {
		for (Estudiante n:array) {
			System.out.println(n.tusDatos());
		}
		
	}	
	public static void imprimirInt(ArrayList<Integer> array) {
	System.out.println();	
		for (Integer n:array) {
			System.out.print(n + " - ");
		}
	System.out.println();	
		
	}
	public static void imprimirInt(ArrayList<Integer> array, String text) {
		System.out.println("-----"+ text+"-----");
		imprimirInt(array);
	}
	
	public static void combinar(ArrayList<Integer> l1,ArrayList<Integer> l2, ArrayList<Integer> lr){
//		if (!l1.isEmpty() || !l2.isEmpty()) {
//			if ((!l1.isEmpty()) && (l1.get(0) > l2.get(0))) {
//				lr.add(l1.get(0));
//				l1.remove(0);
//			}else if(!l2.isEmpty()){
//				lr.add(l2.get(0));
//				l2.remove(0);
//			}			
//		}
		boolean l1E = l1.isEmpty();
		boolean l2E = l2.isEmpty();
		if ((!l1E) && (!l2E)) {
				if (l1.get(0) > l2.get(0)) {
					lr.add(l1.get(0));
					l1.remove(0);
				}else {
					lr.add(l2.get(0));
					l2.remove(0);
				}
		}else if ((!l1E) && (l2E)) {
				lr.add(l1.get(0));
				l1.remove(0);

		}else if ((l1E)&&(!l2E)) {
			lr.add(l2.get(0));
			l2.remove(0);
		}
		
		if (!l1E || !l2E) {
			combinar(l1,l2,lr);
		}
		
	}
	public static ArrayList<Integer> combinarOrdenado(ArrayList<Integer> lista1, ArrayList<Integer> lista2){
		ArrayList<Integer> l0 = new ArrayList<Integer>();
		ArrayList<Integer> l1 = new ArrayList<Integer>(lista1);
		ArrayList<Integer> l2 = new ArrayList<Integer>(lista2);
		combinar(l1,l2,l0);
		return l0;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Punto A
		System.out.println("<-------------Punto A----------->");
		ArrayList<String> array = new ArrayList<String>();
		for (String n: args) {
			array.add(n);
		}
		for (String n:array) {
			System.out.println(n);
		}
		/* 
	Punto B 
		 Si en lugar de usar un ArrayList en el inciso anterior hubiera usado un LinkedList ¿Qué diferencia encuentra respecto de la implementación? Justifique
		
			Diferencia no hay, ya que la diferencia esta dentro de la clase y no en la implementacion, esto se da gracias al polimorfismo.
	
	Punto C
		¿Existen otras alternativas para recorrer los elementos de la lista del punto 7a.?
			
			Si, se puede recorrer con un iterador:
			
			Iterator<String> iterator = array.iterator();
			while (iterator.hasNext()) {
                String element = iterator.next();
                System.out.println(element);
            }
			
			Y tambien con un for tradicional
			
			for (int i = 0; i<array.lenght;i++){
				array[i];
			}
		 */
		
		System.out.println("<-------------Punto D----------->");
		puntoD();
		
		System.out.println("<-------------Punto F----------->");
		ArrayList<Integer> arrayInt = new ArrayList<Integer>();
		arrayInt.add(2);
		arrayInt.add(5);
		arrayInt.add(2);
		ArrayList<Integer> arrayInt2 = new ArrayList<Integer>();
		arrayInt2.add(8); // 4
		arrayInt2.add(5);
		arrayInt2.add(6);
		arrayInt2.add(3);
		arrayInt2.add(4);
		System.out.println(esCapicua(arrayInt));
		System.out.println(esCapicua(arrayInt2));
		System.out.println("<-------------Punto G----------->");
		List<Integer> puntoG = EjercicioSucesion.calcularSucesion(6);
		for (Integer num: puntoG) {
			System.out.print(num + "-");
		}
		System.out.println();
		
		System.out.println("<-------------Punto H----------->");
		System.out.println("Arreglo Normal");
		imprimirInt(arrayInt2);
		invertirArrayList(arrayInt2);
		System.out.println("Arreglo invertido");
		imprimirInt(arrayInt2);
		
		System.out.println("<-------------Punto I----------->");
		LinkedList<Integer> link = new LinkedList<Integer>();
		link.add(10);
		link.add(12);
		link.add(15);
		link.add(7);
		System.out.println("Suma: "+ sumarLinkedList(link));
		
		System.out.println("<-------------Punto J----------->");
		ArrayList<Integer> lista1 = new ArrayList<Integer>();
		ArrayList<Integer> lista2 = new ArrayList<Integer>();
		lista1.add(5);		
		lista1.add(3);	
		lista1.add(1);
		lista2.add(6);
		lista2.add(4);
		lista2.add(2);
		imprimirInt(lista1,"Lista 1");
		imprimirInt(lista2,"Lista 2");
		ArrayList<Integer> lista3 = combinarOrdenado(lista1,lista2);
		imprimirInt(lista3, "Lista 1 + Lista 2");
		
	}

}
