package Tree;

//
// 需要使用long型整数 long sum = 0
// List<Double>
//
public class AverageOfLevelsInBinaryTree {
	public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            long sum = 0;
            for(int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                sum += curr.val;
                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }
            res.add(sum/(double)size);
        }
        return res;    
    }

}
