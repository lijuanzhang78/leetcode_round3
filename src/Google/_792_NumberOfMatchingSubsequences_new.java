package Google;

public class _792_NumberOfMatchingSubsequences_new {
	public int numMatchingSubseq(String S, String[] words) {
        if (words == null || words.length == 0) return 0;
        Map<Character,Queue<String>> map = new HashMap<>();
        for(char c = 'a'; c <= 'z'; c++) {
            map.put(c,new LinkedList<>());
        }
        for(String w : words) {
            map.get(w.charAt(0)).add(w);
        }
        int count = 0;
        for(int i = 0; i < S.length(); i++) {
            char currc = S.charAt(i);
            int size = map.get(currc).size();
            for(int j = 0; j < size; j++) {
                String currs = map.get(currc).poll();
                if (currs.length() == 1) {
                    count++; continue;
                } else {
                    char nextc = currs.charAt(1);
                    map.get(nextc).offer(currs.substring(1));
                }
            }
        }
        return count;
    }

}
