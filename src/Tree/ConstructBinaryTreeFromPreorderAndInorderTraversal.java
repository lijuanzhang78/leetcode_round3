package Tree;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) return null;
        if (preorder.length != inorder.length) return null;
        return helper(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }
    
    TreeNode helper(int[] preorder, int[] inorder, int pstart, int pend, int istart, int iend) {
        if (istart > iend) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pstart]);
        int rootpos = findPos(preorder[pstart], inorder, istart, iend);
        root.left = helper(preorder,inorder,pstart+1,pstart+(rootpos-istart),istart,rootpos-1);
        root.right = helper(preorder,inorder,pend-(iend-rootpos)+1,pend,rootpos+1,iend);
        return root;
    }
    
    int findPos(int val, int[] inorder, int start, int end) {
        for(int i = 0; i < inorder.length; i++) {
            if (inorder[i] == val) {
                return i;
            }
        }
        return 0;
    }
    
    public static void main(String[] args) {
    	int[] preorder = {1,2};
    	int[] inorder = {2,1};
    	TreeNode root = new ConstructBinaryTreeFromPreorderAndInorderTraversal().buildTree(preorder, inorder);
    	return;
    }
}
