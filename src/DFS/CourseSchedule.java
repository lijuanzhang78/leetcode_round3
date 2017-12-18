package DFS;

// 解法一： DFS
// 注意： 有的点没有在prerequisites里面，需要判断 if (map.containsKey(curr)) {
public class CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0 || prerequisites[0] == null || prerequisites[0].length == 0) return true;
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int[] p : prerequisites) {
            if (!map.containsKey(p[0])) {
                map.put(p[0], new ArrayList<Integer>());
            }
            map.get(p[0]).add(p[1]);            
        }
        
        int[] visited = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                if (!dfs(i,map,visited)) return false;
            }
        }
        return true;    
    }
    
    boolean dfs(int curr, Map<Integer,List<Integer>> map, int[] visited) {
        visited[curr] = 1;
        if (map.containsKey(curr)) {
            List<Integer> adjList = map.get(curr);
            for(int adj : adjList) {
                if (visited[adj] == 0) {
                    if(!dfs(adj,map,visited)) return false;
                } else if (visited[adj] == 1) {
                    return false;
                }    
            }    
        }
        visited[curr] = 2;
        return true;  
    }
    
// 解法二： BFS： count the indegree of each vertex and push them into a queue
// See Course Schedule II

}
