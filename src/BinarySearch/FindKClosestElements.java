package BinarySearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


// binary search + two pointers
// 注意： line 26， 应该是 int left = low - 1, right = low;
// 改进：二分法以后确定该加哪些数的时候，其实只用确定边界就行了，不用找到一个加一个进去，这样还得最后sort
//
public class FindKClosestElements {
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        if (arr == null || arr.length == 0) return res;
        
        // find smallest index for which the element is larger OR EQUAL than x
        int low = 0, high = arr.length - 1;
        while(low < high) {
            int mid = low + (high - low)/2;
            if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
            
        int left = low - 1, right = low; // 不是 left = low, right = low + 1
        while(k > 0) {
            if (left >= 0 && right <= arr.length - 1) {
                if ((Math.abs(arr[left]-x)) <= Math.abs(arr[right] - x)) {
                    //res.add(arr[left]);
                    left--;
                } else {
                    //res.add(arr[right]);
                    right++;
                } 
                k--;
            } else if (left >= 0) {
                    //res.add(arr[left]);
                    left--; k--;
            } else if (right <= arr.length-1) {
                //res.add(arr[right]);
                right++; k--;
            }    
        }
        //Collections.sort(res);
        for(int i = left+1; i <= right-1; i++) {
        	res.add(arr[i]);
        }
        return res;
    }
	
	public static void main(String[] args) {
		int[] arr = {0,0,1,2,3,3,4,7,7,8};
		int k = 3, x= 5;
		List<Integer> res = new FindKClosestElements().findClosestElements(arr, k, x);
		return;	
	}

}
