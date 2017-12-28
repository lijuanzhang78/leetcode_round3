package Tree;

public class PathSumII {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        List<Integer> list = new ArrayList<>();
        helper(root,res,list,sum);
        return res;
    }
    
    void helper(TreeNode root, List<List<Integer>> res, List<Integer> list, int sum) {
        if (sum == root.val && root.left == null && root.right == null) {
            list.add(root.val);
            res.add(new ArrayList<Integer>(list));
            list.remove(list.size()-1);
            return;
        }
        list.add(root.val);
        if (root.left != null) helper(root.left, res, list, sum - root.val);
        if (root.right != null) helper(root.right, res, list, sum - root.val);
        list.remove(list.size()-1);
    }

}
