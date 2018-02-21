package Tree;

public class SerializeAndDeserilizeBST_usingStack {
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
        if (data.equals("")) return null;
        String[] nodes = data.split(",");
        int[] nodesVal = new int[nodes.length];
        for(int i = 0; i < nodes.length; i++) {
            nodesVal[i] = Integer.valueOf(nodes[i]);
        }
        return deserialize(nodesVal);    
    }
    
    TreeNode deserialize(int[] nodesVal) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode res = new TreeNode(nodesVal[0]);
        TreeNode root = res;
        stack.push(root);
        for(int i = 1; i < nodesVal.length; i++) {
            if (nodesVal[i] < root.val) {
                TreeNode left = new TreeNode(nodesVal[i]);
                root.left = left;
                stack.push(left);
                root = left;
            } else {
                while(stack.size() > 0 && stack.peek().val < nodesVal[i]) {
                    root = stack.pop();
                }
                TreeNode right = new TreeNode(nodesVal[i]);
                root.right = right;
                root = right;
                stack.push(right);
            }
        }
        return res;
    }

}
