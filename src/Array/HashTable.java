package Array;

public class HashTable {
	public String shortestCompletingWord(String licensePlate, String[] words) {
        if (licensePlate == null || licensePlate.length() == 0 || words == null || words.length == 0) return "";
        int[] count = new int[26];
        for(int i = 0; i < licensePlate.length(); i++) {
            char c = licensePlate.charAt(i);
            if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
                c = Character.toLowerCase(c);
                count[c-'a']++;
            }
        }
        
        int min = Integer.MAX_VALUE;
        String res = "";
        for(int i = 0; i < words.length; i++) {
            int[] wcount = new int[26];
            for(int j = 0; j < words[i].length(); j++) {
                char c = words[i].charAt(j);
                wcount[c-'a']++;
            }
            int len = matchLicense(count,wcount, words[i]);
            if (len > 0 && len < min) {
                min = len;
                res = words[i];
            }
            
        }
        return res;
    }
    
    int matchLicense(int[] count, int[] wcount, String s) {
        for(int i = 0; i < 26; i++) {
            if (count[i] > 0 && wcount[i] < count[i]) return -1;
        }
        return s.length();
    }

}
