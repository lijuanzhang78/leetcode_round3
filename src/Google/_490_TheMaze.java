package Google;

public class _490_TheMaze {
	public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0) return false;
        int m = maze.length, n = maze[0].length;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start[0]*n+start[1]);
        Set<Integer> visited = new HashSet<>();
        visited.add(start[0]*n+start[1]);
        
        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        while(q.size() > 0) {
            int curr = q.poll();
            int r = curr/n, c = curr%n;
            if (r == destination[0] && c == destination[1]) return true;
            for(int[] d : dirs) {
                int nr = r, nc = c;
                while(nr >= 0 && nr < m && nc >= 0 && nc < n && maze[nr][nc] == 0) {
                    nr += d[0];
                    nc += d[1];
                }
                nr -= d[0]; 
                nc -= d[1];
                if (visited.contains(nr*n+nc)) continue;
                q.offer(nr*n+nc);
                visited.add(nr*n+nc);    
            }
        }
        return false;
    }
}
