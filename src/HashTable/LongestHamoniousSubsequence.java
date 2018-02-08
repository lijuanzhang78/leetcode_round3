package HashTable;

public class LongestHamoniousSubsequence {
	public int findLHS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num,0);
            }
            map.put(num,map.get(num)+1);
        }
        int max = Integer.MIN_VALUE;
        for(int num : map.keySet()) {
            if(map.containsKey(num-1)) {
                max = Math.max(max,map.get(num-1) + map.get(num));
            }
        }
        return max == Integer.MIN_VALUE? 0 : max;
    }

}
