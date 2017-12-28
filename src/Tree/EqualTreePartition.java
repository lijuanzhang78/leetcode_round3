package Tree;
//
// 注意要加上条件：root != rootorig
//
public class EqualTreePartition {
	public boolean checkEqualTree(TreeNode root) {
        Set<Integer> set = new HashSet<>();
        int sum = dfs(root,set,root);
        return sum%2 == 0 && set.contains(sum/2);
    }
    
    int dfs(TreeNode root, Set<Integer> set, TreeNode rootorig) {
        if (root == null) return 0;
        int left = dfs(root.left,set,rootorig);
        int right = dfs(root.right,set,rootorig);
        int sum = left + right + root.val;
        if (!set.contains(sum) && root != rootorig) set.add(sum);
        return sum;
    }

}
