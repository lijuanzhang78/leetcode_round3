package Google;

public class _758_BoldWordsInString {
	public String boldWords(String[] words, String S) {
        if (words == null || words.length == 0) return S;
        boolean[] mark = new boolean[S.length()];
        for(String w : words) {
            markKeyword(w,S,mark);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < S.length(); i++) {
            if (mark[i] && (i == 0 || !mark[i-1])) {
                sb.append("<b>"); 
            }
            sb.append(S.charAt(i));
            if (mark[i] && (i == S.length()-1 || !mark[i+1])) {
                sb.append("</b>");
            }   
        }
        return sb.toString();
    }
    
    void markKeyword(String w, String S, boolean[] mark) {
        for(int i = 0; i <= S.length()-w.length(); i++) {
            String sub = S.substring(i,i+w.length());
            if (sub.equals(w)) {
                for(int j = i; j < i+w.length(); j++) {
                    mark[j] = true;
                }
            }
        }
    }

}
