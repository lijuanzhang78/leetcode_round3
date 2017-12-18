package BFS;

// BFS: 这道题是已知dest找source，就可以反过来，把已知的dest全部push到queue里面，然后看这些点能够flood fill
// 到matrix中间的哪些点
// 我觉得用flood fill理解更直观
// DFS肯定也能做,反正就是找能连在一起的点
//
public class PacificAtlanticWaterFlow {
	public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return res;
        int m = matrix.length, n = matrix[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        
        Queue<int[]> q1 = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            q1.offer(new int[]{0,i});
            pacific[0][i] = true;
        }
        for(int i = 0; i < m; i++) {
            q1.offer(new int[]{i,0});
            pacific[i][0] = true;            
        }
        bfs(matrix,pacific,q1, m,n);
        
        for(int i = 0; i < n; i++) {
            q1.offer(new int[]{m-1,i});
            atlantic[m-1][i] = true;
        }
        for(int i = 0; i < m; i++) {
            q1.offer(new int[]{i,n-1});
            atlantic[i][n-1] = true;            
        }
        bfs(matrix,atlantic,q1, m,n);
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(pacific[i][j] && atlantic[i][j]) {
                    res.add(new int[]{i,j});
                }
            }
        }
        return res;    
    }
    
    void bfs(int[][] matrix, boolean[][] visited, Queue<int[]> q, int m, int n) {
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        while(q.size() > 0) {
            int[] curr = q.poll();
            for(int[] dir : dirs) {
                int x = dir[0] + curr[0];
                int y = dir[1] + curr[1];
                
                if (x >= 0 && x < m && y >=0 && y < n && !visited[x][y]) {
                    if (matrix[x][y] >= matrix[curr[0]][curr[1]]) {
                        q.offer(new int[]{x,y});
                        visited[x][y] = true;
                    }    
                }
            }    
        }    
    }

}
