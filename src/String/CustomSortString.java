package String;

public class CustomSortString {
	public String customSortString(String S, String T) {
        if (S == null || S.length() == 0) return T;
        if (T == null || T.length() == 0) return "";
        
        int[] counts = new int[26];
        for(int i = 0; i < T.length(); i++) {
            char c = T.charAt(i);
            counts[c -'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            while(counts[c-'a'] > 0) {
                sb.append(c);
                counts[c-'a']--;
            }
        }
        for(int i = 0; i < counts.length; i++) {
            while (counts[i] > 0) {
                sb.append((char)(i+'a'));
                counts[i]--;
            }
        }
        return sb.toString();
        
    }

}
