import java.io.IOException;
import java.util.Scanner;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		
		String respuesta = "(* 4 5 (-9 8) (+ (/ 16 2) 2) 7)(+ 8 6)";//input.nextLine();
		List<String> lista = Parse.MakeList(respuesta);

		List<List<String>> instrucciones = Parse.GetIntructions(lista);
		for(int i = 0; i < instrucciones.size(); i++) {
			Node<String> branch = Parse.MakeBranch(instrucciones.get(i));
			String result = Evaluate.EvalBranch(branch);
	        System.out.println(result);
		}
	}
}
