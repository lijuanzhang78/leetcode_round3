package DFS;

public class AccountMerge {
	public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (accounts == null || accounts.size() == 0) return res;
        Map<String,String> map = new HashMap<>();
        // mapping: first email -> account name
        for(List<String> a : accounts) {
            map.put(a.get(1),a.get(0));
        }
        
        Map<String,List<String>> adjList = new HashMap<>();
        for(List<String> a : accounts) {
            if (!adjList.containsKey(a.get(1))) {
                adjList.put(a.get(1),new ArrayList<String>());
            }
            for(int i = 2; i < a.size(); i++) {
                adjList.get(a.get(1)).add(a.get(i));
                if (!adjList.containsKey(a.get(i))) {
                    adjList.put(a.get(i),new ArrayList<String>());
                }
                adjList.get(a.get(i)).add(a.get(1));
            }
        }
        Set<String> visited = new HashSet<>();
        for(String source : map.keySet()) {
            if(!visited.contains(source)) {
                Queue<String> q = new PriorityQueue<>();
                dfs(source,visited,adjList,q);
                List<String> merged = new ArrayList<>();
                merged.add(map.get(source));
                while(!q.isEmpty()) {
                    merged.add(q.poll());
                }
                res.add(merged);
            }
        }        
        return res;        
    }
                
    void dfs(String source, Set<String> visited, Map<String,List<String>> adjList, Queue<String> q) {
        visited.add(source);
        q.offer(source);
        if (!adjList.containsKey(source)) return;
        for(String adj : adjList.get(source)) {
            if (!visited.contains(adj)) {
                dfs(adj,visited,adjList,q);
            }
        }
    }

}
