package Tree;

// use a hashtable to record the numbers existing in this BST
// 错误：在加入新元素到hashset之前，需要先判断hashset是否有k-root.val，否则当两个数相等的时候，算法不work
//
public class TwoSumIV {
	public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return findTarget(root,k,set);
    }
    
    boolean findTarget(TreeNode root, int k, Set<Integer> set) {
        if (root == null) return false;
        if (set.contains(k-root.val)) return true; // 需要在set.add(root.val) 之前
        set.add(root.val);
        return findTarget(root.left,k,set) || findTarget(root.right,k,set);
    }

}
