package HashTable;

public class KDiffPairsInAnArray {public int findPairs(int[] nums, int k) {
    if (nums == null || nums.length == 0) return 0;
    Map<Integer,Integer> map = new HashMap<>(); // (num,count) pairs for k = 0
    for(int num : nums) {
        if (!map.containsKey(num)) map.put(num,0);
        map.put(num,map.get(num)+1);
    }
    int count = 0;
    if (k < 0) return 0;
    if (k == 0) {
        for(int key : map.keySet()) {
            if (map.get(key) > 1) count++;
        }
        return count;
    } else {
        for(int key : map.keySet()) {
            if (map.containsKey(key+k)) count++;
        }
        return count;
    }     
}

}
