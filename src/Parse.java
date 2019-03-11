import java.util.ArrayList;
import java.util.List;

public class Parse{
	public Node<String> ParseList(List<String> lista) {
		Node<String> root = new Node<String>("");
		for(int i = 0; i < lista.size(); i++) {   
        }
		return root;
	}
	
	public static List<String> MakeList(String s){
		List<String> lista = new ArrayList<String>();
		String[] texto = s.split(" ");
        for (int i = 0; i < texto.length; i++) {
        	lista.add(texto[i]);
        }
        return lista;
	}
	
	public static List<String> GetExpression(List<String> list) {
		int parentesisCount = 1;
		int toIndex = list.size();
		for(int i = 0; (parentesisCount != 0) && (i < list.size()); i++) {
			if(list.get(i).equals("(")) {
				parentesisCount++;
			}
			else if(list.get(i).equals(")")) {
				parentesisCount--;
			}
			if(parentesisCount == 0) {
				toIndex = i;
			}
		}
		return list.subList(0, toIndex);
	}
	
	public static Node<String> MakeBranch(List<String> lista) {
		Node<String> root = new Node<String>(lista.get(0));
		for(int i = 1; i < lista.size(); i++) {
			Node<String> leaf = null;
			if(lista.get(i).equals("(")) {
				//Obtengo la sublista desde la posicion actual a lo que resta
				List<String> subLista = GetExpression(lista.subList(i+1, lista.size()));
				
				// Corro el contador para saltarme toda la expresion 
					// (incluyendo el parentesis de cierre)
				i += subLista.size() + 1;
				
				// Ahora la nueva hoja es realmente un arbol inducido por la sublista
				leaf = MakeBranch(subLista);
			}
			else {
				leaf = new Node<String>(lista.get(i));
			}
			root.addChild(leaf);	
        }
		return root;
	}
}
