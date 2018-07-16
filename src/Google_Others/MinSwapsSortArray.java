package Google_Others;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MinSwapsSortArray {
	int minSwapSortArray(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		int[] newarr = new int[nums.length];
		for(int i = 0; i < nums.length; i++) {
			newarr[i] = nums[i];
		}
		Arrays.sort(newarr);
		Map<Integer,Integer> newpos = new HashMap<>();
		for(int i = 0; i < newarr.length; i++) {
			newpos.put(newarr[i], i);
		}
		
		boolean[] visited = new boolean[nums.length];
		int count = 0;
		for(int i = 0; i < nums.length; i++) {
			int numnodes = 0;
			if (!visited[i]) {
				while(!visited[i]) {
					visited[i] = true;
					i = newpos.get(nums[i]);
					numnodes++;
				}
				count += numnodes - 1;
			}	
		}
		return count;
	}
	
	public static void main(String[] args) {
		int[] nums = {2,4,5,1,3};
		int minSwap = new MinSwapsSortArray().minSwapSortArray(nums);
		return;	
	}
}
