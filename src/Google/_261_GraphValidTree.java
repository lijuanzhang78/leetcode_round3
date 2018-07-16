package Google;

public class _261_GraphValidTree {
	public boolean validTree(int n, int[][] edges) {
        if (n <= 0) return false;
        int[] parents = new int[n];
        for(int i = 0; i < n; i++) {
            parents[i] = i;
        }
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for(int[] e : edges) {
            adjList.get(e[0]).add(e[1]);
            adjList.get(e[1]).add(e[0]);
        }
        for(int[] e : edges) {
            int p0 = findParent(e[0],parents);
            int p1 = findParent(e[1],parents);
            if (p0 == p1) return false;
            parents[p1] = p0;
        }
        for(int i = 1; i < parents.length; i++) {
            //if (parents[i] != parents[i-1]) return false;
            if (findParent(i,parents) != findParent(0,parents)) return false;
        }
        return true;
    }
    
    int findParent(int v, int[] parents) {
        if (parents[v] == v) return v;
        parents[v] = findParent(parents[v],parents);
        return parents[v];
    }

}
