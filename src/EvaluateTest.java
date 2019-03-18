import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;

class EvaluateTest {

	@Test
	void testEvalBranch() {
		HashMap<String,Node<String>> funciones = new HashMap<String,Node<String>>();
		String expresion = "(+ ( * 5 8) 4)";
		List<String> lista = Parse.MakeList(expresion);
		Node<String> branch = Parse.MakeBranch(lista, funciones);
		String resultado = Evaluate.EvalBranch(branch, funciones);
		assertEquals(resultado,"44.0");
	}

}
