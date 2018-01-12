package BackTracking;

public class PermutationSequence {
	int num = 0;
    String res = "";
    public String getPermutation(int n, int k) {
        if (n == 0 || k == 0) return "";
        boolean[] visited = new boolean[n+1];
        getPermutation(n,k,0,"",visited);
        return res;
    }
    
    boolean getPermutation(int n, int k, int pos, String curr, boolean[] visited) {
        if (pos == n) {
            num++;
            if (num == k) {
                res = curr;
                return true;
            } else {
                return false;
            } 
        }
        
        for(int i = 1; i <= n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            if (getPermutation(n,k,pos+1,curr+i,visited)) return true;
            visited[i] = false;
        }
        
        return false;
         
    }
    
    public static void main(String[] args) {
    	String res = new PermutationSequence().getPermutation(3, 4);
    	return;	
    }

}
