package Google;

public class _685_RedundantConnection {
	public int[] findRedundantDirectedConnection(int[][] edges) {
        if (edges == null || edges.length == 0 || edges[0] == null || edges[0].length == 0) return new int[0];
        int N = edges.length;
        int[] parent = new int[N+1];
        int[] first = null, second = null;
        for(int[] e : edges) {
            if (parent[e[1]] != 0) {
                first = new int[]{parent[e[1]], e[1]}; 
                second = new int[]{e[0],e[1]};
                e[0] = -1; e[1] = -1;
            } else {
                parent[e[1]] = e[0];
            }
        }
        
        // no duplicate now and check for cycle
        int[] root = new int[N+1];
        for(int i = 1; i <= N; i++) {
            root[i] = i;
        }
        for(int[] e : edges) {
            if (e[0] < 0) continue;
            int p0 = findRoot(e[0],root);
            int p1 = findRoot(e[1],root);
            if (p0 == p1) {
                //return e; 错误
                return first == null? e : first; 
            } else {
                root[p1] = p0;
            }
        }
        return second;
    }
    
    int findRoot(int i, int[] root) {
        if (root[i] == i) return i;
        root[i] = findRoot(root[i],root);
        return root[i];
    }

}
