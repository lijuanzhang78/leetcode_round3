package DFS;

import java.util.HashMap;
import java.util.Map;

// DFS, 对于每个可能位置都搜索一下
// 注意removeConsecutive需要递归调用，因为相邻的可以消的球可以再次连接
// 看看别人怎么把code写的更简洁
//
public class ZumaGame {
	public int findMinStep(String board, String hand) {
        if (board == null || board.length() == 0 || hand == null || hand.length() == 0) return 0;
        
        // build the character count of hand
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < hand.length(); i++) {
            char c = hand.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c,0);
            }
            map.put(c,map.get(c)+1);
        }
        
        return zumaGame(board,hand,map,0);
    }
    
    int zumaGame(String board, String hand, Map<Character,Integer> map, int counts) {
        if (board.length() == 0) {
            return counts;
        }
        
        // add new characters to the end of consecutive characters
        int minres = Integer.MAX_VALUE;
        for(int i = 0; i < board.length();) {
            char c = board.charAt(i);
            int j = i;
            while(j < board.length() && board.charAt(i) == board.charAt(j)) {
                j++;
            }
            
            int missing = 3-(j-i);
            if (missing > 0 && map.containsKey(c) && map.get(c) >= missing) {
                String newString = buildNewString(board,i,j-1);
                map.put(c,map.get(c)-missing);
                int res = zumaGame(newString,hand,map,counts+missing);
                if (res != -1) minres = Math.min(minres,res);
                map.put(c,map.get(c)+missing);
            } 
            i = j;
        }
        return minres == Integer.MAX_VALUE? -1 : minres;
    }
    
    // elimiate those characters between start & end (inclusive) and return new string
    String buildNewString(String board, int start, int end) {
        String part1 = "", part2 = "";
        if (start > 0) {
            part1 = board.substring(0,start);
        }
        if (end < board.length()-1) {
            part2 = board.substring(end+1,board.length());
        }
        return removeConsecutive(part1+part2);
    }
    
    String removeConsecutive(String s) {
        for(int i = 0; i < s.length();) {
            int j = i;
            while(j < s.length() && s.charAt(j) == s.charAt(i)) {
                j++;
            }
            if (j-i >= 3) {
                return removeConsecutive((i > 0? s.substring(0,i) : "") + (j < s.length()? s.substring(j,s.length()) : ""));
            } // 判断右边界j可以落在s.length()-1
            i = j;
            
        }
        return s;    
    }
 
    public static void main(String[] args) {
    	//String board = "WRRBBW", hand = "RB";
    	String board = "RRWWRRW", hand = "WR";
    	int res = new ZumaGame().findMinStep(board, hand);
    	return;
    }
}
