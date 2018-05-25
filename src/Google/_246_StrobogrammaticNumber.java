package Google;

public class _246_StrobogrammaticNumber {
	public boolean isStrobogrammatic(String num) {
        if (num == null || num.length() == 0) return true;
        Map<Character,Character> map = new HashMap<>();
        map.put('0','0');
        map.put('1','1');
        map.put('6','9');
        map.put('8','8');
        map.put('9','6');
        int low = 0, high = num.length()-1;
        while(low < high) {
            char c1 = num.charAt(low), c2 = num.charAt(high);
            if (!(map.containsKey(c1) && map.get(c1) == c2)) {
                return false;
            }
            low++;high--;
        }
        if (low == high) {
            char mid = num.charAt(low);
            return mid == '0' || mid == '1' || mid == '8';
        }
        return true;
    }

}
