package BFS;

// 最好用Map<Integer,Set<Integer>> to represent the adjacency， 而不是List<List<Integer>>
// 在做bfs的时候，注意判断条件是 while(n > 2), 而不是 while(q.size() > 2)
//
public class MinimumHeightTree {
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<Integer>();
        if (n == 1) return Collections.singletonList(0);
        
        Map<Integer,Set<Integer>> map = new HashMap<>();
        for(int[] edge : edges) {
            int v0 = edge[0];
            int v1 = edge[1];
            if (!map.containsKey(v0)) {
                map.put(v0, new HashSet<Integer>());
            }
            if (!map.containsKey(v1)) {
                map.put(v1, new HashSet<Integer>());
            }
            map.get(v0).add(v1);
            map.get(v1).add(v0);
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if (map.get(i).size() == 1) {
                q.offer(i);
            }    
        }
        
        while(n > 2) {
            int size = q.size();
            for(int isize = 0; isize < size; isize++) {
                int curr = q.poll();
                n--;
                for(int adj : map.get(curr)) {
                    map.get(adj).remove(curr);
                    if (map.get(adj).size() == 1) q.offer(adj);
                }    
            }
        }
        
        while(q.size() > 0) {
            res.add(q.poll());
        }
        return res;   
    }

}
