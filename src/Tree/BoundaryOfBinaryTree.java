package Tree;

public class BoundaryOfBinaryTree {
	public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        res.add(root.val);
        leftBoundary(root.left,res);
        leaves(root.left,res);
        leaves(root.right,res);
        rightBoundary(root.right,res);
        return res;
    }
    
    void leftBoundary(TreeNode root, List<Integer> res) {
        if (root == null) return;
        if (root.left == null && root.right == null) return;
        res.add(root.val);
        if (root.left != null) {
            leftBoundary(root.left, res);
        } else if (root.right != null) {
            leftBoundary(root.right, res);
        }
        return;
    }
    
    void leaves(TreeNode root, List<Integer> res) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            res.add(root.val);
        }
        leaves(root.left,res);
        leaves(root.right,res);
        return;
    }
    
    void rightBoundary(TreeNode root, List<Integer> res) {
        if (root == null) return;
        if (root.left == null && root.right == null) return;
        if (root.right != null) {
            rightBoundary(root.right,res);
        } else if (root.left != null) {
            rightBoundary(root.left,res);
        }
        res.add(root.val);
        return;
        
    }    

}
