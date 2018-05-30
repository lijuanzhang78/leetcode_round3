package Google;

public class _321_CreateMaximumNumber {
	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int maxgetnum1 = Math.min(nums1.length,k);
        int mingetnum1 = Math.max(0,k-nums2.length);
        int[] ans = new int[k];
        for(int i = mingetnum1; i <= maxgetnum1; i++) {
            int[] res1 = maxFromArray(nums1,i);
            int[] res2 = maxFromArray(nums2,k-i);
            int[] res = new int[k];
            int pos1 = 0, pos2 = 0, pos = 0;
            while(pos1 < res1.length && pos2 < res2.length) {
                if (compare(res1,pos1,res2,pos2)) {
                    res[pos++] = res1[pos1++];
                } else {
                    res[pos++] = res2[pos2++];
                }
            }
            while (pos1 < res1.length) {
                res[pos++] = res1[pos1++];
            }
            while (pos2 < res2.length) {
                res[pos++] = res2[pos2++];
            }
            if (compare(res,0,ans,0)) {
                ans = res;
            }
        }
        return ans;
    }
    
    boolean compare(int[] res1, int pos1, int[] res2, int pos2) {
        while(res1.length > 0 && pos1 < res1.length && res2.length > 0 && pos2 < res2.length) {
            if (res1[pos1] == res2[pos2]) {
                pos1++;pos2++;
            } else if (res1[pos1] > res2[pos2]) {
                return true;
            } else {
                return false;
            }
        }
        if (pos1 < res1.length) {
            return true;
        } else {
            return false;
        }
    }
    
    int[] maxFromArray(int[] nums, int k) {
        int[] res = new int[k];
        int len = 0;
        for(int i = 0; i < nums.length; i++) {
            while(len > 0 && nums.length-i+len > k && nums[i] > res[len-1]) {
                len--;
            }
            if (len < k) {
                res[len++] = nums[i];
            }
        }
        return res;
    }

}
