package DFS;

// 这道题是用DFS求解，假设有K个数组（箱子），对于每个数字，有K个箱子选择
// 注意剪枝，数组元素大于target就要立刻返回
// input array需要逆序排列
//
public class PartitionToKEqualSumSubsets {
	public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums == null || nums.length == 0) return false;
        if (k == 0) return false;
        Arrays.sort(nums);
        int sum = 0;
        for(int num : nums) sum += num; 
        if (sum % k != 0) return false;
        int[] sums = new int[k];
        
        if (dfs(nums,nums.length-1,k,sums,sum/k)) return true;
        return false;
    }
    
    boolean dfs(int[] nums, int pos, int k, int[] sums, int target) {
        for(int i = 0; i < k; i++) {
            if (sums[i] > target) {
                return false;
            }
        }
        if (pos == -1) {
            boolean res = true;
            for(int i = 0; i < k; i++) {
                if (sums[i] != target) {
                    res = false;break;
                }
            }
            return res;
        }
        
        for(int i = 0; i < k; i++) {
            sums[i] += nums[pos];
            if(dfs(nums,pos-1,k,sums,target)) return true;
            sums[i] -= nums[pos];
        }
        return false;
    }

}
