package Tree;

// use DFS and depth
// can use BFS
// details: it is res.set, instead of res.add
//
public class FindLargestValueInEachTreeRow {
	public List<Integer> largestValues(TreeNode root) {
        if (root == null) return new ArrayList<Integer>();
        List<Integer> res = new ArrayList<>();
        largestValues(root,0,res);
        return res;
    }
    
    void largestValues(TreeNode root, int depth, List<Integer> res) {
        if (root == null) return;
        if (res.size() == depth) {
            res.add(root.val);
        } else {
            res.set(depth, Math.max(res.get(depth), root.val)); // details
        }
        largestValues(root.left,depth+1,res);
        largestValues(root.right,depth+1,res);
    }

}
