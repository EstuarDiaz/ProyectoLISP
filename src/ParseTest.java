import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;

class ParseTest {

	@Test
	void testMakeList() {
		String expresion = "(+ 5 4)";
		List<String> lista = Parse.MakeList(expresion);
        System.out.println("Lista:");
		for(int i = 0; i < lista.size(); i++) {
	        System.out.println(lista.get(i));
		}
	}

	@Test
	void testMakeBranch() {
		HashMap<String,Node<String>> funciones = new HashMap<String,Node<String>>();
		String expresion = "(+ ( * 5 8) 4)";
		List<String> lista = Parse.MakeList(expresion);
		Node<String> branch = Parse.MakeBranch(lista, funciones);
        System.out.println("Arbol:");
		branch.printData(1);
	}
}
