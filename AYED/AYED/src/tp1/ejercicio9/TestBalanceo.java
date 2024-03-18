package tp1.ejercicio9;

import tp1.ejercicio8.Queue;

public class TestBalanceo {

	public static boolean estaBalanceado(String text) {
		char character;
		Queue<Character> cola = new Queue<Character>();
		int cant = text.length();
		int i = 0;
		boolean siga = true;
		
		while ((cant > i) && (siga)){
			character = text.charAt(i);
			if ((character == '(') || character == '{' || character == '['){
				cola.enqueue(character);
			}
			else if ((character == ')') || character == '}' || character == ']'){
				if (cola.isEmpty()) {
					siga = false;
				}else{
					char tope = cola.dequeue();
					if ((character == ')') && (tope == '(')) {
						siga = true;
					} else if ((character == ']') && (tope == '[')) {
						siga = true;
					} else if ((character == '}') && (tope == '{')) {
						siga = true;
					} else {
						siga = false;
					}
				}
			} else {
				siga = false;
			}
			i++;	
		} 
		return siga;
	}
	
	public static void main(String[] args) {
		String textT = "{()[()]}";
		String textF = "([)]";
		System.out.println(estaBalanceado(textT));
		System.out.println(estaBalanceado(textF));
	}
}
