package Google;

public class _769_MaxChunksToMakeSorted {
	public int maxChunksToSorted(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        int max = 0, count = 0;
        for(int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i],max);
            if (i == max) count++;
        }
        return count;
    }

}
