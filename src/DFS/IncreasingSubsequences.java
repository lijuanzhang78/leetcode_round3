package DFS;

// 这道题还挺容易出错的
// backtracking 重点是要去重
// 给定的array不一定是sorted，还是跟subset一样，先采用一个arraylist保存临时结果
// 由于这道题是要求子序列，所以一定一定不要去sorted，subsequence的意思是子序列，所以不要改变元素的相对位置
// 去重的办法：每次调用dfs，都面对这从pos到nums.length-1 的这么多选择，那么采用在本次调用函数中建立一个local
//           hashset, 如果有dupicate的元素已经在hashset中,说明当前元素要pass
//           
public class IncreasingSubsequences {
	public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<>(); 
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums,res,list,0);
        return res;
    }
    
    void dfs(int[] nums, List<List<Integer>> res, List<Integer> list, int pos) {
        if (list.size() >= 2) res.add(new ArrayList<Integer>(list));
        if (pos == nums.length) return;
        
        Set<Integer> visited = new HashSet<>();
        for(int i = pos; i < nums.length; i++) {
            if (list.size() == 0 || nums[i] >= list.get(list.size()-1)) {
                if (visited.contains(nums[i])) continue;
                list.add(nums[i]);
                visited.add(nums[i]);
                dfs(nums,res,list,i+1);
                list.remove(list.size() - 1);
                //visited.remove(nums[i]); 这一行不能有
            }
        }
        return;
    }

}
