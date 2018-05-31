package Google;

public class _684_RedundantConnection {
	public int[] findRedundantConnection(int[][] edges) {
        if (edges == null || edges.length == 0 || edges[0] == null || edges[0].length == 0) return new int[0];
        int N = edges.length;
        int[] parent = new int[N];
        for(int i = 0; i < N; i++) {
            parent[i] = i;
        }
        int[] res = new int[2];
        for(int[] e : edges) {
            int p0 = findParent(parent,e[0]-1);
            int p1 = findParent(parent,e[1]-1);
            if (p0 == p1) {
                res[0] = e[0];
                res[1] = e[1];
                break;
            } else {
                parent[p0] = p1;
            }
        }
        return res;
    }
    
    int findParent(int[] parent, int i) {
        if (i == parent[i]) return parent[i];
        parent[i] = findParent(parent, parent[i]);
        return parent[i];
    }

}
