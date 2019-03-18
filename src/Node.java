import java.util.ArrayList;
import java.util.List;

public class Node<T> {
 
 private T data = null;
 
 private List<Node<T>> children = new ArrayList<>();
 
 private Node<T> parent = null;
 
 public Node(T data) {
 this.data = data;
 }
 
 public Node<T> addChild(Node<T> child) {
 child.setParent(this);
 this.children.add(child);
 return child;
 }
 
 public void addChildren(List<Node<T>> children) {
 children.forEach(each -> each.setParent(this));
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
	 this.getChildren().forEach(each -> 
	 	each.printData(level+1)
	 );
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
	this.getChildren().forEach(each -> 
 		each.replace(search, replace)
	);
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