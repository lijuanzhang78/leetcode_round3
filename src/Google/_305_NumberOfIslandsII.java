package Google;

public class _305_NumberOfIslandsII {
	int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    int m, n;
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        if (positions == null || positions.length == 0 || positions[0] == null || positions[0].length == 0) return res;
        this.m = m;
        this.n = n;
        int count = 0;
        int[] root = new int[m*n];
        Arrays.fill(root,-1);
        for(int[] pos : positions) {
            count++;
            root[pos[0]*n+pos[1]]= pos[0]*n + pos[1];
            for(int[] dir : dirs) {
                int x = dir[0] + pos[0];
                int y = dir[1] + pos[1];
                if (x < 0 || x >= m || y < 0 || y >= n || root[x*n+y] == -1) continue;
                int p_pos = findRoot(pos[0]*n+pos[1],root);
                int p_nei = findRoot(x*n+y,root);
                if (p_pos != p_nei) {
                    root[p_pos] = p_nei; 
                    count--;
                }
            }
            res.add(count);
        }
        return res;
    }
    
    int findRoot(int i,int[] root) {
        if (root[i] == i) return i;
        root[i] = findRoot(root[i],root);
        return root[i];
    }

}
