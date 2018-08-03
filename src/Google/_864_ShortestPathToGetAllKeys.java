package Google;

public class _864_ShortestPathToGetAllKeys {
	class Solution {
	    class State{
	        int x,y;
	        int keys;
	        State(int x, int y, int keys) {
	            this.x = x;
	            this.y = y;
	            this.keys = keys;
	        }
	    }
	    public int shortestPathAllKeys(String[] grid) {
	        if (grid == null || grid.length == 0) return 0;
	        int start_x = -1, start_y = -1;
	        Queue<State> q = new LinkedList<>();
	        int m = grid.length, n = grid[0].length();
	        int max = 0;
	        Set<String> visited = new HashSet<>();

	        for(int i = 0; i < m; i++) {
	            for(int j = 0; j < n; j++) {
	                char c = grid[i].charAt(j);
	                if (c == '@') {
	                    start_x = i;
	                    start_y = j;
	                    q.offer(new State(start_x,start_y,0));
	                    visited.add(start_x+","+start_y+","+0);
	                } else if (c >= 'a' && c <= 'z') {
	                    max = Math.max(max,c-'a'+1); // 错误
	                }
	            }
	        }
	            
	        int level = 0;
	        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
	        while(q.size() > 0) {
	            int size = q.size();
	            for(int i = 0; i < size; i++) {
	                State curr = q.poll();
	                if (curr.keys == (1 << max) -1) {
	                    return level;
	                }
	                for(int[] d : dirs) {
	                    int x = d[0] + curr.x;
	                    int y = d[1] + curr.y;
	                    int keys = curr.keys;
	                    if (x < 0 || x >= m || y < 0 || y >= n) continue;
	                    if (grid[x].charAt(y) == '#') continue;
	                    if (grid[x].charAt(y) >= 'a' && grid[x].charAt(y) <= 'z') {
	                        keys = keys | 1 << (grid[x].charAt(y)-'a');
	                    } else if (grid[x].charAt(y) >= 'A' && grid[x].charAt(y) <= 'Z') {
	                        if (((keys >> (grid[x].charAt(y)-'A')) & 1) == 0) continue;
	                    }
	                    if (visited.contains(x+","+y+","+keys)) continue;
	                    visited.add(x+","+y+","+keys);
	                    q.offer(new State(x,y,keys));
	                }
	            }
	            level++;
	        }
	        return -1;
	    }
	}

}
