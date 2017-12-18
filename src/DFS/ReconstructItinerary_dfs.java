package DFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReconstructItinerary_dfs {
	public List<String> findItinerary(String[][] tickets) {
        if (tickets == null || tickets.length == 0 || tickets[0] == null || tickets[0].length == 0) return new ArrayList<String>();
        
        Map<String,List<String>> map = new HashMap<>();
        for(String[] t : tickets) {
            if (!map.containsKey(t[0])) {
                map.put(t[0], new ArrayList<String>());
            }
            map.get(t[0]).add(t[1]);
        }
        
        for(Map.Entry<String,List<String>> entry : map.entrySet()) {
            Collections.sort(entry.getValue());
        }
        
        List<String> res = new ArrayList<>();
        res.add("JFK");
        findRoute(map,res,tickets.length+1,"JFK");
        return res;
    }
    
    boolean findRoute(Map<String,List<String>> map, List<String> res, int total, String departure) {
        if (res.size() == total) return true;
        
        if (!map.containsKey(departure)) return false;
        List<String> adjList = map.get(departure);
        for(int i = 0; i < adjList.size(); i++) {
            String arrival = adjList.get(i);
            res.add(arrival);
            adjList.remove(i);
            if(findRoute(map,res,total,arrival)) return true;
            res.remove(res.size()-1);
            adjList.add(i,arrival);
        }
        return false;   
    }  
}
