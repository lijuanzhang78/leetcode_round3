package BinarySearch;

// JAVA API: Arrays.binarySearch
//
public class Heaters {
	public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int res = Integer.MIN_VALUE;
        for(int house : houses) {
            int index = Arrays.binarySearch(heaters,house);
            if (index < 0) {
                index = -(index+1);
            }
            int dist1 = index-1 < 0? Integer.MAX_VALUE : house - heaters[index-1];
            int dist2 = index == heaters.length? Integer.MAX_VALUE : heaters[index] - house;
            res = Math.max(res,Math.min(dist1,dist2));
        }
        return res;
    }

}
