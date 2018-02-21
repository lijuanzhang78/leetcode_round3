package Tree;

public class SplitBST {
	public TreeNode[] splitBST(TreeNode root, int V) {
        if (root == null) return new TreeNode[2];
        TreeNode[] res = new TreeNode[2]; // res[0] smaller, res[1] larger
        if (V < root.val) {
            res[1] = root;
            TreeNode[] subres = splitBST(root.left,V);
            res[0] = subres[0];
            root.left = subres[1];
        } else {
            res[0] = root;
            TreeNode[] subres = splitBST(root.right,V);
            res[1] = subres[1];
            root.right = subres[0];
        }
        return res;   
    }

}
