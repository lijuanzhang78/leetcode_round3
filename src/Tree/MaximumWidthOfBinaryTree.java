package Tree;

public class MaximumWidthOfBinaryTree {public int widthOfBinaryTree(TreeNode root) {
    if (root == null) return 0;
    int res = 1; // only root
    Map<TreeNode, Integer> map = new HashMap<>();
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    map.put(root,1);
    while(!q.isEmpty()) {
        int size = q.size(), begin = 0, end = 0;
        for(int i = 0; i < size; i++) {
            TreeNode parent = q.poll();
            if (i == 0) begin = map.get(parent);
            if (i == size - 1) {
                end = map.get(parent);
                res = Math.max(res,end-begin+1);
            }
            if (parent.left != null) {
                q.offer(parent.left);
                map.put(parent.left,2*map.get(parent));
            }
            if (parent.right != null) {
                q.offer(parent.right);
                map.put(parent.right,2*map.get(parent) + 1);
            }
        }   
    }
    return res;
}

}
