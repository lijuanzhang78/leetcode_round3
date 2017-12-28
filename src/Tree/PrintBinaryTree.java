package Tree;

import java.util.ArrayList;
import java.util.List;

public class PrintBinaryTree {
	public List<List<String>> printTree(TreeNode root) {
        if (root == null) return new ArrayList<List<String>>();
        int totHeight = getHeight(root);
        List<List<String>> res = new ArrayList<>();
        for(int i = 0; i < totHeight; i++) {
            res.add(new ArrayList<String>());
            for(int j = 0; j <  Math.pow(2,totHeight)-1; j++) {
                res.get(i).add("");
            }
        }
        addNode(res,root,0,0,(int)Math.pow(2,totHeight)-2);
        return res;
    }
    
    void addNode(List<List<String>> res, TreeNode root, int depth, int begin, int end) {
        if (root == null) return;
        if (begin == end) {
            res.get(depth).set(begin,""+root.val);
            return;
        }
        int pos = (end+begin)/2;
        res.get(depth).set(pos,""+root.val);
        addNode(res,root.left,depth+1,begin,pos-1);
        addNode(res,root.right,depth+1,pos+1,end);
    }

    int getHeight(TreeNode root) {
        if (root == null) return 0;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return Math.max(left,right) + 1;
    }
    
    public static void main(String[] args) {
    	TreeNode node1 = new TreeNode(1);
    	TreeNode node2 = new TreeNode(2);
    	node1.left = node2;
    	List<List<String>> res = new PrintBinaryTree().printTree(node1);
    	return;
    }
}
