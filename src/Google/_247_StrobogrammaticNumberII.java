package Google;

public class _247_StrobogrammaticNumberII {
	public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<>();
        Map<Character,Character> map = new HashMap<>();
        map.put('0','0');
        map.put('1','1');
        map.put('6','9');
        map.put('8','8');
        map.put('9','6');
        char[] single = new char[]{'0','1','8'};
        
        if (n <= 0) return res;
        boolean hasMid = false;
        if (n % 2 != 0) hasMid = true;
        n /= 2;
        helper(n,map,single,0,new StringBuilder(),hasMid,res);
        return res;
    }
    
    void helper(int n, Map<Character,Character> map, char[] single, int pos, StringBuilder sb, boolean hasMid,List<String> res) {
        if (pos == n) {
            genFull(sb,map,single,hasMid,res);
            return;
        }
        
        for(char c : map.keySet()) {
            if (pos == 0 && c == '0') continue;
            sb.append(c);
            helper(n,map,single,pos+1,sb,hasMid,res);
            sb.deleteCharAt(sb.length()-1);
        }    
    }
    
    void genFull(StringBuilder sb, Map<Character,Character> map, char[] single, boolean hasMid,List<String> res) {
        char[] arr = null;
        if (hasMid) {
            arr = new char[sb.length()*2+1];
        } else {
            arr = new char[sb.length()*2];
        }
        for(int i = 0; i < sb.length();i++) {
            arr[i] = sb.charAt(i);
            arr[arr.length-i-1] = map.get(arr[i]);
        }
        if (hasMid) {
            for(int i = 0; i < single.length; i++) {
                arr[sb.length()] = single[i];
                res.add(new String(arr)); 
            }
        } else {
            res.add(new String(arr));
        }    
    }    
}
