package Heap;

// MAX heap
// Map.Entry
// map.entrySet()
//
public class TopKFrequentElement {
	public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums) {
            if (!map.containsKey(num)) map.put(num,0);
            map.put(num, map.get(num)+1);
        }
        
        Queue<Map.Entry<Integer,Integer>> q = new PriorityQueue<>((a,b) -> (b.getValue() - a.getValue()));
        for(Map.Entry<Integer,Integer> freq : map.entrySet()) {  // map.entrySet()
            q.offer(freq);
        }
        while(res.size() < k) {
            res.add(q.poll().getKey());
        }
        return res;
    }

}
