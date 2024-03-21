package tp1.ejercicio2;

import java.util.Scanner;
// Corregido
public class ejercicio2 {

	public static int[] contar(int n){
		int[] array = new int[n];
		for (int i = 0;i<n;i++) {
			array[i] = (i+1)*n;
		}
		return array;
	}
	
	public static void imprimir(int[] n) {
		for (int num: n) {
			System.out.println(num);
		}
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		//imprimir(contar(5));
		imprimir(contar(n));
		scanner.close();
	}
}
