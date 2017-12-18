package UnionFind;

// 注意find函数的写法，之前写成while(parent[v] != v)
// 结果就是time limit exceeded
//
public class RedundantConnection {
	public int[] findRedundantConnection(int[][] edges) {
        if (edges == null || edges.length == 0 || edges[0] == null || edges[0].length == 0) return new int[2];
        int numV = edges.length;
        int[] parent = new int[numV+1];
        for(int i = 0; i <= numV; i++) {
            parent[i] = i;
        }
        
        for(int[] e : edges) {
            if (find(e[0],parent) == find(e[1],parent)) {
                return e;
            } else {
                parent[parent[e[0]]] = parent[e[1]];
            }
        }
        return new int[2];
    }
    
    int find(int v, int[] parent) {
        if(parent[v] != v) {
            parent[v] = find(parent[v],parent);
        }
        return parent[v];
    }
}
