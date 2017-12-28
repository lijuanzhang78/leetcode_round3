package Tree;

public class SerializeAndDeserializeBinaryTree {
	 // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) return "# ";
        dfs(root,sb);
        return sb.toString();
    }
    
    void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("# ");
            return;
        }
        sb.append(root.val).append(" ");
        dfs(root.left, sb);
        dfs(root.right,sb);
        return;
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(" ");
        Queue<String> q = new LinkedList<>();
        q.addAll(Arrays.asList(nodes));
        return buildTree(q);
    }
    
    TreeNode buildTree(Queue<String> q) {
        String curr = q.poll();
        if (curr.equals("#")) return null;
        TreeNode root = new TreeNode(Integer.valueOf(curr));
        root.left = buildTree(q);
        root.right = buildTree(q);
        return root;
    }

}
