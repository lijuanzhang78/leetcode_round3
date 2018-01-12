package BackTracking;

public class PalindromePartitioning {
	public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        List<String> list = new ArrayList<>();
        helper(res,list,0,s);
        return res;
    }
    
    void helper(List<List<String>> res, List<String> list, int start, String s) {
        if (start == s.length()) {
            res.add(new ArrayList<String>(list));
            return;
        }
        
        for(int pos = start; pos < s.length(); pos++) {
            String partition = s.substring(start,pos+1);
            if (isPalindrome(partition)) {
                list.add(partition);
                helper(res,list,pos+1,s);
                list.remove(list.size()-1);
            }
        }
    }
    
    boolean isPalindrome(String s) {
        char[] arr = s.toCharArray();
        int low = 0, high = arr.length - 1;
        while(low <= high) {
            if (s.charAt(low) != s.charAt(high)) return false;
            low++;
            high--;
        }
        return true;
    }

}
