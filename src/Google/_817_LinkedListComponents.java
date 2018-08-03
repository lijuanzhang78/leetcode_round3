package Google;

public class _817_LinkedListComponents {
	public int numComponents(ListNode head, int[] G) {
        if (G == null || G.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for(int g : G) {
            set.add(g);
        }
        ListNode curr = head;
        boolean start = false;
        int count = 0;
        while(curr != null) {
            if(!set.contains(curr.val)) {
                if (start) {
                    count++;
                    start = false;
                }
            } else {
                if (!start) {
                    start = true;
                }
            }
            curr = curr.next;
        }
        if (start) count++;
        return count;
    }

}

public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> que = new PriorityQueue<>((a,b)->a[0]+a[1]-b[0]-b[1]);
        List<int[]> res = new ArrayList<>();
        if(nums1.length==0 || nums2.length==0 || k==0) return res;
        for(int i=0; i<nums1.length && i<k; i++) que.offer(new int[]{nums1[i], nums2[0], 0});
        while(k-- > 0 && !que.isEmpty()){
            int[] cur = que.poll();
            res.add(new int[]{cur[0], cur[1]});
            if(cur[2] == nums2.length-1) continue;
            que.offer(new int[]{cur[0],nums2[cur[2]+1], cur[2]+1});
        }
        return res;
    }
}