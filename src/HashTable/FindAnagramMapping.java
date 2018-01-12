package HashTable;

public class FindAnagramMapping {
	public int[] anagramMappings(int[] A, int[] B) {
        if (A == null || A.length == 0  || B == null || B.length == 0) return new int[0];
        Map<Integer,LinkedList<Integer>> map = new HashMap<>();
        for(int i = 0; i < B.length; i++) {
            if (!map.containsKey(B[i])) {
                map.put(B[i], new LinkedList<Integer>());
            }
            map.get(B[i]).add(i);
        }
        
        int[] res = new int[A.length];
        for(int i = 0; i < A.length; i++) {
            int index = map.get(A[i]).poll();
            res[i] = index;
        }
        return res;
    }

}
