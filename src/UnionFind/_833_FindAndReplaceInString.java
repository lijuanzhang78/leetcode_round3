package UnionFind;

public class _833_FindAndReplaceInString {
	public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        if (indexes == null || indexes.length == 0) return S;
        char[] arr = S.toCharArray();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < indexes.length; i++) {
            map.put(indexes[i],i);
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < arr.length) {
            if (map.containsKey(i)) {
                int j = map.get(i); 
                if (S.substring(i,i+sources[j].length()).equals(sources[j])) {
                    sb.append(targets[j]);
                    i += sources[j].length();
                } else {
                    sb.append(arr[i++]);
                }
            } else {
                sb.append(arr[i++]);    
            }
        }
        return sb.toString();    
    }

}
