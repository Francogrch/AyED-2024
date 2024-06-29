package tp5.ejercicio5;

public class Persona {
	private String nombre;
	private String domicilio;
	private boolean jubilado;
	private boolean empleado;
	private boolean cobro;

	public Persona(String n, String d, boolean j, boolean e, boolean c) {

		nombre = n;
		domicilio = d;
		jubilado = j;
		empleado = e;
		cobro = c;
	}

	public boolean esJubilado() {
		return jubilado;
	}

	public boolean yaCobro() {
		return cobro;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public boolean esEmpleado() {
		return empleado;
	}

	@Override
	public String toString() {
		return getNombre() + " " + getDomicilio() + " " + " Jubilado: " + esJubilado();
	}

}
