import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.List;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws IOException {
		String programa = "";
		HashMap<String,Node<String>> funciones = new HashMap<String,Node<String>>();
		try {
			System.out.println("Ingrese el nombre del archivo de texto que contiene el programa.\n");
			Scanner input = new Scanner(System.in);
			File file = new File(input.nextLine());
	        Scanner scanner = new Scanner(file);
	        input.close();
	        System.out.println("Programa:");
	        int n = 0;
	        while (scanner.hasNextLine()){
	            String line = scanner.nextLine();
	            // Se quitan comentarios del programa
	            if(line.indexOf(";") > 0) {
	            	programa += line.substring(0, line.indexOf(";"));
	            }
	            else {
	            	programa += line;
	            }
	        	// Se imprimen las lineas del programa ingresado por el usuario
	            System.out.println("[" + Integer.toString(++n) + "]: " + line);
	        }
	        scanner.close();	
	        
	        n = 0;
	        try {
	        	System.out.println("\nResultado:");
				List<String> lista = Parse.MakeList(programa);
				// Se leen las instrucciones del programa
				List<List<String>> instrucciones = Parse.GetIntructions(lista);
				for(int i = 0; i < instrucciones.size(); i++) {
					// Se crea el arbol para cada instruccion/expresion
					Node<String> branch = Parse.MakeBranch(instrucciones.get(i), funciones);
//					System.out.println(Integer.toString(i+1)+":");
//					branch.printData(1);
					// Si se define una funcion, se guarda la funcion en una lista
					if(branch.getData().equals("DEFUN")) {
						String nombre = branch.getChildren().get(0).getData();
						funciones.put(nombre, branch);
					}
					// Se imprime el resultado de la expresion, evaluando el arbol
					String result = Evaluate.EvalBranch(branch,funciones);
			        System.out.println("[" + Integer.toString(++n) + "]: " + result);
				}
        	}
        	catch(Exception e) {
        		System.out.println("Error: revisa la sintaxis del programa.");
        	}
		}
		catch(Exception e) {
			System.out.println("Por favor ingresa una direccion valida para el archivo.");
		}
		
	}
}
