import java.io.IOException;
import java.util.Scanner;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		String respuesta = "* 4 5 ( - 9 6 ) ( + ( / 16 2 ) 2 ) 7";//input.nextLine();
		List<String> lista = Parse.MakeList(respuesta);
        Node<String> branch = Parse.MakeBranch(lista);
        
		String result = Evaluate.EvalBranch(branch);
        System.out.println("Resultado: " + result);

        System.out.println("");
		System.out.println("Arbol: ");
        branch.printData(1);

        System.out.println("");
		System.out.println("Lista: ");
		System.out.println(lista.toString());
	}
}
