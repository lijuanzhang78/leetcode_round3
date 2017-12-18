package DFS;

// 可以用DFS， BFS，union find做
// 判断一个无向图是否为树，需要满足：
// （1）是否有环
//  (2) 是否所有节点都连在一起 -->> 这个容易忘记
// 
// 解法一： DFS
//
public class GraphValidTree {
	public boolean validTree_1(int n, int[][] edges) {
        if (edges == null || edges.length == 0 || edges[0] == null || edges[0].length == 0) {
            if (n == 1) return true;
            return false;
        }
        Map<Integer,Set<Integer>> map = new HashMap<>();
        for(int[] e : edges) {
            if (!map.containsKey(e[0])) {
                map.put(e[0],new HashSet<Integer>());
            }
            if (!map.containsKey(e[1])) {
                map.put(e[1], new HashSet<Integer>());
            }
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }
        boolean[] visited = new boolean[n];
        
        if(!dfs(map,n,visited,0,-1)) return false;
        
        for(int i = 0; i < n; i++) {
            if (!visited[i]) return false;
        }
        return true;
    }
    
    boolean dfs(Map<Integer,Set<Integer>> map, int n, boolean[] visited, int source, int parent) {
        visited[source] = true;
        if (map.containsKey(source)) {
            for(int adj : map.get(source)) {
                if (adj == parent) continue;
                if (visited[adj]) return false;
                if(!dfs(map,n,visited,adj,source)) return false;
            }
            return true;
            
        } else {
            return false;
        }
    }
    
    //
    // 解法二： BFS
    // 因为在loop over相邻的节点时，需要skip 他的parent，这里做了这样一个处理：
    // map.get(adj).remove(curr);---> 这个非常值得借鉴
    //
    public boolean validTree_2(int n, int[][] edges) {
        if (edges == null || edges.length == 0 || edges[0] == null || edges[0].length == 0) {
            if (n == 1) return true;
            return false;
        }
        Map<Integer,Set<Integer>> map = new HashMap<>();
        for(int[] e : edges) {
            if (!map.containsKey(e[0])) {
                map.put(e[0],new HashSet<Integer>());
            }
            if (!map.containsKey(e[1])) {
                map.put(e[1], new HashSet<Integer>());
            }
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }
        boolean[] visited = new boolean[n];
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(0); visited[0] = true;
        while(q.size() > 0) {
            int curr = q.poll();
            if (!map.containsKey(curr)) return false;
            for(int adj : map.get(curr)) {
                if (visited[adj]) return false;
                map.get(adj).remove(curr);
                q.add(adj);
                visited[adj] = true;
            }
        }
        for(int i = 0; i < n; i++) {
            if (!visited[i]) return false;
        }
        return true;
    }
    
    // 解法三：union find

}
