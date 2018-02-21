package Tree;

// use preorder traversal to serialize the binary search tree
// use lower and upper bounds to recursively create the binary search tree
// details: need to explicited return for empty string at line 29 due to usage of split
// deserilize can be implemented by using stack!
//
public class SerializeAndDeserializeBST {
	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        String left = serialize(root.left);
        String right = serialize(root.right);
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        if (root.left == null && root.right == null) return sb.toString();
        if (root.left == null) {
            sb.append(","+right);
        } else if (root.right == null) {
            sb.append(","+left);
        } else {
            sb.append(","+left+","+right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	if (data.equals("")) return null; // need to explicitly return for empty string
        String[] nodes = data.split(",");
        String first = nodes[0];
        for(int i = 0; i < nodes.length; i++) {
            nodesVal[i] = Integer.valueOf(nodes[i]);
        }
        return deserialize(nodesVal,0,nodesVal.length-1);    
    }
    
    TreeNode deserialize(int[] nodesVal, int begin, int end) {
        if (begin > end) return null;
        TreeNode root = new TreeNode(nodesVal[begin]);
        int i = begin+1;
        for(i = begin+1; i <= end; i++) {
            if (nodesVal[i] > nodesVal[begin]) break;
        }
        root.left = deserialize(nodesVal, begin+1,i-1);
        root.right = deserialize(nodesVal,i,end);
        return root;
    }
    
    public static void main(String[] args) {
    	TreeNode root = null;
    	String res = new SerializeAndDeserializeBST().serialize(null);
    	TreeNode res1 = new SerializeAndDeserializeBST().deserialize(res);
    	return;
    }
}
