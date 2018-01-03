package Recursion;

public class OutputContestMatch {
	public String findContestMatch(int n) {
        String[] res = new String[n];
        for(int i = 0; i < n; i++) {
            res[i] = String.valueOf(i+1);
        }
        helper(n,res,0,n-1);
        return res[0];
    }
    
    void helper(int n, String[] res, int start, int end) {
        if (n == 1) {
            return;
        }
        
        for(int i = 0; i <= n/2-1; i++) {
            res[i] = "("+res[i]+","+res[n-i-1]+")";
        }
        
        helper(n/2,res,0,n/2-1);

}
