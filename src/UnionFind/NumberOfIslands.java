package UnionFind;

// 1: union: it is to union the parent of two nodes, not the two nodes themselves
// 2: the index of parents array: it should be i*n+j, where n is the number of columns
// 3: need to convert 2D id to 1D id, using i*n+j;
//
public class NumberOfIslands {
	int parents[];
    int count = 0;
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        parents = new int[m*n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    parents[i*n+j] = i*n+j;
                }
            }
        }
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    for(int[] dir : dirs) {
                        int x = dir[0] + i;
                        int y = dir[1] + j;
                        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == '0') continue;
                        if (findSet(i*n+j) != findSet(x*n+y)) {
                            union(findSet(i*n+j),findSet(x*n+y));
                            count--;
                        }
                    }    
                }
            }
        }
        return count;
    }
    
    int findSet(int id) {
        if (parents[id] == id) return id;
        parents[id] = findSet(parents[id]);
        return parents[id];
    }
    
    void union(int id1, int id2) {
        parents[id1] = id2;
    }

}
