package HashTable;

public class FirstUniqueCharacterInAString {
	public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;
        char[] arr = s.toCharArray();
        int[] counts = new int[26];
        for(int i = 0; i < arr.length; i++) {
            counts[arr[i]-'a']++;    
        }
        for(int i = 0; i < arr.length; i++) {
            if (counts[arr[i]-'a'] == 1) return i;   
        }
        return -1;
    }

}
