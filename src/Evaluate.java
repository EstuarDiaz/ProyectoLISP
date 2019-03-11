import java.util.List;
public class Evaluate {
	public static String EvalBranch(Node<String> branch) {
		if(branch.getChildren().size() == 0) {
			return branch.getData();
		}
		else {
			List<Node<String>> leaves = branch.getChildren();
			if(("+*-/").contains(branch.getData())) {
				float result = 0;
				result = Float.parseFloat(EvalBranch(leaves.get(0)));
				for(int i = 1; i < leaves.size(); i++) {
					String data = EvalBranch(leaves.get(i));
					if(branch.getData().equals("+")) {
						result = result + Float.parseFloat(data);
					}
					else if(branch.getData().equals("*")) {
						result = result * Float.parseFloat(data);
					}
					else if(branch.getData().equals("-")) {
						result = result - Float.parseFloat(data);
					}
					else if(branch.getData().equals("/")) {
						result = result / Float.parseFloat(data);
					}
				}
				return Float.toString(result);
			}
			else {
				return "null";
			}
		}
	}
}
