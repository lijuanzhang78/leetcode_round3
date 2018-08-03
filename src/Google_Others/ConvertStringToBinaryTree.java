package Google_Others;
public class ConvertStringToBinaryTree {
	class Node {
		String val; // number of operator
		Node left, right;
		Node(String val) {
			this.val = val;
			left = null; right = null;
		}
	}
	
	public Node constructBinaryTree(String s) {
		if (s.length() == 1) {
			Node res = new Node(s);
			return res;
		} else {
			Node root = null;
			for(int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '+' || s.charAt(i) == '-') {
					root = new Node(new String(""+s.charAt(i)));
					root.left = constructBinaryTree(s.substring(0,i));
					root.right = constructBinaryTree(s.substring(i+1));
					break;
				} 
			}
			if (root == null) {
				for(int i = 0; i < s.length(); i++) {
					if (s.charAt(i) == '*' || s.charAt(i) == '/') {
						root = new Node(new String(""+s.charAt(i)));
						root.left = constructBinaryTree(s.substring(0,i));
						root.right = constructBinaryTree(s.substring(i+1));
						return root;	
					}
				}	
			}
			return root;
		}
	}

	public static void main(String[] args) {
		String s = "9*3+2-5/2";
		Node res = new ConvertStringToBinaryTree().constructBinaryTree(s);
		return;	
	}
}
