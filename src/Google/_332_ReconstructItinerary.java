package Google;

public class _332_ReconstructItinerary {
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
        dfs(list,"JFK",map,tickets.length+1);
        return list;
    }
    
    boolean dfs(List<String> list, String curr, Map<String,List<String>> map, int total) {
        if (list.size() == total) {
            return true;
        }
        if (!map.containsKey(curr)) return false;
        List<String> adjList = map.get(curr);
        for(int i = 0; i < adjList.size(); i++) {
            String adj = adjList.get(i);
            adjList.remove(adj);
            list.add(adj);
            if(dfs(list,adj,map,total)) return true;
            adjList.add(i,adj);
            list.remove(list.size()-1);
        }
        return false;
    }
}
