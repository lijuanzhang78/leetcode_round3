package Amazon;

public class _762_PrimeNumberOfSetBitsInBinaryRepresentation {
	public int countPrimeSetBits(int L, int R) {
        int[] arr = new int[]{2,3,5,7,11,13,17,19,23,29};
        Set<Integer> set = new HashSet<Integer>(Arrays.asList(2,3,5,7,11,13,17,19,23,29));
        int res = 0;
        for(int i = L; i <= R; i++) {
            int count = 0;
            int num = i;
            while(num != 0) {
                count += num & 1;
                num = num >> 1;
            }
            if(set.contains(count)) res++;
        }
        return res;
    }

}
