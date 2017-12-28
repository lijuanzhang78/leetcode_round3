package Tree;

// 三个base case： 
// (1) p,q同为null
// (2) p,q之一为null
// (3) p,q 不为null，但是要check值是否相等
//
public class SameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
	       if (p == null && q == null) return true;
	       if (p == null && q != null) return false;
	       if (p != null && q == null) return false;
	       if (p.val != q.val) {
	           return false;
	       } else {
	           return isSameTree(p.left,q.left) && isSameTree(p.right, q.right);
	       }
	    }

}
