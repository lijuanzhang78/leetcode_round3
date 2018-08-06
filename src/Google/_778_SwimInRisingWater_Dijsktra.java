package Google;

public class _778_SwimInRisingWater_Dijsktra {
	public int swimInWater(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int[][] days = new int[m][n]; 
        Queue<int[]> pq = new PriorityQueue<int[]>((a,b)->(days[a[0]][a[1]] - days[b[0]][b[1]]));
            
        pq.offer(new int[]{0,0});
        boolean[][] visited = new boolean[m][n];
        for(int[] d : days) Arrays.fill(d,Integer.MAX_VALUE);
        days[0][0] = grid[0][0];
        
        
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        while(pq.size() > 0) {
            int[] curr = pq.poll();
            if (visited[curr[0]][curr[1]]) continue;
            if (curr[0] == m-1 && curr[1] == n-1) return days[m-1][n-1];
            visited[curr[0]][curr[1]] = true;
            
            for(int[] dir : dirs) {
                int x = dir[0]+curr[0];
                int y = dir[1]+curr[1];
                if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y]) continue;
                if (days[x][y] > Math.max(days[curr[0]][curr[1]],grid[x][y])) {
                    days[x][y] = Math.max(days[curr[0]][curr[1]],grid[x][y]);
                    pq.offer(new int[]{x,y});
                }    
            }
        }
        return -1;
    }

}
