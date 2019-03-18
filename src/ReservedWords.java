import javax.swing.tree.TreeNode;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public class ReservedWords {



    public static java.util.Hashtable<String, TreeNode> vars = new Hashtable<>();

    public static String stringIfy(){
        return vars.toString();
    }

    public static boolean varIsDefined(String name){
        return vars.containsKey(name);
    }

    public static void unbindAll(Hashtable <String, TreeNode> tbl){
        Iterator it = tbl.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pairs = (Map.Entry)it.next();
            if ( vars.get(pairs.getKey()) == pairs.getValue() ){
                vars.remove(pairs.getKey());
            }
            it.remove(); // avoids a ConcurrentModificationException
        }
    }

    public static void unbind(String name){
        vars.remove(name);
    }
    public static TreeNode getVarValue(String name) throws Exception{
        if ( vars.containsKey(name) ){
            return vars.get(name);
        } else {
            throw new Exception("Error! No such variable.");
        }
    }

    public static void mergeVars(Hashtable<String, TreeNode> newVars){
        Iterator it = newVars.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry pairs = (Map.Entry)it.next();
            if(vars.contains(pairs.getKey())){
                vars.remove(pairs.getKey());
            }
            vars.put((String) pairs.getKey(), (TreeNode) pairs.getValue());
            it.remove();
        }
    }

    public static Hashtable<String, TreeNode> getVarTable(){
        return new Hashtable<String, TreeNode>(vars);
    }

    public static void setVars(Hashtable<String, TreeNode> v){
        vars = new Hashtable<String, TreeNode>(v);
    }
}
