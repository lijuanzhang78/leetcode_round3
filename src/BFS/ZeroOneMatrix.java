package BFS;

// 解法一： BFS: 多源BFS，把所有的0都加入到队列
// 第一次提交的时候把level++的位置写错了
//
public class ZeroOneMatrix {
	public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return new int[0][0];
        int m = matrix.length, n = matrix[0].length;
        Queue<int[]> q = new LinkedList<>();
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    q.offer(new int[]{i,j});
                }
            }
        }
        
        int level = 0;
        int[][] res = new int[m][n];
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        while(q.size() > 0) {
            int size = q.size();
            level++;
            for(int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for(int[] dir : dirs) {
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] == 1 && res[x][y] == 0) {
                        q.offer(new int[]{x,y});
                         res[x][y] = level;                     
                    }
                }
            } 
        }
        return res;    
    }
}

// 解法二： DP？？？？
