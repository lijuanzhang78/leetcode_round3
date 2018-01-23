package Graph;

// 当query的结果找不到的时候，返回null，所以dfs的结果类型应该为Double
// 
public class EvaluateDivision {
	public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        if (equations == null || equations.length == 0 || values.length == 0 || queries == null || queries.length == 0) return new double[0];
        
        // build adjacencies
        Map<String, Map<String,Double>> map = new HashMap<>();
        for(int i = 0; i < equations.length; i++) {
            String[] eq = equations[i];
            if (!map.containsKey(eq[0])) {
                map.put(eq[0], new HashMap<String,Double>());
            }
            map.get(eq[0]).put(eq[1],values[i]);
            
            if (!map.containsKey(eq[1])) {
                map.put(eq[1], new HashMap<String,Double>());
            }
            map.get(eq[1]).put(eq[0],1.0/values[i]);    
        }
        
        double[] res = new double[queries.length];
        for(int i = 0; i < queries.length; i++) {
            String[] query = queries[i];
            if (!map.containsKey(query[0]) || !map.containsKey(query[1])) {
                res[i] = -1.0;
                continue;
            }
            if (query[0].equals(query[1])) {
                res[i] = 1.0;
                continue;
            }
            
            Set<String> visited = new HashSet<>();
            visited.add(query[0]);
            
            res[i] = dfs(query[0],visited,map,query[1],1.0);
        }
        return res;
    }
    
    double dfs(String curr, Set<String> visited, Map<String,Map<String,Double>> map,String des, double currRes) {
        if (curr.equals(des)) {
            return currRes;
        }
        
        if (!map.containsKey(curr)) return -1.0;
        for(String adj : map.get(curr).keySet()) {
            if (!visited.contains(adj)) {
                visited.add(adj);
                double res = dfs(adj,visited,map,des,currRes*map.get(curr).get(adj));
                if (res != -1.0) return res;
            }
        }
        return -1.0;
    }    

}
