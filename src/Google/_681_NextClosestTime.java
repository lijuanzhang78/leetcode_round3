package Google;

import java.util.ArrayList;
import java.util.List;

public class _681_NextClosestTime {
	String candidate = null;
    int mindiff = Integer.MAX_VALUE;
    public String nextClosestTime(String time) {
        if (time == null || time.length() == 0) return "";
        //if (time.equals("00:00")) return time;
        int original = Integer.parseInt(time.substring(0,2))*60 + Integer.parseInt(time.substring(3,5));
        List<Character> nums = new ArrayList<>();
        for(int i = 0; i < time.length(); i++) {
            if (i == 2) continue;
            nums.add(time.charAt(i));
        }
        dfs(nums,0,"",original);
        if (candidate == null) return time;
        return candidate.substring(0,2) + ":" + candidate.substring(2,4);   
    }
    
    void dfs(List<Character> nums, int curr, String temp, int original) {
        if (curr == nums.size()) {
            int time = Integer.parseInt(temp.substring(0,2))*60+Integer.parseInt(temp.substring(2,4));
            if (time < original && 24*60-original+time < mindiff) {
                candidate = temp;
                mindiff = 24*60-original+time;
            }
            if (time > original && time - original < mindiff) {
                candidate = temp;
                mindiff = time - original;
            }
            return;
        }
            
        for(int i = 0; i < nums.size(); i++) {
            if (curr == 0 && nums.get(i) > '2') continue;
            if (curr == 1 && temp.charAt(0) == '2' && nums.get(i) > '3') continue;
            if (curr == 2 && nums.get(i) > '5') continue;
            dfs(nums,curr+1,temp+nums.get(i),original);
        }
    }
    
    public static void main(String[] args) {
    	String time = "19:34";
    	String res = new _681_NextClosestTime().nextClosestTime(time);
    	return;
    }

}
