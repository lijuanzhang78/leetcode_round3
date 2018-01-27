package BinarySearch;

// 有n+1个数，数的值得范围是1到n，求这个数的值。数组是unsorted。
// 假设这个数是mid = low + （high - low）/2
// 遍历这个数组，找到小于等于mid的数的个数，如果count > mid, 那search space是【low，mid】，如果count <= mid, 
// 那么mid不可能是duplicate，搜索范围应该是【mid+1,high】
// 注意：low = mid + 1才可以让程序跳出无限循环，如果是low = mid，那么只剩最后两个数的时候，会有问题。

public class FindTheDuplicateNumber {
	public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int low = 1, high = nums.length - 1;
        while(low < high) {
            int mid = low + (high - low)/2;
            int count = 0;
            for (int num : nums) {
                if (num <= mid) count++;
            }
            if (count <= mid) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        
        return low;    
    }

}
