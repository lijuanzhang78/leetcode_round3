package Tree;

// 这种题的套路就是先判断root 是否为null，在把左子树看成一个整体，右子树看成一个整体，最后考虑用左右子树的返回值
// 构建成现在问题的解
// longestUnivalePath 也是一样的套路
//
public class ConstructStringFromBinaryTree {
	public String tree2str(TreeNode t) {
        if (t == null) return "";
        StringBuilder sb = new StringBuilder();
        String left = tree2str(t.left);
        String right = tree2str(t.right);
        sb.append(t.val);
        if (left.length() == 0 && right.length() == 0) {
            return sb.toString();
        }
        if (left.length() == 0) {
            sb.append("()");
        } else {
            sb.append("("+left+")");
        }
        if (right.length() != 0) sb.append("("+right+")");
        return sb.toString();
    }
	
	// 第二次写是这样的，第一次写的更简洁
	public String tree2str(TreeNode t) {
        if (t == null) return "";
        StringBuilder sb = new StringBuilder();
        sb.append(t.val);
        if (t.left == null && t.right == null) return sb.toString();
        sb.append("(");
        String left = tree2str(t.left);
        sb.append(left);
        sb.append(")");
        
        if (t.left != null && t.right == null) return sb.toString();
        sb.append("(");
        String right = tree2str(t.right);
        sb.append(right);
        sb.append(")");
        
        return sb.toString();
    }

}
