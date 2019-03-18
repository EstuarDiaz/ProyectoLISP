import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class NodeTest {

	@Test
	void testPrintData() {
		Node<String> root = new Node<String>("A");
		Node<String> leaf1 = new Node<String>("AB");
		Node<String> leaf2 = new Node<String>("AC");
		root.addChild(leaf1);
		root.addChild(leaf2);
        System.out.println("Arbol:");
		root.printData(1);
	}

	@Test
	void testReplace() {
		Node<String> root = new Node<String>("A");
		Node<String> leaf1 = new Node<String>("AB");
		Node<String> leaf2 = new Node<String>("AC");
		root.addChild(leaf1);
		root.addChild(leaf2);
		root.replace("AB", "BA");
		assertEquals(root.getChildren().get(0).getData(),"BA");
	}

	@Test
	void testCopy() {
		Node<String> root = new Node<String>("A");
		Node<String> leaf1 = new Node<String>("AB");
		root.addChild(leaf1);
		Node<String> copy = root.copy();
		assertEquals(copy.getChildren().get(0).getData(),"AB");
	}

}
