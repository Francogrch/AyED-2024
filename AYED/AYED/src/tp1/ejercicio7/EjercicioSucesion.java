package tp1.ejercicio7;

import java.util.ArrayList;
import java.util.List;

public class EjercicioSucesion {
	
	public static void metodoRecursivo(List<Integer> list, Integer n){
		list.add(n);
		if (n != 1) {
			if (n % 2 == 0) {
				metodoRecursivo(list,(int)(n/2));
			}else {
				metodoRecursivo(list,(int) ((3*n) +1)); 
				} 
			}
	}
	
	
	public static List<Integer> calcularSucesion (int n) {
		List<Integer> list = new ArrayList<Integer>();
		
		metodoRecursivo(list,n);
		
		return list;
		}
}
