import java.util.List;
public class Evaluate {
	/**
	 * Recibe un arbol y lo evalua de manera recursiva
	 * @param branch El arbol a evaluar
	 * @return retorna un string con el resultado, "null" si falla
	 */
	public static String EvalBranch(Node<String> branch) {
		if(branch.getChildren().size() == 0) {
			return branch.getData();
		}
		else {
			List<Node<String>> leaves = branch.getChildren();
			// En el caso de operaciones aritmeticas, se obtiene el primer valor
			// y luego se aplica la operacion con el segundo operando, el resultado
			// se opera con el tercero, el resultado se opera con el cuarto (etc.)
			if(("+*-/").contains(branch.getData())) {
				float result = 0;
				result = Float.parseFloat(EvalBranch(leaves.get(0)));
				for(int i = 1; i < leaves.size(); i++) {
					String data = EvalBranch(leaves.get(i));
					if(branch.getData().equals("+")) {
						result = result + Float.parseFloat(data);
					}
					else if(branch.getData().equals("*")) {
						result = result * Float.parseFloat(data);
					}
					else if(branch.getData().equals("-")) {
						result = result - Float.parseFloat(data);
					}
					else if(branch.getData().equals("/")) {
						result = result / Float.parseFloat(data);
					}
				}
				return Float.toString(result);
			}
			else {
				return "null";
			}
		}
	}
}
