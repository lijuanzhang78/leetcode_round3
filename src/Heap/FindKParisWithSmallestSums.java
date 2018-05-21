package Heap;

public class FindKParisWithSmallestSums {
	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>();
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return res;
        Queue<int[]> pq = new PriorityQueue<int[]> ((a,b)->(nums1[a[0]]+nums2[a[1]]-nums1[b[0]]-nums2[b[1]]));
        int m = Math.max(nums1.length, nums2.length);
        boolean[][] visited = new boolean[m][m];
        
        pq.offer(new int[]{0,0});
        visited[0][0] = true;
        int count = 0;
        while(pq.size() > 0) {
            int[] curr = pq.poll();
            res.add(new int[]{nums1[curr[0]], nums2[curr[1]]});
            if (++count == k) break;
            if (curr[0]+1 < nums1.length && !visited[curr[0]+1][curr[1]]) {
                pq.offer(new int[]{curr[0]+1, curr[1]});
                visited[curr[0]+1][curr[1]] = true;
            }
            if (curr[1]+1 < nums2.length && !visited[curr[0]][curr[1]+1]) {
                pq.offer(new int[]{curr[0], curr[1]+1});
                visited[curr[0]][curr[1]+1] = true;
            }
        }
        return res;
    }

}
