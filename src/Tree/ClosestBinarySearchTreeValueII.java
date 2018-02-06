package Tree;

import java.util.LinkedList;
import java.util.List;

// inorder traversal
// can be early terminated - see the second version
// details: res must be declared as LinkedList, the following does not pass compilation
// List<Integer> res = new LinkedList<Integer>(), as the argument is LinkedList<Integer> in 'inorder'
//
public class ClosestBinarySearchTreeValueII {
	public List<Integer> closestKValues(TreeNode root, double target, int k) {
        LinkedList<Integer> res = new LinkedList<Integer>();
        inorder(root,target,k,res);
        return res;   
    }
    
    void inorder(TreeNode root, double target, int k , LinkedList<Integer> res) {
        if (root == null) return;
        if (root.left != null) {
            inorder(root.left, target, k, res);
        } 
        res.add(root.val);
        if (res.size() > k) {
            int first = res.peek();
            if (Math.abs(target-root.val) <= Math.abs(target-first)) {
                res.poll();
            } else {
                res.pollLast();
            } 
        }
        if (root.right != null) {
            inorder(root.right,target,k,res);
        }
    }
    
    public List<Integer> closestKValues_better(TreeNode root, double target, int k) {
        LinkedList<Integer> res = new LinkedList<Integer>();
        inorder(root,target,k,res);
        return res;   
    }
    
    void inorder(TreeNode root, double target, int k , LinkedList<Integer> res) {
        if (root == null) return;
        if (root.left != null) {
            inorder(root.left, target, k, res);
        } 
        if (res.size() == k) {
            int first = res.peek();
            if (Math.abs(target-root.val) <= Math.abs(target-first)) {
                res.poll();
                res.add(root.val);
            } else {
                return;
            } 
        } else {
            res.add(root.val);
        }
        
        if (root.right != null) {
            inorder(root.right,target,k,res);
        }
    }
    
    public static void main(String[] args) {
    	TreeNode root = new TreeNode(2);
    	TreeNode left = new TreeNode(1);
    	root.left = left;
    	int k = 1;
    	double target = 2147483647.0;
    	List<Integer> res = new ClosestBinarySearchTreeValueII().closestKValues(root, target, k);
    	
    	
    }

}
