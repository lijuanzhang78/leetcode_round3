package HashTable;

public class ContinuousArray {
	public int findMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0; // number of 1s
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                len = Math.max(len, i+1);
                continue;
            }
            if (map.containsKey(count)) len = Math.max(len,i-map.get(count));
            if (!map.containsKey(count)) {
                map.put(count,i);
            }
            
        }
        return len == Integer.MIN_VALUE? 0 : len;
    }

}
