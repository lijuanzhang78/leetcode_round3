package Tree;

public class MostFrequentSubtreeSum {
	int max = Integer.MIN_VALUE;
    //Map<Integer,Integer> map = new HashMap<>();
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) return new int[0];
        Map<Integer,Integer> map = new HashMap<>();
        dfs(root, map);
        List<Integer> list = new ArrayList<>();
        for(int key : map.keySet()) {
            if (map.get(key) == max) list.add(key);
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
    
    int dfs(TreeNode root, Map<Integer,Integer> map) {
        if (root == null) return 0;
        int left = dfs(root.left,map);
        int right = dfs(root.right,map);
        int res = left + right + root.val;
        if (!map.containsKey(res)) {
            map.put(res,0);
        }
        map.put(res, map.get(res)+1);
        if (map.get(res) > max) max = map.get(res);
        return res;
    }

}
