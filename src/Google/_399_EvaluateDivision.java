package Google;

public class _399_EvaluateDivision {
	class Node {
        String s;
        double val;
        Node(String s, double val) {
            this.s = s;
            this.val = val;
        }
    }
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        if (queries == null || queries.length == 0) return new double[0];
        // build the graph
        Map<String,Map<String,Double>> map = new HashMap<>();
        for(int i = 0; i < equations.length; i++) {
            String[] e = equations[i];
            if (!map.containsKey(e[0])) {
                map.put(e[0], new HashMap<String,Double>());
            }
            map.get(e[0]).put(e[1],values[i]);
            if (Math.abs(values[i]) > 1.0e-6) {
                if (!map.containsKey(e[1])) {
                    map.put(e[1], new HashMap<String,Double>());
                }
                map.get(e[1]).put(e[0],1.0/values[i]);
            }    
        }
        
        double[] res = new double[queries.length];
        for(int i = 0; i < queries.length; i++) {
            if (map.containsKey(queries[i][0]) && queries[i][0].equals(queries[i][1])) {
                res[i] = 1.0; 
            } else {
                res[i] = bfs(queries[i][0], queries[i][1], map);
            }
        }
        return res;
    }
    
    double bfs(String src, String dest, Map<String,Map<String,Double>> map) {
        Map<String,Double> visited = new HashMap<>();
        Queue<String> q = new LinkedList<>();
        q.offer(src);
        visited.put(src,1.0);
        
        while(q.size() > 0) {
            String curr = q.poll();
            if (!map.containsKey(curr)) continue;
            for(String adj : map.get(curr).keySet()) {
                if (visited.containsKey(adj)) continue;
                double value = visited.get(curr)*map.get(curr).get(adj);
                visited.put(adj,value);
                if (adj.equals(dest)) {
                    return value;
                } else {
                    q.offer(adj);
                }
            }   
        }
        return -1.0;
    }

}
