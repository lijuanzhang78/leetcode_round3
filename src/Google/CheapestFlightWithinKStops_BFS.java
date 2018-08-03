package Google;

public class CheapestFlightWithinKStops_BFS {
	int min;
    class Node{
        int city;
        int cost;
        Node(int city, int cost) {
            this.city = city;
            this.cost = cost;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        if (flights == null || flights.length == 0) return 0;
        min = Integer.MAX_VALUE;
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(src,0));
        int level = 0;
        while(q.size() > 0) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                Node curr = q.poll();
                if (curr.city == dst) {
                    min = Math.min(min,curr.cost);
                }
                for(int[] f : flights) {
                    if (f[0] == curr.city) {
                        if (f[2]+curr.cost > min) continue;
                        q.offer(new Node(f[1],f[2]+curr.cost));
                    }
                }
            }
            level++;
            if (level > K+1) break;
        }
        return min == Integer.MAX_VALUE? -1 : min;    
    } 

}
