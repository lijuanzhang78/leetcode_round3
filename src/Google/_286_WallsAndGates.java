package Google;

public class _286_WallsAndGates {
	public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0] == null || rooms[0].length == 0) return;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < rooms.length; i++) {
            for(int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    q.offer(new int[]{i,j});
                }
            }
        }
        
        int level = 0;
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        int m = rooms.length, n = rooms[0].length;
        while(q.size() > 0) {
            int size = q.size();
            level++;
            for(int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for(int[] dir : dirs) {
                    int x = dir[0]+curr[0];
                    int y = dir[1] + curr[1];
                    if (x < 0 || x >= m || y < 0 || y >= n || rooms[x][y] != Integer.MAX_VALUE) continue;
                    q.offer(new int[]{x,y});
                    rooms[x][y] = level;
                }
            }
        }
        return;
    }

}
