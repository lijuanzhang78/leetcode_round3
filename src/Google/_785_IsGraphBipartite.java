package Google;

public class _785_IsGraphBipartite {
	public boolean isBipartite(int[][] graph) {
        if (graph == null || graph.length == 0) return false;
        int[] colors = new int[graph.length]; // 1 && 2
        for(int i = 0; i < graph.length; i++) {
            if (colors[i] == 0) {
                colors[i] = 1;
                if(!dfs(colors,graph,i)) return false;
            }
        }
        return true;
    }
    
    boolean dfs(int[] colors, int[][] graph, int curr) {
        for(int adj : graph[curr]) {
            if (colors[adj] != 0 && colors[adj] == colors[curr]) return false;
            if (colors[adj] != 0 && colors[adj] != colors[curr]) continue;
            if (colors[curr] == 1) {
                colors[adj] = -1;
            } else {
                colors[adj] = 1;
            }
            if (!dfs(colors,graph,adj)) return false;
        }
        return true;
    }

}
