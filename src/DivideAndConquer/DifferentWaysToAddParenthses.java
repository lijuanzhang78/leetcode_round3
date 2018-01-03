package DivideAndConquer;

// 按照operator在的位置，把字符串一分为二，然后分而治之
// 理解递归：大问题分为小问题，不用纠结于递归的过程，只要（1）把base case考虑清楚 （2）怎么递推/组合子问题的返回值
//
public class DifferentWaysToAddParenthses {
	public List<Integer> diffWaysToCompute(String input) {
        if (input == null || input.length() == 0) return new ArrayList<Integer>();
        
        List<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                String s1 = input.substring(0,i);
                String s2 = input.substring(i+1,input.length());
                List<Integer> res1 = diffWaysToCompute(s1);
                List<Integer> res2 = diffWaysToCompute(s2);
                getRes(c,res1,res2,res);
            }
        }
        if (res.size() == 0) res.add(Integer.valueOf(input));
        return res;
    }
    
    void getRes(char op, List<Integer> res1, List<Integer> res2, List<Integer> res) {
        if (op == '+') {
            for(int num1 : res1) {
                for(int num2 : res2) {
                    res.add(num1+num2);
                }
            }
        } else if (op == '-') {
            for(int num1 : res1) {
                for(int num2 : res2) {
                    res.add(num1-num2);
                }
            }
        } else if (op == '*') {
                for(int num1 : res1) {
                    for(int num2 : res2) {
                        res.add(num1*num2);
                    }
                }
        }    
    }

}
