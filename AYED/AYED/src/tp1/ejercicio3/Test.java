package tp1.ejercicio3;

public class Test {
	
	
	public static void main (String[] args) {
		Estudiante estu1 = new Estudiante("Pepe","Garcia","3A","pepe@gmail.com","Calle 50 312");
		Estudiante estu2 = new Estudiante("Pepa","Gonzalez","3B","pepa@gmail.com","Calle 30 312");
		Profesor profe1 = new Profesor("Carlos","Yuliani","carl@gmail.com","Ingenieria","Ingenieria");
		Profesor profe2 = new Profesor("Marcos","Gonzalez","marc@gmail.com","Fundamento de datos","Informatica");
		Profesor profe3 = new Profesor("Yulita","Maritnez","yuli@gmail.com","Composicion IV","Artes");
	
		Estudiante[] estudiantes = new Estudiante[2];
		Profesor[] profesores = new Profesor[3];
		
		estudiantes[0] = estu1;
		estudiantes[1] = estu2;
		profesores[0] = profe1;
		profesores[1] = profe2;
		profesores[2] = profe3;
		System.out.println("<-------------------------------->");
		System.out.println("Recorrido estudiantes");
		for (Estudiante estudiante: estudiantes) {
			System.out.println(estudiante.tusDatos());
			System.out.println("<----------------->");
	}
		System.out.println("<-------------------------------->");
		System.out.println("Recorrido Profesores");
		
		for (Profesor profesor: profesores) {
			System.out.println(profesor.tusDatos());
			System.out.println("<----------------->");
		}
	
	}
}
