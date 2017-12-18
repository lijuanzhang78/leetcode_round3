package DFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class ReconstructItinerary2 {
	 Map<String, List<String>> flights;
	    LinkedList<String> path;

	    public List<String> findItinerary(String[][] tickets) {
	        flights = new HashMap<>();
	        path = new LinkedList<>();
	        for (String[] ticket : tickets) {
	            flights.putIfAbsent(ticket[0], new ArrayList<>());
	            flights.get(ticket[0]).add(ticket[1]);
	        }
	        List<String> temp = new ArrayList<>();
	        Set<String> visited = new HashSet<>();
	        dfs("JFK",temp,tickets.length+1,visited);
	        return temp;
	    }

	    boolean dfs(String departure,List<String> temp,int length,Set<String> visited) {
	        temp.add(departure);
	        List<String> arrivals = flights.get(departure);
	        if (temp.size() == length) return true;
	        
	        if (arrivals != null && arrivals.size() > 0) {
	            Collections.sort(arrivals);
	            for(String next : arrivals) {
	                if (visited.contains(departure+"->"+next)) continue;
	                visited.add(departure+"->"+next);
	                if(dfs(next,temp,length,visited)) return true;
	                visited.remove(departure+"->"+next);
	            }
	        }
	        temp.remove(temp.size()-1);
	        return false;
	    }
    public static void main(String[] args) {
		//String[][] tickets = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
		String[][] tickets = {{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};
		List<String> res = new ReconstructItinerary2().findItinerary(tickets);
		return;
	}

}
