package BFS;

public class WallsAndGates {
	public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) return;
        int m = rooms.length;
        int n = rooms[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) q.offer(new int[]{i,j});
            }
        }
        
        int[][] dirs = {{0,1},{0,-1},{-1,0},{1,0}};
        int level = 0;
        while(q.size() > 0) {
            int size = q.size();
            level++;
            for(int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for(int[] dir : dirs) {
                    int x = dir[0]+curr[0];
                    int y = dir[1]+curr[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && rooms[x][y] == Integer.MAX_VALUE) {
                        rooms[x][y] = level;
                        q.offer(new int[]{x,y}); 
                    }
                }
            }
        }
    }

}
