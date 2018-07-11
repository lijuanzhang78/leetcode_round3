package Google;

public class _845_LongestMountainInArray {
	public int longestMountain(int[] A) {
        boolean hasFirst = false;
        boolean hasSecond = false;
        int start = -1, max = 0;
        for(int i = 1; i < A.length; i++) {
            if (A[i] > A[i-1]) {
                if (!hasFirst) {
                    start = i-1;
                    hasFirst = true;
                } else if (hasSecond && hasFirst) {
                    max = Math.max(max,i-start);
                    start = i-1;
                    hasSecond = false;
                    hasFirst = true;
                } 
            } else if (A[i] < A[i-1]) {
                if (hasFirst && !hasSecond) {
                    hasSecond = true;
                }
            } else {
                if (hasSecond && hasFirst) {
                   max = Math.max(max,i-start);
                }
                hasFirst = false;
                hasSecond = false;
                
            }
        }
        if (hasSecond && hasFirst) max = Math.max(max, A.length-start);
        return max;
    }

}
