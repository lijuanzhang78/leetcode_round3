package DynamicProgramming;

// same : the number of ways when the color is the same as previous color
// diff: the number of ways when the color is different from previous color
// 因为不能超过连续两个相同颜色，所以需要区别same 和 diff
//
public class PaintFence {
	public int numWays(int n, int k) {
        if (n == 0 || k == 0) return 0;
        int same, diff;
        same = 0;
        diff = k;
        for(int i = 2; i <= n; i++) {
            int temp = diff;
            diff = (same + diff) * (k-1);
            same = temp;
        }
        return same + diff;
        
    }

}
