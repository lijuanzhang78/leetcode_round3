package Google;

public class _266_PalindromePermutation {
	public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        char[] arr = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i],0);
            }
            map.put(arr[i],map.get(arr[i])+1);
        }
        
        
        int single = s.length()%2;
        for(char c : map.keySet()) {
            if (map.get(c) % 2 !=0 ) {
                if (single == 0)  {
                    return false;
                } else {
                    single--;
                }
            } 
        }
        return true;
    }

}
