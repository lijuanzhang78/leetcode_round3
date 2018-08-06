package Google;

public class _224_BasicCalculator_new {
	public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        s = s.trim();
        int sign = 1, num = 0, res = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                num = 10*num + (c-'0');
            } else if (c == '+') {
                res += num*sign;
                num = 0;
                sign = 1;
            } else if (c == '-') {
                res += num*sign;
                num = 0; 
                sign = -1;
            } else if (c == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            } else if (c == ')') {
                res += sign*num;
                num = 0;
                sign = 1;
                res *= stack.pop();
                res += stack.pop();
            }
        }
        if (num != 0) res += sign*num;
        return res;
    }

}
