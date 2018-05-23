package Google;

public class _815_BusRoutes {
	public int numBusesToDestination(int[][] routes, int S, int T) {
        if (routes == null || routes.length == 0) return 0;
        // build the adjcency lists where key is the bus stop and the corresponding list contains the bus #
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < routes.length; i++) {
            for(int j = 0; j < routes[i].length; j++) {
                if (!map.containsKey(routes[i][j])) {
                    map.put(routes[i][j], new ArrayList<Integer>());
                }
                map.get(routes[i][j]).add(i);
            }
        }
        if (S == T) return 0;
        
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        //Set<Integer> visitedbus = new HashSet<>();
        int level = 0; 
        q.offer(S); 
        while(!q.isEmpty()) {
            int size = q.size();
            level++;
            for(int i = 0; i < size; i++) {
                int curr = q.poll(); // curr stop
                for(int bus : map.get(curr)) { // get the buses passing curr stop
                    if (visited.contains(bus)) continue;
                    visited.add(bus);
                    for(int stop : routes[bus]) { // get all stops that this bus stops
                        if (stop == T) return level;
                        q.offer(stop);
                    }
                }
            }
        }
        return -1;
    }

}
