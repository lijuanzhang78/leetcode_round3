package DynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FreedomTrail_noDP {
	public int findRotateSteps(String ring, String key) {
        if (ring == null || ring.length() == 0 || key == null || key.length() == 0) return 0;
        //Map<String,Integer> map = new HashMap<>();
        return findSteps(ring,key,0,0);
    }
    
    int findSteps(String ring, String key, int pos, int steps) {
        if (pos == key.length()) {
            return steps;
        }
        
        //if (map.containsKey(ring+"#"+pos)) return map.get(ring+"#"+pos);
        int minSteps = Integer.MAX_VALUE;
        // get the next possible strings
        char c = key.charAt(pos);
        List<Integer> rotates = new ArrayList<>();
        List<String> nextStrings = new ArrayList<>();
        getNextStrings(ring,c,rotates,nextStrings);
        for(int i = 0; i < nextStrings.size(); i++) {
            minSteps = Math.min(minSteps, findSteps(nextStrings.get(i),key,pos+1,steps+rotates.get(i)));}
        //map.put(ring+"#"+pos, minSteps);
        return minSteps;
    }
    
    void getNextStrings(String ring, char c, List<Integer> rotates, List<String> nextStrings) {
        for(int i = 0; i < ring.length(); i++) {
            if (ring.charAt(i) == c) {
                String clock = ring.substring(i,ring.length()) + (i == 0? "" : ring.substring(0,i));
                nextStrings.add(clock);
                rotates.add(i+1);
                nextStrings.add(clock);
                rotates.add(ring.length() - i+1);    
            }
        }
    }
    
    String reverse(String s) {
        if (s.length() == 0) return "";
        char[] arr = s.toCharArray();
        int low = 0, high = arr.length - 1;
        while(low <= high) {
            char temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;high--;
        }
        return new String(arr);   
    }
    
    public static void main(String[] args) {
    	String ring = "abcde", key = "ade";
    	int res = new FreedomTrail_noDP().findRotateSteps(ring, key);
    	return;
    }
}
