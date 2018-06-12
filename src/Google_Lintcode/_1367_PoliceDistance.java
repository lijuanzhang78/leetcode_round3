package Google_Lintcode;

public class _1367_PoliceDistance {
	public int[][] policeDistance(int[][] matrix ) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return new int[0][0];
        
        int m = matrix.length, n = matrix[0].length;
        int[][] res = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    q.offer(new int[]{i,j});
                }
            }
        }
        
        int level = 0;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        while(q.size() > 0) {
            int size = q.size();
            level++;
            for(int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for(int[] dir : dirs) {
                    int x = dir[0]+curr[0];
                    int y = dir[1]+curr[1];
                    if (x < 0 || x >= m || y < 0 || y >= n) continue;
                    if (matrix[x][y] == -1) {
                        res[x][y] = -1;
                        continue;
                    }
                    if (matrix[x][y] != 0) continue;
                    matrix[x][y] = 2;
                    res[x][y] = level;
                    q.offer(new int[]{x,y});
                }
            }
        }
        return res;
    }

}
