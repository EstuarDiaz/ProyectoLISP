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
			else if(("<>EQUAL").contains(branch.getData())) {
				// En este caso, se obtiene el primer valor y se compara 
				// con todos los demas, con el criterio de comparacion dado
				String result = "true";
				String compareTo = EvalBranch(leaves.get(0));
				for(int i = 1; i < leaves.size(); i++) {
					String data = EvalBranch(leaves.get(i));
					if(branch.getData().equals("EQUAL")) {
						if(Float.isNaN(Float.parseFloat(compareTo))) {
							if(!compareTo.equals(data)) {
								result = "false";
							}
						}
						else {
							if(Float.compare(Float.parseFloat(compareTo), Float.parseFloat(data)) != 0) {
								result = "false";
							}
						}
					}
					else if(branch.getData().equals("<")) {
						if(Float.parseFloat(compareTo) >= Float.parseFloat(data)) {
							result = "false";
						}
					}
					else if(branch.getData().equals(">")) {
						if(Float.parseFloat(compareTo) <= Float.parseFloat(data)) {
							result = "false";
						}
					}
				}
				return result;
			}
			else if(branch.getData().equals("ATOM")) {
				// Devulve true si el objeto es de tipo atomo, false en caso contrario
				String result = "true";
				for(int i = 0; i < leaves.size(); i++) {
					if(leaves.get(i).getChildren().size() > 0) {
						result = "false";
					}
				}
				return result;
			}
			else if(branch.getData().equals("LIST")) {
				// Permite crear una lista
				String list = "(";
				for(int i = 0; i < leaves.size(); i++) {
					list += EvalBranch(leaves.get(i)) + " ";
				}
				return list.substring(0, list.length()-1)+")";
			}
			else {
				return "null";
			}
		}
	}
}
