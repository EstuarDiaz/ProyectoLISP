import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class EvaluateTest {
    /*
    Se le ingresa una serie de simbolos al metodo para ver si se cumple o no el metodo de evaluate, que es
     */

    @Test
    public void evalBranch() {
        String txt = "(+9(-8(*3 (/ 5 5))))";
        List<String> txtListed = Parse.MakeList(txt);
        HashMap<String, Node<String>> randoMap = new HashMap<>();
        Node<String> node = Parse.MakeBranch(txtListed,randoMap);
        System.out.println(Evaluate.EvalBranch(node, randoMap));
    }
}