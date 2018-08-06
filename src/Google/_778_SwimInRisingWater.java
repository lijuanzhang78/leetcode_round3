package Google;

public class _778_SwimInRisingWater {
	class Node{
        int i, j;
        Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    
    public int swimInWater(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        Queue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>() {
            public int compare(Node a, Node b) {
                return grid[a.i][a.j] - grid[b.i][b.j];
            }
        });
        pq.offer(new Node(0,0));
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        int maxDays = 0;
        while(pq.size() > 0) {
            Node curr = pq.poll();
            maxDays = Math.max(maxDays,grid[curr.i][curr.j]);
            for(int[] dir : dirs) {
                int x = dir[0]+curr.i;
                int y = dir[1]+curr.j;
                if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y]) continue;
                if (x == n-1 && y == n-1) {
                    return Math.max(maxDays,grid[n-1][n-1]);
                }
                pq.offer(new Node(x,y));
                visited[x][y] = true;
            }
        }
        return -1;
    }

}
