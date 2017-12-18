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

public class ReconstructItinerary {
    
    List<String> nodes;
    Map<String, Integer> indexes;
    Map<String, List<String>> edges;
    Map<String, List<Boolean>> visited;
    
    public List<String> findItinerary(String[][] tickets) {
        if (!buildNodes(tickets)) return null;
        buildEdges(tickets);
        
        List<String> result = new ArrayList<>();
        findNextEdge(indexes.get("JFK"), result, tickets);
        return result;
        
    }
    
    boolean findNextEdge(int index, List<String> result, String[][] tickets) {
        String node = nodes.get(index);
        result.add(node);
        if (result.size() == tickets.length + 1) {
            return true;
        }
        List<String> curr_edges = edges.get(node);
        List<Boolean> curr_visited = visited.get(node);
        for (int i = 0; i < curr_edges.size(); ++i) {
            if (curr_visited.get(i) == false) {
                curr_visited.set(i, true);
                if (findNextEdge(indexes.get(curr_edges.get(i)), result, tickets) == true) {
                    return true;
                } else {
                    curr_visited.set(i, false);
                }
            }
        }
        result.remove(result.size() - 1);
        return false;
    }
    
    private boolean buildNodes(String[][] tickets) {
        if (tickets == null || tickets.length == 0 || tickets[0].length != 2)
            return false;
        Set<String> nodes_set = new HashSet<>();
        for (int i = 0; i < tickets.length; i++) {
            nodes_set.add(tickets[i][0]);
            nodes_set.add(tickets[i][1]);
        }
        nodes = new ArrayList<>(nodes_set);
        Collections.sort(nodes);
        
        indexes = new HashMap<>();
        for (int i = 0; i < nodes.size(); ++i) {
            indexes.put(nodes.get(i), i);
        }
        return true;
    }
    
    private void buildEdges(String[][] tickets) {
        edges = new HashMap<>();
        visited = new HashMap<>();
        for (int i = 0; i < nodes.size(); i++) {
            edges.put(nodes.get(i), new ArrayList<String>());
        }
        for (int i = 0; i < tickets.length; ++i) {
            edges.get(tickets[i][0]).add(tickets[i][1]);
        }
        for (Map.Entry<String,List<String>> entry : edges.entrySet()) {
            Collections.sort(entry.getValue());
            List<Boolean> curr_visited = new ArrayList<>();
            for (int i = 0; i < entry.getValue().size(); ++i) {
            	curr_visited.add(false);
            }
            visited.put(entry.getKey(), curr_visited);
        }
    }
	

	public static void main(String[] args) {
		String[][] tickets = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
		//String[][] tickets = {{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};
		List<String> res = new ReconstructItinerary().findItinerary(tickets);
		int i = 9;
		return;
	}

}
