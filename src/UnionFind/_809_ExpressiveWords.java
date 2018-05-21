package UnionFind;

public class _809_ExpressiveWords {
	public int expressiveWords(String S, String[] words) {
        if (words == null || words.length == 0) return 0;
        int count = 0;
        for(String w : words) {
            int i = 0, j = 0;
            while(i < S.length()) {
                if (j < w.length() && S.charAt(i) == w.charAt(j)) {
                    i++; j++;
                } else if (i > 0 && i+1 < S.length() && S.charAt(i) == S.charAt(i-1) && S.charAt(i) == S.charAt(i+1)) {
                    i++;
                } else if (i > 1 && S.charAt(i) == S.charAt(i-1) && S.charAt(i-1) == S.charAt(i-2)) {
                    i++;
                } else {
                    break;
                }
            }
            if (i == S.length() && j == w.length()) count++;
        }
        return count;
    }
	
	public static void main(String[] args) {
		String S = "heeellooo";
		String[] words = {"hello", "hi", "helo"};
		int res = new _809_ExpressiveWords().expressiveWords(S, words);
		return;
	}

}
