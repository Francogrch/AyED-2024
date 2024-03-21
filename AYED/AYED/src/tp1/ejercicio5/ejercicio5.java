package tp1.ejercicio5;
// Corregido
public class ejercicio5 {
	public static int[] arreglo = {1,2,3,4,5};
	
	public static int[] conReturn(int[] array) {
		int[] retu = new int[3];
		retu[0] = 9999;
		retu[1] = 0; 
		retu[2] = 0;
		for (int n: array) {
			if (n < retu[0]) {
				retu[0] = n;
			}
			if (n > retu[2]) {
				retu[2] = n;
			}
			retu[1] = n + retu[1];
		}
		retu[1] = (int) (retu[1] / array.length);
		
		return  retu;
		
	}
	
	public static void noArreglo(Arreglo a){
		System.out.println("Minimo: " + a.minN());
		System.out.println("Promedio: " + a.promA());
		System.out.println("Maximo: " + a.maxN());
		
	}
	
	public static void sinParametros() {
		System.out.println("Sin parametros: ");
		noArreglo(new Arreglo(arreglo));
	}
	
	public static void main(String[] args) {
		// Calcular el valor máximo, mínimo, y promedio
		// TODO Auto-generated method stub
		
		
		int[] conRetu = new int[3];
		conRetu = conReturn(arreglo);
		System.out.println("Con return: ");
		System.out.println("Minimo: " + conRetu[0]);
		System.out.println("Promedio: " + conRetu[1]);
		System.out.println("Maximo: " + conRetu[2]);
		
		System.out.println("Con parametro: ");
		noArreglo(new Arreglo(arreglo));
		
		sinParametros();
		
		
	}

}
