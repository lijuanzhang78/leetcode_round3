package BinarySearch;

public class RussianDollEnvelopes {
	public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0 || envelopes[0] == null || envelopes[0].length != 2) return 0;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] arr1, int arr2[]) {
                if (arr1[0] == arr2[0]) {
                    return arr2[1] - arr1[1];
                } else {
                    return arr1[0] - arr2[0];
                }    
            }    
        });
        
        int[] tails = new int[envelopes.length];
        int size = 0;
        for(int i = 0; i < envelopes.length; i++) {
            int low = 0, high = size;
            while(low < high) {
                int mid = low + (high - low)/2;
                if (tails[mid] < envelopes[i][1]) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            tails[low] = envelopes[i][1];
            if (low == size) size++;
        }
        return size;
    }

}
