package Recursion;

public class StrobogrammaticNumbersIII {
	char[][] numbers = {{'0','0'}, {'1','1'}, {'8','8'}, {'6','9'}, {'9', '6'}};
    int count = 0;
    public int strobogrammaticInRange(String low, String high) {
        int n1 = low.length(), n2 = high.length();
        for(int len = n1; len <= n2; len++) {
            dfs(len, new char[len],0,len-1,low,high);
        }
        return count;
    }
    
    void dfs(int len, char[] arr, int left, int right, String low, String high) {
        if (left > right) {
            String s = new String(arr);
            if (s.length() == low.length() && s.compareTo(low) < 0 || 
                s.length() == high.length() && s.compareTo(high) > 0) {
                return;
            }
            count++;
            return;
        }
        if (left == right) {
            for(int i = 0; i < 3; i++) {
                arr[left] = numbers[i][0];
                dfs(len,arr,left+1,right-1,low,high);
            }
            return;
        }
        for(int i = 0; i < 5; i++) {
            if (len != 1 && left == 0 && i == 0) continue;
            arr[left] = numbers[i][0];
            arr[right] = numbers[i][1];
            dfs(len,arr,left+1,right-1,low,high);
        }
    }
    
    public static void main(String[] args) {
    	String low = "50", high = "100";
    	int test = new StrobogrammaticNumbersIII().strobogrammaticInRange(low, high);
    	return;
    }

}
