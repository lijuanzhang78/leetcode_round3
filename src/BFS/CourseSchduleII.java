package BFS;

// BFS: count每个vertex的indegree是否为0，如果为0，加入queue
// 
public class CourseSchduleII {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        Map<Integer,List<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];
        
        for(int[] p : prerequisites) {
            if (!map.containsKey(p[1])) {
                map.put(p[1],new ArrayList<Integer>());                
            }
            map.get(p[1]).add(p[0]);
            indegree[p[0]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            } 
        } 
        int count = 0;
        while(q.size() > 0) {
            int curr = q.poll();
            res[count] = curr;
            count++;
            
            if (map.containsKey(curr)) {
                for(int adj : map.get(curr)) {
                    indegree[adj]--;
                    if (indegree[adj] == 0) {
                        q.offer(adj);
                    }    
                }
            }
        }
        if (count != numCourses) return new int[0];
        return res;
    }

}
