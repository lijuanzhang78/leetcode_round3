package UnionFind;

// parents array needs to be filled as -1, in order to filter those '0' element
//
public class NumberOfIslandsII {
	int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    int[] parents;
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        if (positions == null || positions.length == 0 || positions[0] == null || positions[0].length == 0) return new ArrayList<Integer>();
        List<Integer> res = new ArrayList<>();
        parents = new int[m*n];
        Arrays.fill(parents,-1); // need to fill parents array to -1, in order to filter those '0' element
        int count = 0;
        for(int i = 0; i < positions.length; i++) {
            int[] pos = positions[i]; // good use!
            count++;
            parents[pos[0]*n+pos[1]] = pos[0]*n+pos[1];
            for(int[] dir : dirs) {
                int x = dir[0] + pos[0];
                int y = dir[1] + pos[1];
                if (x < 0 || x >= m || y < 0 || y >= n || parents[x*n+y] == -1) continue;
                int p1 = findSet(pos[0]*n+pos[1]), p2 = findSet(x*n+y);
                if (p1 != p2) {
                    count--;
                    union(p1,p2);
                }
            }
            res.add(count);
        }
        return res;
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
