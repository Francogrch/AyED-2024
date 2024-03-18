package tp1.ejercicio8;

public class CircularQueue<T> extends Queue<T>{
	
	public CircularQueue() {
		super();
	// TODO Auto-generated constructor stub
	}	
	
	public T shift() {
		T ult = data.get(data.size());
		data.remove(data.size());
		data.add(0,ult);
		return ult;
		// En el ejercicio no especifica sobre algun error, como anteriores puntos.
		// Claramente este metodo, no esta teniendo en cuanta si esta vacio.
	}
	
}
