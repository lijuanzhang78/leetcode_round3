package Google;

public class _797_AllPathsFromSourceToTarget {
	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        if (graph == null || graph.length == 0 || graph[0] == null || graph[0].length == 0) return new ArrayList<List<Integer>>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(graph,list,res,0);
        return res;
    }
    
    void dfs(int[][] graph, List<Integer> list, List<List<Integer>> res, int curr) {
        if (curr == graph.length - 1) {
            list.add(curr);
            res.add(new ArrayList<Integer>(list));
            list.remove(list.size()-1);
            return;
        }
        
        list.add(curr);
        for(int adj : graph[curr]) {
            dfs(graph,list,res,adj);
        }
        list.remove(list.size()-1);
    }

}
