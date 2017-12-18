package DFS;

public class CourseScheduleII {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int[] p : prerequisites) {
            if (!map.containsKey(p[1])) {
                map.put(p[1],new ArrayList<Integer>());
            }
            map.get(p[1]).add(p[0]);
        }
        int[] visited = new int[numCourses];
        List<Integer> resList = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            if (visited[i] != 0) continue;
            if (!dfs(map,visited,i,resList)) return new int[0];
        }
        int index = 0;
        for(int i : resList) {
            res[index++] = i;
        }
        return res;
    }
                
    boolean dfs(Map<Integer, List<Integer>> map, int[] visited, int source, List<Integer> res) {
        visited[source] = 1;
        if(map.containsKey(source)) {
            for(int adj : map.get(source)) {
                if (visited[adj] == 1) return false;
                if (visited[adj] == 0) {
                    if (!dfs(map,visited,adj,res)) return false;
                }
            }
        }
        visited[source] = 2;
        res.add(0,source);
        return true;    
    }

}
