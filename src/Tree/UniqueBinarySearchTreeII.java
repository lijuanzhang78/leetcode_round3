package Tree;

// 注意这道题的recursion return结果的方式!
// 因为需要return所有的root，那么root最好在loop内部建立
//
public class UniqueBinarySearchTreeII {
	public List<TreeNode> generateTrees(int n) {
        if (n <= 0) return new ArrayList<TreeNode>();
        return buildTree(1,n);
    }
    
    List<TreeNode> buildTree(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }
        for(int i = start; i <= end; i++) {
            //TreeNode root = new TreeNode(i);
            List<TreeNode> left = buildTree(start,i-1);
            List<TreeNode> right = buildTree(i+1,end);
            for(TreeNode lnode : left) {
                for(TreeNode rnode : right) {
                    TreeNode root = new TreeNode(i); // 注意root建立的地方！！！！
                    root.left = lnode;
                    root.right = rnode;
                    res.add(root);
                }
            }
        }
        return res;
    }

}
