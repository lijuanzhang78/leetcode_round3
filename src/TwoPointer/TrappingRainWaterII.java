package TwoPointer;

// BFS using priorityQueue
//
public class TrappingRainWaterII {
	class node{
        int x;
        int y;
        int height;
        
        public node(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.height = h;
        }
    }
    
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0) return 0;
        int m = heightMap.length, n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        
        PriorityQueue<node> pq = new PriorityQueue<>((a,b)->(a.height - b.height));
        for(int i = 0; i < n; i++) {
            visited[0][i] = true;
            pq.offer(new node(0,i,heightMap[0][i]));
            visited[m-1][i] = true;
            pq.offer(new node(m-1,i,heightMap[m-1][i]));    
        }
        
        for(int i = 0; i < m; i++) {
            visited[i][0] = true;
            pq.offer(new node(i,0,heightMap[i][0]));
            visited[i][n-1] = true;
            pq.offer(new node(i,n-1,heightMap[i][n-1]));    
        }
        
        int res = 0;
        while(pq.size() > 0) {
            node curr = pq.poll();
            for(int[] dir : dirs) {
                int x = dir[0] + curr.x;
                int y = dir[1] + curr.y;
                if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y]) continue;
                res += Math.max(0,curr.height - heightMap[x][y]);
                pq.offer(new node(x,y,Math.max(curr.height, heightMap[x][y])));
                visited[x][y] = true;
            }
        }
        return res;
    }

}
