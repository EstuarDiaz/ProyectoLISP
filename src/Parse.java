import java.util.ArrayList;
import java.util.List;

public class Parse{
	public Node<String> ParseList(List<String> lista) {
		Node<String> root = new Node<String>("");
		for(int i = 0; i < lista.size(); i++) {   
        }
		return root;
	}
	
	/**
	 * Recibe un string y devuelve una lista de tokens
	 * @param s El string a convertir
	 * @return la lista de tokens
	 */
	public static List<String> MakeList(String s){
		List<String> lista = new ArrayList<String>();
		s = s.replace("(", " ( ");
		s = s.replace(")", " ) ");
		s = s.replace("+", " + ");
		s = s.replace("*", " * ");
		s = s.replace("-", " - ");
		s = s.replace("/", " / ");
		String[] texto = s.split(" ");
        for (int i = 0; i < texto.length; i++) {
        	if(!texto[i].isEmpty()) {
        		lista.add(texto[i]);
        	}
        }
        return lista;
	}
	
	/**
	 * Devuelve la expresion siguiente, ejemplo:
	 *  para: (+ 9 (+ 6 7)) 8 9 ) 6 5 ... )
	 *  devuelve: (+ 9 (+ 6 7))
	 * @param list lista original que contiene almenos una expresion
	 * @return La primera expresion completa contenida en la lista original
	 */
	public static List<String> GetExpression(List<String> list) {
		int parentesisCount = 1;
		int toIndex = list.size();
		for(int i = 1; (parentesisCount != 0) && (i < list.size()); i++) {
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
		return list.subList(0, toIndex+1);
	}
	
	/**
	 * Convierte una lista con varias expresiones en una lista de expresiones
	 * que representan una linea o instruccion en el programa
	 * @param texto El texto del programa
	 * @return Lista de instrucciones o expresiones
	 */
	public static List<List<String>> GetIntructions(List<String> texto){
		List<List<String>> instrucciones = new ArrayList<List<String>>();
		for(int i = 0; i < texto.size(); i++) {
			List<String> linea = GetExpression(texto.subList(i, texto.size()));
			i += linea.size() - 1;
			instrucciones.add(linea);
		}
		return instrucciones;
	}
	
	/**
	 * Dada una expresion, crea un arbol de manera recursiva que la representa
	 * @param lista La lista a evaluar
	 * @return Un arbol de la clase Nodo
	 */
	public static Node<String> MakeBranch(List<String> lista) {
		Node<String> root = new Node<String>(lista.get(1));
		for(int i = 2; i < lista.size() - 1; i++) {
			Node<String> leaf = null;
			if(lista.get(i).equals("(")) {
				//Obtengo la sublista desde la posicion actual a lo que resta
				List<String> subLista = GetExpression(lista.subList(i, lista.size()));
				
				// Corro el contador para saltarme toda la expresion
				i += subLista.size() - 1;
				
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
