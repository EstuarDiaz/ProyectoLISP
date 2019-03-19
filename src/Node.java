import java.util.ArrayList;
import java.util.List;

public class Node<T> {
/*Se definen las acciones que la clase Node, puede realizar. Entre ellas estan:
     -Agregar hijos dentro del arbol
     -Llamar a los hijos del arbol
     -Llamar a la informacion 
     -Establecer la informacion
     -Establecer a los padres
     -Reemplazar la informacion
     -Copiar la informacion
*/
 
 private T data = null;
 
 private List<Node<T>> children = new ArrayList<>();
 
 private Node<T> parent = null;
 
 /**
  * Creator
  * @param data La informacion a almacenar
  */
 public Node(T data) {
 this.data = data;
 }
 
 /**
  * Agrega un nodo al arbol
  * @param child
  * @return El nodo ingresado
  */
 public Node<T> addChild(Node<T> child) {
 child.setParent(this);
 this.children.add(child);
 return child;
 }
 
 public void addChildren(List<Node<T>> children) {
	 for(int i = 0; i < children.size(); i++) {
		 children.get(i).setParent(this);
	 }
 this.children.addAll(children);
 }
 
 public List<Node<T>> getChildren() {
 return children;
 }
 
 public T getData() {
 return data;
 }
 
 public void setData(T data) {
 this.data = data;
 }
 
 private void setParent(Node<T> parent) {
 this.parent = parent;
 }
 
 public Node<T> getParent() {
 return parent;
 }
 
 public void printData(int level) {
	 String s = "";
	 for(int i = 0; i < level; i++) {s = s + "-";}
	 System.out.println(s + ">| " + this.getData());
	 for(int j = 0; j < this.getChildren().size(); j++) {
		 this.getChildren().get(j).printData(level+1);
	 }
 }

/**
 * Reemplazar una variable por un valor en el arbol,
 * Se utiliza para las definicion de funciones, como
 * paso de parametros
 * @param search variable a buscar
 * @param replace valor por el cual se reemplaza
 */
public void replace(T search, T replace) {
	if(this.getData().equals(search)) {
		this.setData(replace);
	}
	for(int i = 0; i < this.getChildren().size(); i++) {
		this.getChildren().get(i).replace(search, replace);
	}
}

/**
 * Crea una copia del arbol, se utiliza para evaluar
 * fuciones definidas por el usuario
 * @return Node identico al original.
 */
public Node<T> copy(){
	Node<T> n = new Node<T>(this.getData());
	for(int i = 0; i < children.size(); i++) {
		n.addChild(children.get(i).copy());
	}
	return n;
}
}
