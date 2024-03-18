package tp1.ejercicio5;

public class Arreglo {

	private int[] array;
	private int max = 0;
	private int min = 9999;
	private int prom = 0;
	
	public Arreglo(int[] array) {
		this.array = array;
		for (int n: array) {
			if (n>max) {
				this.max = n;
			}
			if (n<min) {
				this.min = n;
			}
			prom = n + prom;
		}
		prom = (int) prom / array.length;
	}
	
	public int maxN() {
		return max;
	}
	public int minN() {
		return min;
	}
	public int promA() {
		return prom;
	}
}
