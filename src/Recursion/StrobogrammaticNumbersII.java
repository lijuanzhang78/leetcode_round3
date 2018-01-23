package Recursion;

// DFS
// 从两边往中间加，left++，right--，之前的做法是先做一半，然后以后处理的形式完成另外一半，代码非常不简洁。
// (1) 当left == right, 只能选0，1，8
// (2) 当left < right, 继续加
// (3) 当left > right, dfs停止
// (4) 注意：当n大于1的时候，选择最高位的时候不能选择0
//     if (n != 1 && left == 0 && i == 0) continue;
//
public class StrobogrammaticNumbersII {
	char[][] numbers = {{'0','0'},{'1','1'},{'8','8'},{'6','9'},{'9','6'}};
    public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) return res;
        dfs(res,new char[n],0,n-1, n);
        return res;
    }
    
    void dfs(List<String> res, char[] arr, int left, int right, int n) {
        if (left > right) {
            res.add(new String(arr));
            return;
        }
        
        if (left == right) {
            for(int i = 0; i < 3; i++) {
                arr[left] = numbers[i][0];
                res.add(new String(arr));
            }
            return;    
        }
        
        for(int i = 0; i < 5; i++) {
            if (n != 1 && left == 0 && i == 0) continue;
            arr[left] = numbers[i][0];
            arr[right] = numbers[i][1];
            dfs(res,arr,left+1,right-1,n);
        }
    }    

}
