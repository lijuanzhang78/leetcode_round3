package Heap;

// 跟Heap相比，bucket sort可以达到O（N）时间复杂度

public class TopKFrequentElements_bucketSort {
	public List<Integer> topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new ArrayList<Integer>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num,0);
            }
            map.put(num, map.get(num)+1);
        }
        List<List<Integer>> counts = new ArrayList<>();
        for(int i = 0; i < nums.length + 1; i++) counts.add(new ArrayList<Integer>());
        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            counts.get(entry.getValue()).add(entry.getKey());
        }
        List<Integer> res = new ArrayList<>();
        int count = 0;
        for(int i = nums.length; i >= 0; i--) {
            //if (count == k) return res;
            if (counts.get(i).size() == 0) continue;
            for(Integer num : counts.get(i)) {
                res.add(num); count++;
                if (count == k) return res;    
            }
        }
        return res;
    }

}
