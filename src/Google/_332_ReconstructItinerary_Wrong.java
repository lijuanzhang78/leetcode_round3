package Google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _332_ReconstructItinerary_Wrong {
	public List<String> findItinerary(String[][] tickets) {
        List<String> res = new ArrayList<>();
        if (tickets == null || tickets.length == 0) return res;
        Map<String, List<String>> map = new HashMap<>();
        for(String[] t : tickets) {
            if (!map.containsKey(t[0])) {
                map.put(t[0], new ArrayList<String>());
            }
            map.get(t[0]).add(t[1]);
        }
        for(String key : map.keySet()) {
            Collections.sort(map.get(key));
        }
        List<String> list = new ArrayList<>();
        list.add("JFK");
        dfs(res,list,"JFK",map,tickets.length+1);
        return res;
    }
    
    boolean dfs(List<String> res, List<String> list, String curr, Map<String,List<String>> map, int total) {
        if (list.size() == total) {
            res = new ArrayList<String>(list);
            return true;
        }
        if (!map.containsKey(curr)) return false;
        List<String> adjList = map.get(curr);
        for(int i = 0; i < adjList.size(); i++) {
            String adj = adjList.get(i);
            adjList.remove(adj);
            list.add(adj);
            if(dfs(res,list,adj,map,total)) return true;
            adjList.add(i,adj);
            list.remove(list.size()-1);
        }
        return false;
    }
    
    public static void main(String[] args) {
    	String[][] tickets = {{"MUC","LHR"},{"JFK","MUC"},{"SFO","SJC"},{"LHR","SFO"}};
    	List<String> res = new _332_ReconstructItinerary_Wrong().findItinerary(tickets);
    	return;
    }
}
