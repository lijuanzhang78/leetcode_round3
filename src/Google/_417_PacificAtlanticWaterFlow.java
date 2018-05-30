package Google;

public class _417_PacificAtlanticWaterFlow {
	public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return res;
        Queue<int[]> qpac = new LinkedList<>();
        Queue<int[]> qatl = new LinkedList<>();
        boolean[][] pacific = new boolean[matrix.length][matrix[0].length];
        boolean[][] atlantic = new boolean[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix[0].length; i++) {
            qpac.offer(new int[]{-1,i});
            qatl.offer(new int[]{matrix.length, i});
        }
        for(int i = 0; i < matrix.length; i++) {
            qpac.offer(new int[]{i,-1});
            qatl.offer(new int[]{i,matrix[0].length});    
        }
        bfs(qpac,pacific,matrix);
        bfs(qatl,atlantic,matrix);
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(new int[]{i,j});
                }
            }
        }
        return res;
    }
    
    void bfs(Queue<int[]> q, boolean[][] visited, int[][] matrix) {
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        int m = matrix.length, n = matrix[0].length;
        while(q.size() > 0) {
            int[] curr = q.poll();
            for(int[] dir : dirs) {
                int x = dir[0] + curr[0];
                int y = dir[1] + curr[1];
                if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || visited[x][y]) continue;
                if (curr[0] < 0 || curr[1] < 0 || curr[0] == matrix.length || curr[1] == matrix[0].length || matrix[curr[0]][curr[1]] <= matrix[x][y]) {
                    q.offer(new int[]{x,y});
                    visited[x][y] = true;
                }
            }    
        }
    }

}
