package Google;

public class _679_24Game {
	public boolean judgePoint24(int[] nums) {
        double[] dnums = new double[]{(double)nums[0], (double)nums[1], (double)nums[2], (double)nums[3]};
        return judgeHelper(dnums);
    }
    
    boolean judgeHelper(double[] nums) {
        if (nums.length == 1) {
            return Math.abs(nums[0] - 24.0) <= 1.0e-6;
        }
        
        // pick two numbers out of the array
        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = i+1; j < nums.length; j++) {
                for(double num : compute(nums[i], nums[j])) {
                    double[] newarr = new double[nums.length-1];
                    int q = 0;
                    for(int k = 0; k < nums.length; k++) {
                        if (k != i && k != j) {
                            newarr[q++] = nums[k];
                        }
                    }
                    newarr[q] = num;
                    if (judgeHelper(newarr)) return true;    
                }
            }
        }
        return false;
    }
    
    List<Double> compute(double a, double b) {
        List<Double> res = new ArrayList<>();
        res.add(a*b);
        res.add(a+b);
        res.add(a-b);
        res.add(b-a);
        if (Math.abs(a) > 1.0e-6) res.add(b/a);
        if (Math.abs(b) > 1.0e-6) res.add(a/b);
        return res;
    }

}
