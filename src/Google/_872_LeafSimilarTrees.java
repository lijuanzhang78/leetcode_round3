package Google;

public class _872_LeafSimilarTrees {
	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return false;
        List<Integer> leaves = new ArrayList<>();
        getLeaves(root1,leaves);
        if(!checkLeaves(root2,leaves)) return false;
        if(leaves.size() > 0) return false;
        return true;
    }
    
    void getLeaves(TreeNode root, List<Integer> leaves) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            leaves.add(root.val);
        }
        getLeaves(root.left,leaves);
        getLeaves(root.right,leaves);
    }
    
    boolean checkLeaves(TreeNode root, List<Integer> leaves) {
        if (root == null) return true;
        if (root.left == null && root.right == null) {
            if (leaves.size() == 0 || leaves.get(0) != root.val) return false;
            leaves.remove(0);
        }
        if (!checkLeaves(root.left,leaves)) return false;
        if (!checkLeaves(root.right,leaves)) return false;
        return true;
    }

}
