package Graph;

public class FindEventualSafeState {
	public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        if (graph == null || graph.length == 0) return res;
        int[] color = new int[graph.length];
        for(int i = 0; i < graph.length; i++) {
            color[i] = 0; // unvisited
        }
        
        for(int i = 0; i < graph.length; i++) {
            if (color[i] == 0) {
                dfs(i,color,graph);
            }
        }
        
        for(int i = 0; i < graph.length; i++) {
            if (color[i] == 2) res.add(i);
        }
        return res;
    }
    
    boolean dfs(int source, int[] color, int[][] graph) {
        color[source] = 1;
        for(int adj : graph[source]) {
            if (color[adj] == 1) {
                return false;
            } 
            if (color[adj] == 0) {
                if(!dfs(adj,color,graph)) return false;
            }
        }
        color[source] = 2;
        return true;   
    }

}
