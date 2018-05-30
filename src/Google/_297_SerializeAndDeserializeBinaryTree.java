package Google;

public class _297_SerializeAndDeserializeBinaryTree {
	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(" ");
        Queue<String> q = new LinkedList<>();
        for(String node : nodes) {
            q.offer(node);
        }
        return buildTree(q);
    }
    
    TreeNode buildTree(Queue<String> q) {
        String node = q.poll();
        if (node.equals("#")) {
            return null;
        } else {
            TreeNode root = new TreeNode(Integer.parseInt(node));
            root.left = buildTree(q);
            root.right = buildTree(q);
            return root;
        }
    }
    
    void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#").append(" ");
            return;
        } else {
            sb.append(root.val).append(" ");
            serialize(root.left, sb);
            serialize(root.right,sb);
        }   
    }

}
