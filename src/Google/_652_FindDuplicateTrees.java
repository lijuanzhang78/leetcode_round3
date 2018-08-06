package Google;

public class _652_FindDuplicateTrees {
	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        if (root == null) return res;
        postOrder(res,new HashMap<String,Integer>(),root);
        return res;
    }
    
    String postOrder(List<TreeNode> res, Map<String,Integer> map, TreeNode root) {
        if (root == null) return "#";
        String left = postOrder(res,map,root.left);
        String right = postOrder(res,map,root.right);
        String s = root.val+"-"+left+"-"+right;
        if (map.containsKey(s) && map.get(s) == 1) {
            res.add(root);
        } 
        if (!map.containsKey(s)) {
            map.put(s,0);
        }
        map.put(s,map.get(s)+1);
        return s;
    }

}
