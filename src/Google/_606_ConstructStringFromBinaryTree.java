package Google;

public class _606_ConstructStringFromBinaryTree {
	public String tree2str(TreeNode t) {
        if (t == null) return "";
        StringBuilder sb = new StringBuilder();
        tree2strhelper(t,sb);
        return sb.toString();
    }
    
    void tree2strhelper(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        sb.append(root.val);
        if (root.left == null && root.right == null) return;
        sb.append("(");
        tree2strhelper(root.left,sb);
        sb.append(")");
        if (root.right != null) {
            sb.append("(");
            tree2strhelper(root.right,sb);
            sb.append(")");
        }
    }

}
