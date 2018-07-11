package Google;

public class _803_BricksFallingWhenHit {
	
    
    public static void main(String[] args) {
    	//int[][] grid = {{1,0,0,0},{1,1,1,0}};
    	//int[][] hits = {{1,0}};
    	//int[][] grid = {{1},{1},{1},{1},{1}};
    	//int[][] hits = {{3,0},{4,0},{1,0},{2,0},{0,0}};
    	int[][] grid = {{1,0,1},{0,0,1}};
    	int[][] hits = {{1,0},{0,0}};
    	
    	int[] res = new _803_BricksFallingWhenHit().hitBricks(grid, hits);
    	return;
    }class unionFind {
        int[] parents;
        int[] size;
        int N;
        unionFind(int N) {
            parents = new int[N+1];
            size = new int[N+1];
            this.N = N;
            for(int i = 0; i < parents.length; i++) {
                parents[i] = i;
                size[i] = 1;
            }    
        }
        
        int findParent(int i) {
            if (parents[i] == i) return i;
            parents[i] = findParent(parents[i]);
            return parents[i];
        }
        
        void union(int i, int j) {
            int pi = findParent(i);
            int pj = findParent(j);
            if (pi != pj) { // always use the larger root as the new root
                if (pi > pj) {
                    parents[pj] = pi;
                    size[pi] += size[pj];
                } else {
                    parents[pi] = pj;
                    size[pj] += size[pi];
                }
            }    
        }
        
        int total() {
            return size[N]-1;
        }
    }
    
    
    public int[] hitBricks(int[][] grid, int[][] hits) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return new int[0];
        int m = grid.length, n = grid[0].length;
        for(int[] hit : hits) {
            if (grid[hit[0]][hit[1]] == 1) grid[hit[0]][hit[1]] = 2; // 如果原来就是0就不用remove了  
        }
        // create the final connected components
        unionFind UF = new unionFind(m*n);
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] != 1) continue;
                if (i == 0) {
                    UF.union(j,m*n);
                }
                if (i > 0 && grid[i-1][j] == 1) {
                    UF.union((i-1)*n+j,i*n+j);
                }
                if (j > 0 && grid[i][j-1] == 1) {
                    UF.union(i*n+j-1,i*n+j);
                }    
            }
        }
        
        int prevTotal = UF.total();
        int remove = hits.length;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        int[] res = new int[hits.length];
        while(remove > 0) {
            int[] hit = hits[remove-1];
            if (grid[hit[0]][hit[1]] != 2) {
                remove--; // 错误
                continue;
            }
            grid[hit[0]][hit[1]] = 1;
            if (hit[0] == 0) UF.union(m*n,hit[0]*n+hit[1]); // 如果是top row，需要跟root unite
            for(int[] dir : dirs) {
                int x = dir[0] + hit[0];
                int y = dir[1] + hit[1];
                if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != 1) continue;
                UF.union(x*n+y,hit[0]*n+hit[1]);
            }
            int total = UF.total();
            res[remove-1] = total-prevTotal-1 > 0? total-prevTotal-1 : 0; // 如果加上的元素并不能增加total
            remove--;
            prevTotal = total;
        }
        return res;    
    }
}
