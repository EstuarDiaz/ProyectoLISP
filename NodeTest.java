import org.junit.Test;

import static org.junit.Assert.*;

public class NodeTest {

    @Test
    public void replace() {
        String node = "Me van a remplazar :(";
        String nodos = "Yo lo remplazo :)";
        String nodeReplace = node.replace(node, nodos);
        assertNotEquals(node, nodeReplace);
    }

    @Test
    public void copy() {
        Node<String> node = new Node<String>("Haz una prueba de que si copio");
        Node<String> copyNode = node.copy();
        assertEquals(node.getData(), copyNode.getData());
    }
}