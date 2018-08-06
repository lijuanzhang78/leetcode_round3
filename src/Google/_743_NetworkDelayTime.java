package Google;

public class _743_NetworkDelayTime {
	public void buildGraph(Map<Integer,Map<Integer,Integer>> map, int[][] times) {
        for(int[] t : times) {
            if (!map.containsKey(t[0]-1)) {
                map.put(t[0]-1, new HashMap<Integer,Integer>());
            }
            map.get(t[0]-1).put(t[1]-1,t[2]);
        }
    }
    
    public int networkDelayTime(int[][] times, int N, int K) {
        if (times == null || times.length == 0 || times[0] == null || times[0].length == 0) return 0;
        
        Queue<int[]> q = new PriorityQueue<int[]>((a,b)->(a[1]-b[1]));
        Set<Integer> visited = new HashSet<>();
        int[] dist = new int[N];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[K-1] = 0;
        
        
        q.offer(new int[]{K-1,0});
        Map<Integer,Map<Integer,Integer>> map = new HashMap<>();
        buildGraph(map,times);
        int max = Integer.MIN_VALUE;
        
        while(q.size() > 0) {
            int[] curr = q.poll();
            if (visited.contains(curr[0])) continue;
            visited.add(curr[0]);
            max = Math.max(max,curr[1]);
            dist[curr[0]] = curr[1];
            
            if (map.containsKey(curr[0])) {
                for(int adj : map.get(curr[0]).keySet()) {
                    if (visited.contains(adj)) continue;
                    if (map.get(curr[0]).get(adj) + curr[1] < dist[adj]) {
                        dist[adj] = map.get(curr[0]).get(adj) + dist[curr[0]];
                        q.offer(new int[]{adj,dist[adj]});
                    }
                }
            }
        }
        if (visited.size() != N) return -1;
        return max;
    }

}
