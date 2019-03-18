import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.List;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		String programa = "";
		HashMap<String,Node<String>> funciones = new HashMap<String,Node<String>>();
        File file = new File("programaLISP5.txt");
        Scanner scanner = new Scanner(file);
        System.out.println("Programa:");
        int n = 0;
        while (scanner.hasNextLine()){
            String line = scanner.nextLine(); 
        	programa += line;
        	n++;
            System.out.println("[" + Integer.toString(n) + "]: " + line);
        }
        scanner.close();	
        
        n = 0;
        System.out.println("\nResultado:");
		List<String> lista = Parse.MakeList(programa);
		List<List<String>> instrucciones = Parse.GetIntructions(lista);
		for(int i = 0; i < instrucciones.size(); i++) {
			Node<String> branch = Parse.MakeBranch(instrucciones.get(i), funciones);
//			System.out.println(Integer.toString(i+1)+":");
//			branch.printData(1);
			if(branch.getData().equals("DEFUN")) {
				String nombre = branch.getChildren().get(0).getData();
				funciones.put(nombre, branch);
			}
			String result = Evaluate.EvalBranch(branch,funciones);
	        System.out.println("[" + Integer.toString(++n) + "]: " + result);
		}
	}
}
