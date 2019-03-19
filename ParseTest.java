import com.sun.source.tree.Tree;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class ParseTest {
    /*
    Se comprueba que haya un root y los siguientes nodos.
     */

    @Test
    public void makeBranch() {
        String txt = "(+9(-8 5))";
        List<String> txtListed = Parse.MakeList(txt);
        HashMap<String, Node<String>> randoMap = new HashMap<>();
        Node<String> node = Parse.MakeBranch(txtListed,randoMap);
        System.out.println(node.getData());
        System.out.println(node.getChildren());
    }
}
