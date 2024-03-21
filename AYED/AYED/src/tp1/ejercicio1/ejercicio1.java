package tp1.ejercicio1;
// Corregido
public class ejercicio1 {
	public static void recorridoFor(int a,int b) {
		for (int i = a;i<=b;i++) {
			System.out.println(i);
		}
	}
	public static void recorridoWhile(int a, int b) {
		while (a <= b) {
			System.out.println(a);
			a++;
		}
	}
	
	public static void recorridoRecu(int a, int b) {
		if (a <= b) {
			System.out.println(a);
			recorridoRecu(++a,b);
		}
	}
	
	public static void main(String[] args) {
		int a,b;
		a = 1;
		b = 4;
		System.out.println("--------------------");
		System.out.println("Recorrido con For");
		recorridoFor(a,b);
		System.out.println("--------------------");
		System.out.println("Recorrido con While");
		recorridoWhile(a,b);
		System.out.println("--------------------");
		System.out.println("Recorrido Recursivo");
		recorridoRecu(a,b);
	}
	
}
