package Google;

public class _787_CheapestFlightsWIthKStops {
	Map<Integer,List<node>> map = new HashMap<>();
    class node{
        int tocity;
        int cost;
        node(int tocity, int cost) {
            this.tocity = tocity;
            this.cost = cost;
        }
    }
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        createAdjacency(flights);
        int[] costs = new int[n];
        Arrays.fill(costs,Integer.MAX_VALUE);
        costs[src] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        int stop = 0;
        while(q.size() > 0 && stop <= K) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int curr = q.poll();
                
                if (!map.containsKey(curr)) continue;
                for(node adj : map.get(curr)) {
                    if (stop == K && adj.tocity != dst) continue;
                    if (costs[adj.tocity] > costs[curr] + adj.cost) {
                        costs[adj.tocity] = costs[curr] + adj.cost;
                        q.offer(adj.tocity);
                    }
                }
            }
            stop++;
        }
        
        return costs[dst] == Integer.MAX_VALUE? -1 : costs[dst];
    }
    
    private void createAdjacency(int[][] flights) {
        for(int[] f : flights) {
            if (!map.containsKey(f[0])) {
                map.put(f[0], new ArrayList<node>());
            }
            map.get(f[0]).add(new node(f[1], f[2]));
        }
    } 

}
