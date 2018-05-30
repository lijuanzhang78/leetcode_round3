package Google;

public class _841_KeysAndRooms {
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms == null || rooms.size() == 0) return true;
        Set<Integer> visited = new HashSet<>();
        dfs(visited,0,rooms);
        
        for(int i = 0; i < rooms.size(); i++) {
            if (!visited.contains(i)) return false;
        }
        return true;
    }
    
    void dfs(Set<Integer> visited, int curr, List<List<Integer>> rooms) {
        visited.add(curr);
        for(int nei : rooms.get(curr)) {
            if (!visited.contains(nei)) {
                dfs(visited,nei,rooms);
            }
        }
    }

}
