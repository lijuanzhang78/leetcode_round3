package Google;

public class _224_BasicCalculator {
	public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        int sign = 1, i = 0, num = 0, res = 0;
        s = s.trim();
        LinkedList<Integer> stack = new LinkedList<>();
        while(i < s.length()) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                num = num*10 + c-'0';
            } else if (c == '+') {
                num *= sign;
                sign = 1;
                res += num;
                num = 0;
            } else if (c == '-') {
                num = num*sign;
                sign = -1;
                res += num;
                num = 0;
            } else if (c == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0; num = 0;
                sign = 1;
            } else if (c == ')') {
                res += sign * num;
                res *= stack.pop();
                res += stack.pop();
                num = 0;
            } 
            i++;
        }
        if (num != 0) res += num*sign;
        return res;
    }

}
