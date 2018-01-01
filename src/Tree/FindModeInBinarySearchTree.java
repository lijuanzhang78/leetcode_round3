package Tree;

public class FindModeInBinarySearchTree {
	int maxcount = -1;
    TreeNode prev = null;
    int count = 0;
    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        List<Integer> list = new ArrayList<>();
        inorder(root,list);
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
    
    void inorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        inorder(root.left,res);
        if (prev != null) {
            if (prev.val == root.val) {
                count++;
            } else {
                count = 1;
            }
        } else {
            count = 1;
        }
        
        if (count > maxcount) {
            maxcount = count;
            res.clear();
            res.add(root.val);
        } else  if (count == maxcount){
            res.add(root.val);
        }
        
        prev = root;
        inorder(root.right,res);
    }

}
