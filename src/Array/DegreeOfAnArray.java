package Array;

public class DegreeOfAnArray {
	public int findShortestSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Map<Integer,List<Integer>> map = new HashMap<>();
        int maxnum = 0;
        for(int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i],new ArrayList<Integer>());
            }
            map.get(nums[i]).add(i);
            if (map.get(nums[i]).size() > maxnum) {
                maxnum = map.get(nums[i]).size();
            }
        }
        
        int minlen = Integer.MAX_VALUE;
        for(Integer num : map.keySet()) {
            if (map.get(num).size() == maxnum) {
                minlen = Math.min(minlen, map.get(num).get(map.get(num).size()-1) - map.get(num).get(0)+1);
            }
        }
        return minlen;    
    }

}
